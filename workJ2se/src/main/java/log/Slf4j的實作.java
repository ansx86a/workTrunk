package log;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4j的實作 {
	// http://www.mkyong.com/spring-mvc/spring-mvc-logback-slf4j-example/
	// http://note-whu.rhcloud.com/2015/09/28/%E5%9C%A8spring%E4%B8%8B%E4%BD%BF%E7%94%A8slf4jlog4j/
	public static void main(String[] args) {
		// 這裡有一個問題是，log只在控制台列印，實際上不會有輸出
		// Slf4j可能無法支援log4j的PropertyConfigurator.configure(p);
		// 但是如果是Log4J預設目錄放log4j.properties就不會有問題

		// PropertyConfigurator.configure("log/log4j1_11.properties");
		initLog("log4j1_11.properties");
		Logger logger = LoggerFactory.getLogger(Slf4j的實作.class);
		logger.error("什麼鬼東西");
		logger.info("xxxddd");
		logger.info("dddd|{}| dddd|{}|", "ggg", "xxx");
		logger.info("dddd|{}| dddd|{}|", "ggg", "xxx", "多一個");
		logger.info("dddd|{}| dddd|{}|", "少一個");
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
