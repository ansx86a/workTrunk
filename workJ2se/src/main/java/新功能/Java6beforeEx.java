package 新功能;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.Test;

public class Java6beforeEx {
	static {
		System.out.println("class statis區塊java ex static start");
	}

	public static void main(String[] args) throws Exception {
		// new Scanner(System.in) while(.nextInt()!=0)，用來玩輸入選擇題用的
	}

	@Test
	public void tryLog() {
		Logger log = Logger.getLogger("myLog");
		Logger log2 = Logger.getLogger("myLog");
		System.out.println("log == log2 ->" + (log == log2));
		log.info("just info");
		// log == log2 ->true
		// 八月 05, 2014 9:38:23 上午 ttt.Java6beforeEx tryLog
		// 資訊: just info
	}

	@Test
	public void propertiesTest() throws Exception {
		System.out.println("properties的應用==========================");
		Properties ps = new Properties();
		ps.setProperty("key1", "value1\r\n有換行耶\t有跳脫鍵");
		ps.setProperty("key2", "value2");
		StringWriter sw = new StringWriter();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ps.store(sw, "comments string 序列化的時候可以加一行註解");
		ps.storeToXML(out, "comments xml序列化的時候可以加一行註解");
		// 可以寫出string 也可以寫出xml
		sw.flush();
		sw.close();
		out.flush();
		out.close();
		System.out.println(sw.toString());
		System.out.println(new String(out.toByteArray()));
		// #comments
		// #Tue Aug 05 09:38:23 CST 2014
		// key2=value2
		// key1=value1

		ps = new Properties();
		ps.load(new StringReader(sw.toString()));
		System.out.println("讀取properties的值，驗証\\字元的功能：" + ps.getProperty("key1"));// value1
	}

}
