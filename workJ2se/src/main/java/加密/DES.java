package 加密;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DES {
	private final String algorithm = "DES";
	//private final String transformation = "DESede/ECB/NoPadding";
	private final String transformation = "DESede/ECB/PKCS5PADDING";//這樣字資料就不用補到8個位元了

	private Cipher enCipher = null;
	private Cipher deCipher = null;

	private DES(String key) throws Exception {
		enCipher = getCipher(Cipher.ENCRYPT_MODE, key);
		deCipher = getCipher(Cipher.DECRYPT_MODE, key);
	}

	private Cipher getCipher(int mode, String key) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key.getBytes());

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
		SecretKey securekey = keyFactory.generateSecret(dks);

		Cipher cipher = Cipher.getInstance(transformation);
		cipher.init(mode, securekey, sr);
		return cipher;
	}

	private String toHex(byte b) {
		return String.format("%02x", b).toUpperCase();
	}

	public byte[] hexToBytes(String str) {
		byte[] result = new byte[str.length() / 2];
		for (int i = 0; i < str.length(); i += 2) {
			String s = str.substring(i, i + 2);
			result[i / 2] = (byte) Integer.parseInt(s, 16);
		}
		return result;
	}

	public String encrypt(String data) throws Exception {
		byte bytes[] = enCipher.doFinal(data.getBytes());
		StringBuffer sb = new StringBuffer();
		for (byte b : bytes)
			sb.append(toHex(b));
		return sb.toString();
	}

	public String encrypt(String data, String key) throws Exception {
		Cipher enCipher = getCipher(Cipher.ENCRYPT_MODE, key);

		byte bytes[] = enCipher.doFinal(data.getBytes());
		StringBuffer sb = new StringBuffer();
		for (byte b : bytes)
			sb.append(toHex(b));
		return sb.toString();
	}

	public String decrypt(String data) throws Exception {
		return new String(deCipher.doFinal(hexToBytes(data)));
	}

	public String decrypt(String data, String key) throws Exception {
		Cipher deCipher = getCipher(Cipher.DECRYPT_MODE, key);
		return new String(deCipher.doFinal(hexToBytes(data)));
	}

	public static void main(String args[]) throws Exception {
		String key = "aabbccdd";
		System.out.println("key要8碼:" + key);
		DES d = new DES(key);
		String data = "373953146391007 000000000200031400000000170193951234567890123456789     ";
		System.out.println("長度要8的倍數：" + data.length());
		String encode = d.encrypt(data);
		System.out.println("encode: " + encode);
		System.out.println("decode: " + d.decrypt(encode));
		System.out.println("=========================");
		key = "11223344";
		encode = d.encrypt(data, key);
		System.out.println("encode: " + encode);
		System.out.println("decode: " + d.decrypt(encode, key));

	}
}