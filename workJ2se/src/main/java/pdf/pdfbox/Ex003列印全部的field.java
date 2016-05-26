package pdf.pdfbox;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;

/**
 * 把actionForm的所有filed印出來的程式吧
 * 
 * @author ai
 *
 */
public class Ex003列印全部的field {

	/**
	 * This will print all the fields from the document.
	 * 
	 * @param pdfDocument The PDF to get the fields from.
	 * 
	 * @throws IOException If there is an error getting the fields.
	 */
	public void printFields(PDDocument pdfDocument) throws IOException {
		PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
		PDAcroForm acroForm = docCatalog.getAcroForm();
		List<PDField> fields = acroForm.getFields();

		System.out.println(fields.size() + " top-level fields were found on the form");

		for (PDField field : fields) {
			processField(field, "|--", field.getPartialName());
		}
	}

	private void processField(PDField field, String sLevel, String sParent) throws IOException {
		String partialName = field.getPartialName();

		if (field instanceof PDNonTerminalField) {
			if (!sParent.equals(field.getPartialName())) {
				if (partialName != null) {
					sParent = sParent + "." + partialName;
				}
			}
			System.out.println(sLevel + sParent);

			for (PDField child : ((PDNonTerminalField) field).getChildren()) {
				processField(child, "|  " + sLevel, sParent);
			}
		} else {
			String fieldValue = field.getValueAsString();
			StringBuilder outputString = new StringBuilder(sLevel);
			outputString.append(sParent);
			if (partialName != null) {
				outputString.append(".").append(partialName);
			}
			outputString.append(" = ").append(fieldValue);
			outputString.append(",  type=").append(field.getClass().getName());
			System.out.println(outputString);
		}
	}

	/**
	 * This will read a PDF file and print out the form elements. <br />
	 * see usage() for commandline
	 * 
	 * @param args command line arguments
	 * 
	 * @throws IOException If there is an error importing the FDF document.
	 */
	public static void main(String[] args) throws IOException {

		PDDocument pdf = null;
		try {
			File f = new File("z:/SimpleForm.pdf");
			pdf = PDDocument.load(f);
			Ex003列印全部的field exporter = new Ex003列印全部的field();
			exporter.printFields(pdf);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pdf != null) {
				pdf.close();
			}
		}
		System.out.println("end PrintFields");
	}

}