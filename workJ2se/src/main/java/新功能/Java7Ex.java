package 新功能;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import tool.Utils;

public class Java7Ex {

	public static void main(String[] args) throws Exception {
		// io 多了一個path class

		// 泛型宣告
		List<String> list = new ArrayList<>();
		// auto close
		autoClose();
		// 字符串终于可以 switch 啦。
		strSwitch();
		// 2進位表示取值
		byte2value();
		// Exception可用or表複數
		/*
		 * catch (IOException|SQLException ex) { logger.log(ex); throw ex; }
		 */
	}

	public static void autoClose() throws Exception {
		BufferedReader br1 = null;
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(
				Utils.getResourceFromRoot("新功能/test.txt")), "ms950");
				BufferedReader br = new BufferedReader(isr)) {
			br1 = br;
			System.out.println(br.readLine());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// 照理說是被關了，會丟出closed的消息
		try {
			System.out.println(br1.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void strSwitch() {
		String s = "just do 它";
		switch (s) {
		case "just do 它":
			System.out.println("你switch到了 just do 它");
			break;
		default:
			System.out.println("你switch到default");
			break;
		}
		// 你switch到了 just do 它
	}

	public static void byte2value() {
		// 8位byte
		byte aByte = (byte) 0b0010_0001;
		// 16位short
		short aShort = (short) 0b1010000101000101;
		// 32位int
		int anInt1 = 0b10100001010001011010000101000101;
		System.out.println("0b0010_0001[_可選要不要加] =" + aByte);
		// 0b0010_0001[_可選要不要加] =33
	}

}
