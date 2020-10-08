package json;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;

/**
 * https://www.jianshu.com/p/e740196225a4
 */
public class Gson實作 {

    @Test
    public void $1objectToJson() {
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
    public void $2jsonToMapOrObject() {
        String s = "{\"age\":233,\"name\":\"allen\",\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"]}";
        Gson gson = new Gson();
        UserVo u = gson.fromJson(s, UserVo.class);
        System.out.println(u);
        HashMap<String, String> map = gson.fromJson(s, HashMap.class);
        System.out.println(map);// map的話，數字會被轉成double???
    }

    @Test
    public void $3ListToJsonToList() {
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
        //3.用Array使List的中判

        System.out.println( gson.fromJson(result, listType1).toString());
        System.out.println( gson.fromJson(result, listType2).toString());
        System.out.println(Arrays.toString(gson.fromJson(result,UserVo[].class)));
    }


}
