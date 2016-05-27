package pdf.pdfbox;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.multipdf.LayerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDDocumentNameDictionary;
import org.apache.pdfbox.pdmodel.PDEmbeddedFilesNameTreeNode;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDEmbeddedFile;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType2;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDOutputIntent;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType2;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType3;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLine;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitHeightDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitWidthDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageXYZDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.util.Matrix;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.apache.xmpbox.schema.DublinCoreSchema;
import org.apache.xmpbox.schema.PDFAIdentificationSchema;
import org.apache.xmpbox.schema.XMPBasicSchema;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.xml.DomXmpParser;
import org.apache.xmpbox.xml.XmpParsingException;
import org.apache.xmpbox.xml.XmpSerializer;

import tool.Utils;

public class Ex101pdModel {
	static final float INCH = 72;

	public static void main(String[] args) throws Exception {
		Ex101pdModel e = new Ex101pdModel();
		e.$1建立空白頁();
		e.$2打印世界你好();
		e.$3底色和區塊填色();
		e.$4載入ttf輸出中文字();
		e.$5pdfBox內建字型();
		e.$6移除第一頁();
		e.$7加入script();
		e.$8加入圖片();
		e.$8_2加入底層圖片();
		e.$9郵戳印花();
		e.$10建立書籤();
		e.$11讀取書籤();
		e.$12開啟時跳到書籤();
		e.$13讀取pdf某頁變大旋轉印到本頁();
		e.$14加入註解物件();
		e.$15修改url註解();
		e.$16印出url註解();
		// 這兩個沒什麼實用性吧
		e.$17加入metaData();
		e.$17_2印出metaData();
		e.$17_3解析metaData();
		// 不懂pdfa差在那裡，無用
		e.$18建立PDFA文件();
		e.$19每頁的後製處理();
		e.$20橫向排版畫線();
		e.$21附加檔案();// 由於20_2可以解出來，應該是有加進去附加檔
		e.$21_2解出附加檔案();
		e.$22文字放大旋轉展示();
		e.$23pdf轉圖片();
		System.out.println("end");
	}

	public void $1建立空白頁() throws IOException {
		PDDocument doc = new PDDocument();
		try {
			PDPage blankPage = new PDPage();
			doc.addPage(blankPage);
			doc.save("z:/001空白頁.pdf");
			;
		} finally {
			doc.close();
		}
	}

	public void $2打印世界你好() throws IOException {

		String filename = "z:/002世界你好.pdf";
		String message = "hello world ....... i can't say chinese";

		PDDocument doc = new PDDocument();
		try {
			PDPage page = new PDPage();
			doc.addPage(page);
			PDFont font = PDType1Font.HELVETICA_BOLD;// 字型

			// 內文的stream，直接寫文字用的吧
			PDPageContentStream contents = new PDPageContentStream(doc, page);
			contents.beginText();
			contents.setFont(font, 12);
			contents.newLineAtOffset(100, 700);// x,y，和html的left,top不同
			contents.showText(message);
			contents.showText(" and i say ...........kkkkkkkkkkkkksssssssssssssllllllllllllllllaaaaaaaaaaaaaaaaaayyyyyyyyyyyyyyyyfffffffffffffffffffiiiiiiiiiiiiiiiddddddddddd");
			contents.endText();
			contents.close();
			doc.save(filename);
		} finally {
			doc.close();
		}
	}

	public void $3底色和區塊填色() throws IOException {

		String filename = "z:/003底色和區塊填色.pdf";

		PDDocument doc = new PDDocument();
		try {
			PDPage page = new PDPage();
			doc.addPage(page);

			PDPageContentStream contents = new PDPageContentStream(doc, page);

			// 會被底色蓋過去
			contents.beginText();
			contents.setFont(PDType1Font.HELVETICA_BOLD, 12);
			contents.newLineAtOffset(100, 500);// x,y，和html的left,top不同
			contents.showText(" just say my color before");
			contents.endText();

			// 底色
			// fill the entire background with cyan
			contents.setNonStrokingColor(Color.CYAN);
			contents.addRect(0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
			contents.fill();

			// draw a red box in the lower left hand corner
			contents.setNonStrokingColor(Color.RED);
			contents.addRect(10, 10, 100, 100);
			contents.fill();

			contents.beginText();
			contents.setFont(PDType1Font.HELVETICA_BOLD, 12);
			contents.newLineAtOffset(100, 700);// x,y，和html的left,top不同
			contents.showText(" just say my color after");
			contents.endText();

			contents.close();
			doc.save(filename);
		} finally {
			doc.close();
		}
	}

	public void $4載入ttf輸出中文字() throws Exception {
		String pdfPath = "z:/004世界你好中文.pdf";
		String message = "世界你好..........對不對あいうえお夺sssssssssssss";
		// window送的標楷體，反正機器是win的就直接用這一個顯示中文吧
		// 試了一下大概就標楷是繁體中文為主，其它3個是簡體為主
		String ttfPath = "C:\\Windows\\Fonts\\kaiu.ttf";
		// ttfPath = "C:\\Windows\\Fonts\\simfang.ttf";//fanqsong 標準
		ttfPath = "C:\\Windows\\Fonts\\simkai.ttf";// kaiti標準
		ttfPath = "C:\\Windows\\Fonts\\simhei.ttf";// simhei 標準

		PDDocument doc = new PDDocument();
		try {
			PDPage page = new PDPage();
			doc.addPage(page);
			PDFont font = PDType0Font.load(doc, new File(ttfPath));
			PDPageContentStream contents = new PDPageContentStream(doc, page);
			contents.beginText();
			contents.setFont(font, 12);
			contents.newLineAtOffset(100, 700);
			contents.showText(message);
			contents.endText();
			contents.close();
			doc.save(pdfPath);
			System.out.println(pdfPath + " created!");
		} finally {
			doc.close();
		}
	}

	/**
	 * 爛透了，竟然沒有支援中文字
	 * @throws IOException
	 */
	public void $5pdfBox內建字型() throws IOException {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage(PDRectangle.A4);
		PDPage page2 = new PDPage(PDRectangle.A4);
		document.addPage(page);
		document.addPage(page2);
		InputStream in = ClassLoader
				.getSystemResourceAsStream("org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
		PDType0Font font = PDType0Font.load(document, in);

		PDPageContentStream stream = new PDPageContentStream(document, page);
		PDPageContentStream stream2 = new PDPageContentStream(document, page2);

		stream.beginText();
		stream.setFont(font, 12);
		stream.setLeading(12 * 1.2);

		stream.newLineAtOffset(50, 600);
		stream.showText("PDFBox's Unicode with Embedded TrueType Font");
		stream.newLine();

		stream.showText("Supports full Unicode text ☺");
		stream.newLine();

		stream.showText("English русский язык Tiếng Việt");
		stream.newLine();
		// ligature
		stream.showText("Ligatures: \uFB01lm \uFB02ood");

		stream.endText();
		stream.close();

		stream2.beginText();
		stream2.setFont(font, 12);
		stream2.setLeading(12 * 1.2);
		stream2.newLineAtOffset(50, 600);
		stream2.showText("PDFBox's Unicode with Embedded TrueType Font22222222222222222");
		stream2.newLine();
		stream2.endText();
		stream2.close();

		document.save("z:/005內建字型.pdf");
		document.close();
	}

	public void $6移除第一頁() throws IOException {
		PDDocument document = null;
		String path = "z:/005內建字型.pdf";
		try {
			document = PDDocument.load(new File(path));
			if (document.isEncrypted()) {
				throw new IOException("Encrypted documents are not supported for this example");
			}
			if (document.getNumberOfPages() <= 1) {
				throw new IOException("Error: A PDF document must have at least one page, "
						+ "cannot remove the last page!");
			}
			document.removePage(0);
			document.save("z:/006移除第一頁的pdf.pdf");
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	public void $7加入script() throws IOException {
		String path = "z:/005內建字型.pdf";
		PDDocument document = null;
		try {
			document = PDDocument.load(new File(path));
			// cMsg->內文
			// cTitle->標題
			PDActionJavaScript javascript = new PDActionJavaScript(
					"app.alert( {cMsg: 'PDFBox rocks!', nIcon: 3, nType: 0, cTitle: 'PDFBox Javascript example' } );");
			document.getDocumentCatalog().setOpenAction(javascript);
			if (document.isEncrypted()) {
				throw new IOException("Encrypted documents are not supported for this example");
			}
			document.save("z:/007簡單alert的script.pdf");
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	public void $8加入圖片() throws IOException {
		File imageFile = Utils.getResourceFromRoot("pdf/pdfbox/test.png");

		String imagePath = imageFile.getAbsolutePath();
		String pdfPath = "z:/008加入圖片的pdf.pdf";

		PDDocument doc = new PDDocument();
		// PDPage page = new PDPage();
		// doc.addPage(page);

		// 本來是新檔(上兩行)，改成讀舊檔加圖
		doc = PDDocument.load(new File("z:/005內建字型.pdf"));
		PDPage page = doc.getPage(0);
		try {

			// createFromFile is the easiest way with an image file
			// if you already have the image in a BufferedImage,
			// call LosslessFactory.createFromImage() instead
			PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);

			PDPageContentStream contents = new PDPageContentStream(doc, page);

			// draw the image at full size at (x=20, y=20)
			// contents.drawImage(pdImage, 20, 200);
			// 把圖片的長寬減少成一半
			contents.drawImage(pdImage, 20, 20, pdImage.getWidth() / 2, pdImage.getHeight() / 2);

			// to draw the image at half size at (x=20, y=20) use
			// contents.drawImage(pdImage, 20, 20, pdImage.getWidth() / 2, pdImage.getHeight() / 2);

			contents.close();
			doc.save(pdfPath);
		} finally {
			doc.close();
		}

	}

	/**
	 * 和範例8差不多，但8會蓋掉整頁(怪怪)，加強了圖片的放置在上層還是底層
	 * @throws IOException
	 */
	public void $8_2加入底層圖片() throws IOException {
		PDDocument doc = null;
		try {
			doc = PDDocument.load(new File("z:/005內建字型.pdf"));
			// we will add the image to the first page.
			PDPage page = doc.getPage(0);
			File imageFile = Utils.getResourceFromRoot("pdf/pdfbox/test.png");
			// createFromFile is the easiest way with an image file
			// if you already have the image in a BufferedImage,
			// call LosslessFactory.createFromImage() instead
			PDImageXObject pdImage = PDImageXObject.createFromFile(imageFile.getAbsolutePath(), doc);

			// 強化範例八
			// APPEND,OVERWRITE,PREPEND，用PREPEND讓圖變底圖
			PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.PREPEND, true);
			// PDPageContentStream contents = new PDPageContentStream(doc, page);

			// contentStream.drawImage(ximage, 20, 20 );
			// better method inspired by http://stackoverflow.com/a/22318681/535646
			// reduce this value if the image is too large
			float scale = 1f;
			contentStream.drawImage(pdImage, 20, 400, pdImage.getWidth() * scale, pdImage.getHeight() * scale);

			contentStream.close();
			doc.save("z:/008_2加入底層圖片.pdf");
		} finally {
			if (doc != null) {
				doc.close();
			}
		}
	}

	/**
	 * 和郵戳的感覺差不多，用pdf xchange viewer可以移位、改透明度
	 * @throws IOException
	 */
	public void $9郵戳印花() throws IOException {
		PDDocument document = null;
		try {
			document = PDDocument.load(new File("z:/005內建字型.pdf"));
			if (document.isEncrypted()) {
				throw new IOException("Encrypted documents are not supported for this example");
			}
			for (PDPage page : document.getPages()) {
				List<PDAnnotation> annotations = page.getAnnotations();

				PDAnnotationRubberStamp rs = new PDAnnotationRubberStamp();
				rs.setName(PDAnnotationRubberStamp.NAME_TOP_SECRET);
				rs.setRectangle(new PDRectangle(100, 100));
				rs.setContents("A top secret note");
				rs.setLocked(true);// 不給移動和調透明度，其它設定如列印之類的…有很多可以設
				annotations.add(rs);
			}

			document.save("z:/009郵戳印花.pdf");
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	/**
	 * 加入書籤，第一層是all page，第2層的頁數，另外設了大小fit，xyz=不設？
	 * @throws IOException
	 */
	public void $10建立書籤() throws IOException {
		PDDocument document = null;
		try {
			document = PDDocument.load(new File("z:/005內建字型.pdf"));
			if (document.isEncrypted()) {
				System.err.println("Error: Cannot add bookmarks to encrypted document.");
				System.exit(1);
			}
			PDDocumentOutline outline = new PDDocumentOutline();
			document.getDocumentCatalog().setDocumentOutline(outline);
			PDOutlineItem pagesOutline = new PDOutlineItem();
			pagesOutline.setTitle("All Pages");
			outline.addLast(pagesOutline);
			int pageNum = 0;
			for (PDPage page : document.getPages()) {
				pageNum++;
				PDPageDestination dest = new PDPageFitWidthDestination();// 用寬fit
				dest = new PDPageFitHeightDestination();// 用高fit
				dest = new PDPageXYZDestination();// 不會fit，要定位xyz？
				dest.setPage(page);
				PDOutlineItem bookmark = new PDOutlineItem();
				bookmark.setDestination(dest);
				bookmark.setTitle("Page " + pageNum);
				pagesOutline.addLast(bookmark);
			}
			pagesOutline.openNode();
			outline.openNode();

			document.save("z:/010加入書籤.pdf");
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	public void $11讀取書籤() throws IOException {
		PDDocument document = null;
		try {
			File f = new File("z:/010加入書籤.pdf");
			document = PDDocument.load(f);
			PDDocumentOutline outline = document.getDocumentCatalog().getDocumentOutline();
			if (outline != null) {
				printBookmark(outline, "");
			} else {
				System.out.println("This document does not contain any bookmarks");
			}
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	public void printBookmark(PDOutlineNode bookmark, String indentation) throws IOException {
		PDOutlineItem current = bookmark.getFirstChild();
		while (current != null) {
			System.out.println("ex11 書籤：" + indentation + current.getTitle());
			printBookmark(current, indentation + "    ");
			current = current.getNextSibling();
		}
	}

	/**
	 * 只有第一次開啟才會跳頁，再來reader都會記住頁數，除非你改檔名，不然只有一次有用很雞助
	 * @throws IOException
	 */
	public void $12開啟時跳到書籤() throws IOException {
		PDDocument document = null;
		try {
			File f = new File("z:/010加入書籤.pdf");
			document = PDDocument.load(f);
			if (document.isEncrypted()) {
				System.err.println("Error: Cannot add bookmark destination to encrypted documents.");
				System.exit(1);
			}

			if (document.getNumberOfPages() < 2) {
				throw new IOException("Error: The PDF must have at least 2 pages.");
			}
			PDDocumentOutline bookmarks = document.getDocumentCatalog().getDocumentOutline();
			if (bookmarks == null) {
				throw new IOException("Error: The PDF does not contain any bookmarks");
			}
			System.out.println(bookmarks.getOpenCount());
			PDOutlineItem item = bookmarks.getFirstChild();
			for (PDOutlineItem i : item.children()) {
				item = i;
			}
			System.out.println(item.getTitle());
			// 這一行應該是取得同一層的下一書籤，所以會是null，因為ex10是一個主書籤(all page)下面2個子書籤(page1,page2)
			// item = item.getNextSibling();
			PDDestination dest = item.getDestination();
			PDActionGoTo action = new PDActionGoTo();
			action.setDestination(dest);
			document.getDocumentCatalog().setOpenAction(action);
			document.save("z:/012開啟時跳到書籤.pdf");
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	public void $13讀取pdf某頁變大旋轉印到本頁() throws IOException {
		String sourcePath = "z:/005內建字型.pdf";
		String destPath = "z:/013讀取pdf某頁變大旋轉印到本頁.pdf";

		PDDocument sourceDoc = null;
		try {
			// load the source PDF
			sourceDoc = PDDocument.load(new File(sourcePath));
			int sourcePage = 1;

			// create a new PDF and add a blank page
			PDDocument doc = new PDDocument();
			PDPage page = new PDPage();
			doc.addPage(page);

			// write some sample text to the new page
			// 先在第一頁隨便加一些文字Sample text
			PDPageContentStream contents = new PDPageContentStream(doc, page);
			contents.beginText();
			contents.setFont(PDType1Font.HELVETICA_BOLD, 12);
			contents.newLineAtOffset(2, PDRectangle.LETTER.getHeight() - 12);
			contents.showText("Sample text");
			contents.endText();

			// Create a Form XObject from the source document using LayerUtility
			// 載入來源pdf成為一個pdfObject
			LayerUtility layerUtility = new LayerUtility(doc);
			PDFormXObject form = layerUtility.importPageAsForm(sourceDoc, sourcePage - 1);

			// draw the full form
			// 把來源畫上去本身的pdf
			contents.drawForm(form);

			// 畫第二張pdf form時，好像就要saveGraphicsState和restoreGraphicsState()
			// 是怕上一張form消失或被蓋過去，還是原生form有變就要怎樣嗎？？，未測先照用不足再來研究
			// draw a scaled form
			contents.saveGraphicsState();
			Matrix matrix = Matrix.getScaleInstance(0.58f, 0.58f);
			contents.transform(matrix);
			contents.drawForm(form);
			contents.restoreGraphicsState();

			// 這裡又多加上了轉角度
			// draw a scaled and rotated form
			contents.saveGraphicsState();
			matrix.rotate(1.8 * Math.PI); // radians
			contents.transform(matrix);
			contents.drawForm(form);
			contents.restoreGraphicsState();

			contents.close();
			doc.save(destPath);
			doc.close();
		} finally {
			if (sourceDoc != null) {
				sourceDoc.close();
			}
		}
	}

	/**
	 * 包含了幾個annotion，都是樣式蓋在文字的上面<br>
	 * 對話框(button？)、url link，圓、箭頭、方形<br>
	 * PDAnnotationTextMarkup，PDAnnotationLink，PDAnnotationSquareCircle(圓形和方形)，PDAnnotationLine
	 * @throws IOException
	 */
	public void $14加入註解物件() throws IOException {

		PDDocument document = new PDDocument();
		try {
			PDPage page = new PDPage();
			document.addPage(page);
			List<PDAnnotation> annotations = page.getAnnotations();

			// Some basic reusable objects/constants
			// Annotations themselves can only be used once!
			PDColor red = new PDColor(new float[] { 1, 0, 0 }, PDDeviceRGB.INSTANCE);
			PDColor blue = new PDColor(new float[] { 0, 0, 1 }, PDDeviceRGB.INSTANCE);
			PDColor black = new PDColor(new float[] { 0, 0, 0 }, PDDeviceRGB.INSTANCE);

			PDBorderStyleDictionary borderThick = new PDBorderStyleDictionary();
			borderThick.setWidth(INCH / 12); // 12th inch

			PDBorderStyleDictionary borderThin = new PDBorderStyleDictionary();
			borderThin.setWidth(INCH / 72); // 1 point

			PDBorderStyleDictionary borderULine = new PDBorderStyleDictionary();
			borderULine.setStyle(PDBorderStyleDictionary.STYLE_UNDERLINE);
			borderULine.setWidth(INCH / 72); // 1 point

			float pw = page.getMediaBox().getUpperRightX();
			float ph = page.getMediaBox().getUpperRightY();

			// First add some text, two lines we'll add some annotations to this later
			PDFont font = PDType1Font.HELVETICA_BOLD;
			PDPageContentStream contents = new PDPageContentStream(document, page);
			contents.beginText();
			contents.setFont(font, 18);
			contents.newLineAtOffset(INCH, ph - INCH - 18);
			contents.showText("PDFBoxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");// 寫出文字
			contents.newLineAtOffset(0, -(INCH / 2));
			contents.showText("Click Hereeeeeeeeeeeeeeeeeeeeeeeeeeeeee");// 寫出文字
			contents.endText();
			contents.close();

			// PDAnnotationTextMarkup是一個類似button的ui，點兩下可以加註解(pdf xchange reader)
			// Now add the markup annotation, a highlight to PDFBox text
			PDAnnotationTextMarkup txtMark = new PDAnnotationTextMarkup(PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
			txtMark.setColor(blue);
			txtMark.setConstantOpacity((float) 0.2); // 20% transparent

			// 算PDFBox的位置大小
			// Set the rectangle containing the markup
			float textWidth = font.getStringWidth("PDFBox") / 1000 * 18;
			PDRectangle position = new PDRectangle();
			position.setLowerLeftX(INCH);
			position.setLowerLeftY(ph - INCH - 18);
			position.setUpperRightX(72 + textWidth);
			position.setUpperRightY(ph - INCH);
			txtMark.setRectangle(position);

			// work out the points forming the four corners of the annotations
			// set out in anti clockwise form (Completely wraps the text)
			// OK, the below doesn't match that description.
			// It's what acrobat 7 does and displays properly!
			float[] quads = new float[8];
			quads[0] = position.getLowerLeftX(); // x1
			quads[1] = position.getUpperRightY() - 2; // y1
			quads[2] = position.getUpperRightX(); // x2
			quads[3] = quads[1]; // y2
			quads[4] = quads[0]; // x3
			quads[5] = position.getLowerLeftY() - 2; // y3
			quads[6] = quads[2]; // x4
			quads[7] = quads[5]; // y5

			txtMark.setQuadPoints(quads);
			txtMark.setContents("Highlighted since it's important");
			annotations.add(txtMark);

			// Now add the link annotation, so the clickme works
			PDAnnotationLink txtLink = new PDAnnotationLink();
			txtLink.setBorderStyle(borderULine);

			// Set the rectangle containing the link
			textWidth = font.getStringWidth("Click Here") / 1000 * 18;
			position = new PDRectangle();
			position.setLowerLeftX(INCH);
			position.setLowerLeftY(ph - 1.5f * INCH - 20); // down a couple of points
			position.setUpperRightX(72 + textWidth);
			position.setUpperRightY(ph - 1.5f * INCH);
			txtLink.setRectangle(position);

			// add an action
			PDActionURI action = new PDActionURI();
			action.setURI("http://pdfbox.apache.org");
			txtLink.setAction(action);
			annotations.add(txtLink);

			// Now draw a few more annotations
			PDAnnotationSquareCircle aCircle = new PDAnnotationSquareCircle(PDAnnotationSquareCircle.SUB_TYPE_CIRCLE);
			aCircle.setContents("Circle Annotation");
			aCircle.setInteriorColor(red); // Fill in circle in red
			aCircle.setColor(blue); // The border itself will be blue
			aCircle.setBorderStyle(borderThin);

			// Place the annotation on the page, we'll make this 1" round
			// 3" down, 1" in on the page
			position = new PDRectangle();
			position.setLowerLeftX(INCH);
			position.setLowerLeftY(ph - 3 * INCH - INCH); // 1" height, 3" down
			position.setUpperRightX(2 * INCH); // 1" in, 1" width
			position.setUpperRightY(ph - 3 * INCH); // 3" down
			aCircle.setRectangle(position);
			annotations.add(aCircle);

			// Now a square annotation
			PDAnnotationSquareCircle aSquare = new PDAnnotationSquareCircle(PDAnnotationSquareCircle.SUB_TYPE_SQUARE);
			aSquare.setContents("Square Annotation");
			aSquare.setColor(red); // Outline in red, not setting a fill
			aSquare.setBorderStyle(borderThick);

			// Place the annotation on the page, we'll make this 1" (72points) square
			// 3.5" down, 1" in from the right on the page
			position = new PDRectangle(); // Reuse the variable, but note it's a new object!
			position.setLowerLeftX(pw - 2 * INCH); // 1" in from right, 1" wide
			position.setLowerLeftY(ph - 3.5f * INCH - INCH); // 1" height, 3.5" down
			position.setUpperRightX(pw - INCH); // 1" in from right
			position.setUpperRightY(ph - 3.5f * INCH); // 3.5" down
			aSquare.setRectangle(position);
			annotations.add(aSquare);

			// Now we want to draw a line between the two, one end with an open arrow
			PDAnnotationLine aLine = new PDAnnotationLine();
			aLine.setEndPointEndingStyle(PDAnnotationLine.LE_OPEN_ARROW);
			aLine.setContents("Circle->Square");
			aLine.setCaption(true); // Make the contents a caption on the line

			// Set the rectangle containing the line
			position = new PDRectangle(); // Reuse the variable, but note it's a new object!
			position.setLowerLeftX(2 * INCH); // 1" in + width of circle
			position.setLowerLeftY(ph - 3.5f * INCH - INCH); // 1" height, 3.5" down
			position.setUpperRightX(pw - INCH - INCH); // 1" in from right, and width of square
			position.setUpperRightY(ph - 3 * INCH); // 3" down (top of circle)
			aLine.setRectangle(position);

			// Now set the line position itself
			float[] linepos = new float[4];
			linepos[0] = 2 * INCH; // x1 = rhs of circle
			linepos[1] = ph - 3.5f * INCH; // y1 halfway down circle
			linepos[2] = pw - 2 * INCH; // x2 = lhs of square
			linepos[3] = ph - 4 * INCH; // y2 halfway down square
			aLine.setLine(linepos);

			aLine.setBorderStyle(borderThick);
			aLine.setColor(black);
			annotations.add(aLine);

			// save the PDF
			document.save("z:/014加入註解物件.pdf");
		} finally {
			document.close();
		}

	}

	public void $15修改url註解() throws IOException {
		PDDocument doc = null;
		try {
			doc = PDDocument.load(new File("z:/014加入註解物件.pdf"));
			int pageNum = 0;
			for (PDPage page : doc.getPages()) {
				pageNum++;
				List<PDAnnotation> annotations = page.getAnnotations();

				for (PDAnnotation annotation : annotations) {
					PDAnnotation annot = annotation;
					if (annot instanceof PDAnnotationLink) {
						PDAnnotationLink link = (PDAnnotationLink) annot;
						PDAction action = link.getAction();
						if (action instanceof PDActionURI) {
							PDActionURI uri = (PDActionURI) action;
							String oldURI = uri.getURI();
							String newURI = "http://www.kimo.com.tw";
							System.out.println("Page " + pageNum + ": Replacing " + oldURI + " with " + newURI);
							uri.setURI(newURI);
						}
					}
				}
			}
			doc.save("z:/015修改url註解.pdf");

		} finally {
			if (doc != null) {
				doc.close();
			}
		}
	}

	/**
	 * 這裡很複雜，要避免這種需求，拿link很簡單，要弄出link上面的文字卻很難，這例子還有換行的問題
	 * @throws IOException
	 */
	public void $16印出url註解() throws IOException {
		System.out.println("=======$16印出url註解");
		PDDocument doc = null;
		try {
			doc = PDDocument.load(new File("z:/014加入註解物件.pdf"));
			int pageNum = 0;
			for (PDPage page : doc.getPages()) {
				pageNum++;
				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				List<PDAnnotation> annotations = page.getAnnotations();
				// first setup text extraction regions
				for (int j = 0; j < annotations.size(); j++) {
					PDAnnotation annot = annotations.get(j);
					if (annot instanceof PDAnnotationLink) {
						PDAnnotationLink link = (PDAnnotationLink) annot;
						PDRectangle rect = link.getRectangle();
						// need to reposition link rectangle to match text space
						float x = rect.getLowerLeftX();
						float y = rect.getUpperRightY();
						float width = rect.getWidth();
						float height = rect.getHeight();
						int rotation = page.getRotation();
						if (rotation == 0) {
							PDRectangle pageSize = page.getMediaBox();
							y = pageSize.getHeight() - y;
						} else if (rotation == 90) {
							// do nothing
						}

						Rectangle2D.Float awtRect = new Rectangle2D.Float(x, y, width, height);
						stripper.addRegion("" + j, awtRect);
					}
				}

				stripper.extractRegions(page);

				for (int j = 0; j < annotations.size(); j++) {
					PDAnnotation annot = annotations.get(j);
					if (annot instanceof PDAnnotationLink) {
						PDAnnotationLink link = (PDAnnotationLink) annot;
						PDAction action = link.getAction();
						String urlText = stripper.getTextForRegion("" + j);
						if (action instanceof PDActionURI) {
							PDActionURI uri = (PDActionURI) action;
							System.out.println("Page " + pageNum + ":'" + urlText + "'=" + uri.getURI());
						}
					}
				}
			}

		} finally {
			if (doc != null) {
				doc.close();
			}
		}
	}

	public void $17加入metaData() throws Exception {
		PDDocument document = null;

		try {
			document = PDDocument.load(new File("z:/005內建字型.pdf"));
			if (document.isEncrypted()) {
				System.err.println("Error: Cannot add metadata to encrypted document.");
				System.exit(1);
			}
			PDDocumentCatalog catalog = document.getDocumentCatalog();
			PDDocumentInformation info = document.getDocumentInformation();

			XMPMetadata metadata = XMPMetadata.createXMPMetadata();

			AdobePDFSchema pdfSchema = metadata.createAndAddAdobePDFSchema();
			// 因為會null，改成hardcode
			// pdfSchema.setKeywords(info.getKeywords());
			pdfSchema.setKeywords("keyword");
			// pdfSchema.setProducer(info.getProducer());
			pdfSchema.setProducer("Producer");

			XMPBasicSchema basicSchema = metadata.createAndAddXMPBasicSchema();
			// basicSchema.setModifyDate(info.getModificationDate());
			basicSchema.setModifyDate(Calendar.getInstance());
			// basicSchema.setCreateDate(info.getCreationDate());
			basicSchema.setCreateDate(Calendar.getInstance());
			// basicSchema.setCreatorTool(info.getCreator());
			basicSchema.setCreatorTool("Creator");
			basicSchema.setMetadataDate(new GregorianCalendar());

			DublinCoreSchema dcSchema = metadata.createAndAddDublinCoreSchema();
			// dcSchema.setTitle(info.getTitle());
			dcSchema.setTitle("Title");
			dcSchema.addCreator("PDFBox");
			// dcSchema.setDescription(info.getSubject());
			dcSchema.setDescription("Subject");

			PDMetadata metadataStream = new PDMetadata(document);
			catalog.setMetadata(metadataStream);

			XmpSerializer serializer = new XmpSerializer();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			serializer.serialize(metadata, baos, false);
			metadataStream.importXMPMetadata(baos.toByteArray());

			document.save("z:/017加入metaData的pdf.pdf");
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	public void $17_2印出metaData() throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat();
		PDDocument document = null;
		try {
			document = PDDocument.load(new File("z:/017加入metaData的pdf.pdf"));
			PDDocumentInformation info = document.getDocumentInformation();
			PDDocumentCatalog cat = document.getDocumentCatalog();
			PDMetadata metadata = cat.getMetadata();
			System.out.println("Page Count=" + document.getNumberOfPages());
			System.out.println("Title=" + info.getTitle());
			System.out.println("Author=" + info.getAuthor());
			System.out.println("Subject=" + info.getSubject());
			System.out.println("Keywords=" + info.getKeywords());
			System.out.println("Creator=" + info.getCreator());
			System.out.println("Producer=" + info.getProducer());
			System.out.println("Creation Date=" + (info.getCreationDate()));
			System.out.println("Modification Date=" + (info.getModificationDate()));
			System.out.println("Trapped=" + info.getTrapped());
			if (metadata != null) {
				String string = new String(metadata.toByteArray(), "ISO-8859-1");
				System.out.println("Metadata=" + string);
			}
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	public void $17_3解析metaData() throws Exception {
		System.out.println("17_3解析metaData(目前無法正常執行，先跳過不重要)==============");
		PDDocument document = null;
		try {
			document = PDDocument.load(new File("z:/017加入metaData的pdf.pdf"));
			PDDocumentCatalog catalog = document.getDocumentCatalog();
			PDMetadata meta = catalog.getMetadata();
			if (meta != null) {
				DomXmpParser xmpParser = new DomXmpParser();
				try {
					XMPMetadata metadata = xmpParser.parse(meta.createInputStream());

					DublinCoreSchema dc = metadata.getDublinCoreSchema();
					if (dc != null) {
						display("Title:", dc.getTitle());
						display("Description:", dc.getDescription());
						display("Creators: ", dc.getCreators());
						display("Dates:", dc.getDates());
						display("Subjects:", dc.getSubjects());
					}

					AdobePDFSchema pdf = metadata.getAdobePDFSchema();
					if (pdf != null) {
						display("Keywords:", pdf.getKeywords());
						display("PDF Version:", pdf.getPDFVersion());
						display("PDF Producer:", pdf.getProducer());
					}

					XMPBasicSchema basic = metadata.getXMPBasicSchema();
					if (basic != null) {
						display("Create Date:", basic.getCreateDate());
						display("Modify Date:", basic.getModifyDate());
						display("Creator Tool:", basic.getCreatorTool());
					}
				} catch (XmpParsingException e) {
					System.err.println("An error ouccred when parsing the meta data: " + e.getMessage());
				}
			} else {
				// The pdf doesn't contain any metadata, try to use the
				// document information instead
				PDDocumentInformation information = document.getDocumentInformation();
				if (information != null) {
					display("Title:", information.getTitle());
					display("Subject:", information.getSubject());
					display("Author:", information.getAuthor());
					display("Creator:", information.getCreator());
					display("Producer:", information.getProducer());
				}
			}

		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	private static void display(String title, Object value) {
		if (value != null) {
			System.out.println(title + " " + value);
		}
	}

	/**
	 * PDF/X、PDF/E 和 PDF/A 規範是由國際標準組織 (ISO) 所制定。PDF/X 規範適用於圖形內容交換；PDF/E 規範適用於工程文件的互動交換；PDF/A 規範適用於電子文件的長期存檔
	 * @throws Exception
	 */
	public void $18建立PDFA文件() throws Exception {
		String ttfPath = "C:\\Windows\\Fonts\\kaiu.ttf";
		String file = "z:/018建立PDFA文件.pdf";
		String message = "鬼才知道會有什麼東西";
		String fontfile = ttfPath;

		PDDocument doc = new PDDocument();
		try {
			PDPage page = new PDPage();
			doc.addPage(page);

			// load the font as this needs to be embedded
			PDFont font = PDType0Font.load(doc, new File(fontfile));

			// create a page with the message
			PDPageContentStream contents = new PDPageContentStream(doc, page);
			contents.beginText();
			contents.setFont(font, 12);
			contents.newLineAtOffset(100, 700);
			contents.showText(message);
			contents.endText();
			contents.saveGraphicsState();
			contents.close();

			// add XMP metadata
			XMPMetadata xmp = XMPMetadata.createXMPMetadata();

			try {
				DublinCoreSchema dc = xmp.createAndAddDublinCoreSchema();
				dc.setTitle(file);

				PDFAIdentificationSchema id = xmp.createAndAddPFAIdentificationSchema();
				id.setPart(1);
				id.setConformance("B");

				XmpSerializer serializer = new XmpSerializer();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				serializer.serialize(xmp, baos, true);

				PDMetadata metadata = new PDMetadata(doc);
				metadata.importXMPMetadata(baos.toByteArray());
				doc.getDocumentCatalog().setMetadata(metadata);
			} catch (BadFieldValueException e) {
				// won't happen here, as the provided value is valid
				throw new IllegalArgumentException(e);
			}
			// sRGB output intent
			// InputStream colorProfile = CreatePDFA.class
			// .getResourceAsStream("/org/apache/pdfbox/resources/pdfa/sRGB Color Space Profile.icm");
			InputStream colorProfile = ClassLoader.getSystemResourceAsStream("pdf/pdfbox/sRGB Color Space Profile.icm");

			PDOutputIntent intent = new PDOutputIntent(doc, colorProfile);
			intent.setInfo("sRGB IEC61966-2.1");
			intent.setOutputCondition("sRGB IEC61966-2.1");
			intent.setOutputConditionIdentifier("sRGB IEC61966-2.1");
			intent.setRegistryName("http://www.color.org");
			doc.getDocumentCatalog().addOutputIntent(intent);
			doc.save(file);
		} finally {
			doc.close();
		}

	}

	/**
	 * 類似印水印可以這樣做？用文字會蓋過去有點不好看，是否用png可以改善？注意用PREPEND會影嚮本來的文字顏色
	 * @throws IOException
	 */
	public void $19每頁的後製處理() throws IOException {
		String message = "Hello every page";
		String outfile = "z:/019每頁的後製處理.pdf";
		PDDocument doc = null;
		try {
			doc = PDDocument.load(new File("z:/005內建字型.pdf"));

			PDFont font = PDType1Font.HELVETICA_BOLD;
			float fontSize = 48.0f;

			for (PDPage page : doc.getPages()) {
				PDRectangle pageSize = page.getMediaBox();
				float stringWidth = font.getStringWidth(message) * fontSize / 1000f;
				// calculate to center of the page
				int rotation = page.getRotation();
				rotation = 90;
				boolean rotate = rotation == 90 || rotation == 270;
				float pageWidth = rotate ? pageSize.getHeight() : pageSize.getWidth();
				float pageHeight = rotate ? pageSize.getWidth() : pageSize.getHeight();
				float centerX = rotate ? pageHeight / 2f : (pageWidth - stringWidth) / 2f;
				float centerY = rotate ? (pageWidth - stringWidth) / 2f : pageHeight / 2f;
				// append the content to the existing stream
				PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, true, true);
				contentStream.beginText();
				// set font and font size
				contentStream.setFont(font, fontSize);
				// set text color to red
				contentStream.setNonStrokingColor(255, 0, 0);
				if (rotate) {
					// rotate the text according to the page rotation
					contentStream.setTextMatrix(Matrix.getRotateInstance(Math.PI / 2, centerX, centerY));
				} else {
					contentStream.setTextMatrix(Matrix.getTranslateInstance(centerX, centerY));
				}
				contentStream.showText(message);
				contentStream.endText();
				contentStream.close();
			}

			doc.save(outfile);
		} finally {
			if (doc != null) {
				doc.close();
			}
		}

	}

	public void $20橫向排版畫線() throws IOException {

		String message = "hello world 20--------202020";
		String outfile = "z:/020橫向排版畫線.pdf";

		PDDocument doc = null;
		try {
			doc = new PDDocument();

			PDFont font = PDType1Font.HELVETICA;
			PDPage page = new PDPage(PDRectangle.A4);
			page.setRotation(90);
			doc.addPage(page);
			PDRectangle pageSize = page.getMediaBox();
			float pageWidth = pageSize.getWidth();
			float fontSize = 12;
			float stringWidth = font.getStringWidth(message) * fontSize / 1000f;
			float startX = 100;
			float startY = 100;
			PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.OVERWRITE, false);
			// add the rotation using the current transformation matrix
			// including a translation of pageWidth to use the lower left corner as 0,0 reference
			contentStream.transform(new Matrix(0, 1, -1, 0, pageWidth, 0));
			contentStream.setFont(font, fontSize);
			contentStream.beginText();
			contentStream.newLineAtOffset(startX, startY);
			contentStream.showText(message);
			contentStream.newLineAtOffset(0, 100);
			contentStream.showText(message);
			contentStream.newLineAtOffset(100, 100);
			contentStream.showText(message);
			contentStream.endText();

			contentStream.moveTo(startX - 2, startY - 2);
			contentStream.lineTo(startX - 2, startY + 200 + fontSize);
			contentStream.stroke();

			contentStream.moveTo(startX - 2, startY + 200 + fontSize);
			contentStream.lineTo(startX + 100 + stringWidth + 2, startY + 200 + fontSize);
			contentStream.stroke();

			contentStream.moveTo(startX + 100 + stringWidth + 2, startY + 200 + fontSize);
			contentStream.lineTo(startX + 100 + stringWidth + 2, startY - 2);
			contentStream.stroke();

			contentStream.moveTo(startX + 100 + stringWidth + 2, startY - 2);
			contentStream.lineTo(startX - 2, startY - 2);
			contentStream.stroke();

			contentStream.close();

			doc.save(outfile);
		} finally {
			if (doc != null) {
				doc.close();
			}
		}

	}

	public void $21附加檔案() throws IOException {
		File txtFile = Utils.getResourceFromRoot("pdf/pdfbox/test.txt");
		PDDocument doc = null;
		try {
			doc = new PDDocument();

			PDPage page = new PDPage();
			doc.addPage(page);
			PDFont font = PDType1Font.HELVETICA_BOLD;

			PDPageContentStream contentStream = new PDPageContentStream(doc, page);
			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(100, 700);
			contentStream.showText("Go to Document->File Attachments to View Embedded Files");
			contentStream.endText();
			contentStream.close();

			// embedded files are stored in a named tree
			PDEmbeddedFilesNameTreeNode efTree = new PDEmbeddedFilesNameTreeNode();

			// first create the file specification, which holds the embedded file
			PDComplexFileSpecification fs = new PDComplexFileSpecification();
			fs.setFile("Test.txt");
			fs.setFile(txtFile.getAbsolutePath());

			// create a dummy file stream, this would probably normally be a FileInputStream
			byte[] data = "這就是中文字This is the contents of the embedded file".getBytes("utf-8");
			ByteArrayInputStream fakeFile = new ByteArrayInputStream(data);
			PDEmbeddedFile ef = new PDEmbeddedFile(doc, fakeFile);
			// now lets some of the optional parameters
			ef.setSubtype("test/plain");
			ef.setSize(data.length);
			ef.setCreationDate(new GregorianCalendar());
			fs.setEmbeddedFile(ef);

			// create a new tree node and add the embedded file
			PDEmbeddedFilesNameTreeNode treeNode = new PDEmbeddedFilesNameTreeNode();
			treeNode.setNames(Collections.singletonMap("My first attachment我的附件.txt", fs));
			// add the new node as kid to the root node
			List<PDEmbeddedFilesNameTreeNode> kids = new ArrayList<PDEmbeddedFilesNameTreeNode>();
			kids.add(treeNode);
			efTree.setKids(kids);
			// add the tree to the document catalog
			PDDocumentNameDictionary names = new PDDocumentNameDictionary(doc.getDocumentCatalog());
			names.setEmbeddedFiles(efTree);
			doc.getDocumentCatalog().setNames(names);

			doc.save("z:/021附加檔案(不能測).pdf");
		} finally {
			if (doc != null) {
				doc.close();
			}
		}

	}

	public void $21_2解出附加檔案() throws IOException {

		PDDocument document = null;
		try {
			File pdfFile = new File("z:/021附加檔案(不能測).pdf");
			String filePath = pdfFile.getParent() + System.getProperty("file.separator");
			document = PDDocument.load(pdfFile);
			PDDocumentNameDictionary namesDictionary = new PDDocumentNameDictionary(document.getDocumentCatalog());
			PDEmbeddedFilesNameTreeNode efTree = namesDictionary.getEmbeddedFiles();
			if (efTree != null) {
				Map<String, PDComplexFileSpecification> names = efTree.getNames();
				if (names != null) {
					extractFiles(names, filePath);
				} else {
					List<PDNameTreeNode<PDComplexFileSpecification>> kids = efTree.getKids();
					for (PDNameTreeNode<PDComplexFileSpecification> node : kids) {
						names = node.getNames();
						extractFiles(names, filePath);
					}
				}
			}

			// extract files from annotations
			for (PDPage page : document.getPages()) {
				for (PDAnnotation annotation : page.getAnnotations()) {
					if (annotation instanceof PDAnnotationFileAttachment) {
						PDAnnotationFileAttachment annotationFileAttachment = (PDAnnotationFileAttachment) annotation;
						PDComplexFileSpecification fileSpec = (PDComplexFileSpecification) annotationFileAttachment
								.getFile();
						PDEmbeddedFile embeddedFile = getEmbeddedFile(fileSpec);
						extractFile(filePath, fileSpec.getFilename(), embeddedFile);
					}
				}
			}
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	private static void extractFiles(Map<String, PDComplexFileSpecification> names, String filePath) throws IOException {
		for (Entry<String, PDComplexFileSpecification> entry : names.entrySet()) {
			String filename = entry.getKey();
			PDComplexFileSpecification fileSpec = entry.getValue();
			PDEmbeddedFile embeddedFile = getEmbeddedFile(fileSpec);
			extractFile(filePath, filename, embeddedFile);
		}
	}

	private static void extractFile(String filePath, String filename, PDEmbeddedFile embeddedFile) throws IOException {
		String embeddedFilename = filePath + filename;
		File file = new File(filePath + filename);
		System.out.println("Writing " + embeddedFilename);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(embeddedFile.toByteArray());
		} finally {
			IOUtils.closeQuietly(fos);
		}
	}

	private static PDEmbeddedFile getEmbeddedFile(PDComplexFileSpecification fileSpec) {
		// search for the first available alternative of the embedded file
		PDEmbeddedFile embeddedFile = null;
		if (fileSpec != null) {
			embeddedFile = fileSpec.getEmbeddedFileUnicode();
			if (embeddedFile == null) {
				embeddedFile = fileSpec.getEmbeddedFileDos();
			}
			if (embeddedFile == null) {
				embeddedFile = fileSpec.getEmbeddedFileMac();
			}
			if (embeddedFile == null) {
				embeddedFile = fileSpec.getEmbeddedFileUnix();
			}
			if (embeddedFile == null) {
				embeddedFile = fileSpec.getEmbeddedFile();
			}
		}
		return embeddedFile;
	}

	public void $22文字放大旋轉展示() throws IOException {
		String message = "hello world 22__";
		String outfile = "z:/022文字放大旋轉展示.pdf";
		PDDocument doc = null;
		try {
			doc = new PDDocument();

			// Page 1
			PDFont font = PDType1Font.HELVETICA;
			PDPage page = new PDPage(PDRectangle.A4);
			doc.addPage(page);
			float fontSize = 12.0f;

			PDRectangle pageSize = page.getMediaBox();
			float centeredXPosition = (pageSize.getWidth() - fontSize / 1000f) / 2f;
			float stringWidth = font.getStringWidth(message);
			float centeredYPosition = (pageSize.getHeight() - (stringWidth * fontSize) / 1000f) / 3f;

			PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.OVERWRITE, false);
			contentStream.setFont(font, fontSize);
			contentStream.beginText();
			// counterclockwise rotation
			for (int i = 0; i < 8; i++) {
				contentStream.setTextMatrix(Matrix.getRotateInstance(i * Math.PI * 0.25, centeredXPosition,
						pageSize.getHeight() - centeredYPosition));
				contentStream.showText(message + " " + i);
			}
			// clockwise rotation
			for (int i = 0; i < 8; i++) {
				contentStream.setTextMatrix(Matrix.getRotateInstance(-i * Math.PI * 0.25, centeredXPosition,
						centeredYPosition));
				contentStream.showText(message + " " + i);
			}

			contentStream.endText();
			contentStream.close();

			// Page 2
			page = new PDPage(PDRectangle.A4);
			doc.addPage(page);
			fontSize = 1.0f;

			contentStream = new PDPageContentStream(doc, page, AppendMode.OVERWRITE, false);
			contentStream.setFont(font, fontSize);
			contentStream.beginText();

			// text scaling and translation
			for (int i = 0; i < 10; i++) {
				contentStream.setTextMatrix(new Matrix(12 + (i * 6), 0, 0, 12 + (i * 6), 100, 100 + i * 50));
				contentStream.showText(message + " " + i);
			}
			contentStream.endText();
			contentStream.close();

			// Page 3
			page = new PDPage(PDRectangle.A4);
			doc.addPage(page);
			fontSize = 1.0f;

			contentStream = new PDPageContentStream(doc, page, AppendMode.OVERWRITE, false);
			contentStream.setFont(font, fontSize);
			contentStream.beginText();

			int i = 0;
			// text scaling combined with rotation
			contentStream.setTextMatrix(new Matrix(12, 0, 0, 12, centeredXPosition, centeredYPosition * 1.5f));
			contentStream.showText(message + " " + i++);

			contentStream.setTextMatrix(new Matrix(0, 18, -18, 0, centeredXPosition, centeredYPosition * 1.5f));
			contentStream.showText(message + " " + i++);

			contentStream.setTextMatrix(new Matrix(-24, 0, 0, -24, centeredXPosition, centeredYPosition * 1.5f));
			contentStream.showText(message + " " + i++);

			contentStream.setTextMatrix(new Matrix(0, -30, 30, 0, centeredXPosition, centeredYPosition * 1.5f));
			contentStream.showText(message + " " + i++);

			contentStream.endText();
			contentStream.close();

			doc.save(outfile);
		} finally {
			if (doc != null) {
				doc.close();
			}
		}

	}

	public void $23pdf轉圖片() throws IOException {
		PDDocument document = null;
		String file = "z:/023pdf轉圖片.pdf";
		try {
			document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage(page);

			// type 2 (exponential) function with attributes
			// can be used by both shadings
			COSDictionary fdict = new COSDictionary();
			fdict.setInt(COSName.FUNCTION_TYPE, 2);
			COSArray domain = new COSArray();
			domain.add(COSInteger.get(0));
			domain.add(COSInteger.get(1));
			COSArray c0 = new COSArray();
			c0.add(COSFloat.get("1"));
			c0.add(COSFloat.get("0"));
			c0.add(COSFloat.get("0"));
			COSArray c1 = new COSArray();
			c1.add(COSFloat.get("0.5"));
			c1.add(COSFloat.get("1"));
			c1.add(COSFloat.get("0.5"));
			fdict.setItem(COSName.DOMAIN, domain);
			fdict.setItem(COSName.C0, c0);
			fdict.setItem(COSName.C1, c1);
			fdict.setInt(COSName.N, 1);
			PDFunctionType2 func = new PDFunctionType2(fdict);

			// axial shading with attributes
			PDShadingType2 axialShading = new PDShadingType2(new COSDictionary());
			axialShading.setColorSpace(PDDeviceRGB.INSTANCE);
			axialShading.setShadingType(PDShading.SHADING_TYPE2);
			COSArray coords1 = new COSArray();
			coords1.add(COSInteger.get(100));
			coords1.add(COSInteger.get(400));
			coords1.add(COSInteger.get(400));
			coords1.add(COSInteger.get(600));
			axialShading.setCoords(coords1);
			axialShading.setFunction(func);

			// radial shading with attributes
			PDShadingType3 radialShading = new PDShadingType3(new COSDictionary());
			radialShading.setColorSpace(PDDeviceRGB.INSTANCE);
			radialShading.setShadingType(PDShading.SHADING_TYPE3);
			COSArray coords2 = new COSArray();
			coords2.add(COSInteger.get(100));
			coords2.add(COSInteger.get(400));
			coords2.add(COSInteger.get(50)); // radius1
			coords2.add(COSInteger.get(400));
			coords2.add(COSInteger.get(600));
			coords2.add(COSInteger.get(150)); // radius2
			radialShading.setCoords(coords2);
			radialShading.setFunction(func);

			// invoke shading from content stream
			// compress parameter is set to false so that you can see the stream in a text editor
			PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, false);
			contentStream.shadingFill(axialShading);
			contentStream.shadingFill(radialShading);
			contentStream.close();

			document.save(file);
			document.close();

			// render the PDF and save it into a PNG file
			document = PDDocument.load(new File(file));
			BufferedImage bim = new PDFRenderer(document).renderImageWithDPI(0, 300);
			ImageIO.write(bim, "png", new File(file + ".png"));
			document.close();
		} finally {
			if (document != null) {
				document.close();
			}
		}

	}

}
