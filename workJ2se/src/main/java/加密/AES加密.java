package 加密;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.spec.KeySpec;

public class AES加密 {
    //可以參考https://howtodoinjava.com/java/java-security/aes-256-encryption-decryption/
    //可以進入howtodoinjava.com後，點Java Tutorial後，再點Java Security
    public static void main(String[] args) throws Exception {
        //看key的長度可以分類成16字元，24字元，32字元分別為AES128,AES192,AES256
        String key = "tqhYgN4Xe0XFOSdn1234567890123456"; // 32位元的key
        String initVector = "DyDgD3HPbZWxqAo4"; // 16位元的偏移吧
        String enc = encrypt(key, initVector, "棒賽時要小心要小心西索1");
        String dec = decrypt(key, initVector, enc);
        System.out.println(enc);
        System.out.println(dec);
    }

    public static SecretKeySpec getKeySpec2(String key) throws Exception {
        String salt = "salt不知道限制是什麼";
        SecretKeyFactory factory = SecretKeyFactory.getInstance("pbkdf2withhmacsha256");
        KeySpec spec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");
        return secretKeySpec;
    }

    public static String encrypt(String key, String initVector, String value) throws Exception {
        //當是CBC的時候要iv，而ECB不需要
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        //getKeySpec2 是個比較複雜的方式來產生key
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        //如果要用PKCS7PADDING，要加入
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");//PADDING是填空白的方式
        // Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");//書凱的方式，要算到16個位元才不會出錯
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(value.getBytes());
        return Base64.encodeBase64String(encrypted);
    }

    public static String decrypt(String key, String initVector, String encrypted) throws Exception {
        //當是CBC的時候要iv，而ECB不需要
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        //getKeySpec2 是個比較複雜的方式來產生key
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");//PADDING是填空白的方式
        // Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");//書凱的方式，要算到16個位元才不會出錯
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
        return new String(original);
    }
}
