package datasource;

import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import util.ExportUtil;

public class 由sqlConnection去產report {

	public static void main(String[] args) throws Exception {
		// connectionFill();

		connectionGroupFill();
	}

	/**
	 * 一般的connection塞報表資料
	 * @throws Exception
	 */
	public static void connectionFill() throws Exception {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ANZ_WORKFLOW;user=sa;password=sa";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(connectionUrl);

		long start = System.currentTimeMillis();
		Map parameters = new HashMap();
		// 動態讀圖片檔，包在jar檔裡面
		String p1 = new File(ClassLoader.getSystemResource("9999.png").toURI()).getAbsolutePath();
		parameters.put("p1", p1);
		// 動態讀圖片檔，用awtImage，jasper強的地方是可以傳Object進去，真神
		// 以後barcode就可以在java實作後傳進去就好了
		Image p2 = ImageIO.read(new File(p1));
		// p2=p1;
		parameters.put("p2", p2);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ClassLoader
				.getSystemResourceAsStream("datasource/ConfigTable_A4.jasper"));

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
		ExportUtil.匯出pdf(jasperPrint, "z:/configTable.pdf");
		ExportUtil.匯出加密pdf(jasperPrint, "z:/configTable2.pdf", "123", "456");
		ExportUtil.匯出html(jasperPrint, "z:/configTable.html");
		// excel好像在jasper中不支援檔案加密，欄位加密又很難的樣子就算了
		// 加上excle背景圖是無效的
		ExportUtil.匯出xls(jasperPrint, "z:/configTable.xls");
		ExportUtil.匯出xlsx(jasperPrint, "z:/configTable.xlsx");

		ExportUtil.匯出csv(jasperPrint, "z:/configTable.csv");
		ExportUtil.匯出docx(jasperPrint, "z:/configTable.docx");
		ExportUtil.匯出pptx(jasperPrint, "z:/configTable.pptx");
		System.err.println("Filling time : " + (System.currentTimeMillis() - start));
	}

	/**
	 * 測試group和使用相同connection的產報表
	 * @throws Exception
	 */
	public static void connectionGroupFill() throws Exception {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ANZ_WORKFLOW;user=sa;password=sa";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(connectionUrl);

		long start = System.currentTimeMillis();
		Map parameters = new HashMap();
		// 動態讀圖片檔，包在jar檔裡面
		String sub = new File(ClassLoader.getSystemResource("datasource/sub_report.jasper").toURI()).getAbsolutePath();
		/**
		 * 這裡是用sub報表和主報表一樣的connection，而sub報表的路徑由參數傳進去<br>
		 * 而sub報表的connection也可以由參數傳進去，而一般塞資料javaBean可能就不太實用<br>
		 */
		parameters.put("sub", sub);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ClassLoader
				.getSystemResourceAsStream("datasource/ConfigTable_A4_group.jasper"));

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
		ExportUtil.匯出pdf(jasperPrint, "z:/configTable.pdf");
		ExportUtil.匯出加密pdf(jasperPrint, "z:/configTable2.pdf", "123", "456");
		ExportUtil.匯出html(jasperPrint, "z:/configTable.html");
		// excel好像在jasper中不支援檔案加密，欄位加密又很難的樣子就算了
		// 加上excle背景圖是無效的
		ExportUtil.匯出xls(jasperPrint, "z:/configTable.xls");
		ExportUtil.匯出xlsx(jasperPrint, "z:/configTable.xlsx");

		ExportUtil.匯出csv(jasperPrint, "z:/configTable.csv");
		ExportUtil.匯出docx(jasperPrint, "z:/configTable.docx");
		ExportUtil.匯出pptx(jasperPrint, "z:/configTable.pptx");
		System.err.println("Filling time : " + (System.currentTimeMillis() - start));
	}

}
