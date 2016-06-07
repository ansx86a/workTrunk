package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.ScatterChartData;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tool.Utils;

/**
 * xlsx用
 * @author ai
 *
 */
public class PoiEx002XssfModel {

	public static void main(String[] args) throws Exception {
		File f = Utils.getResourceFromRoot("excel/sample.xlsx");
		FileUtils.copyFile(f, new File("z:/000.xlsx"));
		PoiEx002XssfModel p = new PoiEx002XssfModel();
		p.$1建立檔案並加入第一個sheet();
		p.$2第1頁可以看到第3頁的東西();// 不太懂，先放置
		p.$3讀取欄位值();
		p.$4();// 不懂OPCPackage，難道是ooxml，沒看有人用過，跳過
		p.$5合併欄位();
		p.$6區間列上移();
		p.$7凍結窗格();
		p.$8欄位換行();
		p.$9欄位加上外框border();
		p.$10欄位底色和遮罩();
		p.$11欄位數字的格式化();
		// p.$12();//設定Workbook Properties ，不懂差在那，檔案可以跑出來確看不出來那裡有變
		p.$13TreeView視景();
		p.$14richtext欄位();
		p.$15加入圖片物件();
		p.$16展示各種欄位_公式日期連結等();
		p.$17對欄位加入註解();
		// p.$18頁首頁尾的設定();//顯示要切到別種的才看得到，而且不一定看得到，感覺可能實用性有待確認
		// *******************************************************
		p.$19繪製圖表();// 很棒的功能，有空一定要加強一下才行
		// *******************************************************
		p.$20();
		p.$21();
		p.$22();
		p.$23();
		p.$24();
		p.$25();
		p.$26();
		p.$27();
		p.$28();
		p.$29();
		p.$30();

		System.out.println("end");
	}

	public void $1建立檔案並加入第一個sheet() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		Sheet sheet = wb.createSheet("第一個sheet");
		PrintSetup ps = sheet.getPrintSetup();

		// 看不懂這幾行在設什麼，調整也沒有太大的改變
		// FitSheetToOnePage
		sheet.setAutobreaks(true);
		ps.setFitHeight((short) 1);
		ps.setFitWidth((short) 1);

		// Create various cells and rows for spreadsheet.

		FileOutputStream fileOut = new FileOutputStream("z:/001建立檔案並加入第一個sheet.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $2第1頁可以看到第3頁的東西() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();

		wb.createSheet("row sheet");
		wb.createSheet("another sheet");
		Sheet sheet3 = wb.createSheet(" sheet 3 ");
		// 註要是這個select搭配active，懶得去查怎麼用，反正先放著
		sheet3.setSelected(true);
		wb.setActiveSheet(2);

		// Create various cells and rows for spreadsheet.

		FileOutputStream fileOut = new FileOutputStream("z:/002selectedSheet第1頁可以看到第3頁的東西.xlsx");
		wb.write(fileOut);
		fileOut.close();

		wb.close();
	}

	public void $3讀取欄位值() throws IOException {
		Workbook wb = new XSSFWorkbook(new FileInputStream("z:/000.xlsx"));
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			Sheet sheet = wb.getSheetAt(i);
			System.out.println(wb.getSheetName(i));
			for (Row row : sheet) {
				System.out.print("[rownum: " + row.getRowNum() + "]");
				for (Cell cell : row) {
					System.out.print("{" + cell.toString() + "}");
				}
				System.out.println();
			}
		}
	}

	public void $4() {
		// OPCPackage pkg = OPCPackage.open(args[0]);
		// XSSFWorkbook wb = new XSSFWorkbook(pkg);
		//
		// for (XSSFMap map : wb.getCustomXMLMappings()) {
		// XSSFExportToXml exporter = new XSSFExportToXml(map);
		//
		// ByteArrayOutputStream os = new ByteArrayOutputStream();
		// exporter.exportToXML(os, true);
		// String xml = os.toString("UTF-8");
		// System.out.println(xml);
		// }
		// pkg.close();
	}

	public void $5合併欄位() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		Sheet sheet = wb.createSheet("new sheet");

		Row row = sheet.createRow((short) 2);// 第三列
		Cell cell = row.createCell((short) 1);// 第二行
		cell.setCellValue(new XSSFRichTextString("This is a test of merging"));

		// int firstRow, int lastRow, int firstCol, int lastCol
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 2));

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/005合併欄位.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $6區間列上移() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Sheet1");

		Row row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue(1);

		Row row2 = sheet.createRow(4);
		row2.createCell(1).setCellValue(2);

		Row row3 = sheet.createRow(5);
		row3.createCell(2).setCellValue(3);

		Row row4 = sheet.createRow(6);
		row4.createCell(3).setCellValue(4);

		Row row5 = sheet.createRow(9);
		row5.createCell(4).setCellValue(5);

		// Shift rows 6 - 11 on the spreadsheet to the top (rows 0 - 5)

		FileOutputStream fileOut = new FileOutputStream("z:/006區間列上移.xlsx");
		wb.write(fileOut);
		fileOut.close();
		// int startRow, int endRow, int n
		sheet.shiftRows(5, 10, -4);// 把5-10列往上移4列，1和2都會被空白列的空白蓋過去
		fileOut = new FileOutputStream("z:/006區間列上移2.xlsx");
		wb.write(fileOut);
		fileOut.close();

	}

	public void $7凍結窗格() throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet1 = wb.createSheet("new sheet");
		Sheet sheet2 = wb.createSheet("second sheet");
		Sheet sheet3 = wb.createSheet("third sheet");
		Sheet sheet4 = wb.createSheet("fourth sheet");

		// Freeze just one row
		sheet1.createFreezePane(0, 1, 0, 1);
		// Freeze just one column
		sheet2.createFreezePane(1, 0, 1, 0);
		// Freeze the columns and rows (forget about scrolling position of the lower right quadrant).
		sheet3.createFreezePane(2, 2);
		// Create a split with the lower left side being the active quadrant
		sheet4.createSplitPane(2000, 2000, 0, 0, Sheet.PANE_LOWER_LEFT);

		FileOutputStream fileOut = new FileOutputStream("z:/007凍結窗格.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $8欄位換行() throws Exception {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		Sheet sheet = wb.createSheet();

		Row row = sheet.createRow(2);// 第三列
		Cell cell = row.createCell(2);// 第三格
		cell.setCellValue("中文換行 \n 不過是☆☆ a new line");

		// to enable newlines you need set a cell styles with wrap=true
		CellStyle cs = wb.createCellStyle();
		cs.setWrapText(true);// 設定可以換行
		cell.setCellStyle(cs);

		// increase row height to accomodate two lines of text
		row.setHeightInPoints((2 * sheet.getDefaultRowHeightInPoints()));// 預設行高2倍

		// adjust column width to fit the content
		sheet.autoSizeColumn(2);

		FileOutputStream fileOut = new FileOutputStream("z:/008欄位換行.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $9欄位加上外框border() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		Sheet sheet = wb.createSheet("borders");

		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow((short) 1);

		// Create a cell and put a value in it.
		Cell cell = row.createCell((short) 1);
		cell.setCellValue(4);

		// Style the cell with borders all around.
		CellStyle style = wb.createCellStyle();
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLUE.getIndex());
		style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		cell.setCellStyle(style);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/009欄位加上外框border.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $10欄位底色和遮罩() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		Sheet sheet = wb.createSheet("new sheet");

		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow((short) 1);

		// Aqua background
		CellStyle style = wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(CellStyle.BIG_SPOTS);
		Cell cell = row.createCell((short) 1);
		cell.setCellValue(new XSSFRichTextString("X"));
		cell.setCellStyle(style);

		// Orange "foreground", foreground being the fill foreground not the font color.
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell = row.createCell((short) 2);
		cell.setCellValue(new XSSFRichTextString("X"));
		cell.setCellStyle(style);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/010欄位底色和遮罩.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $11欄位數字的格式化() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		Sheet sheet = wb.createSheet("format sheet");
		CellStyle style;
		DataFormat format = wb.createDataFormat();
		Row row;
		Cell cell;
		short rowNum = 0;
		short colNum = 0;

		row = sheet.createRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(11111.25);
		style = wb.createCellStyle();
		style.setDataFormat(format.getFormat("0.0"));// 小數點1位，第2位為4捨5入
		cell.setCellStyle(style);

		row = sheet.createRow(++rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(11111.25);
		style = wb.createCellStyle();
		style.setDataFormat(format.getFormat("#,##0.0000"));// 小數點4位，正數3位1個逗號，ex 1,000,000.0000為1百萬
		cell.setCellStyle(style);

		FileOutputStream fileOut = new FileOutputStream("z:/011欄位數字的格式化.xlsx");
		wb.write(fileOut);
		fileOut.close();

		wb.close();
	}

	public void $12() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		workbook.createSheet("Workbook Properties");

		POIXMLProperties props = workbook.getProperties();

		/**
		 * Extended properties are a predefined set of metadata properties that are specifically applicable to Office
		 * Open XML documents. Extended properties consist of 24 simple properties and 3 complex properties stored in
		 * the part targeted by the relationship of type
		 */
		POIXMLProperties.ExtendedProperties ext = props.getExtendedProperties();
		ext.getUnderlyingProperties().setCompany("Apache Software Foundation");
		ext.getUnderlyingProperties().setTemplate("XSSF");

		/**
		 * Custom properties enable users to define custom metadata properties.
		 */

		POIXMLProperties.CustomProperties cust = props.getCustomProperties();
		cust.addProperty("Author", "John Smith");
		cust.addProperty("Year", 2009);
		cust.addProperty("Price", 45.50);
		cust.addProperty("Available", true);

		FileOutputStream out = new FileOutputStream("z:/012workbook.xlsx");
		workbook.write(out);
		out.close();
	}

	public void $13TreeView視景() throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet1 = wb.createSheet("new sheet");

		sheet1.groupRow(5, 14);
		sheet1.groupRow(7, 14);
		sheet1.groupRow(16, 19);

		sheet1.groupColumn((short) 4, (short) 7);
		sheet1.groupColumn((short) 9, (short) 12);
		sheet1.groupColumn((short) 10, (short) 11);

		FileOutputStream fileOut = new FileOutputStream("z:/013TreeView視景1.xlsx");
		wb.write(fileOut);
		fileOut.close();

		Workbook wb2 = new XSSFWorkbook();
		Sheet sheet2 = wb2.createSheet("new sheet");
		sheet2.groupRow(5, 14);
		sheet2.groupRow(7, 14);
		sheet2.groupRow(16, 19);

		sheet2.groupColumn((short) 4, (short) 7);
		sheet2.groupColumn((short) 9, (short) 12);
		sheet2.groupColumn((short) 10, (short) 11);

		sheet2.setRowGroupCollapsed(7, true);
		// sheet1.setRowGroupCollapsed(7,false);

		sheet2.setColumnGroupCollapsed((short) 4, true);
		sheet2.setColumnGroupCollapsed((short) 4, false);

		fileOut = new FileOutputStream("z:/013TreeView視景2.xlsx");
		wb2.write(fileOut);
		fileOut.close();
	}

	public void $14richtext欄位() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		try {
			XSSFSheet sheet = wb.createSheet();
			XSSFRow row = sheet.createRow((short) 2);

			XSSFCell cell = row.createCell(1);
			XSSFRichTextString rt = new XSSFRichTextString("The quick brown fox");

			XSSFFont font1 = wb.createFont();
			font1.setBold(true);
			font1.setColor(new XSSFColor(new java.awt.Color(255, 0, 0)));
			rt.applyFont(0, 10, font1);

			XSSFFont font2 = wb.createFont();
			font2.setItalic(true);
			font2.setUnderline(XSSFFont.U_DOUBLE);
			font2.setColor(new XSSFColor(new java.awt.Color(0, 255, 0)));
			rt.applyFont(10, 19, font2);

			XSSFFont font3 = wb.createFont();
			font3.setColor(new XSSFColor(new java.awt.Color(0, 0, 255)));
			rt.append(" 這一串是額外加入的", font3);

			cell.setCellValue(rt);

			// Write the output to a file
			OutputStream fileOut = new FileOutputStream("z:/014xssf-richtext.xlsx");
			try {
				wb.write(fileOut);
			} finally {
				fileOut.close();
			}
		} finally {
			wb.close();
		}
	}

	public void $15加入圖片物件() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		try {
			CreationHelper helper = wb.getCreationHelper();
			File f = Utils.getResourceFromRoot("excel/test.png");
			// add a picture in this workbook.
			InputStream is = new FileInputStream(f);
			byte[] bytes = IOUtils.toByteArray(is);
			is.close();
			int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);

			// create sheet
			Sheet sheet = wb.createSheet();

			// create drawing
			Drawing drawing = sheet.createDrawingPatriarch();

			// add a picture shape
			ClientAnchor anchor = helper.createClientAnchor();
			anchor.setCol1(1);
			anchor.setRow1(1);
			Picture pict = drawing.createPicture(anchor, pictureIdx);

			// auto-size picture
			pict.resize(2);

			// save workbook
			String file = "z:/015加入圖片物件.xls";
			if (wb instanceof XSSFWorkbook)
				file += "x";
			OutputStream fileOut = new FileOutputStream(file);
			try {
				wb.write(fileOut);
			} finally {
				fileOut.close();
			}
		} finally {
			wb.close();
		}
	}

	public void $16展示各種欄位_公式日期連結等() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		CreationHelper creationHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("new sheet");

		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow((short) 0);
		// Create a cell and put a value in it.
		Cell cell = row.createCell((short) 0);
		cell.setCellValue(1);// 第一欄為單純數字

		// numeric value
		row.createCell(1).setCellValue(1.2);// 第二欄為單純數字，有小數

		// plain string value
		row.createCell(2).setCellValue("This is a string cell");// 第三欄為單純字串

		// rich text string
		RichTextString str = creationHelper.createRichTextString("Apache");
		Font font = wb.createFont();
		font.setItalic(true);
		font.setUnderline(Font.U_SINGLE);
		str.applyFont(font);
		row.createCell(3).setCellValue(str);// 第4欄為rich字串

		// boolean value
		row.createCell(4).setCellValue(true);// 第5欄為布林

		// formula
		row.createCell(5).setCellFormula("SUM(A1:B1)");// 第6欄為公式

		// date
		CellStyle style = wb.createCellStyle();
		style.setDataFormat(creationHelper.createDataFormat().getFormat("m/d/yy h:mm"));
		cell = row.createCell(6);
		cell.setCellValue(new Date());// 第7欄為日期
		cell.setCellStyle(style);

		// hyperlink
		row.createCell(7).setCellFormula("SUM(A1:B1)");// 第8欄重覆公式搞屁啊
		cell = row.createCell(8);// 第9欄是連結，自已修正的，本來會把第7欄蓋掉
		cell.setCellFormula("HYPERLINK(\"http://google.com\",\"Google\")");

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/016展示各種欄位_公式日期連結等.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $17對欄位加入註解() throws IOException {
		Workbook wb = new XSSFWorkbook();
		CreationHelper factory = wb.getCreationHelper();
		Sheet sheet = wb.createSheet();

		Cell cell1 = sheet.createRow(3).createCell(5);
		cell1.setCellValue("F4");

		Drawing drawing = sheet.createDrawingPatriarch();
		ClientAnchor anchor = factory.createClientAnchor();

		Comment comment1 = drawing.createCellComment(anchor);
		RichTextString str1 = factory.createRichTextString("Hello, World!");
		comment1.setString(str1);
		comment1.setAuthor("Apache POI");
		cell1.setCellComment(comment1);

		Cell cell2 = sheet.createRow(2).createCell(2);
		cell2.setCellValue("C3");

		Comment comment2 = drawing.createCellComment(anchor);
		RichTextString str2 = factory.createRichTextString("XSSF can set cell comments");
		// apply custom font to the text in the comment
		Font font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 14);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.RED.getIndex());
		str2.applyFont(font);

		comment2.setString(str2);
		comment2.setAuthor("Apache POI");
		comment2.setColumn(2);
		comment2.setRow(2);

		String fname = "z:/017對欄位加入註解.xlsx";
		FileOutputStream out = new FileOutputStream(fname);
		wb.write(out);
		out.close();

		wb.close();
	}

	public void $18頁首頁尾的設定() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		Sheet sheet = wb.createSheet("first-header - format sheet");
		sheet.createRow(0).createCell(0).setCellValue(123);

		// set page numbers in the footer
		Footer footer = sheet.getFooter();
		// &P == current page number
		// &N == page numbers
		footer.setRight("Page &P of &N");

		Header firstHeader = ((XSSFSheet) sheet).getFirstHeader();
		// &F == workbook file name
		firstHeader.setLeft("&F ......... first header");

		for (int i = 0; i < 100; i = i + 10) {
			sheet.createRow(i).createCell(0).setCellValue(123);
		}

		XSSFSheet sheet2 = (XSSFSheet) wb.createSheet("odd header-even footer");
		Header oddHeader = sheet2.getOddHeader();
		// &B == bold
		// &E == double underline
		// &D == date
		oddHeader.setCenter("&B &E oddHeader     &D ");

		Footer evenFooter = sheet2.getEvenFooter();
		evenFooter.setRight("even footer &P");
		sheet2.createRow(10).createCell(0).setCellValue("Second sheet with an oddHeader and an evenFooter");

		for (int i = 0; i < 200; i = i + 10) {
			sheet2.createRow(i).createCell(0).setCellValue(123);
		}

		XSSFSheet sheet3 = (XSSFSheet) wb.createSheet("odd header- odd footer");
		sheet3.createRow(10).createCell(0).setCellValue("Third sheet with oddHeader and oddFooter");
		Header oddH = sheet3.getOddHeader();
		// &C == centered
		oddH.setCenter("centered oddHeader");
		oddH.setLeft("left ");
		oddH.setRight("right ");

		Footer oddF = sheet3.getOddFooter();
		oddF.setLeft("Page &P");
		oddF.setRight("Pages &N ");

		FileOutputStream fileOut = new FileOutputStream("z:/018headerFooter.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $19繪製圖表() throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("Sheet 1");
		final int NUM_OF_ROWS = 3;
		final int NUM_OF_COLUMNS = 10;

		// Create a row and put some cells in it. Rows are 0 based.
		Row row;
		Cell cell;
		for (int rowIndex = 0; rowIndex < NUM_OF_ROWS; rowIndex++) {
			row = sheet.createRow((short) rowIndex);
			for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
				cell = row.createCell((short) colIndex);
				cell.setCellValue(colIndex * (rowIndex + 1));
			}
		}

		Drawing drawing = sheet.createDrawingPatriarch();
		ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);

		Chart chart = drawing.createChart(anchor);
		ChartLegend legend = chart.getOrCreateLegend();
		legend.setPosition(LegendPosition.TOP_RIGHT);

		ScatterChartData data = chart.getChartDataFactory().createScatterChartData();

		ValueAxis bottomAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.BOTTOM);
		ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
		leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

		ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 0,
				NUM_OF_COLUMNS - 1));
		ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 1, 0,
				NUM_OF_COLUMNS - 1));
		ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 2, 0,
				NUM_OF_COLUMNS - 1));

		data.addSerie(xs, ys1);
		data.addSerie(xs, ys2);

		chart.plot(data, bottomAxis, leftAxis);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/019繪製圖表.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $20() {
	}

	public void $21() {
	}

	public void $22() {
	}

	public void $23() {
	}

	public void $24() {
	}

	public void $25() {
	}

	public void $26() {
	}

	public void $27() {
	}

	public void $28() {
	}

	public void $29() {
	}

	public void $30() {
	}

}
