package esapi;

import org.junit.Test;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Validator;
import org.owasp.esapi.crypto.CipherText;
import org.owasp.esapi.crypto.PlainText;
import org.owasp.esapi.errors.EncryptionException;
import org.owasp.esapi.reference.crypto.JavaEncryptor;

public class EsapiTest {

    @Test
    public void 第一步() {
        // 載入maven jar檔，並把原始碼中的才下兩個檔案copy過來放到resource，esapi目錄應該是可以省略的
        // esapi/ESAPI.properties 和 esapi/validation.properties
        // 另外一個檔案要copy到resource根目錄下，不然初始化會出錯
        // esapi-java-logging.properties
    }

    @Test
    public void html編碼使用() {
        String result = ESAPI.encoder().encodeForHTML("<tr>看角括號是否存在 </tr>");
        System.out.println(result);
        System.out.println(ESAPI.encoder().decodeForHTML(result));
        //還有其它的如下
        ESAPI.encoder().encodeForJavaScript("");
        ESAPI.encoder().encodeForCSS("");
    }

    @Test
    public void 驗証資料使用() {
        Validator validator = ESAPI.validator();
        String toValidateEmail = "aaa@bbb.ccc";
        String type = "Email";//validation.properties中的Validator.XXXX中的XXXX
        boolean result = validator.isValidInput("任意文字，log使用", toValidateEmail, type, 100, false);
        System.out.println(result);
        try {
            String result2 = validator.getValidInput("任意文字，log使用", toValidateEmail, type, 100, false);
            System.out.println(result2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        //驗証檔案，預防使用上層目錄，我猜是使用ESAPI.properties中的Validator.FileName，未確認
        //ESAPI.validator().isValidFileName()
        //ESAPI.validator().isValidFileContent()
    }

    public void 驗証上傳檔案使用() {
        //ESAPI.validator().assertValidFileUpload();
    }

    @Test
    public void 加解密() throws EncryptionException {
        //加解密用的key也許是用以下的
        //Encryptor.MasterKey=a6H9is3hEVGKB4Jut+lOVA==
        //Encryptor.MasterSalt=SbftnvmEWD5ZHHP+pX3fqugNysc=

        CipherText cipherText = ESAPI.encryptor().encrypt(new PlainText("123456"));
        String base64 = cipherText.getBase64EncodedRawCipherText();
        System.out.println(base64);
        PlainText plainText = ESAPI.encryptor().decrypt(cipherText);
        System.out.println(plainText.toString());
        //因為CipherText的建構子，所以要轉成asPortableSerializedByteArray
        CipherText cipherText2 = CipherText.fromPortableSerializedBytes(cipherText.asPortableSerializedByteArray());
        System.out.println(ESAPI.encryptor().decrypt(cipherText2).toString());
    }

    @Test
    public void 產生金鑰() throws Exception {
        //產生128位元的key
        //256位元以下的要裝JCE的樣子，感覺很難跳過
        JavaEncryptor.main(new String[]{});


    }
}
