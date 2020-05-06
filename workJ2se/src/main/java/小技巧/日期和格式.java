package 小技巧;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class 日期和格式 {
    @Test
    public void Double轉數字格式和去小數點() {
        DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
        DecimalFormat df2 = new DecimalFormat("###,###,###,##0.00");
        DecimalFormat df3 = new DecimalFormat("###,###,#00,000.00");
        df.setRoundingMode(RoundingMode.DOWN);
        double d = 0.229;
        System.out.println(df.format(d));
        System.out.println(df2.format(d));
        System.out.println(df3.format(d));
    }


}
