package 小技巧;

import static java.lang.Math.abs;

import java.util.Arrays;

import org.junit.Test;

public class 基本語法 {

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
	/** 沒事不要使用，要看需求，阿里巴巴的規範有提有空再補. */
	public void 測試不定參數() {
		不定參數(1, "不定參數", 9, 8, 7);
	}

	public void 不定參數(int a, String b, int... c) {
		System.out.println("不定參數(int a, String b, int... c)" + b + Arrays.toString(c));
	}
}
