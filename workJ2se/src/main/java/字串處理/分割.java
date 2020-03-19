package 字串處理;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

public class 分割 {

    @Test
    public void 加在一起比較() {
        String s = ",1,,2,3,   4   ,,";//不要格式化，不然辛苦加的空格會不見
        //會遺失最後的空值
        System.out.println(Arrays.toString(s.split(",")));// [, 1, , 2, 3,    4   ]
        //會遺失全部的空值
        System.out.println(Arrays.toString(StringUtils.split(s, ",")));// [1, 2, 3,    4   ]
        //不懂
        System.out.println(Arrays.toString(StringUtils.splitByWholeSeparator(s, ",")));// [1, 2, 3,    4   , ]
        //保留全部的空值
        System.out.println(Arrays.toString(StringUtils.splitPreserveAllTokens(s, ",")));// [, 1, , 2, 3,    4   , , ]
        //保留全部的空值
        System.out.println(Splitter.on(",").splitToList(s));// [, 1, , 2, 3,    4   , , ]
        //保留全部的空值加上trim
        System.out.println(Splitter.on(",").trimResults().splitToList(s));// [, 1, , 2, 3, 4, , ]
        //遺失全部的空值加上trim
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().splitToList(s));// [1, 2, 3, 4]


    }

    @Test
    public void guava字串處理() {
        String str = ",1,   null  ,2,,  3  ,4,   ,5,";
        System.out.println(Splitter.on(",").splitToList(str));
        System.out.println(Splitter.on(",").trimResults().splitToList(str));
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str));
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str));
        //on可用正規表示式 pattern

    }

}
