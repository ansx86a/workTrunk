package 加密;

import java.io.*;

import com.sun.xml.fastinfoset.algorithm.BASE64EncodingAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.util.Base64Utils;

import static org.owasp.esapi.codecs.Base64.DONT_BREAK_LINES;
import static org.owasp.esapi.codecs.Base64.GZIP;

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

    private static String TEST_STRING = "這是給base64使用的測試字串,這是給base64使用的測試字串"
            + "這是給base64使用的測試字串,這是給base64使用的測試字串";

    @Test
    public void java內建的Base64不換行() {
        //要換行要用以下的程式吧讓程式幫你斷行？
        //

        String s = java.util.Base64.getEncoder().encodeToString(TEST_STRING.getBytes());
        System.out.println(s);
        //目前觀察有2個變化/->_，+->-
        s = java.util.Base64.getUrlEncoder().encodeToString(TEST_STRING.getBytes());
        System.out.println(s);
        System.out.println(TEST_STRING.equals(new String(java.util.Base64.getUrlDecoder().decode(s))));
    }

    @Test
    public void java內建的Base64使用換行() throws IOException {
        //感覺換行的部分是寄送郵寄使用，正常的base64是不是不換行
        String s = java.util.Base64.getMimeEncoder().encodeToString(TEST_STRING.getBytes());
        System.out.println(s);
        //以下程式測試沒用，因為預設的encoder的換行字元是null，不知道有沒有辦法改善
//        ByteArrayOutputStream bo = new ByteArrayOutputStream();
//        OutputStream wraped = java.util.Base64.getEncoder().wrap(bo);
//        wraped.write(TEST_STRING.getBytes());
//        wraped.close();
//        System.out.println(new String(bo.toByteArray()));
    }


    @Test
    public void apache的Base64() {
        String s = Base64.encodeBase64String(TEST_STRING.getBytes());
        System.out.println(s);
        //目前觀察有2個變化/->_，+->-，而且==也不見了
        s = Base64.encodeBase64URLSafeString(TEST_STRING.getBytes());
        System.out.println(s);
        System.out.println(TEST_STRING.equals(new String(Base64.decodeBase64(s))));
    }

    @Test
    public void esapi的Base64() {
        //會自已換行，我想應該是會和使用Mime壓出來的內容相同吧
        //不過esapi的強項應該是解碼的部分有沒有換行都能過
        String s = org.owasp.esapi.codecs.Base64.encodeBytes(TEST_STRING.getBytes());
        System.out.println("正常模式======================");
        System.out.println(s);
        //option有2個選項，可以相加：不要換行DONT_BREAK_LINES = 8，，GZIP = 2
        s = org.owasp.esapi.codecs.Base64.encodeBytes(TEST_STRING.getBytes(), DONT_BREAK_LINES);
        System.out.println("不換行模式======================");
        System.out.println(s);
        System.out.println("GZIP======================================");
        s = org.owasp.esapi.codecs.Base64.encodeBytes(TEST_STRING.getBytes(), GZIP);
        System.out.println(s);
        System.out.println("不換行模式 + GZIP======================================");
        s = org.owasp.esapi.codecs.Base64.encodeBytes(TEST_STRING.getBytes(), DONT_BREAK_LINES + GZIP);
        System.out.println(s);
    }

    @Test
    public void spring的Base64Utils感覺是功能最陽春的() {
        String s = Base64Utils.encodeToString(TEST_STRING.getBytes());
        System.out.println(s);
    }


}
