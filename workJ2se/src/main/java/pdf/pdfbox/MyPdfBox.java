package pdf.pdfbox;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * http://radixcode.com/pdfbox-example-create-pdf-file-with-text-in-java/
 * @author ai
 *
 */
public class MyPdfBox {

	public static void main(String[] args) {

		try {

			System.out.println("Create Simple PDF file with Text");
			String fileName = "z:/PdfWithtext.pdf"; // name of our file

			PDDocument doc = new PDDocument();
			PDPage page = new PDPage();

			doc.addPage(page);

			PDPageContentStream content = new PDPageContentStream(doc, page);

			content.beginText();
			content.setFont(PDType1Font.HELVETICA, 26);
			content.moveTextPositionByAmount(220, 750);
			content.drawString("Registration Form");
			content.endText();

			content.beginText();
			content.setFont(PDType1Font.HELVETICA, 16);
			content.moveTextPositionByAmount(80, 700);
			content.drawString("Name : ");
			content.endText();

			// PDFont font = PDTrueTypeFont.loadTTF(doc, new File("CheckRepFont.ttf"));
			// PDFont font = PDTrueTypeFont.loadTTF(doc, new File("c:/windows/fonts/ARIALUNI.ttf"));
			// PDFont font = PDType1Font.COURIER;
			PDFont font = PDType0Font.load(doc, new File("z:/ARIALUNI.TTF"));

			content.beginText();
			content.setFont(font, 16);
			content.moveTextPositionByAmount(80, 650);
			content.drawString("Father Name中文 : ");
			content.endText();

			content.beginText();
			content.moveTextPositionByAmount(80, 600);
			content.drawString("DOB : ");
			content.endText();

			content.close();
			doc.save(fileName);
			doc.close();

			System.out.println("your file created in : " + System.getProperty("user.dir"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}

}
