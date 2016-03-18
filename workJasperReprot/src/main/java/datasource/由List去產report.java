package datasource;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import vo.CustomBeanFactory;

/**
 * 正常的報表都有包sql，而會傳connection進去，由sql產生出list<br>
 * 再由list去填報表，這個例子就是直接由list去填報表，省掉↑↑的方式
 * @author ai
 *
 */
public class 由List去產report {

	public static void main(String[] args) throws JRException {
		由List去產report o1 = new 由List去產report();
		o1.fill3();
		o1.fill4();

		System.out.println("done");
	}

	/**
	 * 由陣列去產生report
	 * @throws JRException
	 */
	public void fill3() throws JRException {
		long start = System.currentTimeMillis();
		Map parameters = new HashMap();
		parameters.put("ReportTitle", "Address Report");
		parameters.put("DataFile", "CustomBeanFactory.java - Bean Array");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ClassLoader
				.getSystemResourceAsStream("datasource/DataSourceReport.jasper"));
		// 直接走讀檔就不需要compile，但是source 都是寫在jar裡，還是拉出來用jaserReport好了
		{
			// JasperFillManager.fillReportToFile("build/reports/DataSourceReport.jasper", parameters,
			// new JRBeanArrayDataSource(CustomBeanFactory.getBeanArray()));
		}
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanArrayDataSource(
				CustomBeanFactory.getBeanArray()));
		JasperExportManager.exportReportToHtmlFile(jasperPrint, "z:/fill3.html");

		System.err.println("Filling time : " + (System.currentTimeMillis() - start));
	}

	/**
	 * 由集合去產出report
	 * @throws JRException
	 */
	public void fill4() throws JRException {
		long start = System.currentTimeMillis();
		// Preparing parameters
		Map parameters = new HashMap();
		parameters.put("ReportTitle", "Address Report");
		parameters.put("DataFile", "CustomBeanFactory.java - Bean Collection");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ClassLoader
				.getSystemResourceAsStream("datasource/DataSourceReport.jasper"));
		// 直接走讀檔就不需要compile，但是source 都是寫在jar裡，還是拉出來用jaserReport好了
		{
			// JasperFillManager.fillReportToFile("build/reports/DataSourceReport.jasper", parameters,
			// new JRBeanCollectionDataSource(CustomBeanFactory.getBeanCollection()));
		}
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
				new JRBeanCollectionDataSource(CustomBeanFactory.getBeanCollection()));
		JasperExportManager.exportReportToHtmlFile(jasperPrint, "z:/fill4.html");
		System.err.println("Filling time : " + (System.currentTimeMillis() - start));
	}
}
