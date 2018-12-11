package log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class Step1 {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("我的log哈哈哈");
		logger.debug("這裡還不須要有logback.xml");
		logger.warn("可以把logback.xml刪掉看看印出來的會不一樣");
		logger.info("先測試slf4j可否在console列印出資訊來，成功");
		// 下面感覺是針對logback會去掃一些組態檔如logback.xml，logback-test.xml，logback.groovy
		// 然後把組態檔的資訊列印出來
		// 把logback.xml的debug設成<configuration debug="true">，好像會有相同的效果，在getLogger時就會有同下的效果 
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
		System.out.println("end");
	}

}
