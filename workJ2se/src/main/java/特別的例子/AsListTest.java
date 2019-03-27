package 特別的例子;

import java.util.Arrays;
import java.util.List;

public class AsListTest {

    /**
     * <pre>
     * 1.asList的內容修改，array的內容也會修改
     * 2.array的內容修改，asList的內容也會修改
     * 3.asList不能新增刪除，但是可以set本來的值
     * 使用心得就是一個array的view所以被限制大小
     * 
     * </pre>
     * 
     * @param args
     */
    public static void main(String[] args) {

        String[] str = new String[] { "aaa", "bbb" };
        List list = Arrays.asList(str);// [aaa, bbb]
        System.out.println(list);
        str[0] = "ccc";
        System.out.println(list);// [ccc, bbb]
        list.set(0, "ddd");
        System.out.println(list);// [ddd, bbb]
        list.add("java.lang.UnsupportedOperationException");

    }

}
