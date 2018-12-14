package log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * 可以參照github中的內容 <br>
 * https://github.com/Volong/logback-chinese-manual
 * 
 * @author ai
 *
 */
public class Step1 {
/**
 * <pre>
 * 舊版的要先加入maven，2個依賴如下 
 * 	<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
			<version>1.0.13</version>
		</dependency>

		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>1.8.0-beta2</version>
		</dependency>
		
		新舊的只要加logback的依賴就好了
 * </pre>
 * 
 * @param args
 */
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("我的log哈哈哈");
		logger.debug("這裡還不須要有logback.xml");
		logger.warn("可以把logback.xml刪掉看看印出來的會不一樣");
		logger.info("先測試slf4j可否在console列印出資訊來，成功");
		// 下面感覺是針對logback會去掃一些組態檔如logback.xml，logback-test.xml，logback.groovy
		// 然後把組態檔的資訊列印出來
		// 把logback.xml的debug設成<configuration
		// debug="true">，好像會有相同的效果，在getLogger時就會有同下的效果
		//目的應該是log組態有錯或是log出不來的校正吧
		//<statusListener class="ch.qos.logback.core.status.OnConsoleStatusListener" />也可以設置
		
		
		//以下新版不能用，先mark起來
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
		System.out.println("end");
	}

}
