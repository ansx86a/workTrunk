package 小技巧;

import static java.lang.Math.abs;

import java.util.Arrays;

import org.junit.Test;

public class 基本語法 {

	@Test
	public void 位元運算() {
		// 位元運算 ~(not) |(or) &(and) ^(xor) <<(左移) >>(右移)
		System.out.println(Integer.toHexString(1024).toUpperCase());
		System.out.println(Integer.toHexString(~1024).toUpperCase());
		System.out.println("7|3=" + (7 | 3));
		System.out.println("7&3=" + (7 & 3));
		System.out.println("7^3=" + (7 ^ 3));
		System.out.println("7>>1=" + (7 >> 1));// 小數點會不見
		System.out.println("7<<1=" + (7 << 1));
		System.out.println("忽略>>>和<<<的測試，有機會再補");
	}

	@Test
	public void 位元運算byte2value_java7() {
		// 8位byte
		byte aByte = (byte) 0b0010_0001;
		// 16位short
		short aShort = (short) 0b1010000101000101;
		// 32位int
		int anInt1 = 0b10100001010001011010000101000101;
		System.out.println("0b0010_0001[_可選要不要加] =" + aByte);
		// 0b0010_0001[_可選要不要加] =33
	}

	@Test
	public void 判斷isa() {
		// 判斷is a 的時候用
		System.out.println("字串 instanceof String：" + ("xxx" instanceof String));// true

	}

	@Test
	public void 靜態導入() {
		// 靜態導入，參看最上面
		System.out.println("靜態導入 abs(-987)=" + abs(-987));// 987
	}

	@Test
	public void 字串switch_java7() {
		String s = "just do 它";
		switch (s) {
		case "just do 它":
			System.out.println("你switch到了 just do 它");
			break;
		default:
			System.out.println("你switch到default");
			break;
		}
	}

	@Test
	/**
	 * 沒事不要使用，要看需求，阿里巴巴的規範有提有空再補
	 */
	public void 測試不定參數() {
		不定參數(1, "不定參數", 9, 8, 7);
	}

	public void 不定參數(int a, String b, int... c) {
		System.out.println("不定參數(int a, String b, int... c)" + b + Arrays.toString(c));
	}
}
