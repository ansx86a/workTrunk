package tool;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Utils {

	public static File getRootFile() {
		try {
			//File f = new File(Utils.class.getClassLoader().getSystemResource("").toURI());
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			File f = new File(classLoader.getResource("").toURI());
			return f;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static File getResourceFromRoot(String resource) {
		try {
			File f = getRootFile();
			f = new File(f, resource);
			return f;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String[] split(String s, String reg) {
		// 建立中…
		// 忘了這裡要幹嘛用的
		String[] ss = s.split(reg);
		ArrayList<String> list = new ArrayList<>();
		if (1 > 2) {
			return list.toArray(new String[] {});
		}
		return null;
	}

	public static String toHex(byte b) {
		return String.format("%02x", b);
	}

	public static String toHexUpper(byte b) {
		return String.format("%02x", b).toUpperCase();
	}

	public static byte[] hexToBytes(String str) {
		byte[] result = new byte[str.length() / 2];
		for (int i = 0; i < str.length(); i += 2) {
			String s = str.substring(i, i + 2);
			result[i / 2] = (byte) Integer.parseInt(s, 16);
		}
		return result;
	}

}
