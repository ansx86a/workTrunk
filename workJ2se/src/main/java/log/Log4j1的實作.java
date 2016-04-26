package log;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;

public class Log4j1的實作 {

	// 正常的寫法
	// private static final Logger logger = Logger.getLogger(Log4j1的實作.class);
	// private Logger logger = Logger.getLogger(Log4j1的實作.class);

	public Log4j1的實作(String log1) {

	}

	public static void main(String[] args) throws Exception {
		$3由name就設定log_並和root脫勾();
	}

	public static void $1初始化log由不特定的properties位置() {
		// 這個例子證明了，log4j是由一個static的實體在控制
		// 所以只能有一個properties，新的會蓋過舊的

		String log1 = "log4j1_01.properties";
		String log2 = "log4j1_02.properties";
		initLog(log1);
		Logger logger = Logger.getLogger(Log4j1的實作.class);
		logger.info("123");
		logger.info("456");
		initLog(log2);
		logger.info("777");
		logger.info("888");
		initLog(log1);
		logger.info("999");
		logger.info("aaa");
	}

	public static void $2由本來的log當template客製化log物件() throws Exception {
		String log1 = "log4j1_01.properties";
		String file = "z:/我的客製化.log";
		String patternLayout = "%d [%p] %m%n";
		String datePattern = "_yyyy-MM-dd";
		String appender = "客製化Appender";
		initLog(log1);// 這一行也可以註解，但是會有警告

		Logger log = Logger.getLogger(Log4j1的實作.class);
		log.info("舊舊52");// root的都會印
		log.removeAllAppenders();

		if (log.getAppender(appender) == null) {
			PatternLayout pattern = new PatternLayout(patternLayout);
			DailyRollingFileAppender dailyRollingFileAppender = new DailyRollingFileAppender(pattern, file, datePattern);
			dailyRollingFileAppender.setName(appender);
			log.addAppender(dailyRollingFileAppender);
		}
		log.info("新新52");// root和新加的都印
		log.removeAllAppenders();
		log = Logger.getLogger(Log4j1的實作.class);
		log.info("新新新新64");// root的都會印
		log.info(log.getAppender(appender));
		log.info(log.getAppender("file"));
		// 結論，怪怪的
		// 動態加的在removeAppenders後，重新取的log就不會有動態的打印
		// 沒有removeAppenders，重新取的log仍然會動態打印
		// 這種動態的加法，適合本來就沒有寫出任何檔案的地方，不能這個程式的log影嚮到別的程式的log就不好

		// 想到一個合適的地方，就是在台新銀行的batch程式，包了10幾支，如果要包成jar檔
		// 可以寫很多log4j設定檔分別載入，或者是寫一個batch共同的，然後用這個方式動態加設定

	}

	public static void $3由name就設定log_並和root脫勾() {
		String log1 = "log4j1_11.properties";
		String log2 = "log4j1_12.properties";
		initLog(log1);
		Logger logger = Logger.getLogger("name1");
		logger.info("root看得到");
		logger.debug("root也看得到");
		//這裡2個都看得到，因為每個子類都會去繼承Root，然後debug或info等級只看自已不看Root
		initLog(log2);
		logger = Logger.getLogger("name2");
		logger.info("root看不到");
		//這裡有設定log4j.additivity.name2=false，所以不會繼承root的設定

	}

	public static void initLog(String log1) {
		Properties p = new Properties();
		try {
			p.load(ClassLoader.getSystemResourceAsStream("log/" + log1));
			PropertyConfigurator.configure(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
