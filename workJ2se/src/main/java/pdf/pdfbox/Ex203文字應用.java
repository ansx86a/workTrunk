package pdf.pdfbox;

import java.awt.Rectangle;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingColor;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingColorN;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingColorSpace;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingDeviceCMYKColor;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingDeviceGrayColor;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingDeviceRGBColor;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingColor;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingColorN;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingColorSpace;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingDeviceCMYKColor;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingDeviceGrayColor;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingDeviceRGBColor;
import org.apache.pdfbox.contentstream.operator.state.Concatenate;
import org.apache.pdfbox.contentstream.operator.state.Restore;
import org.apache.pdfbox.contentstream.operator.state.Save;
import org.apache.pdfbox.contentstream.operator.state.SetGraphicsStateParameters;
import org.apache.pdfbox.contentstream.operator.state.SetMatrix;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingMode;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.tools.ExtractText;
import org.apache.pdfbox.util.Matrix;

import tool.Utils;

public class Ex203文字應用 {

	public static void main(String[] args) throws IOException {
		Ex101pdModel model = new Ex101pdModel();
		Ex203文字應用 e = new Ex203文字應用();
		e.$1pdf轉文字();
		e.$2讀取區塊的文字();
		e.$2_1依頁數取文字();// 抄網路的，可能不穩要小心使用

		e.$3把文字用unicode顯示();// 不懂
		model.$5pdfBox內建字型();
		model.$8_2加入底層圖片();// 給第4例測試用的
		e.$4移掉全部的文字();
		e.$5列印出文字的顏色屬性();// 和例3差不多，看不太懂，也沒什麼太大的實用

		e.$6列印出圖片的屬性();// 和例3、例5差不多，看不太懂

		// 不懂，類似第3例，印一堆文字不知道是在幹嘛用的
		// DrawPrintTextLocations.main(new String[] { "z:/008_2加入底層圖片.pdf" });

	}

	public void $1pdf轉文字() {
		File pdfFile = Utils.getResourceFromRoot("pdf/pdfbox/Ex203.pdf");
		File txtFile = new File("z:/001readTxt.txt");

		try {
			ExtractText.main(new String[] { pdfFile.getAbsolutePath(), txtFile.getAbsolutePath() });
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end $1pdf轉文字");
	}

	public void $2讀取區塊的文字() throws IOException {
		PDDocument document = null;
		try {
			File f = Utils.getResourceFromRoot("pdf/pdfbox/Ex203.pdf");
			document = PDDocument.load(f);
			PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			stripper.setSortByPosition(true);
			Rectangle rect = new Rectangle(10, 280, 275, 100);
			stripper.addRegion("class1", rect);
			PDPage firstPage = document.getPage(0);
			stripper.extractRegions(firstPage);
			System.out.println("Text in the area:" + rect);
			System.out.println(stripper.getTextForRegion("class1"));
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	/**
	 * 反apache的範例，去抄的，會因為段落讀到到某些段落的文字？，如要使用此例需小心測試
	 * @throws IOException
	 */
	public void $2_1依頁數取文字() throws IOException {
		System.out.println("2_1=========");
		File file = Utils.getResourceFromRoot("pdf/pdfbox/Ex203.pdf");
		PDFParser parser = new PDFParser(new RandomAccessFile(file, "r")); // update for PDFBox V 2.0

		parser.parse();
		COSDocument cosDoc = parser.getDocument();
		PDFTextStripper pdfStripper = new PDFTextStripper();
		PDDocument pdDoc = new PDDocument(cosDoc);
		pdDoc.getNumberOfPages();
		pdfStripper.setStartPage(1);
		pdfStripper.setEndPage(1);

		// reading text from page 1 to 10
		// if you want to get text from full pdf file use this code
		// pdfStripper.setEndPage(pdDoc.getNumberOfPages());

		String text = pdfStripper.getText(pdDoc);
		System.out.println(text.substring(0, 10));
		System.out.println(text.substring(text.length() - 10, text.length()));
	}

	/**
	 * 不太懂真正的意義，大概本例就是可以用unicode印字，但是out不知道在幹嘛，那個匿名類別真的的用意也不太懂
	 * @throws IOException
	 */
	public void $3把文字用unicode顯示() throws IOException {
		PDDocument document = null;
		try {
			File f = Utils.getResourceFromRoot("pdf/pdfbox/Ex203.pdf");
			File f2 = new File("z:/Ex203.pdf");
			FileUtils.copyFileToDirectory(f, f2.getParentFile());
			document = PDDocument.load(f2);
			PDFTextStripper stripper = new PDFTextStripper() {
				@Override
				protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
					for (TextPosition text : textPositions) {
						// System.out.println("String[" + text.getXDirAdj() + "," + text.getYDirAdj() + " fs="
						// + text.getFontSize() + " xscale=" + text.getXScale() + " height=" + text.getHeightDir()
						// + " space=" + text.getWidthOfSpace() + " width=" + text.getWidthDirAdj() + "]"
						// + text.getUnicode());

						// 先註解，才不會console太亂
						// System.out.println(text.getUnicode());
					}
				}
			};
			stripper.setSortByPosition(true);
			stripper.setStartPage(0);
			stripper.setEndPage(document.getNumberOfPages());
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			Writer dummy = new OutputStreamWriter(bo);
			stripper.writeText(document, dummy);
			System.out.println(bo.toByteArray().length);
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	public void $4移掉全部的文字() throws IOException {
		PDDocument document = null;
		try {
			document = PDDocument.load(new File("z:/008_2加入底層圖片.pdf"));
			if (document.isEncrypted()) {
				System.err.println("Error: Encrypted documents are not supported for this example.");
				System.exit(1);
			}
			for (PDPage page : document.getPages()) {
				PDFStreamParser parser = new PDFStreamParser(page);
				parser.parse();
				List<Object> tokens = parser.getTokens();
				List<Object> newTokens = new ArrayList<Object>();
				for (Object token : tokens) {
					if (token instanceof Operator) {
						Operator op = (Operator) token;
						if (op.getName().equals("TJ") || op.getName().equals("Tj")) {
							// remove the one argument to this operator
							newTokens.remove(newTokens.size() - 1);
							continue;
						}
					}
					newTokens.add(token);
				}
				PDStream newContents = new PDStream(document);
				OutputStream out = newContents.createOutputStream(COSName.FLATE_DECODE);
				ContentStreamWriter writer = new ContentStreamWriter(out);
				writer.writeTokens(newTokens);
				out.close();
				page.setContents(newContents);
			}
			document.save("z:/004移掉全部的文字.pdf");
		} finally {
			if (document != null) {
				document.close();
			}
		}

	}

	public void $5列印出文字的顏色屬性() throws IOException {
		PDDocument document = null;
		try {
			document = PDDocument.load(new File("z:/008_2加入底層圖片.pdf"));
			PDFTextStripper stripper = new PDFTextStripper() {
				@Override
				protected void processTextPosition(TextPosition text) {
					super.processTextPosition(text);
					PDColor strokingColor = getGraphicsState().getStrokingColor();
					PDColor nonStrokingColor = getGraphicsState().getNonStrokingColor();
					String unicode = text.getUnicode();
					RenderingMode renderingMode = getGraphicsState().getTextState().getRenderingMode();

					// console太長，先註解
					// System.out.println("Unicode:            " + unicode);
					// System.out.println("Rendering mode:     " + renderingMode);
					// System.out.println("Stroking color:     " + strokingColor);
					// System.out.println("Non-Stroking color: " + nonStrokingColor);
					// System.out.println("Non-Stroking color: " + nonStrokingColor);
					// System.out.println();

					// See the PrintTextLocations for more attributes
				}
			};
			stripper.addOperator(new SetStrokingColorSpace());
			stripper.addOperator(new SetNonStrokingColorSpace());
			stripper.addOperator(new SetStrokingDeviceCMYKColor());
			stripper.addOperator(new SetNonStrokingDeviceCMYKColor());
			stripper.addOperator(new SetNonStrokingDeviceRGBColor());
			stripper.addOperator(new SetStrokingDeviceRGBColor());
			stripper.addOperator(new SetNonStrokingDeviceGrayColor());
			stripper.addOperator(new SetStrokingDeviceGrayColor());
			stripper.addOperator(new SetStrokingColor());
			stripper.addOperator(new SetStrokingColorN());
			stripper.addOperator(new SetNonStrokingColor());
			stripper.addOperator(new SetNonStrokingColorN());

			stripper.setSortByPosition(true);
			stripper.setStartPage(0);
			stripper.setEndPage(document.getNumberOfPages());

			Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
			stripper.writeText(document, dummy);
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	public void $6列印出圖片的屬性() throws IOException {
		PDDocument document = null;
		try {
			document = PDDocument.load(new File("z:/008_2加入底層圖片.pdf"));
			PDFStreamEngine printer = new PDFStreamEngine() {
				@Override
				protected void processOperator(Operator operator, List<COSBase> operands) throws IOException {
					String operation = operator.getName();
					if ("Do".equals(operation)) {
						COSName objectName = (COSName) operands.get(0);
						PDXObject xobject = getResources().getXObject(objectName);
						if (xobject instanceof PDImageXObject) {
							PDImageXObject image = (PDImageXObject) xobject;
							int imageWidth = image.getWidth();
							int imageHeight = image.getHeight();
							System.out.println("*******************************************************************");
							System.out.println("Found image [" + objectName.getName() + "]");

							Matrix ctmNew = getGraphicsState().getCurrentTransformationMatrix();
							float imageXScale = ctmNew.getScalingFactorX();
							float imageYScale = ctmNew.getScalingFactorY();

							// position in user space units. 1 unit = 1/72 inch at 72 dpi
							System.out.println("position in PDF = " + ctmNew.getTranslateX() + ", "
									+ ctmNew.getTranslateY() + " in user space units");
							// raw size in pixels
							System.out.println("raw image size  = " + imageWidth + ", " + imageHeight + " in pixels");
							// displayed size in user space units
							System.out.println("displayed size  = " + imageXScale + ", " + imageYScale
									+ " in user space units");
							// displayed size in inches at 72 dpi rendering
							imageXScale /= 72;
							imageYScale /= 72;
							System.out.println("displayed size  = " + imageXScale + ", " + imageYScale
									+ " in inches at 72 dpi rendering");
							// displayed size in millimeters at 72 dpi rendering
							imageXScale *= 25.4;
							imageYScale *= 25.4;
							System.out.println("displayed size  = " + imageXScale + ", " + imageYScale
									+ " in millimeters at 72 dpi rendering");
							System.out.println();
						} else if (xobject instanceof PDFormXObject) {
							PDFormXObject form = (PDFormXObject) xobject;
							showForm(form);
						}
					} else {
						super.processOperator(operator, operands);
					}
				}
			};
			printer.addOperator(new Concatenate());
			printer.addOperator(new DrawObject());
			printer.addOperator(new SetGraphicsStateParameters());
			printer.addOperator(new Save());
			printer.addOperator(new Restore());
			printer.addOperator(new SetMatrix());

			int pageNum = 0;
			for (PDPage page : document.getPages()) {
				pageNum++;
				System.out.println("Processing page: " + pageNum);
				printer.processPage(page);
			}
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

}
