package 新功能;

import org.junit.Test;

public class 新功能整理出比較可能用的 {

	@Test
	public void 數字轉16進字串和16進字串轉數字() {
		// 注意會有補0的問題
		int i = 1234;
		String hex = Integer.toHexString(i).toUpperCase();
		System.out.println(hex);
		int result = Integer.valueOf(hex, 16);
		System.out.println(result);
	}

	@Test
	public void 常用printf() {
		// 可以參考這裡，很詳細 http://blog.csdn.net/lonely_fireworks/article/details/7962171
		// printf範列
		System.out.println("十進整%d,十進浮%.2f,科學%.2e,八進%o,16進%x%h,換行%n字串%s,char%C%c,布林%b有值為%b");
		System.out.printf("十進整%d,十進浮%.2f,科學%.2e,八進%o,16進%x%h,換行%n字串%s,char%C%c,布林%b有值為%b\r\n", 077, 21.23456, 3210.234,
				123, 123, 123, 123, 'a', 97, false, "false");// 十進整63,十進浮21.23,科學3.21e+03,八進173,16進7b7b,換行//字串123,charAa,布林false有值為true
		System.out.printf("printf 左靠|%-5s|%-5d|\r\n", 20, 20);
		System.out.printf("printf 數字補0|%05d|\r\n", 20);
		System.out.printf("printf 16進制補0|%02x|\r\n", 11);

	}
}
