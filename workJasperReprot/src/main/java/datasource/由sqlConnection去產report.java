package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import util.ExportUtil;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class 由sqlConnection去產report {

	public static void main(String[] args) throws Exception {
		connectionFill();
	}

	public static void connectionFill() throws Exception {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ANZ_WORKFLOW;user=sa;password=sa";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(connectionUrl);

		long start = System.currentTimeMillis();
		Map parameters = new HashMap();
		parameters.put("p1", "this is my p1");
		parameters.put("p2", "this is my p2");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ClassLoader
				.getSystemResourceAsStream("datasource/ConfigTable_A4.jasper"));

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
		ExportUtil.匯出pdf(jasperPrint, "z:/configTable.pdf");
		ExportUtil.匯出加密pdf(jasperPrint, "z:/configTable2.pdf", "123", "456");
		ExportUtil.匯出html(jasperPrint, "z:/configTable.html");
		//excel好像在jasper中不支援檔案加密，欄位加密又很難的樣子就算了
		ExportUtil.匯出xls(jasperPrint, "z:/configTable.xls");
		ExportUtil.匯出xlsx(jasperPrint, "z:/configTable.xlsx");

		ExportUtil.匯出csv(jasperPrint, "z:/configTable.csv");
		ExportUtil.匯出docx(jasperPrint, "z:/configTable.docx");
		ExportUtil.匯出pptx(jasperPrint, "z:/configTable.pptx");
		System.err.println("Filling time : " + (System.currentTimeMillis() - start));
	}

}
