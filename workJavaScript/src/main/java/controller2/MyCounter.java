package controller2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class MyCounter {
	private int count = 0;
	private byte[] b;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public void read(File f) {
		try {
			b = FileUtils.readFileToByteArray(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}