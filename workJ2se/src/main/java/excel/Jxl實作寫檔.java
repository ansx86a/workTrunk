package excel;

import java.io.File;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 實作調整欄寬，設定每個cell格式<br>
 * 只有string和number兩種格式的範例<br>
 * 另有產生公式的範例<br>
 * @author ai
 */
// 參考
// http://blog.xuite.net/chocopie0226/programerJava/65431645-JAVA+EXCEL+(JXL-JExcelApi)
// http://www.vogella.com/tutorials/JavaExcel/article.html#createexcel

public class Jxl實作寫檔 {
	private WritableCellFormat timesBoldUnderline;
	private WritableCellFormat times;

	public static void main(String[] args) throws Exception {
		Jxl實作寫檔 jxl = new Jxl實作寫檔();
		jxl.產出excel檔_建sheet();
		System.out.println("done");
	}

	public void 產出excel檔_建sheet() throws Exception {
		File file = new File("z:/testjxl.xls");
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));// 這行不知道

		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet("Report", 0);
		workbook.createSheet("Report2", 1);
		WritableSheet excelSheet = workbook.getSheet(0);
		WritableSheet excelSheet2 = workbook.getSheet(1);
		建標題列(excelSheet);
		createContent(excelSheet2);
		// 以下兩行，設定凍結欄位
		// setSheet_1.getSettings().setHorizontalFreeze(1);
		// setSheet_1.getSettings().setVerticalFreeze(1);

		workbook.write();
		workbook.close();
	}

	private void 建標題列(WritableSheet sheet) throws WriteException {
		// 設定一個字型
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		// 設定欄位的樣式
		times = new WritableCellFormat(times10pt);
		// 設定欄位換行
		times.setWrap(true);

		// 設定字型粗體字有底線
		WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
				UnderlineStyle.SINGLE);
		// 設定欄位的樣式
		timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
		// 設定欄位換行
		timesBoldUnderline.setWrap(true);

		// cellFormat.setBackground(Colour.LIGHT_BLUE); // 背景顏色
		// cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
		調整行寬: {
			CellView cv = new CellView();
			cv.setFormat(times);
			// cv.setAutosize(true);
			cv.setSize(5000);
			sheet.setColumnView(0, cv);
			cv = new CellView();
			cv.setFormat(timesBoldUnderline);
			cv.setAutosize(true);
			sheet.setColumnView(1, cv);
			break 調整行寬;
		}

		// Write a few headers
		addCaption(sheet, 0, 0, "標題1111111111111");
		addCaption(sheet, 1, 0, "這是第二個標題，測試能不能換行");

	}

	private void createContent(WritableSheet sheet) throws WriteException, RowsExceededException {
		// 放數字進去excel
		for (int i = 1; i < 10; i++) {
			// First column
			addNumber(sheet, 0, i, i + 10);
			// Second column
			addNumber(sheet, 1, i, i * i);
		}
		// 建立公式
		StringBuffer buf = new StringBuffer();
		buf.append("SUM(A2:A10)");
		Formula f = new Formula(0, 10, buf.toString());
		sheet.addCell(f);
		// 建立公式
		buf = new StringBuffer();
		buf.append("SUM(B2:B10)");
		f = new Formula(1, 10, buf.toString());
		sheet.addCell(f);

		// 建立純文字
		for (int i = 12; i < 20; i++) {
			// First column
			addLabel(sheet, 0, i, "Boring text " + i);
			// Second column
			addLabel(sheet, 1, i, "Another text");
		}
	}

	private void addCaption(WritableSheet sheet, int column, int row, String s) throws RowsExceededException,
			WriteException {
		Label label;
		// 這裡可以定義格式，但是我在<建標題列>方法中已經設好cellView了，格式可以由cellView在定
		// label = new Label(column, row, s, timesBoldUnderline);
		label = new Label(column, row, s);
		sheet.addCell(label);
	}

	private void addNumber(WritableSheet sheet, int column, int row, Integer integer) throws WriteException,
			RowsExceededException {
		Number number;
		number = new Number(column, row, integer, times);
		sheet.addCell(number);
	}

	private void addLabel(WritableSheet sheet, int column, int row, String s) throws WriteException,
			RowsExceededException {
		Label label;
		label = new Label(column, row, s, times);
		sheet.addCell(label);
	}
}
