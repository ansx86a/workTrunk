package first;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

/**
 * 第二動 改sqlmap
 * @author ai
 *
 */

public class 修改SqlmapNamespace {

	public static void main(String[] args) throws Exception {
		new 修改SqlmapNamespace().run("Ext");
		System.out.println("end");
	}

	public void run(String append) throws Exception {
		Pattern p = Pattern.compile("namespace=\"([\\w]{1,20}\\.?){1,20}\" >");
		File dir = new File("Z:\\1\\sqlmap");
		File newDir = new File("z:\\1\\sqlmap\\" + append);
		for (File f : dir.listFiles()) {
			if (!f.getName().endsWith(".xml")) {
				continue;
			}
			String s = FileUtils.readFileToString(f);
			Matcher m = p.matcher(s);
			StringBuffer nameSpace = new StringBuffer();
			if (m.find()) {
				nameSpace = nameSpace.append(m.group());
			} else {
				continue;
			}
			int index = s.indexOf(nameSpace.toString());
			String s1 = s.substring(0, index);
			String s3 = s.substring(index + nameSpace.length());
			String s2 = nameSpace.insert(nameSpace.length() - 3, append).toString();
			File resultFile = new File(newDir, f.getName());
			FileUtils.writeStringToFile(resultFile, s1 + s2 + s3);
		}
	}

}
