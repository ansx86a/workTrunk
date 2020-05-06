package 日期處理;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class Date和Calendar處理 {

    public void cal() {
        Calendar c = Calendar.getInstance();
        System.out.println(c);

    }

    @Test
    public void 取得上個月初和月底() {
        //先用月份truncate取得這個月的1號，再減1天即可
        Date lastMonthEnd = DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.MONTH), -1);
        Date lastMonthStart = DateUtils.truncate(lastMonthEnd, Calendar.MONTH);
        System.out.println(lastMonthEnd);
        System.out.println(lastMonthStart);
    }
}
