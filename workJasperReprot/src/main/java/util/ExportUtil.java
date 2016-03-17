package util;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import com.lowagie.text.pdf.PdfWriter;

public class ExportUtil {

	public static void 匯出pdf(JasperPrint jasperPrint, String filePathAndName) throws JRException {
		JasperExportManager.exportReportToPdfFile(jasperPrint, filePathAndName);
	}

	public static void 匯出加密pdf(JasperPrint jasperPrint, String filePathAndName, String userPwd, String ownerPwd)
			throws JRException {
		// 需要額外使用bcprov-jdk16-1.46.jar
		// <dependency>
		// <groupId>org.bouncycastle</groupId>
		// <artifactId>bcprov-jdk16</artifactId>
		// <version>1.46</version>
		// </dependency>
		// 使用舊版

		// <dependency>
		// <groupId>bouncycastle</groupId>
		// <artifactId>bcprov-jdk15</artifactId>
		// <version>124</version>
		// </dependency>
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePathAndName));
		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
		configuration.setEncrypted(true);
		configuration.set128BitKey(true);
		configuration.setUserPassword(userPwd);
		configuration.setOwnerPassword(ownerPwd);
		// 這裡大概是設定user的權限，owner應該是全開不用設？，有實用到再測試
		configuration.setPermissions(PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING);
		exporter.setConfiguration(configuration);
		exporter.exportReport();
	}

	public static void 匯出html(JasperPrint jasperPrint, String filePathAndName) throws JRException {
		JasperExportManager.exportReportToHtmlFile(jasperPrint, filePathAndName);
	}

	public static void 匯出xls(JasperPrint jasperPrint, String filePathAndName) throws JRException {
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePathAndName));
		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
		configuration.setOnePagePerSheet(false);
		exporter.setConfiguration(configuration);
		exporter.exportReport();
	}

	public static void 匯出xlsx(JasperPrint jasperPrint, String filePathAndName) throws JRException {
		JRXlsxExporter exporter = new JRXlsxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePathAndName));
		exporter.exportReport();
	}

	public static void 匯出加密xlsx(JasperPrint jasperPrint, String filePathAndName,String pwd) throws JRException {
		JRXlsxExporter exporter = new JRXlsxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePathAndName));
		SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
		config.setPassword(pwd);
		exporter.exportReport();
	}
	
	public static void 匯出csv(JasperPrint jasperPrint, String filePathAndName) throws JRException {
		JRCsvExporter exporter = new JRCsvExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleWriterExporterOutput(filePathAndName));
		exporter.exportReport();
	}

	public static void 匯出docx(JasperPrint jasperPrint, String filePathAndName) throws JRException {
		JRDocxExporter exporter = new JRDocxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePathAndName));
		exporter.exportReport();
	}

	public static void 匯出pptx(JasperPrint jasperPrint, String filePathAndName) throws JRException {
		JRPptxExporter exporter = new JRPptxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePathAndName));
		exporter.exportReport();
	}
}
