package 小技巧;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class 集合相關 {

    /**
     * <pre>
     * 1.asList的內容修改，array的內容也會修改
     * 2.array的內容修改，asList的內容也會修改
     * 3.asList不能新增刪除，但是可以set本來的值
     * 使用心得就是一個array的view所以被限制大小
     *
     * </pre>
     */
    @Test
    public void 測試asList() {

        String[] str = new String[]{"aaa", "bbb"};
        List list = Arrays.asList(str);// [aaa, bbb]
        System.out.println(list);
        str[0] = "ccc";
        System.out.println(list);// [ccc, bbb]
        list.set(0, "ddd");
        System.out.println(list);// [ddd, bbb]
        list.add("java.lang.UnsupportedOperationException");
    }

    @Test
    public void 測試subList() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(6);
        List<Integer> list2 = list1.subList(0, 2);
        System.out.println(list1);//[1, 3, 5, 6]
        System.out.println(list2);//[1, 3]
        list2.add(9);
        System.out.println(list1);//[1, 3, 9, 5, 6]
        System.out.println(list2);//[1, 3, 9]

        //實際上list2是一個view，操作會全部反映回原來的list
        System.out.println(list2.getClass());//class java.util.ArrayList$SubList
    }

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
        array = list.toArray(new String[]{});
        System.out.println(Arrays.toString(array));
        array = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }
}
