package tool;

/*
 * Excel是用雙引號加上&來串字串的，本例可省去處理""和&的部分
 */
public class ExcelStringCreater {

	private StringBuffer result = new StringBuffer();

	public static void main(String[] args) {
		ExcelStringCreater c = new ExcelStringCreater();
		c.appendStr("update SEC_FUNCTION set FUNCTION_NAME ='");
		c.appendColumn("E2");
		c.appendStr("'  where FUNCTION_ID = '");
		c.appendColumn("D2");
		c.appendStr("';");
		System.out.println(c.getResult());
	}

	public void appendStr(String str) {
		if (result.length() == 0) {
			result.append("=");
		}
		if (result.length() > 1) {
			result.append("&");
		}
		result.append("\"");
		result.append(str);
		result.append("\"");
	}

	public void appendColumn(String column) {
		if (result.length() == 0) {
			result.append("=");
		}
		if (result.length() > 1) {
			result.append("&");
		}
		result.append(column);
	}

	public String getResult() {
		return result.toString();
	}

}
