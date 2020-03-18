package format;

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


}
