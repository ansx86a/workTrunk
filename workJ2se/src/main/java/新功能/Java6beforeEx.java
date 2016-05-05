package 新功能;

import static java.lang.Math.abs;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class Java6beforeEx {
	static {
		System.out.println("class statis區塊java ex static start");
	}

	private List<String> 匿名加內容的List = new ArrayList<String>() {
		{
			add("msg 1");
			add("msg 2");
			add("msg 3");
			int i = 0;
			add("msg i->" + i);
		}
	};


	public static void main(String[] args) throws Exception {
		Java6beforeEx j = new Java6beforeEx();
		System.out.println(j.匿名加內容的List);
		
		j.$1靜態導入();
		j.$2printf();
		j.$3邊界和浮點誤差();
		j.$5不定參數(1, "不定參數", 9, 8, 7);
		// 位元運算 ~(not) |(or) &(and) ^(xor) <<(左移) >>(右移)
		// new Scanner(System.in) while(.nextInt()!=0)，用來玩輸入選擇題用的
		// interface中 [public abstract] void method(); ，中括號的東西可以被省略
		// 判斷is a 的時候用
		System.out.println("xxx" instanceof String);// true
		// properties的測試
		propertiesTest();
		// finally的測試
		trytryFinally();
		// 測試log
		tryLog();// 好像沒什麼用
	}

	public void $1靜態導入() {
		// 靜態導入，參看最上面
		System.out.println(abs(-987));// 987
	}

	public void $2printf() {
		// printf範列
		System.out.println("十進整%d,十進浮%.2f,科學%.2e,八進%o,16進%x%h,換行%n字串%s,char%C%c,布林%b有值為%b");
		System.out.printf("十進整%d,十進浮%.2f,科學%.2e,八進%o,16進%x%h,換行%n字串%s,char%C%c,布林%b有值為%b", 077, 21.23456, 3210.234,
				123, 123, 123, 123, 'a', 97, false, "false");// 十進整63,十進浮21.23,科學3.21e+03,八進173,16進7b7b,換行//字串123,charAa,布林false有值為true
	}

	public void $3邊界和浮點誤差() {
		// 浮點數宣告
		float b = 12.3e-3f;// 預設是double
		// 沒有溢位的exception
		int a = Integer.MAX_VALUE;
		a++;
		System.out.println(a);// -2147483648
		// double會有誤差，不好用來算錢，雖然誤差很小
		System.out.println("" + (1.0 - 0.8));// 0.19999999999999996
	}

	public void $4泛型類別() {
		// 測試寫一個泛型class
		泛型類別<String> te = new 泛型類別<String>();
		te.run();
		te.add("eee");
		te.run();
	}

	public void $5不定參數(int a, String b, int... c) {
		System.out.println(b + Arrays.toString(c));
	}

	private static void tryLog() {
		Logger log = Logger.getLogger("myLog");
		Logger log2 = Logger.getLogger("myLog");
		System.out.println("log == log2 ->" + (log == log2));
		log.info("just info");
		// log == log2 ->true
		// 八月 05, 2014 9:38:23 上午 ttt.Java6beforeEx tryLog
		// 資訊: just info
	}

	private static void propertiesTest() throws Exception {
		Properties ps = new Properties();
		ps.setProperty("key1", "value1\r\n有換行耶\t有跳脫鍵");
		ps.setProperty("key2", "value2");
		StringWriter sw = new StringWriter();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ps.store(sw, "comments string");
		ps.storeToXML(out, "comments xml");
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
		System.out.println(ps.getProperty("key1"));// value1

	}

	private static void trytryFinally() {

		try {
			System.out.println("start try");
			return;
		} finally {
			System.out.println("就算在try或catch return，也會跑finally");
		}
		// start try
		// finally after return
	}

	static class 泛型類別<E> {
		E a = null;

		void run() {
			System.out.println(a);
		}

		void add(E a) {
			this.a = a;
		}
	}

}
