package datasource;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import util.ExportUtil;

public class 空的去產生 {

	public static void main(String[] args) throws JRException {
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ClassLoader
				.getSystemResourceAsStream("datasource/ConfigTable_A4.jasper"));

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
		ExportUtil.匯出pdf(jasperPrint, "z:/zzzxxx.pdf");

	}

}
