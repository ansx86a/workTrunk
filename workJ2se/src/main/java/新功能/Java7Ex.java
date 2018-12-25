package 新功能;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import tool.Utils;

public class Java7Ex {

	public static void main(String[] args) throws Exception {
		// io 多了一個path class
		// nio package
		// auto close
		autoClose();
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

}
