package pdf.pdfbox;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDComboBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDListBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

/**
 * 把Field的值用程式替換掉
 * @author ai
 *
 */
public class Ex004Field多型填值 {
	/**
	 * This will set a single field in the document.
	 *
	 * @param pdfDocument The PDF to set the field in.
	 * @param name The name of the field to set.
	 * @param value The new value of the field.
	 *
	 * @throws IOException If there is an error setting the field.
	 */
	public void setField(PDDocument pdfDocument, String name, String value) throws IOException {
		PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
		PDAcroForm acroForm = docCatalog.getAcroForm();
		PDField field = acroForm.getField(name);
		if (field != null) {
			if (field instanceof PDCheckBox) {
				field.setValue("Yes");
			} else if (field instanceof PDComboBox) {
				field.setValue(value);
			} else if (field instanceof PDListBox) {
				field.setValue(value);
			} else if (field instanceof PDRadioButton) {
				field.setValue(value);
			} else if (field instanceof PDTextField) {
				field.setValue(value);
			}
		} else {
			System.err.println("No field found with name:" + name);
		}
	}

	/**
	 * This will read a PDF file and set a field and then write it the pdf out again. <br />
	 * see usage() for commandline
	 *
	 * @param args command line arguments
	 *
	 * @throws IOException If there is an error importing the FDF document.
	 */
	public static void main(String[] args) throws IOException {
		Ex004Field多型填值 setter = new Ex004Field多型填值();
		setter.setField();
	}

	/**
	 * 測試method，寫死，應該要放在main的，不過它的範例就長這樣就造用了
	 * 
	 * @throws IOException
	 */
	private void setField() throws IOException {
		PDDocument pdf = null;
		try {
			File pdfFile = new File("z:/SimpleForm.pdf");
			String filedName = "SampleField";
			String filedValue = "replaced Field Value(TextBox)" + new Date();
			pdf = PDDocument.load(pdfFile);
			setField(pdf, filedName, filedValue);
			pdf.save(pdfFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pdf != null) {
				pdf.close();
			}
		}

		System.out.println("end setField");
	}

}