package controller2;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

public class MyThreadLocal2 {

	private static ThreadLocal t = new ThreadLocal();

	/**
	 * 用來測javase，可以gc，不知道quartz能不能gc
	 */
	public static void save() {
		byte[] b;
		try {
			b = FileUtils.readFileToByteArray(new File("z:/1.bin"));
			String s = Base64.getEncoder().encodeToString(b);
			t.set(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 測試後發現有remove後，好像可以阻止記憶體一直變大(應該有實用價值，能不能真的都gc還不知道)
	 * @param s
	 */
	public static void saveStr(String s) {
		// t.remove();
		t.set(s);
		t.remove();
	}

	/**
	 * 用來測web，把值設在request中可以gc，但是設在其它的地方就無法gc<br>
	 * 如果是用webloader的話，就都擺在request裡吧
	 * @param request
	 */
	public static void save(HttpServletRequest request) {
		try {
			byte[] b = FileUtils.readFileToByteArray(new File("z:/1.bin"));
			String s = Base64.getEncoder().encodeToString(b);

			// 不能gc: {
			// t.remove();
			// t.set(s);
			// s=null;
			// }

			可以gc: {
				request.setAttribute("s", s);
				t.set(request);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}