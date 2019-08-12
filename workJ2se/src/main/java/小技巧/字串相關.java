package 小技巧;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Splitter;

public class 字串相關 {

    public static void main(String[] args) {
        split();
        split2();
    }

    /**
     * <pre>
    [, 1, , 2, 3,    4   ]
    [1, 2, 3,    4   ]
    [1, 2, 3,    4   , ]
    [, 1, , 2, 3,    4   , , ]
    [, 1, , 2, 3,    4   , , ]
    [, 1, , 2, 3, 4, , ]
    [1, 2, 3, 4]
     * </pre>
     */
    private static void split() {
        String s = ",1,,2,3,   4   ,,";// 不要格式化，不然辛苦加的空格會不見
        System.out.println(Arrays.toString(s.split(",")));// [, 1, , 2, 3, 4 ]
        System.out.println(Arrays.toString(StringUtils.split(s, ",")));// [1, 2, 3, 4 ]
        System.out.println(Arrays.toString(StringUtils.splitByWholeSeparator(s, ",")));// [1, 2, 3, 4 , ]
        System.out.println(Arrays.toString(StringUtils.splitPreserveAllTokens(s, ",")));// [, 1, , 2, 3, 4 , , ]
        System.out.println(Splitter.on(",").splitToList(s));// [, 1, , 2, 3, 4 , , ]
        System.out.println(Splitter.on(",").trimResults().splitToList(s));// [, 1, , 2, 3, 4, , ]
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().splitToList(s));// [1, 2, 3, 4]
    }

    private static void split2() {
        System.out.println("當split為空值時是每個字元都會被切出來，包含空白字元");
        String s = "123456780     abcdefghijk";
        System.out.println(s);
        System.out.println(Arrays.toString(s.split("")));

    }
}
