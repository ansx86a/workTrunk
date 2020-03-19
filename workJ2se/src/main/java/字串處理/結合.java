package 字串處理;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class 結合 {
    @Test
    public void guava字串處理() {
        List<String> list = Arrays.asList("", "0", "1", null, "2", "", "3", "");
        System.out.println(Joiner.on(";").skipNulls().join(list));//沒skip null 會出ex
        System.out.println(Joiner.on(";").useForNull("null string").join(list));


        String str = ",1,   null  ,2,,  3  ,4,   ,5,";
        System.out.println(Splitter.on(",").splitToList(str));
        System.out.println(Splitter.on(",").trimResults().splitToList(str));
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str));
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str));
        //on可用正規表示式 pattern

        CharMatcher.javaDigit();//CharMatcher感覺不好用，跳過，我喜歡直接用正規表示式來操作

        //可以轉換 db <-> java的get,set之類的
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "abc_def_ggg"));
    }
}
