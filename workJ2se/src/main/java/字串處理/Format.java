package 字串處理;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import org.junit.Test;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;

public class Format {


    @Test
    public void testStringFormat() {
        System.out.println(String.format("用%s來替代", "{替換文字}"));
    }

    @Test
    public void testSlf4jFormat() {
        //超過2個的用 MessageFormatter.arrayFormat
        FormattingTuple tp = MessageFormatter.format("可傳2個參數：{} _ {}", "[參數1]", "[參數2]");
        System.out.println(tp.getMessage());
        System.out.println(Arrays.toString(tp.getArgArray()));
    }

    @Test
    public void testJavaMessageFormat() {
//http://vence.github.io/2016/04/29/javamethod-messageformat/

        //{index,FormatType,FormatStyle}  index是從0開始
        //FormatType: ：number,date,time,choice：调用ChoiceFormat进行格式化
        //FormatStyle :short,medium,long,full,integer,currency,percent,SubformatPattern (子格式模式，形如#.##)

        System.out.println(MessageFormat.format("{0},{1},{2},{0} 可用數字來設出出值的位置，可重覆出現", "[參數0]", "[參數1]"));

        System.out.println(MessageFormat.format("可以針對數字格式化小數點，會4捨5入{0,number,##.##} ", 456.789));

        System.out.println(MessageFormat.format("強轉成int會四捨5入{0,number,integer}", 456.789));

        System.out.println(MessageFormat.format("單引號會不見 ex:'a' is not {0}", 456.789));
        System.out.println(MessageFormat.format("單引號要2個才不會不見 ex:''a'' is not {0}", 456.789));
        System.out.println(MessageFormat.format("單狎號使佔位符失效 '{0}{1}'  '{0}'  '{0}{1} {0}{1}' {0} {1} 'xx {0} {1} ", "零", "一"));

        System.out.println(MessageFormat.format("正常來說不能使用括號，除非使用跳脫字元如右 '{'{0}'}'", "零"));

        System.out.println(MessageFormat.format("日期時間：{0,date} - {0,time}", new Date()));


    }

    @Test
    public void guava字串處理() {
        CharMatcher.javaDigit();//CharMatcher感覺不好用，跳過，我喜歡直接用正規表示式來操作

        //可以轉換 db <-> java的get,set之類的
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "abc_def_ggg"));
    }

    @Test
    public void 常用printf() {
        // 可以參考這裡，很詳細 http://blog.csdn.net/lonely_fireworks/article/details/7962171
        // printf範列
        System.out.println("十進整%d,十進浮%.2f,科學%.2e,八進%o,16進%x%h,換行%n字串%s,char%C%c,布林%b有值為%b");
        System.out.printf("十進整%d,十進浮%.2f,科學%.2e,八進%o,16進%x%h,換行%n字串%s,char%C%c,布林%b有值為%b\r\n", 077, 21.23456, 3210.234,
                123, 123, 123, 123, 'a', 97, false, "false");// 十進整63,十進浮21.23,科學3.21e+03,八進173,16進7b7b,換行//字串123,charAa,布林false有值為true
        System.out.printf("printf 左靠|%-5s|%-5d|\r\n", 20, 20);
        System.out.printf("printf 數字補0|%05d|\r\n", 20);
        System.out.printf("printf 16進制補0|%02x|\r\n", 11);

    }

    @Test
    public void 數字轉16進字串和16進字串轉數字() {
        // 注意會有補0的問題
        int i = 1234;
        String hex = Integer.toHexString(i).toUpperCase();
        System.out.println(hex);
        int result = Integer.valueOf(hex, 16);
        System.out.println(result);
    }
}
