package pdf.pdfbox;

import java.io.IOException;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

/*
 *  建立一個Form和一個text欄位放到第一頁或是第二頁去
 */
public final class Ex001CreateSimpleForm {
	private Ex001CreateSimpleForm() {
	}

	public static void main(String[] args) throws IOException {
		// Create a new document with an empty page.
		// 建立一個A4的空白pdf頁
		PDDocument document = new PDDocument();
		PDPage page = new PDPage(PDRectangle.A4);
		PDPage page2 = new PDPage(PDRectangle.A4);
		document.addPage(page);
		document.addPage(page2);

		// Adobe Acrobat uses Helvetica as a default font and
		// stores that under the name '/Helv' in the resources dictionary
		
		//Pdf的預設字型是Helvetica
		//把字型放到resource，用處在下面46行設定預設的字型和大小
		PDFont font = PDType1Font.HELVETICA;
		System.out.println(COSName.getPDFName("Helv"));//COSName{Helv}
		PDResources resources = new PDResources();
		resources.put(COSName.getPDFName("Helv"), font);

		// Add a new AcroForm and add that to the document
		
		//acroForm，一個組件的概念嗎？只是一個ui panel的概念，是一個容易可以設一些預設值類似html給子物件繼承，又或者是說成相依屬性的概念
		PDAcroForm acroForm = new PDAcroForm(document);
		document.getDocumentCatalog().setAcroForm(acroForm);
		// Add and set the resources and default appearance at the form level
		acroForm.setDefaultResources(resources);

		// Acrobat sets the font size on the form level to be
		// auto sized as default. This is done by setting the font size to '0'
		
		//預設的字型和大小
		String defaultAppearanceString = "/Helv 0 Tf 0 g";
		acroForm.setDefaultAppearance(defaultAppearanceString);

		// Add a form field to the form.
		
		//加入一個textBox，把textBox定義一個名字
		PDTextField textBox = new PDTextField(acroForm);
		textBox.setPartialName("SampleField");
		// Acrobat sets the font size to 12 as default
		// This is done by setting the font size to '12' on the
		// field level.
		
		//設定欄位的設字型
		defaultAppearanceString = "/Helv 12 Tf 0 g";
		textBox.setDefaultAppearance(defaultAppearanceString);

		// add the field to the acroform
		acroForm.getFields().add(textBox);

		// Specify the annotation associated with the field
		//位置的資訊是記在annotation裡？反正用下行取出再設定位置長寬後再設定出現在那一頁就可以了
		PDAnnotationWidget widget = textBox.getWidgets().get(0);
		PDRectangle rect = new PDRectangle(50, 750, 200, 50);
		widget.setRectangle(rect);
		widget.setPage(page);
		//widget.setPage(page2);

		// Add the annotation to the page
		//把註解加到page，和上面的setPage有呼應，最好設一樣，不然有時候會被其中一個設定蓋過去
		page.getAnnotations().add(widget);
		//page2.getAnnotations().add(widget);

		// set the field value
		textBox.setValue("Sample field(text box)");

		document.save("z:/SimpleForm.pdf");
		document.close();
		System.out.println("end");
	}
}
