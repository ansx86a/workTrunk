package 日期處理;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class LocalDate處理 {

    @Test
    public void 取得上個星期X() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.getDayOfWeek());
        LocalDate d = now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        System.out.println(d);
        System.out.println(d.getDayOfWeek());
    }


    @Test
    public void LocalDateTime轉成Date() {
        LocalDateTime ld = LocalDateTime.now().plusDays(-1);
        //方法1，和方法2類似我也覺得不錯
        Date d = new Date(ld.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(d);
        //方法2 ，這個我比較喜歡，比較短
        d = Date.from(ld.toInstant(ZoneOffset.ofHours(8)));
        System.out.println(d);
        //方法3，有點長，比較不喜歡，就用方法1吧
        d = Date.from(ld.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(d);
    }

    @Test
    public void Date轉成LocalDateTime() {
        Date d = new Date();
        LocalDateTime ld = null;
        ld = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(ld);
        //這個好一點，
        ld = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
        System.out.println(ld);

    }

    public void format和parser() {
        final LocalDateTime qingmingParsed = LocalDateTime.parse("2015-04-05T12:30:30");
        final LocalDateTime qingmingParsed2 = LocalDateTime.parse("2015/04/05 12:30:30",
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        qingmingParsed.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));

    }

    @Test
    public void LocalDateTime的限制() {
        //truncate只能到日，月的話不行
        //沒辦法取得今天是不是第一週(使用TemporalAdjusters也許可以)，Calendar好像也做不到

    }

}
