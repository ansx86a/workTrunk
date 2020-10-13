package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.hslf.usermodel.HSLFSlideShowImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.PrintOrientation;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.ScatterChartData;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XSLFSlideShow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRowImpl;

import tool.Utils;
import excel.example.BigGridDemo;
import excel.example.XLSX2CSV;

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
		p.$11欄位數字的格式化();//客戶要求數字要有千分位時就可以用到
		// p.$12();//設定Workbook Properties ，不懂差在那，檔案可以跑出來確看不出來那裡有變
		p.$13TreeView視景();
		p.$14richtext欄位();
		p.$15加入圖片物件();
		p.$16展示各種欄位_公式日期連結等();
		p.$17對欄位加入註解();
		// p.$18頁首頁尾的設定();//顯示要切到別種的才看得到，而且不一定看得到，感覺可能實用性有待確認
		// *******************************************************
		p.$19繪製圖表();// 很棒的功能，有空一定要加強一下才行
		p.$26線性圖表();// 感覺和$19差不多是一樣的東西
		// *******************************************************
		// p.$20設定重覆顯示的資料();//程式碼好像逾時且無效，反正看起來沒屁用可跳過吧
		p.$21超連結網扯檔案信箱書籤();
		// ***************************************
		p.$22表格物件可統計加總();// 類似圖表，對於統計可能有不錯的功能性
		// ***************************************
		// p.$23提取內嵌物件();//暫物用不到，跳過
		p.$24字型樣式的設定();
		p.$25表格pivottable();// 老實說看不懂在幹嘛

		p.$27欄位靠左中右置上中下();
		p.$28產出日曆();
		// 撰寫大量資料的測試
		BigGridDemo.main(new String[] { "z:/029template.xlsx", "z:/029big-grid.xlsx" });
		p.$29();
		XLSX2CSV.main(new String[]{"z:/000.xlsx"});
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

	public void $20設定重覆顯示的資料() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();

		/**
		 * It's possible to set up repeating rows and columns in your printouts by using the
		 * setRepeatingRowsAndColumns() function in the Workbook object.
		 *
		 * This function Contains 5 parameters: The first parameter is the index to the sheet (0 = first sheet). The
		 * second and third parameters specify the range for the columns to repreat. To stop the columns from repeating
		 * pass in -1 as the start and end column. The fourth and fifth parameters specify the range for the rows to
		 * repeat. To stop the columns from repeating pass in -1 as the start and end rows.
		 */
		Sheet sheet1 = wb.createSheet("new sheet");
		Sheet sheet2 = wb.createSheet("second sheet");

		// Set the columns to repeat from column 0 to 2 on the first sheet
		Row row1 = sheet1.createRow(0);
		row1.createCell(0).setCellValue(1);
		row1.createCell(1).setCellValue(2);
		row1.createCell(2).setCellValue(3);
		Row row2 = sheet1.createRow(1);
		row2.createCell(1).setCellValue(4);
		row2.createCell(2).setCellValue(5);

		Row row3 = sheet2.createRow(1);
		row3.createCell(0).setCellValue(2.1);
		row3.createCell(4).setCellValue(2.2);
		row3.createCell(5).setCellValue(2.3);
		Row row4 = sheet2.createRow(2);
		row4.createCell(4).setCellValue(2.4);
		row4.createCell(5).setCellValue(2.5);

		// Set the columns to repeat from column 0 to 2 on the first sheet
		wb.setRepeatingRowsAndColumns(0, 0, 2, -1, -1);
		// Set the the repeating rows and columns on the second sheet.
		wb.setRepeatingRowsAndColumns(1, 4, 5, 1, 2);

		// set the print area for the first sheet
		wb.setPrintArea(0, 1, 2, 0, 3);

		FileOutputStream fileOut = new FileOutputStream("z:/020設定重覆顯示的資料.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $21超連結網扯檔案信箱書籤() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();

		// cell style for hyperlinks
		// by default hyperlinks are blue and underlined
		CellStyle hlink_style = wb.createCellStyle();
		Font hlink_font = wb.createFont();
		hlink_font.setUnderline(Font.U_SINGLE);
		hlink_font.setColor(IndexedColors.BLUE.getIndex());
		hlink_style.setFont(hlink_font);

		Cell cell;
		Sheet sheet = wb.createSheet("Hyperlinks");
		// URL
		cell = sheet.createRow(0).createCell((short) 0);
		cell.setCellValue("URL Link");

		Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_URL);
		link.setAddress("http://poi.apache.org/");
		cell.setHyperlink(link);
		cell.setCellStyle(hlink_style);

		// link to a file in the current directory
		cell = sheet.createRow(1).createCell((short) 0);
		cell.setCellValue("File Link");
		link = createHelper.createHyperlink(Hyperlink.LINK_FILE);
		link.setAddress("link1.xls");
		cell.setHyperlink(link);
		cell.setCellStyle(hlink_style);

		// e-mail link
		cell = sheet.createRow(2).createCell((short) 0);
		cell.setCellValue("Email Link");
		link = createHelper.createHyperlink(Hyperlink.LINK_EMAIL);
		// note, if subject contains white spaces, make sure they are url-encoded
		link.setAddress("mailto:poi@apache.org?subject=Hyperlinks");
		cell.setHyperlink(link);
		cell.setCellStyle(hlink_style);

		// link to a place in this workbook

		// create a target sheet and cell
		Sheet sheet2 = wb.createSheet("Target Sheet");
		sheet2.createRow(0).createCell((short) 0).setCellValue("Target Cell");

		cell = sheet.createRow(3).createCell((short) 0);
		cell.setCellValue("Worksheet Link");
		Hyperlink link2 = createHelper.createHyperlink(Hyperlink.LINK_DOCUMENT);
		link2.setAddress("'Target Sheet'!A1");
		cell.setHyperlink(link2);
		cell.setCellStyle(hlink_style);

		FileOutputStream out = new FileOutputStream("z:/021超連結網扯檔案信箱書籤.xlsx");
		wb.write(out);
		out.close();
	}

	public void $22表格物件可統計加總() throws IOException {
		Workbook wb = new XSSFWorkbook();
		XSSFSheet sheet = (XSSFSheet) wb.createSheet();

		// Create
		XSSFTable table = sheet.createTable();
		table.setDisplayName("Test");
		CTTable cttable = table.getCTTable();

		// Style configurations
		CTTableStyleInfo style = cttable.addNewTableStyleInfo();
		style.setName("TableStyleMedium2");
		style.setShowColumnStripes(false);
		style.setShowRowStripes(true);

		// Set which area the table should be placed in
		AreaReference reference = new AreaReference(new CellReference(0, 0), new CellReference(2, 2));
		cttable.setRef(reference.formatAsString());
		cttable.setId(1);
		cttable.setName("Test");
		cttable.setTotalsRowCount(1);

		CTTableColumns columns = cttable.addNewTableColumns();
		columns.setCount(3);
		CTTableColumn column;
		XSSFRow row;
		XSSFCell cell;
		for (int i = 0; i < 3; i++) {
			// Create column
			column = columns.addNewTableColumn();
			column.setName("Column");
			column.setId(i + 1);
			// Create row
			row = sheet.createRow(i);
			for (int j = 0; j < 3; j++) {
				// Create cell
				cell = row.createCell(j);
				if (i == 0) {
					cell.setCellValue("Column" + j);
				} else {
					cell.setCellValue("0");
				}
			}
		}

		FileOutputStream fileOut = new FileOutputStream("z:/022表格物件可統計加總.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $23提取內嵌物件(String args[]) throws Exception {
		OPCPackage pkg = OPCPackage.open(args[0]);
		XSSFWorkbook workbook = new XSSFWorkbook(pkg);
		for (PackagePart pPart : workbook.getAllEmbedds()) {
			String contentType = pPart.getContentType();
			// Excel Workbook - either binary or OpenXML
			if (contentType.equals("application/vnd.ms-excel")) {
				HSSFWorkbook embeddedWorkbook = new HSSFWorkbook(pPart.getInputStream());
			}
			// Excel Workbook - OpenXML file format
			else if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
				XSSFWorkbook embeddedWorkbook = new XSSFWorkbook(pPart.getInputStream());
			}
			// Word Document - binary (OLE2CDF) file format
			else if (contentType.equals("application/msword")) {
				HWPFDocument document = new HWPFDocument(pPart.getInputStream());
			}
			// Word Document - OpenXML file format
			else if (contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
				XWPFDocument document = new XWPFDocument(pPart.getInputStream());
			}
			// PowerPoint Document - binary file format
			else if (contentType.equals("application/vnd.ms-powerpoint")) {
				HSLFSlideShowImpl slideShow = new HSLFSlideShowImpl(pPart.getInputStream());
			}
			// PowerPoint Document - OpenXML file format
			else if (contentType.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
				OPCPackage docPackage = OPCPackage.open(pPart.getInputStream());
				XSLFSlideShow slideShow = new XSLFSlideShow(docPackage);
			}
			// Any other type of embedded object.
			else {
				System.out.println("Unknown Embedded Document: " + contentType);
				InputStream inputStream = pPart.getInputStream();
			}
		}
		pkg.close();
	}

	public void $24字型樣式的設定() throws IOException {
		Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Fonts");

		Font font0 = wb.createFont();
		font0.setColor(IndexedColors.BROWN.getIndex());
		CellStyle style0 = wb.createCellStyle();
		style0.setFont(font0);

		Font font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 14);
		font1.setFontName("Courier New");
		font1.setColor(IndexedColors.RED.getIndex());
		CellStyle style1 = wb.createCellStyle();
		style1.setFont(font1);

		Font font2 = wb.createFont();
		font2.setFontHeightInPoints((short) 16);
		font2.setFontName("Arial");
		font2.setColor(IndexedColors.GREEN.getIndex());
		CellStyle style2 = wb.createCellStyle();
		style2.setFont(font2);

		Font font3 = wb.createFont();
		font3.setFontHeightInPoints((short) 18);
		font3.setFontName("Times New Roman");
		font3.setColor(IndexedColors.LAVENDER.getIndex());
		CellStyle style3 = wb.createCellStyle();
		style3.setFont(font3);

		Font font4 = wb.createFont();
		font4.setFontHeightInPoints((short) 18);
		font4.setFontName("Wingdings");
		font4.setColor(IndexedColors.GOLD.getIndex());
		CellStyle style4 = wb.createCellStyle();
		style4.setFont(font4);

		Font font5 = wb.createFont();
		font5.setFontName("Symbol");
		CellStyle style5 = wb.createCellStyle();
		style5.setFont(font5);

		Cell cell0 = sheet.createRow(0).createCell(1);
		cell0.setCellValue("Default");
		cell0.setCellStyle(style0);

		Cell cell1 = sheet.createRow(1).createCell(1);
		cell1.setCellValue("Courier");
		cell1.setCellStyle(style1);

		Cell cell2 = sheet.createRow(2).createCell(1);
		cell2.setCellValue("Arial");
		cell2.setCellStyle(style2);

		Cell cell3 = sheet.createRow(3).createCell(1);
		cell3.setCellValue("Times New Roman");
		cell3.setCellStyle(style3);

		Cell cell4 = sheet.createRow(4).createCell(1);
		cell4.setCellValue("Wingdings");
		cell4.setCellStyle(style4);

		Cell cell5 = sheet.createRow(5).createCell(1);
		cell5.setCellValue("Symbol");
		cell5.setCellStyle(style5);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/024字型樣式的設定.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $25表格pivottable() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();

		// Create some data to build the pivot table on
		setCellData(sheet);

		XSSFPivotTable pivotTable = sheet.createPivotTable(new AreaReference("A1:D4"), new CellReference("H5"));
		// Configure the pivot table
		// Use first column as row label
		pivotTable.addRowLabel(0);
		// Sum up the second column
		pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1);
		// Set the third column as filter
		pivotTable.addColumnLabel(DataConsolidateFunction.AVERAGE, 2);
		// Add filter on forth column
		pivotTable.addReportFilter(3);

		FileOutputStream fileOut = new FileOutputStream("z:/025表格pivottable.xlsx");
		wb.write(fileOut);
		fileOut.close();
		wb.close();
	}

	public static void setCellData(XSSFSheet sheet) {
		Row row1 = sheet.createRow(0);
		// Create a cell and put a value in it.
		Cell cell11 = row1.createCell(0);
		cell11.setCellValue("Names");
		Cell cell12 = row1.createCell(1);
		cell12.setCellValue("#");
		Cell cell13 = row1.createCell(2);
		cell13.setCellValue("%");
		Cell cell14 = row1.createCell(3);
		cell14.setCellValue("Human");

		Row row2 = sheet.createRow(1);
		Cell cell21 = row2.createCell(0);
		cell21.setCellValue("Jane");
		Cell cell22 = row2.createCell(1);
		cell22.setCellValue(10);
		Cell cell23 = row2.createCell(2);
		cell23.setCellValue(100);
		Cell cell24 = row2.createCell(3);
		cell24.setCellValue("Yes");

		Row row3 = sheet.createRow(2);
		Cell cell31 = row3.createCell(0);
		cell31.setCellValue("Tarzan");
		Cell cell32 = row3.createCell(1);
		cell32.setCellValue(5);
		Cell cell33 = row3.createCell(2);
		cell33.setCellValue(90);
		Cell cell34 = row3.createCell(3);
		cell34.setCellValue("Yes");

		Row row4 = sheet.createRow(3);
		Cell cell41 = row4.createCell(0);
		cell41.setCellValue("Terk");
		Cell cell42 = row4.createCell(1);
		cell42.setCellValue(10);
		Cell cell43 = row4.createCell(2);
		cell43.setCellValue(90);
		Cell cell44 = row4.createCell(3);
		cell44.setCellValue("No");
	}

	public void $26線性圖表() throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("linechart");
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

		LineChartData data = chart.getChartDataFactory().createLineChartData();

		// Use a category axis for the bottom axis.
		ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
		ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
		leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

		ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 0,
				NUM_OF_COLUMNS - 1));
		ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 1, 0,
				NUM_OF_COLUMNS - 1));
		ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 2, 0,
				NUM_OF_COLUMNS - 1));

		data.addSeries(xs, ys1);
		data.addSeries(xs, ys2);

		chart.plot(data, bottomAxis, leftAxis);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/026線性圖表.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $27欄位靠左中右置上中下() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();

		XSSFSheet sheet = wb.createSheet();
		XSSFRow row = sheet.createRow((short) 2);
		row.setHeightInPoints(30);
		for (int i = 0; i < 8; i++) {
			// column width is set in units of 1/256th of a character width
			sheet.setColumnWidth(i, 256 * 15);
		}

		createCell(wb, row, (short) 0, XSSFCellStyle.ALIGN_CENTER, XSSFCellStyle.VERTICAL_BOTTOM);
		createCell(wb, row, (short) 1, XSSFCellStyle.ALIGN_CENTER_SELECTION, XSSFCellStyle.VERTICAL_BOTTOM);
		createCell(wb, row, (short) 2, XSSFCellStyle.ALIGN_FILL, XSSFCellStyle.VERTICAL_CENTER);
		createCell(wb, row, (short) 3, XSSFCellStyle.ALIGN_GENERAL, XSSFCellStyle.VERTICAL_CENTER);
		createCell(wb, row, (short) 4, XSSFCellStyle.ALIGN_JUSTIFY, XSSFCellStyle.VERTICAL_JUSTIFY);
		createCell(wb, row, (short) 5, XSSFCellStyle.ALIGN_LEFT, XSSFCellStyle.VERTICAL_TOP);
		createCell(wb, row, (short) 6, XSSFCellStyle.ALIGN_RIGHT, XSSFCellStyle.VERTICAL_TOP);

		// center text over B4, C4, D4
		row = sheet.createRow((short) 3);
		centerAcrossSelection(wb, row, (short) 1, (short) 3, XSSFCellStyle.VERTICAL_CENTER);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/027欄位靠左中右置上中下.xlsx");
		wb.write(fileOut);
		fileOut.close();

		wb.close();
	}

	private static void createCell(XSSFWorkbook wb, XSSFRow row, short column, short halign, short valign) {
		XSSFCell cell = row.createCell(column);
		cell.setCellValue(new XSSFRichTextString("Align It"));
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(halign);
		cellStyle.setVerticalAlignment(valign);
		cell.setCellStyle(cellStyle);
	}

	private static void centerAcrossSelection(XSSFWorkbook wb, XSSFRow row, short start_column, short end_column,
			short valign) {

		// Create cell style with ALIGN_CENTER_SELECTION
		XSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER_SELECTION);
		cellStyle.setVerticalAlignment(valign);

		// Create cells over the selected area
		for (int i = start_column; i <= end_column; i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellStyle(cellStyle);
		}

		// Set value to the first cell
		XSSFCell cell = row.getCell(start_column);
		cell.setCellValue(new XSSFRichTextString("Align It"));

		// Make the selection
		CTRowImpl ctRow = (CTRowImpl) row.getCTRow();

		// Add object with format start_coll:end_coll. For example 1:3 will span from
		// cell 1 to cell 3, where the column index starts with 0
		//
		// You can add multiple spans for one row
		Object span = start_column + ":" + end_column;

		List<Object> spanList = new ArrayList<Object>();
		spanList.add(span);

		// add spns to the row
		ctRow.setSpans(spanList);
	}

	private static final String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	private static final String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	public void $28產出日曆() throws IOException {
		Calendar calendar = Calendar.getInstance();

		// if (args.length > 0)
		// calendar.set(Calendar.YEAR, Integer.parseInt(args[0]));

		int year = calendar.get(Calendar.YEAR);

		XSSFWorkbook wb = new XSSFWorkbook();
		Map<String, XSSFCellStyle> styles = createStyles(wb);

		for (int month = 0; month < 12; month++) {
			calendar.set(Calendar.MONTH, month);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			// create a sheet for each month
			XSSFSheet sheet = wb.createSheet(months[month]);

			// turn off gridlines
			sheet.setDisplayGridlines(false);
			sheet.setPrintGridlines(false);
			XSSFPrintSetup printSetup = sheet.getPrintSetup();
			printSetup.setOrientation(PrintOrientation.LANDSCAPE);
			sheet.setFitToPage(true);
			sheet.setHorizontallyCenter(true);

			// the header row: centered text in 48pt font
			XSSFRow headerRow = sheet.createRow(0);
			headerRow.setHeightInPoints(80);
			XSSFCell titleCell = headerRow.createCell(0);
			titleCell.setCellValue(months[month] + " " + year);
			titleCell.setCellStyle(styles.get("title"));
			sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$N$1"));

			// header with month titles
			XSSFRow monthRow = sheet.createRow(1);
			for (int i = 0; i < days.length; i++) {
				// for compatibility with HSSF we have to set column width in units of 1/256th of a character width
				sheet.setColumnWidth(i * 2, 5 * 256); // the column is 5 characters wide
				sheet.setColumnWidth(i * 2 + 1, 13 * 256); // the column is 13 characters wide
				sheet.addMergedRegion(new CellRangeAddress(1, 1, i * 2, i * 2 + 1));
				XSSFCell monthCell = monthRow.createCell(i * 2);
				monthCell.setCellValue(days[i]);
				monthCell.setCellStyle(styles.get("month"));
			}

			int cnt = 1, day = 1;
			int rownum = 2;
			for (int j = 0; j < 6; j++) {
				XSSFRow row = sheet.createRow(rownum++);
				row.setHeightInPoints(100);
				for (int i = 0; i < days.length; i++) {
					XSSFCell dayCell_1 = row.createCell(i * 2);
					XSSFCell dayCell_2 = row.createCell(i * 2 + 1);

					int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
					if (cnt >= day_of_week && calendar.get(Calendar.MONTH) == month) {
						dayCell_1.setCellValue(day);
						calendar.set(Calendar.DAY_OF_MONTH, ++day);

						if (i == 0 || i == days.length - 1) {
							dayCell_1.setCellStyle(styles.get("weekend_left"));
							dayCell_2.setCellStyle(styles.get("weekend_right"));
						} else {
							dayCell_1.setCellStyle(styles.get("workday_left"));
							dayCell_2.setCellStyle(styles.get("workday_right"));
						}
					} else {
						dayCell_1.setCellStyle(styles.get("grey_left"));
						dayCell_2.setCellStyle(styles.get("grey_right"));
					}
					cnt++;
				}
				if (calendar.get(Calendar.MONTH) > month)
					break;
			}
		}

		// Write the output to a file
		FileOutputStream out = new FileOutputStream("z:/028產出日曆-" + year + ".xlsx");
		wb.write(out);
		out.close();
	}

	private static Map<String, XSSFCellStyle> createStyles(XSSFWorkbook wb) {
		Map<String, XSSFCellStyle> styles = new HashMap<String, XSSFCellStyle>();

		XSSFCellStyle style;
		XSSFFont titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 48);
		titleFont.setColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFont(titleFont);
		styles.put("title", style);

		XSSFFont monthFont = wb.createFont();
		monthFont.setFontHeightInPoints((short) 12);
		monthFont.setColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
		monthFont.setBold(true);
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(monthFont);
		styles.put("month", style);

		XSSFFont dayFont = wb.createFont();
		dayFont.setFontHeightInPoints((short) 14);
		dayFont.setBold(true);
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.TOP);
		style.setFillForegroundColor(new XSSFColor(new java.awt.Color(228, 232, 243)));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		style.setFont(dayFont);
		styles.put("weekend_left", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.TOP);
		style.setFillForegroundColor(new XSSFColor(new java.awt.Color(228, 232, 243)));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		styles.put("weekend_right", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.TOP);
		style.setBorderLeft(BorderStyle.THIN);
		style.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setLeftBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		style.setFont(dayFont);
		styles.put("workday_left", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.TOP);
		style.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		styles.put("workday_right", style);

		style = wb.createCellStyle();
		style.setBorderLeft(BorderStyle.THIN);
		style.setFillForegroundColor(new XSSFColor(new java.awt.Color(234, 234, 234)));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		styles.put("grey_left", style);

		style = wb.createCellStyle();
		style.setFillForegroundColor(new XSSFColor(new java.awt.Color(234, 234, 234)));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(new XSSFColor(new java.awt.Color(39, 51, 89)));
		styles.put("grey_right", style);

		return styles;
	}

	public void $29() {
	}

	public void $30() throws IOException {
	
	}

}
