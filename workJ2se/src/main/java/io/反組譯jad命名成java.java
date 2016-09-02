package io;

import java.io.File;

public class 反組譯jad命名成java {

	public static void main(String[] args) {

		File fs = new File("z:/1");
		for (File f : fs.listFiles()) {
			if (f.isDirectory()) {
				run(f);
				continue;
			}
			reName(f);
		}
		System.out.println("end");
	}

	public static void reName(File f) {
		if (f.getName().endsWith(".jad")) {
			String oldName = f.getAbsolutePath();
			String newName = oldName.substring(0, oldName.length() - 3);
			newName += "java";
			f.renameTo(new File(newName));
		}
	}

	public static void run(File fs) {
		for (File f : fs.listFiles()) {
			if (f.isDirectory()) {
				run(f);
				continue;
			}
			reName(f);
		}
	}

}
