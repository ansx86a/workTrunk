package ldap;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeTransform {

	public TimeTransform() {
	}

	public String calendar2NdsTimeString(Calendar time) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTimeInMillis(time.getTime().getTime());
		TimeZone ttz = TimeZone.getTimeZone("UTC");
		rightNow.setTimeZone(ttz);
		int day = rightNow.get(5);
		int month = rightNow.get(2) + 1;
		int year = rightNow.get(1);
		int hour = rightNow.get(11);
		int min = rightNow.get(12);
		int sec = rightNow.get(13);
		DecimalFormat df2 = new DecimalFormat("00");
		DecimalFormat df4 = new DecimalFormat("0000");
		String ndsTimeString = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(df4
				.format(year))))).append(df2.format(month)).append(df2.format(day)).append(df2.format(hour))
				.append(df2.format(min)).append(df2.format(sec)).append("Z")));
		return ndsTimeString;
	}

	public Calendar ndsTime2Calendar(String ndsTimeString) {
		Calendar calendar;
		try {
			int year = (new Integer(ndsTimeString.substring(0, 4))).intValue();
			int month = (new Integer(ndsTimeString.substring(4, 6))).intValue();
			int day = (new Integer(ndsTimeString.substring(6, 8))).intValue();
			int hour = (new Integer(ndsTimeString.substring(8, 10))).intValue();
			int min = (new Integer(ndsTimeString.substring(10, 12))).intValue();
			int sec = (new Integer(ndsTimeString.substring(12, 14))).intValue();
			TimeZone tz = TimeZone.getTimeZone("UTC");
			Calendar cal = Calendar.getInstance(tz);
			cal.set(year, month - 1, day, hour, min, sec);
			cal.setTimeZone(TimeZone.getDefault());
			Calendar calendar1 = cal;
			return calendar1;
		} catch (Exception e) {
			calendar = null;
		}
		return calendar;
	}

	public Calendar serialTimeStringToCalendar(String timeString) {
		Calendar calendar;
		try {
			int year = (new Integer(timeString.substring(0, 4))).intValue();
			int month = (new Integer(timeString.substring(4, 6))).intValue();
			int day = (new Integer(timeString.substring(6, 8))).intValue();
			int hour = (new Integer(timeString.substring(8, 10))).intValue();
			int min = (new Integer(timeString.substring(10, 12))).intValue();
			int sec = (new Integer(timeString.substring(12, 14))).intValue();
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, day, hour, min, sec);
			Calendar calendar1 = cal;
			return calendar1;
		} catch (Exception e) {
			calendar = null;
		}
		return calendar;
	}

	public String calendarToSerialTimeString(Calendar rightNow) {
		int day = rightNow.get(5);
		int month = rightNow.get(2) + 1;
		int year = rightNow.get(1);
		int hour = rightNow.get(11);
		int min = rightNow.get(12);
		int sec = rightNow.get(13);
		DecimalFormat df2 = new DecimalFormat("00");
		DecimalFormat df4 = new DecimalFormat("0000");
		String timeString = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(df4
				.format(year))))).append(df2.format(month)).append(df2.format(day)).append(df2.format(hour))
				.append(df2.format(min)).append(df2.format(sec))));
		return timeString;
	}

	public String calendarToSerialDateString(Calendar rightNow) {
		int day = rightNow.get(5);
		int month = rightNow.get(2) + 1;
		int year = rightNow.get(1);
		DecimalFormat df2 = new DecimalFormat("00");
		DecimalFormat df4 = new DecimalFormat("0000");
		String timeString = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(df4
				.format(year))))).append(df2.format(month)).append(df2.format(day))));
		return timeString;
	}
}