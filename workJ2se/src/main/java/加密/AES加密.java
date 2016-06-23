package 加密;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AES加密 {

	public static void main(String[] args) {
		String key = "tqhYgN4Xe0XFOSdn"; // 16位元的key
		String initVector = "DyDgD3HPbZWxqAo4"; // 16位元的偏移吧
		String enc = encrypt(key, initVector, "棒賽時要小心要小心西索1");
		String dec = decrypt(key, initVector, enc);
		System.out.println(enc);
		System.out.println(dec);
	}

	public static String encrypt(String key, String initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			// Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");//書凱的方式，要算到16個位元才不會出錯
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String key, String initVector, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			// Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");//書凱的方式，要算到16個位元才不會出錯
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
