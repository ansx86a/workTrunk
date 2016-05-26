package pdf.pdfbox;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

/**
 * 接繼且相依Ex001的範例，把點擊後要修改textFiled的外框改變樣式或是顏色，用途不大
 * @author ai
 *
 */
public final class Ex002Field異動時的Border {
	private Ex002Field異動時的Border() {
	}

	public static void main(String[] args) throws IOException {
		// Load the PDF document created by SimpleForm.java
		PDDocument document = PDDocument.load(new File("z:/SimpleForm.pdf"));
		PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

		// Get the field and the widget associated to it.
		// Note: there might be multiple widgets
		PDField field = acroForm.getField("SampleField");
		PDAnnotationWidget widget = field.getWidgets().get(0);

		// Create the definition for a green border
		// 這三行應該是在設定外框和顏色，顏色是用rgb吧
		PDAppearanceCharacteristicsDictionary fieldAppearance = new PDAppearanceCharacteristicsDictionary(
				new COSDictionary());
		PDColor green = new PDColor(new float[] { 0, 1, 0 }, PDDeviceRGB.INSTANCE);
		fieldAppearance.setBorderColour(green);

		// Set the information to be used by the widget which is responsible
		// for the visual style of the form field.
		widget.setAppearanceCharacteristics(fieldAppearance);

		document.save("z:/AddBorderToField.pdf");
		document.close();

		System.out.println("end Ex002AddBorderToField" + new Date());
	}
}