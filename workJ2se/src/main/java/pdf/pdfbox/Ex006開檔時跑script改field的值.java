package pdf.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;

/**
 * 在開檔的時候去改變field的值，感覺用不上，對win8的 pdf reader 不管用
 * @author ai
 *
 */
public final class Ex006開檔時跑script改field的值 {

	public static void main(String[] args) throws IOException {
		// Load the PDF document created by SimpleForm.java
		PDDocument document = PDDocument.load(new File("z:/SimpleForm.pdf"));

		// Note that the JavaScript will depend on the reader application.
		// The classes and methods available to Adobe Reader and Adobe Acrobat
		// are documented in the Acrobat SDK.
		String javaScript = "var now = util.printd('yyyy-mm-dd', new Date());"
				+ "var oField = this.getField('SampleField');" + "oField.value = now;";

		// Create an action as JavaScript action
		PDActionJavaScript jsAction = new PDActionJavaScript();
		jsAction.setAction(javaScript);

		// Set the action to be executed when the document is opened
		document.getDocumentCatalog().setOpenAction(jsAction);

		document.save("z:/由javascript去改變初始值.pdf");
		document.close();
		System.out.println("end UpdateFieldOnDocumentOpen");
	}
}
