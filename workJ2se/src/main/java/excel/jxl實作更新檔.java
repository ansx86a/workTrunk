package excel;

import java.io.File;

import jxl.Cell;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import tool.Utils;

public class jxl實作更新檔 {

	public static void main(String[] args) throws Exception {
		File f = Utils.getResourceFromRoot("excel/jxlRead2.xls");
		System.out.println(f);
		Workbook workbook = Workbook.getWorkbook(f);
		WritableWorkbook writeBook = Workbook.createWorkbook(f, workbook);
		WritableSheet writeSheet = writeBook.getSheet(0);
		// 更新一個儲存格
		Cell cell = writeSheet.getCell(1, 1);
		((Label) cell).setString("我是新的字串");
		// 新增一個儲存格
		jxl.write.Number writeNumber = new jxl.write.Number(2, 0, 999); // 在C1寫入999的數字
		writeSheet.addCell(writeNumber);

		writeBook.write(); // 把之前的操作都寫入到物件內
		writeBook.close(); // 操作完成時，關閉物件，釋放佔用的記憶體空間
		workbook.close(); // 操作完成時，關閉物件，釋放佔用的記憶體空間
		System.out.println("done");
	}

}
