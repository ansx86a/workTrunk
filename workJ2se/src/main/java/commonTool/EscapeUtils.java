package commonTool;

import org.apache.commons.lang3.StringEscapeUtils;

public class EscapeUtils {

	public static void main(String[] args) {
		String s=StringEscapeUtils.escapeHtml4("<aa bb ddd>");
		System.out.println(s);
	}

}
