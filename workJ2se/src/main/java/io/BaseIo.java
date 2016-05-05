package io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import tool.Utils;

public class BaseIo  {

	public static void main(String[] args) throws Exception {
		BaseIo baseIo = new BaseIo();
		// baseIo.設定可讀可寫可執行();
		// baseIo.InputStream讀文字檔();
		// baseIo.bufferedReader讀文字檔();
		baseIo.fileOutputStream寫出文字檔();
		// baseIo.bufferedWriter寫出文字檔();
		// baseIo.copy檔案();
		// baseIo.建立暫存檔();
		// baseIo.序列化物件();
		// baseIo.命令列輸入();
	}

	public void 命令列輸入() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input;
			while ((input = br.readLine()) != null) {
				System.out.println(input);
			}

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public void 序列化物件() throws Exception {
		Address address = new Address();
		address.setStreet("街道11111");
		address.setCountry("國家22222");
		try (FileOutputStream fout = new FileOutputStream(Utils.getResourceFromRoot("io/address.obj"));
				ObjectOutputStream oos = new ObjectOutputStream(fout);) {
			oos.writeObject(address);
		}
		System.out.println("序列化物件 Done");
		// xml就用jaxb吧
		try (FileInputStream fin = new FileInputStream(Utils.getResourceFromRoot("io/address.obj"));
				ObjectInputStream ois = new ObjectInputStream(fin);) {
			System.out.println(ois.readObject());
			System.out.println("反序列化物件 Done");
		}
	}

	public void 建立暫存檔() throws Exception {
		File f = File.createTempFile("我是暫存檔", ".tmp");
		System.out.println(f.getAbsolutePath());
		f.deleteOnExit();
	}

	public void copy檔案() throws Exception {

		File afile = new File("/temptemp/IOTest/test.txt");
		File bfile = new File("/temptemp/IOTest/testCopy.txt");
		try (InputStream inStream = new FileInputStream(afile); OutputStream outStream = new FileOutputStream(bfile)) {
			byte[] buffer = new byte[1024];
			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
		}
		System.out.println("File is copied successful!");
	}

	public void bufferedWriter寫出文字檔() throws Exception {

		String content = "This is the content to write into file";
		for (int i = 0; i < 10; i++) {
			content += content;
		}
		content += "==end";
		File file = Utils.getResourceFromRoot("io/ioTxtFile.txt");
		if (!file.exists()) {
			Object o = file.getParentFile().exists() ? true : file.getParentFile().mkdirs();
			file.createNewFile();
		} else {
			file.delete();
			file.createNewFile();
		}
		// 我試的話好像有close就不用flush，我想java不會那麼笨，應該是不用flush了
		// 反正IOUtils可以做得很好了，不用自已寫了
		try (FileWriter fw = new FileWriter(file.getAbsoluteFile()); BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write(content);
		}
		System.out.println("Done");

	}

	public void fileOutputStream寫出文字檔() throws Exception {
		// 這裡沒用到DataOutputStream有點可惜，有的話會更好
		// 但是考慮到只有純文字的話就沒關系了，直接轉byte丟出去就可以了，這樣應該就是utf8的編碼了
		File file = Utils.getResourceFromRoot("io/ioTxtFile.txt");
		System.out.println(file.getAbsolutePath());
		String content = "This is the text content加個中日文です";
		for (int i = 0; i < 15; i++) {
			content += content;
		}
		content += "=end";

		try (FileOutputStream fop = new FileOutputStream(file)) {
			if (!file.exists()) {
				Object o = file.getParentFile().exists() ? true : file.getParentFile().mkdirs();
				file.createNewFile();
			} else {
				file.delete();
				file.createNewFile();
			}
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			// 我試看來flush好像有做掉，因為不是bufferOutputStream吧可能不用flush吧
			// fop.flush();
			// fop.close();
			System.out.println("Done");
		}
	}

	public void bufferedReader讀文字檔() throws Exception {

		try (BufferedReader br = new BufferedReader(new FileReader("/temptemp/IOTest/test.txt"))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		}
	}

	/**
	 * <pre>
	 * 還用了一層DataInputStream去讀資料，所以可以讀出字串、Boolean……之類的資料
	 * 所以利用DataStream配FileStream去寫資料是不錯的選擇吧
	 * 
	 * <pre>
	 * @throws Exception
	 */
	public void InputStream讀文字檔() throws Exception {
		File file = new File("/temptemp/IOTest/test.txt");
		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis = new DataInputStream(bis);) {
			while (dis.available() != 0) {
				System.out.println(dis.readLine());
			}
		}
	}

	public void 設定可讀可寫可執行() throws Exception {
		File file = new File("/temptemp/IOTest/abc.txt");

		if (file.exists()) {
			System.out.println("Is Execute allow : " + file.canExecute());
			System.out.println("Is Write allow : " + file.canWrite());
			System.out.println("Is Read allow : " + file.canRead());
		}

		file.setExecutable(false);
		file.setReadable(false);
		file.setWritable(false);

		System.out.println("Is Execute allow : " + file.canExecute());
		System.out.println("Is Write allow : " + file.canWrite());
		System.out.println("Is Read allow : " + file.canRead());

		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}

	}

}
