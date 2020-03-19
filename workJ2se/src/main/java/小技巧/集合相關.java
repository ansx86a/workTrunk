package 小技巧;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class 集合相關 {
    private List<String> 匿名加內容的List = new ArrayList<>() {
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
    public void toArray的用法不用轉型() {
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = new String[list.size()];// 好像和直接用new String[] {}一樣
        array = list.toArray(array);
        System.out.println(Arrays.toString(array));
        array = list.toArray(new String[] {});
        System.out.println(Arrays.toString(array));
        array = list.toArray(new String[0] );
        System.out.println(Arrays.toString(array));
    }
}
