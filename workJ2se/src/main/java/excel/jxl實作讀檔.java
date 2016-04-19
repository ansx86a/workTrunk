package excel;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import tool.Utils;

public class jxl實作讀檔 {

	public static void main(String[] args) throws Exception {
		File f = Utils.getResourceFromRoot("excel/jxlRead.xls");
		Workbook workbook = Workbook.getWorkbook(f);
		// 獲得工作薄（Workbook）中工作表（Sheet）的個數
		int sheetsNum = workbook.getNumberOfSheets();
		System.out.println(sheetsNum);
		Sheet sheet = workbook.getSheet(0); // (只能讀取，不能寫入)
		System.out.println(sheet.getName());
		// 獲取 Sheet 表中所包含的總列數
		System.out.println(sheet.getColumns());
		// 取直列的欄值
		for (Cell cell : sheet.getColumn(0)) {
			System.out.println(cell.getContents());
		}
		// 取橫列的列值
		System.out.println("======================");
		for (Cell cell : sheet.getRow(2)) {
			System.out.println(cell.getContents());
		}
		System.out.println("======================");
		// 直接取內容值
		System.out.println(sheet.getCell(1, 1).getContents());

	}

}
