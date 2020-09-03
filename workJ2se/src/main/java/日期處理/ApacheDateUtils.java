package 日期處理;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.lang.ref.Cleaner;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class ApacheDateUtils {

    @Test
    public void 轉字串() {
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
    }

    @Test
    public void 轉成Date() throws ParseException {
        //可以傳多個format
        Date d = DateUtils.parseDate("2020-01-03", "yyyy-MM-dd", "yyyyMMdd");
        System.out.println(d);
    }

    @Test
    public void truncateDate() {
        Date d = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
        System.out.println(d);
        d = DateUtils.truncate(new Date(), Calendar.MONTH);
        System.out.println(d);

    }

}
