package first;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 第一動 ，genDao出來
 * @author ai
 *
 */
public class DaoGenerator {
	// 參照網站
	// http://my.oschina.net/lujianing/blog/200135
	// http://www.jianshu.com/p/e09d2370b796
	// http://mbg.cndocs.tk/running/running.html
	// http://www.mybatis.org/mybatis-3/zh/configuration.html

	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("z:/mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println(warnings.toString().replaceAll(",", "\r\n"));
		System.out.println("end");
	}
}
