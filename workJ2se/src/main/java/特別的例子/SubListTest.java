package 特別的例子;

import java.util.ArrayList;
import java.util.List;

public class SubListTest {

    public static void main(String args[]) {
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
}
