package json;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

public class Gson實作 {

    public static void main(String args[]) {

        Gson實作 g = new Gson實作();
        g.$1objectToJson();
        g.$2jsonToObject();

    }

    public void $1objectToJson() {
        HashMap map = new HashMap();
        map.put("key1", 100);
        Gson gson = new Gson();
        UserVo u = new UserVo();
        System.out.println(gson.toJson(u));
        gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(u));
        System.out.println(gson.toJson(map));
    }

    @Test
    public void $2jsonToObject() {
        String s = "{\"age\":233,\"name\":\"allen\",\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"]}";

        Gson gson = new Gson();
        UserVo u = gson.fromJson(s, UserVo.class);
        System.out.println(u);
        HashMap<String, String> map = gson.fromJson(s, HashMap.class);
        System.out.println(map);// map的話，數字會被轉成double???
    }
}
