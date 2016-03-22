package first;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * 第三動 加入擴充功能的DAO
 * @author ai
 *
 */
public class 增加繼承的Dao {

	public static void main(String[] args) throws Exception {
		new 增加繼承的Dao().run("Ext");
		System.out.println("end");
	}

	public void run(String append) throws Exception {
		File dir = new File("Z:\\1\\dao");
		File newDir = new File("z:\\1\\dao\\" + append);
		for (File f : dir.listFiles()) {
			if (!f.getName().endsWith(".java")) {
				continue;
			}
			String s = FileUtils.readFileToString(f);
			s = s.substring(0, s.indexOf("{")) + "{}";
			String className = f.getName().split("\\.")[0];
			String newClassName = className + append;
			s = s.replaceFirst("public interface " + className, "public interface " + newClassName + " extends "
					+ className);
			File resultFile = new File(newDir, newClassName + ".java");
			FileUtils.writeStringToFile(resultFile, s);
		}

	}

}
