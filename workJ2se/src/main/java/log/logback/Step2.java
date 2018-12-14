package log.logback;

import java.io.File;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Step2 {
	static final Logger logger = LoggerFactory.getLogger(Step2.class);

	static String logStr = "一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十";
	public static void main(String[] args) throws InterruptedException {
		File f = new File(".");
		System.out.println(f.getAbsolutePath());
		for(int i = 0 ;i<100;i++) {
			logger.debug("Did it again!" + new Date());
			for(int j=0;j<=1000;j++) {
				logger.debug(logStr);
			}
			Thread.sleep(1000);
		}
	

	}

}
