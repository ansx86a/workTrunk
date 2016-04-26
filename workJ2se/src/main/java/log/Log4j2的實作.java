package log;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

public class Log4j2的實作 {

	public static void main(String[] args) throws Exception {
		// 只要把log4j2.xml放在resource下就可以自動讀出Log4j2了
		InputStream in = ClassLoader.getSystemResourceAsStream("log/log4j2.xml");
		ConfigurationSource source = new ConfigurationSource(in);
		Configurator.initialize(null, source);
		Logger logger = LogManager.getLogger(Log4j2的實作.class);
		logger.info("這不是xxx");
		logger.debug("這是yyy");
		logger = LogManager.getLogger("test");
		logger.info("這不是xxx");
		logger.debug("這是yyy");

	}

}
