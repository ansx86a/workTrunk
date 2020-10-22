package json;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;
import static org.apache.commons.codec.binary.StringUtils.getBytesUtf8;
import static org.apache.commons.codec.binary.StringUtils.newStringUtf8;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

/**
 * https://www.jianshu.com/p/e740196225a4
 */
public class Gson實作 {

    @Test
    public void 物件轉json_靜態變數不會被序列化() {
        HashMap map = new HashMap();
        map.put("key1", 100);
        Gson gson = new Gson();
        UserVo u = new UserVo();
        System.out.println(gson.toJson(u));
        //加入format排版
        gson = new GsonBuilder().setPrettyPrinting().create();
        //其它builder如disableHtmlEscaping，要用再看看就可以了

        System.out.println(gson.toJson(u));
        System.out.println(gson.toJson(map));
    }

    @Test
    public void json轉Map或物件() {
        String s = "{\"age\":233,\"name\":\"allen\",\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"]}";
        Gson gson = new Gson();
        UserVo u = gson.fromJson(s, UserVo.class);
        System.out.println(u);
        HashMap<String, String> map = gson.fromJson(s, HashMap.class);
        System.out.println(map);// map的話，數字會被轉成double???
    }

    @Test
    public void JsonArray轉回List泛型物件_避免轉成List泛型Map() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<UserVo> list = Arrays.asList(new UserVo(), new UserVo());
        String result = gson.toJson(list);
        System.out.println(result);
        //要轉回List，因煎泛型的問題吧，我猜，所以要有typeToken才行，class本身就有實作type
        //1.用guava，2.8之前版本太舊沒有要注意，舊的改用 new TypeToken<ArrayList<UserVo>>(){}.getType();
        //寫法用奇怪，利用{}實作區塊來new出protected，我覺得不太好，就用下面這個
        Type listType1 = TypeToken.getParameterized(List.class, UserVo.class).getType();
        //2.用apache
        Type listType2 = TypeUtils.parameterize(List.class, UserVo.class);
        //3.用Array使List的中介

        System.out.println(gson.fromJson(result, listType1).toString());
        System.out.println(gson.fromJson(result, listType2).toString());
        System.out.println(Arrays.toString(gson.fromJson(result, UserVo[].class)));
        //System.out.println(gson.fromJson(result,UserVo.class));//錯誤
        System.out.println(gson.fromJson(result, ArrayList.class));//會變List<LinkedTreeMap>，而map裡面的vlaue是多個值的話會變成ArrayList的伹
    }

    @Test
    public void 簡單的builder設定() {
        //沒會序列化null和靜態變數
        System.out.println(new Gson().toJson(new BuilderVo()));
        //增加序列化null
        System.out.println(new GsonBuilder().serializeNulls().create().toJson(new BuilderVo()));
        //只對有Expose的柵位序列化
        System.out.println(new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(new BuilderVo()));
        //當map的key非基本形別物件時，要開啟
        //.enableComplexMapKeySerialization()
        //ex: new HashMap<List<User>,String>
        //設定日期格式
        System.out.println(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(new BuilderVo()));
        //格式化結果
        //setPrettyPrinting()
        //取消html escaping
        System.out.println(new GsonBuilder().disableHtmlEscaping().create().toJson(new BuilderVo()));

        System.out.println("版控，影嚮age顯示，沒設定version就都不會出來，有設就提 version>= since and version < until才會出來");
        System.out.println(new GsonBuilder().setVersion(1.1).create().toJson(new BuilderVo()));
        System.out.println(new GsonBuilder().setVersion(1.2).create().toJson(new BuilderVo()));
        System.out.println(new GsonBuilder().setVersion(1.3).create().toJson(new BuilderVo()));

        System.out.println("測試JsonAdapter，感覺比registerTypeAdapter還要活");
        System.out.println(new Gson().toJson(new BuilderVo()));
        System.out.println(reflectionToString(new Gson().fromJson(new Gson().toJson(new BuilderVo()), BuilderVo.class)));


    }


    static class BuilderVo {
        //不會被序列化
        public static String shortName = "ai";
        private Date birdthday = new Date();
        @Since(1.1)
        @Until(1.3)
        private int age = 233;
        private String html = "<p>html</p>";
        @Expose
        private String name = "allen";
        //可以改變名字
        @SerializedName("COLOR")
        private String color = null;
        private List<String> messages = ImmutableList.of("msg1", "msg2", "msg3");
        @JsonAdapter(Base64TypeAdapter.class)
        private String base641 = "base64";
        @JsonAdapter(Base64TypeAdapter2.class)
        private String base642 = "base64";

    }

    /**
     * 好處是序列化和反序列化可分開，type也可以用不一樣的，序如壓用byte[]，解成string
     */
    static class Base64TypeAdapter implements JsonSerializer<String>, JsonDeserializer<String> {
        @Override
        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return newStringUtf8(decodeBase64(json.getAsString()));
        }

        @Override
        public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(encodeBase64String(getBytesUtf8(src)));
        }
    }

    /**
     * 缺點是用繼承的，序列化和反序列化用同一個Type，但是在複雜物件來說應該用這個會比較簡單
     */
    static class Base64TypeAdapter2 extends TypeAdapter<String> {
        @Override
        public void write(JsonWriter out, String value) throws IOException {
            out.beginObject();
            out.name("newBase64");
            out.value(encodeBase64String(getBytesUtf8(value)));
            out.endObject();
        }

        @Override
        public String read(JsonReader in) throws IOException {
            in.beginObject();
            System.out.println(in.nextName());
            String result = in.nextString();
            in.endObject();
            return result;
        }
    }
}
