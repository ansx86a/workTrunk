package pdf.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import tool.Utils;

/**
 * 和ex004類似，填值而已，nested？
 * @author ai
 *
 */
public final class Ex005Field填值 {

	public static void main(String[] args) throws IOException {
		// String formTemplate = "src/main/resources/org/apache/pdfbox/examples/interactive/form/FillFormField.pdf";
		File f = Utils.getResourceFromRoot("pdf/pdfbox/Ex005.pdf");

		// load the document
		PDDocument pdfDocument = PDDocument.load(f);

		// get the document catalog
		PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();

		// as there might not be an AcroForm entry a null check is necessary
		if (acroForm != null) {
			// Retrieve an individual field and set its value.
			PDTextField field = (PDTextField) acroForm.getField("sampleField");
			field.setValue("Text Entry");

			// If a field is nested within the form tree a fully qualified name
			// might be provided to access the field.
			field = (PDTextField) acroForm.getField("fieldsContainer.nestedSampleField");
			field.setValue("Text Entry");
		}

		// Save and close the filled out form.
		pdfDocument.save("z:/FillFormField.pdf");
		pdfDocument.close();

		System.out.println("end");
	}

}
