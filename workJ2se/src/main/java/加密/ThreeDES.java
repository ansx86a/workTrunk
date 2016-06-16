package 加密;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class ThreeDES {
	private final String algorithm = "DESede";
	//private final String transformation = "DESede/ECB/NoPadding";
	private final String transformation = "DESede/ECB/PKCS5PADDING";//這樣字資料就不用補到8個位元了

	private Cipher enCipher = null;
	private Cipher deCipher = null;

	private ThreeDES(String key) throws Exception {
		enCipher = getCipher(Cipher.ENCRYPT_MODE, key);
		deCipher = getCipher(Cipher.DECRYPT_MODE, key);
	}

	private Cipher getCipher(int mode, String key) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESedeKeySpec dks = new DESedeKeySpec(key.getBytes());

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
		String key1 = "12345678";
		String key2 = "abcdefgh";
		String key = key1 + key2 + key1;
		ThreeDES d = new ThreeDES(key);
		String data = "1234";
		System.out.println(data);

		String encode = d.encrypt(data);
		System.out.println("encode: " + encode);
		System.out.println("decode: " + d.decrypt(encode));
		System.out.println("=================================");
	}
}
