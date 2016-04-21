package 新功能;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Java8Time {

	public static void main(String args[]) {
		//整體上的想法，duration可以套回目前的date配上dateUtils去做加減用
		//再來時區的轉換很複雜，或許用Date本身的會好點
		//TemporalAdjusters.previousOrSame 取得下一個星期X或是上一個星期X是很華麗的功能，有需要時可以考慮寫成tool
		//Period 回傳2個日期差的年、月、日，是分開計的，所以不會有超過12月和31天的情況發生，用途不知道那裡可以用
		Period p =Period.between(LocalDate.now(), LocalDate.of(2010, 3, 3));
		System.out.println(p.getYears()+","+p.getMonths()+","+p.getDays());
		
		System.out.println(new Date().getTime());
		System.out.println(Instant.now());
		System.out.println(Instant.now().getEpochSecond());// 這裡出來的是UTC的毫秒數
		final Instant instant = Instant.parse("2015-04-03T00:00:00Z");
		Duration duration = Duration.parse("PT20M");
		duration = Duration.ofMillis(20);// 和上面相同
		final Instant newInstant = instant.plus(duration); // 會再產生出新的「2015-04-03T00:20:00Z」之Instant物件

		final ZoneId zoneidDefault = ZoneId.systemDefault(); // 系統預設時區
		final ZoneId zoneidPlus8 = ZoneId.of("UTC+8"); // UTC時間+8
		final LocalDateTime nowLocalDateTime = LocalDateTime.ofInstant(Instant.now(), zoneidPlus8);
		System.out.println(nowLocalDateTime);

		// 時區
		final ZoneOffset zoneid8hr1 = (ZoneOffset) ZoneId.of("+8");
		final ZoneOffset zoneid8hr2 = ZoneOffset.of("+8");
		final ZoneOffset zoneid0hr3 = ZoneOffset.ofHours(2);

		final Instant nowLocalDateTimeToInstant = nowLocalDateTime.toInstant(zoneid8hr1);

		// 再來做localTime的測試
		LocalDateTime currentPoint = LocalDateTime.now();

		final LocalDateTime currentPointUTC = LocalDateTime.now(Clock.systemUTC());
		final LocalDateTime currentPointDefault = LocalDateTime.now(Clock.systemDefaultZone()); // 同LocalDateTime.now();
		final LocalDateTime currentPointPlus8 = LocalDateTime.now(Clock.system(ZoneId.of("+8")));

		final LocalDateTime qingming = LocalDateTime.of(2015, 4, 5, 12, 30, 30, 30);
		final LocalDate qingmingDate = LocalDate.of(2015, 4, 5); // 同qingming.toLocalDate()
		final LocalTime qingmingTime = LocalTime.of(12, 30, 30); // 同qingming.toLocalTime()

		final LocalDateTime qingmingParsed = LocalDateTime.parse("2015-04-05T12:30:30");
		final LocalDateTime qingmingParsed2 = LocalDateTime.parse("2015/04/05 12:30:30",
				DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));

		final LocalDate currentDate = LocalDate.now();
		final LocalDate thisMonth = currentDate.withDayOfMonth(1); // 將日期指定為該月1號。注意這裡currentDate並沒有被改變！

		final LocalDateTime nextWeekDateTime = LocalDateTime.now().plusWeeks(1);
		final LocalDateTime next7DaysDateTime = LocalDateTime.now().plusDays(7);
		// 取得目前這個月的最後一天
		final LocalDateTime lastDayOfMonthDateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());

		// 取得距離目前最近的星期三
		final LocalDateTime previousWednesdayDateTime = LocalDateTime.now().with(
				TemporalAdjusters.previousOrSame(DayOfWeek.WEDNESDAY));
		final LocalDateTime nextWednesdayDateTime = LocalDateTime.now().with(
				TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		// 減少時間精確度(Truncation)
		final LocalDateTime hourDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS); // 捨棄比小時小的單位

		// ZonedDateTime的建立與使用
		System.out.println(ZonedDateTime.now());
		final LocalDateTime currentDateTime = LocalDateTime.now();
		final ZonedDateTime zonedCurrentDateTime = currentDateTime.atZone(ZoneId.of("+8"));
		// ZonedDateTime物件因為已經包含了時區資訊，因此可以直接使用toInstant方法，不用代入任何時區參數，就可以轉成Instant物件。
		final Instant zonedCurrentInstant = ZonedDateTime.now().toInstant();

		// 生日和年月，基本上用處不大，大不了用字串做掉
		final MonthDay birthday = MonthDay.of(8, 10);
		final YearMonth creditCard = YearMonth.of(2015, 4);
		// 生日和年月轉日期，要補上少掉的資訊
		final LocalDate birthdayLocalDate = birthday.atYear(1993);
		final LocalDate creditCardLocalDate = creditCard.atDay(5);
	}
}
