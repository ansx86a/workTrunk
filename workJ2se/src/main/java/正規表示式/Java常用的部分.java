package 正規表示式;

import java.util.regex.Pattern;

public class Java常用的部分 {

    public static void main(String[] args) {
        String pattern = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
        String str = "1996-08-06";
        System.out.println(str.matches(pattern));
        System.out.println(str.matches("\\Q1996-08-06\\E"));
        System.out.println(str.matches(Pattern.quote("1996-08-06")));
        // pattern的一些用法有空多研究一下

    }

}
