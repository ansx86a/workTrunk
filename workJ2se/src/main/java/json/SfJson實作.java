package json;

import java.util.ArrayList;
import java.util.HashMap;

import net.sf.json.JSONObject;

public class SfJson實作 {

	public static void main(String[] args) {

		SfJson實作 g = new SfJson實作();
		g.$1objectToJson();
		g.$2jsonToObject();
	}

	public void $1objectToJson() {
		HashMap map = new HashMap();
		map.put("key1", 100);
		JSONObject o = new JSONObject();
		ArrayList<String> list = new ArrayList();
		list.add("array1");
		list.add("array2");
		list.add("array3");
		o.put("key1", "key2");
		o.put("list", list);
		System.out.println(o.toString());
		System.out.println(JSONObject.fromObject(new UserVo()).toString());
		System.out.println(JSONObject.fromObject(map).toString());// map也可以和json互換
	}

	public void $2jsonToObject() {
		String s = "{\"age\":233,\"name\":\"allen\",\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"]}";
		JSONObject json = JSONObject.fromObject(s);
		System.out.println(json.toString());
		System.out.println(JSONObject.toBean(json, UserVo.class));
		System.out.println(JSONObject.toBean(json, HashMap.class));// map也可以和json互換
	}
}
