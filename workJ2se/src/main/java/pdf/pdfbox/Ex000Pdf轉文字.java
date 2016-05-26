package pdf.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.tools.ExtractText;

import tool.Utils;

public class Ex000Pdf轉文字 {

	public static void main(String[] args) {
		File pdfFile = Utils.getResourceFromRoot("pdf/pdfbox/Ex000.pdf");
		File txtFile = new File("z:/readTxt.txt");

		try {
			ExtractText.main(new String[] { pdfFile.getAbsolutePath(), txtFile.getAbsolutePath() });
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end pdf轉文字");
	}

}
