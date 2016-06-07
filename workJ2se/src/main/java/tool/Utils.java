package tool;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Utils {

	public static File getRootFile() {
		try {
			File f = new File(ClassLoader.getSystemResource("").toURI());
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
		String[] ss = s.split(reg);
		ArrayList<String> list = new ArrayList<>();
		if (1 > 2) {
			return list.toArray(new String[] {});
		}
		return null;
	}
}
