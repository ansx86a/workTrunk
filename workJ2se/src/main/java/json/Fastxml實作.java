package json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

        m = MapperFeature.USE_ANNOTATIONS;


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

}
