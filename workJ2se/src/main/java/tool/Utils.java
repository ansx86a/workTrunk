package tool;

import java.io.File;
import java.net.URISyntaxException;

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

	public static File getResourceFromRoot(String resourec) {
		try {
			File f = new File(ClassLoader.getSystemResource(resourec).toURI());
			return f;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

}
