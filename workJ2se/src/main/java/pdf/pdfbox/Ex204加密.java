package pdf.pdfbox;

import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;

import org.apache.pdfbox.tools.Decrypt;
import org.apache.pdfbox.tools.Encrypt;
import org.codehaus.plexus.util.FileUtils;

import tool.Utils;

public class Ex204加密 {

	public static void main(String[] args) throws IOException, CertificateException {
		// copy一份副本來使用
		File f1 = Utils.getResourceFromRoot("pdf/pdfbox/Ex203.pdf");
		File f2 = new File("z:/204.pdf");
		FileUtils.copyFile(f1, f2);
		// -o和-u都是密碼，o是owner，u是user
		// 最後兩個參數放in和out，其它參數看原始碼吧
		Encrypt.main(new String[] { "-O", "abcd", "-U", "1234", "z:/204.pdf", "z:/204enc.pdf" });
		System.out.println("end");

		// 加密ok的話，就順便來試一下解密
		Decrypt.main(new String[] { "-password", "1234", "z:/204enc.pdf", "z:/204dec.pdf" });
		System.out.println("end");

	}

}
