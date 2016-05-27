package pdf.pdfbox;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.apache.pdfbox.pdmodel.interactive.action.PDAnnotationAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDComboBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDListBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
import org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import tool.Utils;

/*
 *  建立一個Form和一個text欄位放到第一頁或是第二頁去
 */
public final class Ex001Form相關 {

	public static void main(String[] args) throws IOException {
		Ex001Form相關 e = new Ex001Form相關();
		e.$1建立SimplrForm();
		e.$2把field加border();
		e.$3印出所有的Form欄位();
		e.$4設定field值多型();
		e.$5設定field值簡易();
		e.$6由javascript去改變初始值();
		e.$7FieldPdf事件綁定();
		System.out.println("end main");
	}

	public void $1建立SimplrForm() throws IOException {
		// Create a new document with an empty page.
		// 建立一個A4的空白pdf頁
		PDDocument document = new PDDocument();
		PDPage page = new PDPage(PDRectangle.A4);
		PDPage page2 = new PDPage(PDRectangle.A4);
		document.addPage(page);
		document.addPage(page2);

		// Adobe Acrobat uses Helvetica as a default font and
		// stores that under the name '/Helv' in the resources dictionary

		// Pdf的預設字型是Helvetica
		// 把字型放到resource，用處在下面46行設定預設的字型和大小
		PDFont font = PDType1Font.HELVETICA;
		System.out.println(COSName.getPDFName("Helv"));// COSName{Helv}
		PDResources resources = new PDResources();
		resources.put(COSName.getPDFName("Helv"), font);

		// Add a new AcroForm and add that to the document

		// acroForm，一個組件的概念嗎？只是一個ui panel的概念，是一個容易可以設一些預設值類似html給子物件繼承，又或者是說成相依屬性的概念
		PDAcroForm acroForm = new PDAcroForm(document);
		document.getDocumentCatalog().setAcroForm(acroForm);
		// Add and set the resources and default appearance at the form level
		acroForm.setDefaultResources(resources);

		// Acrobat sets the font size on the form level to be
		// auto sized as default. This is done by setting the font size to '0'

		// 預設的字型和大小
		String defaultAppearanceString = "/Helv 0 Tf 0 g";
		acroForm.setDefaultAppearance(defaultAppearanceString);

		// Add a form field to the form.

		// 加入一個textBox，把textBox定義一個名字
		PDTextField textBox = new PDTextField(acroForm);
		textBox.setPartialName("SampleField");
		// Acrobat sets the font size to 12 as default
		// This is done by setting the font size to '12' on the
		// field level.

		// 設定欄位的設字型
		defaultAppearanceString = "/Helv 12 Tf 0 g";
		textBox.setDefaultAppearance(defaultAppearanceString);

		// add the field to the acroform
		acroForm.getFields().add(textBox);

		// Specify the annotation associated with the field
		// 位置的資訊是記在annotation裡？反正用下行取出再設定位置長寬後再設定出現在那一頁就可以了
		PDAnnotationWidget widget = textBox.getWidgets().get(0);
		PDRectangle rect = new PDRectangle(50, 750, 200, 50);
		widget.setRectangle(rect);
		widget.setPage(page);
		// widget.setPage(page2);

		// Add the annotation to the page
		// 把註解加到page，和上面的setPage有呼應，最好設一樣，不然有時候會被其中一個設定蓋過去
		page.getAnnotations().add(widget);
		// page2.getAnnotations().add(widget);

		// set the field value
		textBox.setValue("Sample field(text box)");

		document.save("z:/SimpleForm.pdf");
		document.close();
		System.out.println("end ex001");
	}

	/**
	 * 點下去編輯時才會顯示border
	 * 
	 * @throws IOException
	 */
	public void $2把field加border() throws IOException {
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

		document.save("z:/002AddBorderToField.pdf");
		document.close();

		System.out.println("end Ex002AddBorderToField" + new Date());
	}

	public void $3印出所有的Form欄位() throws IOException {
		System.out.println("ex003=======================");
		PDDocument pdf = null;
		try {
			File f = new File("z:/SimpleForm.pdf");
			pdf = PDDocument.load(f);
			printFields(pdf);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pdf != null) {
				pdf.close();
			}
		}
	}

	public void printFields(PDDocument pdfDocument) throws IOException {
		PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
		PDAcroForm acroForm = docCatalog.getAcroForm();
		List<PDField> fields = acroForm.getFields();

		System.out.println(fields.size() + " top-level fields were found on the form");

		for (PDField field : fields) {
			processField(field, "|--", field.getPartialName());
		}
	}

	public void processField(PDField field, String sLevel, String sParent) throws IOException {
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

	public void $4設定field值多型() throws IOException {
		PDDocument pdf = null;
		try {
			File pdfFile = new File("z:/SimpleForm.pdf");
			String filedName = "SampleField";
			String filedValue = "replaced Field Value(TextBox)" + new Date();
			pdf = PDDocument.load(pdfFile);
			setField(pdf, filedName, filedValue);
			pdf.save("z:/004設定值simpleForm.pdf");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pdf != null) {
				pdf.close();
			}
		}

		System.out.println("end 004");
	}

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

	public void $5設定field值簡易() throws IOException {

		// String formTemplate = "src/main/resources/org/apache/pdfbox/examples/interactive/form/FillFormField.pdf";
		File f = Utils.getResourceFromRoot("pdf/pdfbox/Ex001_05.pdf");

		// load the document
		PDDocument pdfDocument = PDDocument.load(f);

		// get the document catalog
		PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();

		// as there might not be an AcroForm entry a null check is necessary
		if (acroForm != null) {
			// Retrieve an individual field and set its value.
			PDTextField field = (PDTextField) acroForm.getField("sampleField");
			field.setValue("Text Entry -- " + new Date());

			// If a field is nested within the form tree a fully qualified name
			// might be provided to access the field.
			field = (PDTextField) acroForm.getField("fieldsContainer.nestedSampleField");
			field.setValue("Text Entry ++" + new Date());
		}

		// Save and close the filled out form.
		pdfDocument.save("z:/005FillFormField.pdf");
		pdfDocument.close();

		System.out.println("end 005");

	}

	public void $6由javascript去改變初始值() throws IOException {
		// Load the PDF document created by SimpleForm.java
		PDDocument document = PDDocument.load(new File("z:/SimpleForm.pdf"));

		// Note that the JavaScript will depend on the reader application.
		// The classes and methods available to Adobe Reader and Adobe Acrobat
		// are documented in the Acrobat SDK.
		String javaScript = "var now = util.printd('yyyy-mm-dd HH:MM:ss', new Date());"
				+ "var oField = this.getField('SampleField');" + "oField.value = now;";

		// Create an action as JavaScript action
		PDActionJavaScript jsAction = new PDActionJavaScript();
		jsAction.setAction(javaScript);

		// Set the action to be executed when the document is opened
		document.getDocumentCatalog().setOpenAction(jsAction);

		document.save("z:/006由javascript去改變初始值.pdf");
		document.close();
		System.out.println("end 006");

	}

	/**
	 * 對field綁定事件，感覺把事情複雜化，不要這麼做吧，留下參考用
	 * @throws IOException
	 */
	public void $7FieldPdf事件綁定() throws IOException {
		// Load the PDF document created by SimpleForm.java
		PDDocument document = PDDocument.load(new File("z:/SimpleForm.pdf"));
		PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

		// Get the field and the widget associated to it.
		// Note: there might be multiple widgets
		PDField field = acroForm.getField("SampleField");
		PDAnnotationWidget widget = field.getWidgets().get(0);

		// Some of the actions are available to the widget, some are available to the form field.
		// See Table 8.44 and Table 8.46 in the PDF 1.7 specification

		// Actions for the widget
		PDAnnotationAdditionalActions annotationActions = new PDAnnotationAdditionalActions();

		// Create an action when entering the annotations active area
		PDActionJavaScript jsEnterAction = new PDActionJavaScript();
		jsEnterAction.setAction("app.alert(\"On 'enter' action\")");
		annotationActions.setE(jsEnterAction);

		// Create an action when exiting the annotations active area
		PDActionJavaScript jsExitAction = new PDActionJavaScript();
		jsExitAction.setAction("app.alert(\"On 'exit' action\")");
		annotationActions.setX(jsExitAction);

		// Create an action when the mouse button is pressed inside the annotations active area
		PDActionJavaScript jsMouseDownAction = new PDActionJavaScript();
		jsMouseDownAction.setAction("app.alert(\"On 'mouse down' action\")");
		annotationActions.setD(jsMouseDownAction);

		// Create an action when the mouse button is released inside the annotations active area
		PDActionJavaScript jsMouseUpAction = new PDActionJavaScript();
		jsMouseUpAction.setAction("app.alert(\"On 'mouse up' action\")");
		annotationActions.setU(jsMouseUpAction);

		// Create an action when the annotation gets the input focus
		PDActionJavaScript jsFocusAction = new PDActionJavaScript();
		jsFocusAction.setAction("app.alert(\"On 'focus' action\")");
		annotationActions.setFo(jsFocusAction);

		// Create an action when the annotation loses the input focus
		PDActionJavaScript jsBlurredAction = new PDActionJavaScript();
		jsBlurredAction.setAction("app.alert(\"On 'blurred' action\")");
		annotationActions.setBl(jsBlurredAction);

		widget.setActions(annotationActions);

		// Actions for the field
		PDFormFieldAdditionalActions fieldActions = new PDFormFieldAdditionalActions();

		// Create an action when the user types a keystroke in the field
		PDActionJavaScript jsKeystrokeAction = new PDActionJavaScript();
		jsKeystrokeAction.setAction("app.alert(\"On 'keystroke' action\")");
		fieldActions.setK(jsKeystrokeAction);

		// Create an action when the field is formatted to display the current value
		PDActionJavaScript jsFormattedAction = new PDActionJavaScript();
		jsFormattedAction.setAction("app.alert(\"On 'formatted' action\")");
		fieldActions.setF(jsFormattedAction);

		// Create an action when the field value changes
		PDActionJavaScript jsChangedAction = new PDActionJavaScript();
		jsChangedAction.setAction("app.alert(\"On 'change' action\")");
		// fieldActions.setV(jsChangedAction);

		// Create an action when the field value changes
		PDActionJavaScript jsRecalculateAction = new PDActionJavaScript();
		jsRecalculateAction.setAction("app.alert(\"On 'recalculate' action\")");
		fieldActions.setC(jsRecalculateAction);

		// Set the Additional Actions entry for the field
		// Note: this is a workaround as if there is only one widget the widget
		// and the form field may share the same dictionary. Now setting the
		// fields Additional Actions entry directly will overwrite the settings done for
		// the widget.
		// https://issues.apache.org/jira/browse/PDFBOX-3036

		field.getActions().getCOSObject().addAll(fieldActions.getCOSObject());

		document.save("z:/007綁定事件的.pdf");
		document.close();

		System.out.println("end 007");
	}

}
