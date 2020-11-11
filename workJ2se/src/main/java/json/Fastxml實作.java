package json;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public class Fastxml實作 {

    public static void main(String[] args) throws Exception {
        Fastxml實作 j = new Fastxml實作();

    }

    @Test
    // 這種寫法很不方便，不考慮使用
    public void $1直接寫出json檔() throws Exception {
        JsonFactory jfactory = new JsonFactory();
        /*** write to file ***/
        StringWriter sw = new StringWriter();
        // 簡化寫法，由sw來不由file
        // JsonGenerator jGenerator = jfactory.createJsonGenerator(new File("c:\\user.json"), JsonEncoding.UTF8);
        JsonGenerator jGenerator = jfactory.createGenerator(sw);
        jGenerator.writeStartObject(); // {

        jGenerator.writeStringField("name", "allen"); // "name" : "allen"
        jGenerator.writeNumberField("age", 99); // "age" : 99
        jGenerator.writeFieldName("messages"); // "messages" :

        jGenerator.writeStartArray(); // [
        jGenerator.writeString("msg\" 1"); // "msg 1"
        jGenerator.writeString("msg\" 2"); // "msg 2"
        jGenerator.writeString("msg\" 3"); // "msg 3"
        jGenerator.writeEndArray(); // ]
        jGenerator.writeEndObject(); // }
        jGenerator.close();
        System.out.println(sw.toString());
    }

    @Test
    public void $2使用Object轉json() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // 舊寫法
        // ObjectWriter wr = mapper.defaultPrettyPrintingWriter();
        // 新寫法
        // ObjectWriter wr = mapper.writerWithDefaultPrettyPrinter();
        // 沒有排版的寫法
        ObjectWriter wr = mapper.writer();
        UserVo user = new UserVo();
        String s = wr.writeValueAsString(user);
        System.out.println(s);
    }

    @Test
    // 這種寫法很不方便，不考慮使用
    public void $3直接走訪讀json檔() throws Exception {
        String s = "{\"age\":233,\"name\":\"allen\",\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"]}";
        // 再來是Parser
        // JsonParser jParser = jfactory.createJsonParser(new File("c:\\user.json"));
        JsonFactory jfactory = new JsonFactory();
        JsonParser jParser = jfactory.createParser(new StringReader(s));
        // JsonToken的走訪好像是key->value->key->value....
        while (jParser.nextToken() != JsonToken.END_OBJECT) {
            System.out.println("token=" + jParser.getCurrentToken());
            String fieldname = jParser.getCurrentName();

            if ("name".equals(fieldname)) {
                // current token is "name",move to next, which is "name"'s value
                jParser.nextToken();
                System.out.println(jParser.getText()); // display name
            }

            if ("age".equals(fieldname)) {
                // current token is "age", move to next, which is "age"'s value
                jParser.nextToken();
                System.out.println(jParser.getIntValue()); // display 99
            }

            // 要是array裡面又包array不就冏大了，看來又是遞迴的天下了
            if ("messages".equals(fieldname)) {
                jParser.nextToken(); // current token is "[", move next messages is array, loop until token equal to "]"
                System.out.println("token=" + jParser.getCurrentToken());
                while (jParser.nextToken() != JsonToken.END_ARRAY) {
                    System.out.println("token=" + jParser.getCurrentToken());
                    // display msg1, msg2, msg3
                    System.out.println(jParser.getText());
                }
            }
        }
        jParser.close();
    }

    @Test
    public void $4讀json檔to物件() throws Exception {
        String s = "{\"age\":233,\"name\":\"allen\",\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"]}";
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader or = mapper.readerFor(UserVo.class);
        UserVo user = or.readValue(s);
        System.out.println(user);
        user = mapper.readValue(s, UserVo.class);
        System.out.println(user);
    }

    @Test
    public void $5mapToJsonToMap() {
        String json = "{\"name\":\"allen\", \"age\":\"99\", \"age2\":[1,2,3], \"age3\":[{\"name\":\"allen\", \"age\":\"99\"}]}";
        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            // map = mapper.readValue(json, map.getClass());
            map = mapper.readValue(json, new TypeReference<HashMap<String, Object>>() {
            });
            System.out.println("name=" + map.get("name") + ",age=" + map.get("age"));
            System.out.println("map=" + map);
            Object o = map.get("age3");
            System.out.println(o + "->" + o.getClass());

            // 上面順利把json2Map了，再來Map2Json回去
            json = mapper.writeValueAsString(map);
            System.out.println(json);
            StringWriter sw = new StringWriter();
            // 這個method後面吃一般的Obj<要有getset>，也吃map，其它的要再測
            mapper.writeValue(sw, map);
            System.out.println(sw.toString());
            // 最後file再到json
            // Map<String, Object> map2 = mapper.readValue(new StringReader(sw.toString()), map.getClass());
            Map<String, Object> map2 = mapper.readValue(new StringReader(sw.toString()),
                    new TypeReference<Map<String, Object>>() {
                    });
            System.out.println("name2=" + map2.get("name") + ",age2=" + map2.get("age"));
            System.out.println("map2=" + map2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //不明白用途，應該不會使用Tree的方式去讀檔
    @Test
    public void $6轉成JsonNode() throws Exception {
        UserVo user = new UserVo();
        ObjectMapper mapper = new ObjectMapper();
        String js = mapper.writer().writeValueAsString(user);

        JsonNode node = mapper.readTree(js);

        JsonNode nameNode = node.path("name");
        System.out.println(nameNode.asText());

        JsonNode ageNode = node.path("age");
        System.out.println(ageNode.asInt());

        JsonNode msgNode = node.path("messages");
        Iterator<JsonNode> ite = msgNode.elements();

        while (ite.hasNext()) {
            JsonNode temp = ite.next();
            System.out.println(temp.asText());
        }
        // 更新tree的結構，要轉到子類別才能動
        ((ObjectNode) node).put("nickname", "new nickname");
        ((ObjectNode) node).put("name", "updated name");
        ((ObjectNode) node).remove("age");

        // 更新後的結果輸出如下
        StringWriter sw = new StringWriter();
        mapper.writeValue(sw, node);
        System.out.println(sw.toString());
    }


    @Test
    public void 一共有五組設定可以調整() throws JsonProcessingException {
        //有builder可以使用
        ObjectMapper o1 = JsonMapper.builder().enable(SerializationFeature.CLOSE_CLOSEABLE).build();
        //yaml要額外的jar檔，寫法應該是相同的
        //ObjectMapper o2 = YAMLMapper.builder().enable(SerializationFeature.CLOSE_CLOSEABLE).build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.CLOSE_CLOSEABLE, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true);
        mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, true);
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        JsonParser.Feature a;
        //是否自動關閉reader，true
        a = JsonParser.Feature.AUTO_CLOSE_SOURCE;
        // json不允許comment，但此功能設成true的話就可以，預設false，可用下下行替代
        a = JsonParser.Feature.ALLOW_COMMENTS;
        mapper.enable(JsonReadFeature.ALLOW_JAVA_COMMENTS.mappedFeature());
        a = JsonParser.Feature.ALLOW_YAML_COMMENTS;
        mapper.enable(JsonReadFeature.ALLOW_YAML_COMMENTS.mappedFeature());
        //充許沒有雙引號包住key的解析,false
        a = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES;
        mapper.enable(JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES.mappedFeature());
        //允許使用單引號來包住值，false
        a = JsonParser.Feature.ALLOW_SINGLE_QUOTES;
        mapper.enable(JsonReadFeature.ALLOW_SINGLE_QUOTES.mappedFeature());
        //允許出現 ascii32以下的控制字元，如\t\r\n這類的，false
        a = JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS;
        mapper.enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature());
        //允許出現\出現但是失敗的escaping不會出錯，如\z會變成，不然正常就\"可以用吧我猜，false
        a = JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER;
        mapper.enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature());
        //允許數字的前面有0而不會出錯ex 0001，false
        a = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS;
        mapper.enable(JsonReadFeature.ALLOW_LEADING_ZEROS_FOR_NUMBERS.mappedFeature());
        // 允許 .234 而不一定要0.234的數字,false
        a = JsonParser.Feature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS;
        mapper.enable(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature());
        // 允許 NaN或是INF,-INF等數值出現,false
        a = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS;
        mapper.enable(JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS.mappedFeature());
        // 允許[1,2,,3]，不然要[1,2,null,3]才會合法,false
        a = JsonParser.Feature.ALLOW_MISSING_VALUES;
        mapper.enable(JsonReadFeature.ALLOW_MISSING_VALUES.mappedFeature());
        // 允許{"a":1,"b":2,}，遏號後面可以不接其它的屬性,false
        a = JsonParser.Feature.ALLOW_TRAILING_COMMA;
        mapper.enable(JsonReadFeature.ALLOW_TRAILING_COMMA.mappedFeature());
        //檢查有無相同名字的屬性，有就丟錯，沒設的話舊的值會蓋掉新的值，也許是隨機要再測試，false
        a = JsonParser.Feature.STRICT_DUPLICATE_DETECTION;
        //我猜是有一些自定義的屬性才需要使用這個值的設定，可能是略過自定義的設定如enum然後先跳過，要配合schema？，不太懂先跳過，false
        a = JsonParser.Feature.IGNORE_UNDEFINED;
        // 應該是設定可以引用資源，可能有安全性的問題，先不研究，false
        a = JsonParser.Feature.IGNORE_UNDEFINED;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JsonGenerator.Feature b;
        //  在JsonGenerator.close()時自動關閉writer，true
        b = JsonGenerator.Feature.AUTO_CLOSE_TARGET;
        //  在JsonGenerator.close()時是否end讀到一半的array或object ，true
        b = JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT;
        //  在JsonGenerator.flush()時執行writer.flush()，沒特別理由不會改這個值，true
        b = JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM;
        //  設成false可以把key的""拿掉，變成javascript的物件使用，true
        b = JsonGenerator.Feature.QUOTE_FIELD_NAMES;
        //  設成false可以把value為NaN等非數字的的"NaN"拿掉成NaN，java中的Double.NaN可以測試，變成javascript的物件使用，true
        b = JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS;
        //  設成true，可以把中文字escape成Uxxxx等字元，應該是要解決亂碼問題，在讀入java時不用任何設定也能轉成正確的中文字，false
        b = JsonGenerator.Feature.ESCAPE_NON_ASCII;
        //  設成true，可以把強制輸出成文字而非數字，false
        b = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS;
        //  設成true，可以把強制輸出長數字為不含科學符號，科學符號如下1.23E10，false
        b = JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN;
        //  設成true會檢查不能有重複的名字，但是很影嚮效能，請不要修改，false
        b = JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION;
        //  在沒有schema時好像沒功能，但protobuf可能就有用，目前測不出效果來先略過，false
        b = JsonGenerator.Feature.IGNORE_UNKNOWN;
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SerializationFeature c;
        //設成true的話：{ "classType":{"name":"name1"}}，不然會為{"name":"name"}，好像只是為了相容jaxb的設計。false
        c = SerializationFeature.WRAP_ROOT_VALUE;
        //設成true可以有縮排，感覺和漂亮排版出來的格式相同。false
        c = SerializationFeature.INDENT_OUTPUT;
        //設成false的話，可允許結果為{}，不然至少要有一個屬性。true
        c = SerializationFeature.FAIL_ON_EMPTY_BEANS;
        //設成false的話，可允許引用自已，通常是OOM，。true
        c = SerializationFeature.FAIL_ON_SELF_REFERENCES;
        //設成false的話，會把Exception包成IOException再丟出來，如果要本來的Exception可設成false試試，。true
        c = SerializationFeature.WRAP_EXCEPTIONS;
        //設成false時，當json無法解析type時會丟掉ex，反之會出ex(我想：不知道有什麼type是java有但不能轉json的，還是json會可觛告type？)，。true
        c = SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS;
        //設成true時，我猜會把自我的引用變成null，FAIL_ON_SELF_REFERENCES要設成false才會生效，。false
        c = SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL;
        //設成true時，無論序列化成功失敗，都會call close，表示writeValue只能執行一次，只影嚮rootObject，。false
        c = SerializationFeature.CLOSE_CLOSEABLE;
        //設成true時，在writeValue後會call JsonGenerator.flush()，。true
        c = SerializationFeature.FLUSH_AFTER_WRITE_VALUE;
        //設成true時，會把和Date相關的類別都轉成timestamps(1900->now的毫秒數吧)來處理，。true
        c = SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
        //試不出來，設成false時，使用文字來表示當作key的日期(當java為map物件時，key就可能為date)。false
        c = SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS;
        //試不出來，設成true時，出來的日期會包含時區??，和WRITE_DATES_AS_TIMESTAMPS要搭配使用？。false
        c = SerializationFeature.WRITE_DATES_WITH_ZONE_ID;
        //試不出來。true
        c = SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS;
        //設定true時，char[]會變成[a,b,c]，false時會變成abc。false
        c = SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS;
        //設定enum是用name還是toString。false
        c = SerializationFeature.WRITE_ENUMS_USING_TO_STRING;
        //設定enum是用name還是index。false
        c = SerializationFeature.WRITE_ENUMS_USING_INDEX;
        //應該是指map的key是enum時，是用name還是index。false
        c = SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX;
        //設定false，當MAP時，如果值為null就不產出。true
        c = SerializationFeature.WRITE_NULL_MAP_VALUES;//改使用 com.fasterxml.jackson.annotation.JsonInclude
        //設定false，當List為空集合時不產出，null仍會產出。true
        c = SerializationFeature.WRITE_EMPTY_JSON_ARRAYS;//改使用 com.fasterxml.jackson.annotation.JsonInclude
        //設定true， { "arrayProperty" : [ 1 ] }->{ "arrayProperty" : 1 }。false
        c = SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED;
        //設成true，可以把強制輸出長數字為不含科學符號，科學符號如下1.23E10，false
        c = SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN;//改使用com.fasterxml.jackson.core.JsonGenerator.Feature
        //好像支搜java8之後的Date/Time使用此設定，3rd和舊版不行，true
        c = SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS;
        //啟用對MAP key值做排序，SortedMaps好像就會用自身的排序，false
        c = SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS;
        //ObjectWriter 會不會嘗試先取得JSonSerializer，在沒問題時不要禁用此選項，true
        c = SerializationFeature.EAGER_SERIALIZER_FETCH;
        //不清楚用途，試不出來，想不出equal和json的關系，false
        c = SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID;
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        DeserializationFeature d;
        // 不知道真實型別如Objcet時，預設false使用double來反序列化，可設true改用bigDecimal，false
        d = DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
        // 同上吧 ，false
        d = DeserializationFeature.USE_BIG_INTEGER_FOR_INTS;
        // 同上吧，false
        d = DeserializationFeature.USE_LONG_FOR_INTS;
        // 設成true，如果屬性為Object，會把array轉成Object[]，反之為List<Object>，如果屬性已經知道是List鎬Array就不用設這裡的值了 ，false
        d = DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY;
        // 有未知屬性時是否丟錯誤出來，true
        d = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        // 當原生型別int之類的值，遇到null會出錯，改成false就會變塞預設值，true
        d = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
        // 使用 enum的ordinal來map enum值,true時就不能放數字，個人覺得用true還蠻正常的，false
        d = DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS;
        // 不懂(是指Object嗎)：值遇到多型無法判斷子類別時就出錯，true
        d = DeserializationFeature.FAIL_ON_INVALID_SUBTYPE;
        // 遇到相同的key值，舊值會蓋掉新值，false
        d = DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY;
        // 當使用JsoIgnore時，那個屬性就不會被吃進去也不錯出錯，設true可出錯提醒payload不應該有這個值，false
        d = DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES;
        // 看不種，是指抽像類別鎬介面沒有實作的子類嗎？？？,true
        d = DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS;
        // 我猜應該是屬性的建構子出錯時，給預設null值，false
        d = DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES;
        // 不懂，我猜和上面是差不多的東西，分析不出來差在那裡,false
        d = DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES;
        // 使用JsonTypeInfo註解有決一些東西時會出錯的樣子,true
        d = DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY;
        // 看不懂,false
        d = DeserializationFeature.FAIL_ON_TRAILING_TOKENS;
        // 應該是幫裝ex來獲取更多資訊而已,true
        d = DeserializationFeature.WRAP_EXCEPTIONS;
        // 設成true應該是可以強制非陣列的值轉成java List或是Array吧,false
        d = DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
        // 和上一個功能反向吧,false
        d = DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS;
        // 對應功能SerializationFeature#WRAP_ROOT_VALUE，2個為一組的設定,false
        d = DeserializationFeature.UNWRAP_ROOT_VALUE;
        //  應該是把空字串轉成null，但我試不出來，false
        d = DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT;
        //  應該是把空陣列串轉成null，但我試不出來，false
        d = DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT;
        //  可把1.2強轉成1，改成flase會丟ex，true
        d = DeserializationFeature.ACCEPT_FLOAT_AS_INT;
        //  對應SerializationFeature#WRITE_ENUMS_USING_TO_STRING，false
        d = DeserializationFeature.READ_ENUMS_USING_TO_STRING;
        //  沒試，設成true應該是把未知的enum轉成null，否則出錯，false
        d = DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL;
        //  沒試，設成true應該是配合annotation.JsonEnumDefaultValue來使用的，註解要在enum的列舉上，false
        d = DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE;
        //  沒試，配合SerializationFeature#WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS使用，true
        d = DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS;
        //  沒試，反正是時區的問題，遇到再試，true
        d = DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
        //  ObjectReader是否提早取得 JsonDeserializer，沒事不要調這個參數，true
        d = DeserializationFeature.EAGER_DESERIALIZER_FETCH;
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        MapperFeature m;
        //使用annotation，false會讓很多功能不能用，true
        m = MapperFeature.USE_ANNOTATIONS;
        //好像是屬性為Collection或map時，當只有get無set時，自動也提供set的功能，true
        m = MapperFeature.USE_GETTERS_AS_SETTERS;
        //設true且屬性前面有modify為transient時，該屬性會被祭序在序列化和反序列化，false
        m = MapperFeature.PROPAGATE_TRANSIENT_MARKER;
        //不是很懂那裡用到： 自動檢測套用public建構子或是static method命為valueOf(single argumnet)，true
        //我猜只有在反序列化的時候去new出物件使用吧，不知道對不對
        m = MapperFeature.AUTO_DETECT_CREATORS;
        //自動檢測public field為屬性，true
        m = MapperFeature.AUTO_DETECT_FIELDS;
        //自動檢測public get method無參數的部分轉為屬性，true
        m = MapperFeature.AUTO_DETECT_GETTERS;
        //自動檢測public is method無參數的部分轉為屬性，true
        m = MapperFeature.AUTO_DETECT_IS_GETTERS;
        //自動檢測public set method 1個參數的部分用來反列列化，true
        m = MapperFeature.AUTO_DETECT_SETTERS;
        //看不懂，好像是final(immutable)可以只有get不用set嗎？，false
        m = MapperFeature.REQUIRE_SETTERS_FOR_GETTERS;
        //可以給final(immutable) field設值，true
        m = MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS;
        //只要寫getter(feild才行)，就會幫忙推斷setter(field)的寫法，true
        m = MapperFeature.INFER_PROPERTY_MUTATORS;
        //好像是java.beans.ConstructorProperties annotation會被推斷成JsonCreator……後面看不懂，true
        m = MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES;
        // 使用反射來存取本來不能存取的modify，來增加效能不用做反射的檢查，沒事不要修改，true
        m = MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS;
        // 對public也修正modify，基本上應該不用這麼做，目的是為了提高反射的效能，沒事不要修改，true
        m = MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS;
        // 看不種，好像是序列化時要使用靜態類別或是runtime type，false
        m = MapperFeature.USE_STATIC_TYPING;
        // 看不種，false
        m = MapperFeature.USE_BASE_TYPE_AS_DEFAULT_IMPL;
        // 看不種，和JsonView相關，true
        m = MapperFeature.DEFAULT_VIEW_INCLUSION;
        // 設成true的話使用JsonPropertyOrder.alphabetic()，應該是自然排序法，false無排序，參照JsonPropertyOrder註解，false
        m = MapperFeature.SORT_PROPERTIES_ALPHABETICALLY;
        // 設true時，在反序列化時，可以不分大小寫來匹配屬性，但會帶來額外的性能開銷，false
        m = MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES;
        // enum反序列化時是否區分大小寫，一般來說enum是用name()或toString()來反序列化的，false
        m = MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS;
        // 看不懂，false
        m = MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES;
        // 看不懂，false
        m = MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME;
        // json的field定義為開頭小寫，ex:(java)URL->(json)url，設成true時，(java)URL->(json)URL，正常是不應該開啟的，false
        m = MapperFeature.USE_STD_BEAN_NAMING;
        // 看不太懂用法，目前都用JsonProperty不就可以達到要求，不知道怎麼測試，false
        m = MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING;
        // 應該是在反序列化的時候才有用，讓boolean可以吃0,1代替true,false，數字可吃字串,true
        m = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        // 看不種意思，棤組是什麼？,true
        m = MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS;
        // 看不懂，不理解指的merge是什麼情況會發生,true
        m = MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE;
        // 好像和驗証有關，當作沒這項好了，3.0之後可能刪掉此設定並且預設為true,false
        m = MapperFeature.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES;
    }


    @Test
    public void 產出jsonSchema() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(objectMapper);
        JsonSchema jsonSchema = jsonSchemaGenerator.generateSchema(Input.class);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));

    }

    static class Input {
        private String name = "123";
        private int age = 18;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @Test
    public void 測試annotation() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String result = objectMapper.writeValueAsString(new TestAnn());
        System.out.println(result);
        System.out.println(reflectionToString(objectMapper.readValue(result, TestAnn.class)));
        //測試使用自已寫建構子也就是自已的反序列化
        String json = "{\"name1\":\"名字\",\"age1\":18}";
        TestAnn2 testAnn2 = objectMapper.readValue(json, TestAnn2.class);
        System.out.println(reflectionToString(testAnn2));
        //測試用builder的反序列化
        TestAnn3 testAnn3 = objectMapper.readValue(json, TestAnn3.class);
        System.out.println(reflectionToString(testAnn3));

        //objectmapper有提供conver，好像是A->JSON->B，以下幾個範列可參考一下
        //int[] ints = mapper.convertValue(sourceList, int[].class);
        //Map<String,Object> propertyMap = mapper.convertValue(pojoValue, Map.class);
        //PojoType pojo = mapper.convertValue(propertyMap, PojoType.class);

        System.out.println("測試anyGetter=================================================================");
        //測試anyGetter
        TestAnn testAnn = new TestAnn();
        testAnn.properties.put("p1", "我是p1");
        testAnn.properties.put("p2", "我是p2");
        String jsonAnyGetter = objectMapper.writeValueAsString(testAnn);
        System.out.println(jsonAnyGetter);
        System.out.println("jsonAnyGetter會把key,value pair的properties放在root object，但這些properties會照成反序列化錯誤");
        System.out.println(reflectionToString(objectMapper.readValue(jsonAnyGetter, TestAnn.class)));
        System.out.println("anySetter可是把沒mapping到的field全丟到map裡面去");

        //@JsonRawValue// 提供field的值可轉成jsonString，而不轉成pojo
        //@JsonValue// 使用在Enum的method上，可指定enum要轉成的json值
        //@JsonRootName//可指定在rootClass上 產出變成{ "rootName":{...}}，原本應該為{...}，如要對應xml還可加設定namespace
        //@JsonAlias({"name1","name_1"})這個註解可deserialization時可以用多組名字來解析
        //@JsonIgnore(field),@JsonIgnoreProperties(class),@JsonIgnoreType(class)
        //@JsonInclude(JsonInclude.Include.NON_NULL) 可以去掉null的值，還有其它的部分自已有空再看看
        //@JsonUnwrapped就是把pojo的值攤到root層，然後root層的值可以設回pojo，和anySetter差不多
        //@JsonView 看不種跳過
        //@JsonFilter，感覺可以用JsonIgnore即可，除非同一個bean要Ignore 動態不同的欄位
        //用法是FilterProvider filters = new SimpleFilterProvider().addFilter.........有點麻煩就先跳過
        //annotation可以客製自已的customerXxxx，先跳過

        System.out.println("測試inject======================================");
        //這裡只是要顯示可以有context使用inject，實用性仍然可能不足，純記錄
        InjectableValues injectableValues = new InjectableValues.Std().addValue("age1", 100);
        TestAnn4 testAnn4 = new ObjectMapper().reader(injectableValues).forType(TestAnn4.class)
                .readValue("{\"name\" : \"name1\"}");
        System.out.println(reflectionToString(testAnn4));


    }

    @JsonIgnoreProperties({"name3"})
    @JsonPropertyOrder({"name6", "位置從0開始插入", "這裡可以改寫產出的property順序"})
    static class TestAnn {
        //JsonProperty好像也可以放在getSet，代替JsonGetter和JsonSetter的工作
        //或者是直接使用 public String xxx不要封裝使用好像也行
        @JsonProperty("用JsonProperty設定name不需要get")
        private String 沒有getSet也能產出 = "name";
        @JsonProperty("JsonProperty會被get影嚮")
        private String name1 = "name1";
        private String name2 = "我沒註解也沒getter不會被序列化";
        private String name3 = "name3補class的JsonIgnoreProperties忽略掉";
        @JsonIgnore
        private String name4 = "name4，會被JsonIgnore忽略";
        private String name5 = "name5，也可把JsonIgnore放在get或是set";
        private String name6 = "可以用JsonGetter來處理properties和get不同名字的問題";
        private Map<String, String> properties = new HashMap<>();
        @JsonSerialize(using = DateSerializer.class)
        @JsonDeserialize(using = DateDeserializer.class)
        private Date date = new Date();
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        private Date date2 = new Date();
        @JsonUnwrapped
        private FullName fullName = new FullName();

        public String getName1() {
            return name1 + "我被影嚮了";
        }

        public String get只有get也是可以被序列化的() {
            return "沒設物件變數也行";
        }

        public String getName3() {
            return name3;
        }

        public String getName4() {
            return name4;
        }

        @JsonIgnore
        public String getName5() {
            return name5;
        }

        @JsonGetter("name6")
        public String getNewName6() {
            return "newName6，可蓋過properties的設定或刪除properties也沒問題";
        }

        //如果只有get產出的json，沒有對應的set會有反序列作的錯誤，這時就用JsonSetter可以解這個問題
        @JsonSetter("name6")
        public void setNewName6(String name6) {
            this.name6 = name6;
        }

        @JsonSetter("只有get也是可以被序列化的")
        public void setXXX(String xxx) {

        }

        @JsonAnyGetter
        public Map<String, String> getProperties() {
            return properties;
        }

        @JsonAnySetter
        public void add(String key, String value) {
            properties.put(key, value);
        }

    }

    static class FullName {
        @JsonProperty
        private String firstName = "firstName";
        @JsonProperty
        private String lastName = "lastName";
    }

    static class TestAnn2 {
        String name;
        int age;

        @JsonCreator
        public TestAnn2(@JsonProperty("name1") String name, @JsonProperty("age1") int age) {
            this.name = name;
            this.age = age;
        }
    }


    @JsonDeserialize(builder = TestAnn3.Builder.class)
    static class TestAnn3 {
        String name;
        int age;

        //annotation裡的值可不寫就會用預設值如下
        @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
        static class Builder {
            String name;
            int age;

            //重點是這一些with要對應到名字
            Builder withName1(String name) {
                this.name = name;
                return this;
            }

            Builder withAge1(Integer age) {
                this.age = age;
                return this;
            }

            public TestAnn3 build() {
                TestAnn3 testAnn3 = new TestAnn3();
                testAnn3.name = name;
                testAnn3.age = age;
                return testAnn3;
            }
        }
    }

    static class DateSerializer extends StdSerializer<Date> {
        public DateSerializer() {
            this(null);
        }

        public DateSerializer(Class<Date> t) {
            super(t);
        }

        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(DateFormatUtils.format(value, "yyyy-MM-dd HH:mm:ss"));
        }
    }

    static class DateDeserializer extends StdDeserializer<Date> {
        public DateDeserializer() {
            this(null);
        }

        protected DateDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            try {
                return DateUtils.parseDate(p.getText(), "yyyy-MM-dd HH:mm:ss");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("fail");
        }
    }

    static class TestAnn4 {
        @JsonProperty
        String name;
        @JacksonInject(value = "age1")
        int age;
    }

    /**
     * 解決無窮遞迴的問題，解法是用不序列化
     *
     * @throws JsonProcessingException
     */
    @Test
    public void testRefenceEachOther() throws JsonProcessingException {
        ItemRef itemRef = new ItemRef();
        UserRef userRef = new UserRef();
        itemRef.userRef = userRef;
        userRef.itemRef = itemRef;
        System.out.println(new ObjectMapper().writeValueAsString(itemRef));
        System.out.println(new ObjectMapper().writeValueAsString(userRef));
        System.out.println("使用JsonManagedReference+JsonBackReference為一對，但JsonBackReference的部分不會被序列化");
        System.out.println("這和直接在另一個類別使用JsonIgnore不是一樣嗎？除了清楚定義外有什麼差別");
    }

    static class ItemRef {
        public String itemName = "itemName";
        @JsonManagedReference
        public UserRef userRef;
    }

    static class UserRef {
        public String userName = "userName";
        @JsonBackReference
        public ItemRef itemRef;
    }

    /**
     * 解決無窮遞迴的問題，使用JsonIdentityInfo定義id的方式解決
     */
    @Test
    public void testJsonIdentityInfo() throws JsonProcessingException {
        ItemIdentify itemIdentify = new ItemIdentify();
        UserIdentify userIdentify = new UserIdentify();
        itemIdentify.user = userIdentify;
        userIdentify.item = itemIdentify;
        System.out.println(new ObjectMapper().writeValueAsString(itemIdentify));
        System.out.println(new ObjectMapper().writeValueAsString(userIdentify));
//        {"id1":1,"itemName":"itemName","user":{"id9":9,"userName":"userName","item":1}}
//        {"id9":9,"userName":"userName","item":{"id1":1,"itemName":"itemName","user":9}}
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id1")
    static class ItemIdentify {
        public int id1 = 1;
        public String itemName = "itemName";
        public UserIdentify user;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id9")
    static class UserIdentify {
        public int id9 = 9;
        public String userName = "userName";
        public ItemIdentify item;
    }

    @Test
    public void testJsonType() throws JsonProcessingException {
        //不太清楚用，先記錄下來
        //好像是多型的class可以多type的property來顯示而已，感覺沒什麼用處
        Zoo.Dog dog = new Zoo.Dog();
        dog.name = "dogName";
        Zoo.Cat cat = new Zoo.Cat();
        cat.name = "catName";
        Zoo.Animal animal = new Zoo.Animal();
        animal.name = "animalName";
        Zoo zoo = new Zoo();
        zoo.animal = dog;
        System.out.println(new ObjectMapper().writeValueAsString(zoo));
        zoo.animal = cat;
        System.out.println(new ObjectMapper().writeValueAsString(zoo));
        zoo.animal = animal;
        System.out.println(new ObjectMapper().writeValueAsString(zoo));
    }
}

class Zoo {
    public Animal animal;

    //可以多一個type的property
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    //可以決定type顯示的值
    @JsonSubTypes({@JsonSubTypes.Type(value = Dog.class, name = "dog")
            , @JsonSubTypes.Type(value = Cat.class, name = "cat")})
    public static class Animal {
        public String name;
    }

    //不明白用處，是反序列化要用到的嗎？
    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public double barkVolume;
    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {
        public boolean likesCream;
        public int lives;
    }
}
