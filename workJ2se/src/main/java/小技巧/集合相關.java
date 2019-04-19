package 小技巧;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class 集合相關 {
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
}
