package excel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFSlideShowImpl;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.usermodel.EscherGraphics;
import org.apache.poi.hssf.usermodel.EscherGraphics2d;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFObjectData;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShapeGroup;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.WorkbookUtil;

import tool.Utils;
import excel.example.AddDimensionedImage;
import excel.example.HSSFReadWrite;
import excel.example.InCellLists;
import excel.example.OfficeDrawing;
import excel.example.XLS2CSVmra;

/**
 * xls用
 * @author ai
 *
 */
public class PoiEx001HssfModel {

	public static void main(String args[]) throws Exception {
		// 特別：樹狀圖tree的縮放，參照example的outlines

		PoiEx001HssfModel p = new PoiEx001HssfModel();
		// 只有一個頁籤的xls檔
		p.$1空白的excel檔();// 在win開啟會有錯誤警告，應該是沒有sheet的問題
		p.$2空白的excel有2個sheet();// 沒有$1的問題
		p.$3放大2倍檢視的sheet();
		p.$4合併儲存格();
		p.$5超連結的欄位();// 樣式和純文字相同，可連結，編修會出現程式語法樣式是個困擾
		p.$6欄位格式展式();// 數字、日期(會變數字，這有問題)、字串、布林、錯誤格式
		p.$7設定內容換行的欄位();
		p.$8凍結窗格();// 行，列，行和列，分割窗格
		p.$9設定字型樣式();// 此例有字體大小、字型和刪除線
		p.$10設定Repeating測試失敗();
		p.$11欄立加上網點或是底色();
		p.$12外框border的應用();
		p.$13格式化日期欄位();
		p.$14更新欄位值();// 可寫新檔，也可蓋掉舊檔
		p.$15欄位置中左右等顯示();
		p.$16超連結網扯信箱檔案書籤();// 取代$5，本例有書籤可參考
		p.$17讀取封裝的物件_失敗();
		p.$18對欄位有對話框的註解_2種();
		p.$19圖像功能畫star();// 太進階了，不太需要研究
		p.$20使用eventApi讀檔();// 搞不太懂為什麼要用eventApi讀檔，一般一個欄位慢慢讀不行嗎？
		// 參照$14更新欄位值 cell.getBooleanCellValue()來讀值應該是可行性比較高的方法

		p.$21大量資料();// 好像只是要展示poi的功能，看起來和一般的寫法差不多

		// dump檔案，內容先不深究，反正一個參數是print，兩個是一進一出
		// 如果要dump整個檔案，幹嘛不copy就好，對不對
		HSSFReadWrite.main(new String[] { "z:/021大量資料.xls", "z:/021dump.xls" });
		// 最後一頁是貼圖
		OfficeDrawing.main(new String[] { "z:/022畫圖.xls" });
		InCellLists.main(new String[] { "z:/023List列表樣式.xls" });

		// 搞不懂寫得這麼可怕要幹嘛，應該不會參考這一個
		File f = Utils.getResourceFromRoot("excel/test.png");
		AddDimensionedImage.main(new String[] { f.getAbsolutePath(), "z:/024加入圖片物件.xls" });
		// 把excel的東西最出來，用,分開，這個例子用print，所以實用性就低了，可能要自已改寫，或是參考它的處理記錄來實作
		XLS2CSVmra.main(new String[] { "z:/006欄位格式展式.xls" });

		System.out.println("end");
	}

	public void $1空白的excel檔() throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream("z:/001空白的excel檔.xls");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $2空白的excel有2個sheet() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		wb.createSheet("new sheet");
		// create with default name
		wb.createSheet();
		final String name = "second sheet";
		// setting sheet name later
		wb.setSheetName(1, WorkbookUtil.createSafeSheetName(name));
		FileOutputStream fileOut = new FileOutputStream("z:/002空白的excel有2個sheet.xls");
		wb.write(fileOut);
		fileOut.close();
		wb.close();
	}

	public void $3放大2倍檢視的sheet() throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("new sheet");
		sheet1.setZoom(200); // XX percent magnification
		FileOutputStream fileOut = new FileOutputStream("z:/003放大2倍檢視的sheet.xls");
		wb.write(fileOut);
		fileOut.close();
		wb.close();
	}

	public void $4合併儲存格() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");
		HSSFRow row = sheet.createRow(2);// 第三列
		HSSFCell cell = row.createCell(2);// 第三行
		cell.setCellValue("This is a test of merging");
		// int firstRow, int lastRow, int firstCol, int lastCol
		// sheet.addMergedRegion(new CellRangeAddress(2, 3, 2, 3)); // 22 ->33，4格合併
		// sheet.addMergedRegion(new CellRangeAddress(2, 3, 2, 2));// 22 ->32，併2列
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 2, 3));// 22 ->23，併2行
		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/004合併儲存格.xls");
		wb.write(fileOut);
		fileOut.close();

	}

	public void $5超連結的欄位() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");
		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell(0);
		cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
		cell.setCellFormula("HYPERLINK(\"http://127.0.0.1:8080/toto/truc/index.html?test=aaa\", \"連結顯示文字\")");

		FileOutputStream fileOut = new FileOutputStream("z:/005超連結的欄位.xls");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $6欄位格式展式() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");
		HSSFRow row = sheet.createRow(2);
		row.createCell(0).setCellValue(1.1);
		row.createCell(1).setCellValue(new Date());
		row.createCell(2).setCellValue("a string");
		row.createCell(3).setCellValue(true);
		row.createCell(4).setCellType(HSSFCell.CELL_TYPE_ERROR);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/006欄位格式展式.xls");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $7設定內容換行的欄位() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet s = wb.createSheet();
		HSSFRow r = null;
		HSSFCell c = null;
		HSSFCellStyle cs = wb.createCellStyle();
		HSSFFont f2 = wb.createFont();

		cs = wb.createCellStyle();

		cs.setFont(f2);
		// Word Wrap MUST be turned on
		cs.setWrapText(true);

		r = s.createRow(2);
		r.setHeight((short) 0x349);// 設定高度
		c = r.createCell(2);
		c.setCellType(HSSFCell.CELL_TYPE_STRING);
		c.setCellValue("Use \n with word wrap on to create a new line");
		c.setCellStyle(cs);
		s.setColumnWidth(2, (int) ((50 * 8) / ((double) 1 / 20)));// 設定寬度

		FileOutputStream fileOut = new FileOutputStream("z:/007設定內容換行的欄位.xls");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $8凍結窗格() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("new sheet");
		HSSFSheet sheet2 = wb.createSheet("second sheet");
		HSSFSheet sheet3 = wb.createSheet("third sheet");
		HSSFSheet sheet4 = wb.createSheet("fourth sheet");

		// Freeze just one row
		sheet1.createFreezePane(0, 1, 0, 1);
		// Freeze just one column
		sheet2.createFreezePane(1, 0, 1, 0);
		// Freeze the columns and rows (forget about scrolling position of the lower right quadrant).
		sheet3.createFreezePane(2, 2);
		// Create a split with the lower left side being the active quadrant
		sheet4.createSplitPane(2000, 2000, 0, 0, HSSFSheet.PANE_LOWER_LEFT);

		FileOutputStream fileOut = new FileOutputStream("z:/008凍結窗格.xls");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $9設定字型樣式() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");

		// Create a row and put some cells in it. Rows are 0 based.
		HSSFRow row = sheet.createRow(1);

		// Create a new font and alter it.
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 24);
		font.setFontName("微軟正黑體");
		font.setItalic(true);
		font.setStrikeout(true);

		// Fonts are set into a style so create a new one to use.
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);

		// Create a cell and put a value in it.
		HSSFCell cell = row.createCell(1);
		cell.setCellValue("This 測試正黑體");
		cell.setCellStyle(style);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/009設定字型樣式.xls");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $10設定Repeating測試失敗() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("first sheet");
		wb.createSheet("second sheet");
		wb.createSheet("third sheet");

		HSSFFont boldFont = wb.createFont();
		boldFont.setFontHeightInPoints((short) 22);
		boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle boldStyle = wb.createCellStyle();
		boldStyle.setFont(boldFont);

		HSSFRow row = sheet1.createRow(1);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("This quick brown fox");
		cell.setCellStyle(boldStyle);

		// Set the columns to repeat from column 0 to 2 on the first sheet
		wb.setRepeatingRowsAndColumns(0, 0, 2, -1, -1);// int sheetIndex,int startColumn, int endColumn,int startRow,
														// int endRow
		// Set the rows to repeat from row 0 to 2 on the second sheet.
		wb.setRepeatingRowsAndColumns(1, -1, -1, 0, 2);
		// Set the the repeating rows and columns on the third sheet.
		wb.setRepeatingRowsAndColumns(2, 4, 5, 1, 2);

		FileOutputStream fileOut = new FileOutputStream("z:/010設定Repeating測試失敗.xls");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $11欄立加上網點或是底色() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");

		// Create a row and put some cells in it. Rows are 0 based.
		HSSFRow row = sheet.createRow(1);

		// Aqua background
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillBackgroundColor(HSSFColor.AQUA.index);
		style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue("加上網點看不到");
		cell.setCellStyle(style);

		// Orange "foreground", foreground being the fill foreground not the font color.
		style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.ORANGE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cell = row.createCell(2);
		cell.setCellValue("加上底色");
		cell.setCellStyle(style);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/011欄立加上網點或是底色.xls");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $12外框border的應用() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");

		// Create a row and put some cells in it. Rows are 0 based.
		HSSFRow row = sheet.createRow(1);

		// Create a cell and put a value in it.
		HSSFCell cell = row.createCell(1);
		cell.setCellValue(4);

		// Style the cell with borders all around.
		HSSFCellStyle style = wb.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(HSSFColor.GREEN.index);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(HSSFColor.BLUE.index);
		style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM_DASHED);
		style.setTopBorderColor(HSSFColor.ORANGE.index);
		cell.setCellStyle(style);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/012外框border的應用.xls");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $13格式化日期欄位() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");

		// Create a row and put some cells in it. Rows are 0 based.
		HSSFRow row = sheet.createRow(0);

		// Create a cell and put a date value in it. The first cell is not styled as a date.
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(new Date());

		// we style the second cell as a date (and time). It is important to create a new cell style from the workbook
		// otherwise you can end up modifying the built in style and effecting not only this cell but other cells.
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		cell = row.createCell(1);
		cell.setCellValue(new Date());
		cell.setCellStyle(cellStyle);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/013格式化日期欄位.xls");
		wb.write(fileOut);
		fileOut.close();
	}

	public void $14更新欄位值() throws IOException {
		FileInputStream fileIn = null;
		FileOutputStream fileOut = null;
		try {
			fileIn = new FileInputStream("z:/006欄位格式展式.xls");
			POIFSFileSystem fs = new POIFSFileSystem(fileIn);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row = sheet.getRow(2);
			if (row == null)
				row = sheet.createRow(2);
			HSSFCell cell = row.getCell(3);
			if (cell == null)
				cell = row.createCell(3);
			System.out.println(cell.getBooleanCellValue());
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("a test");
			// Write the output to a file
			fileOut = new FileOutputStream("z:/014更新欄位值.xls");
			wb.write(fileOut);
		} finally {
			if (fileOut != null)
				fileOut.close();
			if (fileIn != null)
				fileIn.close();
		}
	}

	public void $15欄位置中左右等顯示() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");
		HSSFRow row = sheet.createRow(2);
		createCellex15(wb, row, 0, HSSFCellStyle.ALIGN_CENTER);
		createCellex15(wb, row, 1, HSSFCellStyle.ALIGN_CENTER_SELECTION);
		createCellex15(wb, row, 2, HSSFCellStyle.ALIGN_FILL);
		createCellex15(wb, row, 3, HSSFCellStyle.ALIGN_GENERAL);
		createCellex15(wb, row, 4, HSSFCellStyle.ALIGN_JUSTIFY);
		createCellex15(wb, row, 5, HSSFCellStyle.ALIGN_LEFT);
		createCellex15(wb, row, 6, HSSFCellStyle.ALIGN_RIGHT);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("z:/015欄位置中左右等顯示.xls");
		wb.write(fileOut);
		fileOut.close();

		wb.close();
	}

	private static void createCellex15(HSSFWorkbook wb, HSSFRow row, int column, int align) {
		HSSFCell cell = row.createCell(column);
		cell.setCellValue("Align It");
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment((short) align);
		cell.setCellStyle(cellStyle);
	}

	public void $16超連結網扯信箱檔案書籤() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();

		// cell style for hyperlinks
		// by default hyperlinks are blue and underlined
		HSSFCellStyle hlink_style = wb.createCellStyle();
		HSSFFont hlink_font = wb.createFont();
		hlink_font.setUnderline(HSSFFont.U_SINGLE);
		hlink_font.setColor(HSSFColor.BLUE.index);
		hlink_style.setFont(hlink_font);

		HSSFCell cell;
		HSSFSheet sheet = wb.createSheet("Hyperlinks");

		// URL
		cell = sheet.createRow(0).createCell(0);
		cell.setCellValue("URL Link");
		HSSFHyperlink link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
		link.setAddress("http://poi.apache.org/");
		cell.setHyperlink(link);
		cell.setCellStyle(hlink_style);

		// link to a file in the current directory
		cell = sheet.createRow(1).createCell(0);
		cell.setCellValue("File Link");
		link = new HSSFHyperlink(HSSFHyperlink.LINK_FILE);
		link.setAddress("link1.xls");
		cell.setHyperlink(link);
		cell.setCellStyle(hlink_style);

		// e-mail link
		cell = sheet.createRow(2).createCell(0);
		cell.setCellValue("Email Link");
		link = new HSSFHyperlink(HSSFHyperlink.LINK_EMAIL);
		// note, if subject contains white spaces, make sure they are url-encoded
		link.setAddress("mailto:poi@apache.org?subject=Hyperlinks");
		cell.setHyperlink(link);
		cell.setCellStyle(hlink_style);

		// link to a place in this workbook

		// create a target sheet and cell
		HSSFSheet sheet2 = wb.createSheet("Target Sheet");
		sheet2.createRow(0).createCell(0).setCellValue("Target Cell");

		cell = sheet.createRow(3).createCell(0);
		cell.setCellValue("Worksheet Link");
		link = new HSSFHyperlink(HSSFHyperlink.LINK_DOCUMENT);
		link.setAddress("'Target Sheet'!A1");
		cell.setHyperlink(link);
		cell.setCellStyle(hlink_style);

		FileOutputStream out = new FileOutputStream("z:/016超連結網扯信箱檔案書籤.xls");
		wb.write(out);
		out.close();
	}

	public void $17讀取封裝的物件_失敗() throws IOException {
		int i = 1;
		if (i > 0) {
			return;
		}
		File f = new File("z:/017.xls");

		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(f));
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		for (HSSFObjectData obj : workbook.getAllEmbeddedObjects()) {
			// the OLE2 Class Name of the object
			String oleName = obj.getOLE2ClassName();
			if (oleName.equals("Worksheet")) {
				DirectoryNode dn = (DirectoryNode) obj.getDirectory();
				HSSFWorkbook embeddedWorkbook = new HSSFWorkbook(dn, fs, false);
				// System.out.println(entry.getName() + ": " + embeddedWorkbook.getNumberOfSheets());
				embeddedWorkbook.close();
			} else if (oleName.equals("Document")) {
				DirectoryNode dn = (DirectoryNode) obj.getDirectory();
				HWPFDocument embeddedWordDocument = new HWPFDocument(dn);
				// System.out.println(entry.getName() + ": " + embeddedWordDocument.getRange().text());
			} else if (oleName.equals("Presentation")) {
				DirectoryNode dn = (DirectoryNode) obj.getDirectory();
				HSLFSlideShow embeddedPowerPointDocument = new HSLFSlideShow(new HSLFSlideShowImpl(dn));
				// System.out.println(entry.getName() + ": " + embeddedPowerPointDocument.getSlides().length);
			} else {
				if (obj.hasDirectoryEntry()) {
					// The DirectoryEntry is a DocumentNode. Examine its entries to find out what it is
					DirectoryNode dn = (DirectoryNode) obj.getDirectory();
					for (Iterator<Entry> entries = dn.getEntries(); entries.hasNext();) {
						Entry entry = entries.next();
						// System.out.println(oleName + "." + entry.getName());
					}
				} else {
					// There is no DirectoryEntry
					// Recover the object's data from the HSSFObjectData instance.
					byte[] objectData = obj.getObjectData();
				}
			}
		}
		workbook.close();
	}

	public void $18對欄位有對話框的註解_2種() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Cell comments in POI HSSF");

		// Create the drawing patriarch. This is the top level container for all shapes including cell comments.
		HSSFPatriarch patr = sheet.createDrawingPatriarch();

		// create a cell in row 3
		HSSFCell cell1 = sheet.createRow(3).createCell(1);
		cell1.setCellValue(new HSSFRichTextString("Hello, World"));

		// anchor defines size and position of the comment in worksheet
		HSSFComment comment1 = patr.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));

		// set text in the comment
		comment1.setString(new HSSFRichTextString("We can set comments in POI"));

		// set comment author.
		// you can see it in the status bar when moving mouse over the commented cell
		comment1.setAuthor("Apache Software Foundation");

		// The first way to assign comment to a cell is via HSSFCell.setCellComment method
		cell1.setCellComment(comment1);

		// create another cell in row 6
		HSSFCell cell2 = sheet.createRow(6).createCell(1);
		cell2.setCellValue(36.6);

		HSSFComment comment2 = patr.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 8, (short) 6, 11));
		// modify background color of the comment
		comment2.setFillColor(204, 236, 255);

		HSSFRichTextString string = new HSSFRichTextString("Normal body temperature");

		// apply custom font to the text in the comment
		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.RED.index);
		string.applyFont(font);

		comment2.setString(string);
		comment2.setVisible(true); // by default comments are hidden. This one is always visible.

		comment2.setAuthor("Bill Gates");

		/**
		 * The second way to assign comment to a cell is to implicitly specify its row and column. Note, it is possible
		 * to set row and column of a non-existing cell. It works, the comment is visible.
		 */
		comment2.setRow(6);
		comment2.setColumn(1);

		FileOutputStream out = new FileOutputStream("z:/018對欄位有對話框的註解_2種.xls");
		wb.write(out);
		out.close();
	}

	public void $19圖像功能畫star() throws IOException {
		// Create a workbook with one sheet and size the first three somewhat
		// larger so we can fit the chemical structure diagram in.
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("my drawing");
		sheet.setColumnWidth(1, 256 * 27);
		HSSFRow row1 = sheet.createRow(0);
		row1.setHeightInPoints(10 * 15);
		HSSFRow row2 = sheet.createRow(1);
		row2.setHeightInPoints(5 * 15);
		HSSFRow row3 = sheet.createRow(2);
		row3.setHeightInPoints(10 * 15);

		// Add some cells so we can test that the anchoring works when we
		// sort them.
		row1.createCell(0).setCellValue("C");
		row2.createCell(0).setCellValue("A");
		row3.createCell(0).setCellValue("B");

		// Create the top level drawing patriarch.
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

		HSSFClientAnchor a;
		HSSFShapeGroup group;
		EscherGraphics g;
		EscherGraphics2d g2d;
		// Anchor entirely within one cell.
		a = new HSSFClientAnchor(0, 0, 1023, 255, (short) 1, 0, (short) 1, 0);
		group = patriarch.createGroup(a);
		group.setCoordinates(0, 0, 320, 276);
		float verticalPointsPerPixel = a.getAnchorHeightInPoints(sheet) / Math.abs(group.getY2() - group.getY1());
		g = new EscherGraphics(group, wb, Color.black, verticalPointsPerPixel);
		g2d = new EscherGraphics2d(g);
		drawStar(g2d);

		a = new HSSFClientAnchor(0, 0, 1023, 255, (short) 1, 1, (short) 1, 1);
		group = patriarch.createGroup(a);
		group.setCoordinates(0, 0, 640, 276);
		verticalPointsPerPixel = a.getAnchorHeightInPoints(sheet) / Math.abs(group.getY2() - group.getY1());
		// verticalPixelsPerPoint = (float)Math.abs(group.getY2() - group.getY1()) / a.getAnchorHeightInPoints(sheet);
		g = new EscherGraphics(group, wb, Color.black, verticalPointsPerPixel);
		g2d = new EscherGraphics2d(g);
		drawStar(g2d);

		FileOutputStream out = new FileOutputStream("z:/019圖像功能畫star.xls");
		wb.write(out);
		out.close();

	}

	private static void drawStar(EscherGraphics2d g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (double i = 0; i < Math.PI; i += 0.1) {
			g2d.setColor(new Color((int) (i * 5343062d)));
			int x1 = (int) (Math.cos(i) * 160.0) + 160;
			int y1 = (int) (Math.sin(i) * 138.0) + 138;
			int x2 = (int) (-Math.cos(i) * 160.0) + 160;
			int y2 = (int) (-Math.sin(i) * 138.0) + 138;
			g2d.setStroke(new BasicStroke(2));
			g2d.drawLine(x1, y1, x2, y2);
		}
		g2d.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
		g2d.drawString("EscherGraphics2d", 70, 100);
		g2d.setColor(Color.yellow);
		g2d.fillOval(160 - 20, 138 - 20, 40, 40);
		g2d.setColor(Color.black);
		g2d.fillPolygon(new int[] { -10 + 160, 0 + 160, 10 + 160, 0 + 160 }, new int[] { 0 + 138, 10 + 138, 0 + 138,
				-10 + 138 }, 4);
		g2d.drawPolygon(new int[] { -160 + 160, 0 + 160, 160 + 160, 0 + 160 }, new int[] { 0 + 138, 138 + 138, 0 + 138,
				-138 + 138 }, 4);
	}

	SSTRecord sstrec;

	public void $20使用eventApi讀檔() throws IOException {
		// create a new file input stream with the input file specified
		// at the command line
		FileInputStream fin = new FileInputStream("z:/006欄位格式展式.xls");
		// create a new org.apache.poi.poifs.filesystem.Filesystem
		POIFSFileSystem poifs = new POIFSFileSystem(fin);
		// get the Workbook (excel part) stream in a InputStream
		InputStream din = poifs.createDocumentInputStream("Workbook");
		// construct out HSSFRequest object
		HSSFRequest req = new HSSFRequest();

		HSSFListener listener = new HSSFListener() {
			@Override
			public void processRecord(Record record) {

				switch (record.getSid()) {
				// the BOFRecord can represent either the beginning of a sheet or the workbook
				case BOFRecord.sid:
					BOFRecord bof = (BOFRecord) record;
					if (bof.getType() == BOFRecord.TYPE_WORKBOOK) {
						System.out.println("Encountered workbook");
						// assigned to the class level member
					} else if (bof.getType() == BOFRecord.TYPE_WORKSHEET) {
						System.out.println("Encountered sheet reference");
					}
					break;
				case BoundSheetRecord.sid:
					BoundSheetRecord bsr = (BoundSheetRecord) record;
					System.out.println("New sheet named: " + bsr.getSheetname());
					break;
				case RowRecord.sid:
					RowRecord rowrec = (RowRecord) record;
					System.out.println("Row found, first column at " + rowrec.getFirstCol() + " last column at "
							+ rowrec.getLastCol());
					break;
				case NumberRecord.sid:
					NumberRecord numrec = (NumberRecord) record;
					System.out.println("Cell found with value " + numrec.getValue() + " at row " + numrec.getRow()
							+ " and column " + numrec.getColumn());
					break;
				// SSTRecords store a array of unique strings used in Excel.
				case SSTRecord.sid:
					sstrec = (SSTRecord) record;
					for (int k = 0; k < sstrec.getNumUniqueStrings(); k++) {
						System.out.println("String table value " + k + " = " + sstrec.getString(k));
					}
					break;
				case LabelSSTRecord.sid:
					LabelSSTRecord lrec = (LabelSSTRecord) record;
					System.out.println("String cell found with value " + sstrec.getString(lrec.getSSTIndex()));
					break;
				}
			}
		};
		// lazy listen for ALL records with the listener shown above
		req.addListenerForAllRecords(listener);
		// create our event factory
		HSSFEventFactory factory = new HSSFEventFactory();
		// process our events based on the document input stream
		factory.processEvents(req, din);
		// once all the events are processed close our file input stream
		fin.close();
		// and our document input stream (don't want to leak these!)
		din.close();
		System.out.println("done.");
	}

	public void $21大量資料() throws IOException {
		int rownum;

		// create a new file
		FileOutputStream out = new FileOutputStream("z:/021大量資料.xls");
		// create a new workbook
		HSSFWorkbook wb = new HSSFWorkbook();
		// create a new sheet
		HSSFSheet s = wb.createSheet();
		// declare a row object reference
		HSSFRow r = null;
		// declare a cell object reference
		HSSFCell c = null;
		// create 3 cell styles
		HSSFCellStyle cs = wb.createCellStyle();
		HSSFCellStyle cs2 = wb.createCellStyle();
		HSSFCellStyle cs3 = wb.createCellStyle();
		// create 2 fonts objects
		HSSFFont f = wb.createFont();
		HSSFFont f2 = wb.createFont();

		// set font 1 to 12 point type
		f.setFontHeightInPoints((short) 12);
		// make it red
		f.setColor(HSSFColor.RED.index);
		// make it bold
		// arial is the default font
		f.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);

		// set font 2 to 10 point type
		f2.setFontHeightInPoints((short) 10);
		// make it the color at palette index 0xf (white)
		f2.setColor(HSSFColor.WHITE.index);
		// make it bold
		f2.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);

		// set cell stlye
		cs.setFont(f);
		// set the cell format see HSSFDataFromat for a full list
		cs.setDataFormat(HSSFDataFormat.getBuiltinFormat("($#,##0_);[Red]($#,##0)"));

		// set a thin border
		cs2.setBorderBottom(CellStyle.BORDER_THIN);
		// fill w fg fill color
		cs2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// set foreground fill to red
		cs2.setFillForegroundColor(HSSFColor.RED.index);

		// set the font
		cs2.setFont(f2);

		// set the sheet name to HSSF Test
		wb.setSheetName(0, "HSSF Test");
		// create a sheet with 300 rows (0-299)
		for (rownum = 0; rownum < 300; rownum++) {
			// create a row
			r = s.createRow(rownum);
			// on every other row
			if ((rownum % 2) == 0) {
				// make the row height bigger (in twips - 1/20 of a point)
				r.setHeight((short) 0x249);
			}

			// r.setRowNum(( short ) rownum);
			// create 50 cells (0-49) (the += 2 becomes apparent later
			for (int cellnum = 0; cellnum < 50; cellnum += 2) {
				// create a numeric cell
				c = r.createCell(cellnum);
				// do some goofy math to demonstrate decimals
				c.setCellValue(rownum * 10000 + cellnum + (((double) rownum / 1000) + ((double) cellnum / 10000)));

				// on every other row
				if ((rownum % 2) == 0) {
					// set this cell to the first cell style we defined
					c.setCellStyle(cs);
				}

				// create a string cell (see why += 2 in the
				c = r.createCell(cellnum + 1);

				// set the cell's string value to "TEST"
				c.setCellValue("TEST");
				// make this column a bit wider
				s.setColumnWidth(cellnum + 1, (int) ((50 * 8) / ((double) 1 / 20)));

				// on every other row
				if ((rownum % 2) == 0) {
					// set this to the white on red cell style
					// we defined above
					c.setCellStyle(cs2);
				}

			}
		}

		// draw a thick black border on the row at the bottom using BLANKS
		// advance 2 rows
		rownum++;
		rownum++;

		r = s.createRow(rownum);

		// define the third style to be the default
		// except with a thick black border at the bottom
		cs3.setBorderBottom(CellStyle.BORDER_THICK);

		// create 50 cells
		for (int cellnum = 0; cellnum < 50; cellnum++) {
			// create a blank type cell (no value)
			c = r.createCell(cellnum);
			// set it to the thick black border style
			c.setCellStyle(cs3);
		}

		// end draw thick black border

		// demonstrate adding/naming and deleting a sheet
		// create a sheet, set its title then delete it
		wb.createSheet();
		wb.setSheetName(1, "DeletedSheet");
		wb.removeSheetAt(1);
		// end deleted sheet

		// write the workbook to the output stream
		// close our file (don't blow out our file handles
		wb.write(out);
		out.close();
		wb.close();
	}

}
