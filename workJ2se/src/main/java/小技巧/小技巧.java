package 小技巧;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class 小技巧 {

    private List<String> 匿名加內容的List = new ArrayList<String>() {
        {
            add("msg 1");
            add("msg 2");
            add("msg 3");
            int i = 0;
            add("msg i->" + i);
        }
    };

    @Test
    public void 匿名List() {
        // 不好的例子，應該就使用guava
        System.out.println(匿名加內容的List);
    }

    @Test
    public void 避免NULL的取值法() {

        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        HashMap<String, String> nullMap = null;
        // 在都有值的情況下
        System.out.println(Optional.ofNullable(map).map(o -> o.get("key1")).map(String::toString).orElse("NULL值"));
        // 在value沒有值的情況下
        System.out.println(Optional.ofNullable(map).map(o -> o.get("沒有值的key")).map(String::toString).orElse("NULL值"));
        // 在map 沒有值的情況下
        System.out
                .println(Optional.ofNullable(nullMap).map(o -> o.get("沒有值的key")).map(String::toString).orElse("NULL值"));

        // 測試到那裡開始沒有值，可以發現會轉成Optional.empty所以不會有null的問題
        // 在stream也可以用fiflter來過濾isEmpty[不知為何intellij錯誤]
        Optional<HashMap<String, String>> option = Optional.ofNullable(map);
        System.out.println(option.map(o -> o.get("key1")));
        option.map(o -> o.get("key1")).ifPresent(o -> System.out.println(o));
        System.out.println(option.map(o -> o.get("沒有值的key")));
        System.out.println(option.map(o -> o.get("沒有值的key")).map(String::toString));
        System.out.println(option.map(o -> o.get("沒有值的key")).map(String::toString).isPresent());
    }

}
