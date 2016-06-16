package 加密;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class Base64AndHash {

	public static void main(String[] args) {
		String s = "什麼鬼東西";
		s = Base64.encodeBase64URLSafeString(s.getBytes());
		System.out.println(s);
		byte[] b = Base64.decodeBase64(s);
		s = new String(b);
		System.out.println(s);
		System.out.print("md5:");
		System.out.println(DigestUtils.md5Hex(s.getBytes()));
		System.out.print("sha256");
		System.out.println(DigestUtils.sha256Hex(s.getBytes()));
	}

}
