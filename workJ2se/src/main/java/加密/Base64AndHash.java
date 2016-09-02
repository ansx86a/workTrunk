package 加密;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;

public class Base64AndHash {

	public static void main(String[] args) throws IOException {
		String s = "什麼鬼東西";
		s = 安全的base64在url當中(s);
		System.out.println(s);
		s = base64解碼(s);
		System.out.println(s);
		System.out.print("md5:");
		System.out.println(雜湊md5(s));
		System.out.print("sha256:");
		System.out.println(雜湊sha256(s));
		System.out.println("image base64");
		System.out.println(image2Base64("z:/1.jpg"));
	}

	public static String 安全的base64在url當中(String s) {
		return Base64.encodeBase64URLSafeString(s.getBytes());
	}

	public static String base64解碼(String s) {
		byte[] b = Base64.decodeBase64(s);
		s = new String(b);
		return s;
	}

	public static String 雜湊md5(String s) {
		return DigestUtils.md5Hex(s.getBytes());
	}

	public static String 雜湊sha256(String s) {
		return DigestUtils.sha256Hex(s.getBytes());
	}

	public static String image2Base64(String path) throws IOException {
		File f = new File(path);
		if (!f.exists() || f.isDirectory()) {
			return "";
		}
		byte[] bs = FileUtils.readFileToByteArray(f);
		return Base64.encodeBase64String(bs);
	}
}
