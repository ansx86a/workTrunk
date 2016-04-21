package json;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Fastxml實作 {

	public static void main(String[] args) throws Exception {
		Fastxml實作 j = new Fastxml實作();
		j.$6JsonTree();
	}

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

	public String $2使用Object轉json() throws Exception {
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
		return s;
	}

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

	public void $4讀json檔to物件() throws Exception {
		String s = "{\"age\":233,\"name\":\"allen\",\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"]}";
		ObjectMapper mapper = new ObjectMapper();
		ObjectReader or = mapper.readerFor(UserVo.class);
		UserVo user = or.readValue(s);
		System.out.println(user);
		user = mapper.readValue(s, UserVo.class);
		System.out.println(user);
	}

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

	public void $6JsonTree() throws Exception {
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

}
