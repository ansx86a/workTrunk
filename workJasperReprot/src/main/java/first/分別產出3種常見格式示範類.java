package first;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

/**
 * 簡單的jasperReport樣版輸出而已，這個範例已經盡量最輕量化了<br>
 * 這個範例只是要証明jasper可以幫你做到產出html、pdf、xls三種格式而已，xml格式用不到<br>
 * 使用utf8仍然會有問題，改天再來修正這個問題<br>
 * 參照下面兩個網站使用<br>
 * http://o7planning.org/web/fe/default/en/document/46257/calling-jasper-report-from-java-application-tutorial<br>
 * http://o7planning.org/web/fe/default/en/document/18660/jasperreport-tutorial-for-beginners<br>
 * @param args
 * @throws JRException
 * @throws IOException
 */
public class 分別產出3種常見格式示範類 {

	public static void main(String[] args) throws JRException, IOException {
		// Compile jrxml file.
		{
			// JasperReport jasperReport = JasperCompileManager
			// .compileReport("C:/jasperreport/StyledTextReport/StyledTextReport.jrxml");
		}

		//
		/**
		 * 讀取原始檔並編譯，只要workspace專案用utf8會造成complie error 所以還是直接用編譯好的檔來載的好吧
		 */
		{
			// JasperReport jasperReport = JasperCompileManager
			// .compileReport(ClassLoader
			// .getSystemResourceAsStream("test/StyledTextReport.jrxml"));
		}
		/**
		 * 不要編譯，直接讀編譯完成的檔，應該可以升不少效能吧
		 */
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ClassLoader
				.getSystemResourceAsStream("first/StyledTextReport.jasper"));

		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();

		// DataSource
		// This is simple example, no database.
		// then using empty datasource.
		JRDataSource dataSource = new JREmptyDataSource();

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		// Make sure the output directory exists.
		File outDir = new File("z:/jasperoutput");
		outDir.mkdirs();

		/**
		 * 用到itext-2.1.7.js4.jar
		 */
		// Export to PDF.
		JasperExportManager.exportReportToPdfFile(jasperPrint, "z:/jasperoutput/StyledTextReport.pdf");

		/**
		 * 用到jackson-core、annotations、databind
		 */
		JasperExportManager.exportReportToHtmlFile(jasperPrint, "z:/jasperoutput/StyledTextReport.html");

		/**
		 * 用到poi-3.10.1.jar檔
		 */
		匯出excel舊的寫法: {
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "z:/jasperoutput/StyledTextReport.xls");
			exporterXLS.exportReport();
		}
		匯出excel新的寫法: {
			// 匯出excel新的寫法，好像是把config拉了出來的樣子
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("z:/jasperoutput/StyledTextReport2.xls"));
			SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
			configuration.setOnePagePerSheet(false);
			exporter.setConfiguration(configuration);
			exporter.exportReport();
		}
		匯出新格式excel的寫法: {
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("z:/jasperoutput/StyledTextReport.xlsx"));
			exporter.exportReport();
		}

		匯出csv的寫法: {// 用處會十分的怪異，jasper檔應該只有title和detail吧
			JRCsvExporter exporter = new JRCsvExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleWriterExporterOutput("z:/jasperoutput/StyledTextReport.csv"));
			exporter.exportReport();
		}
		// openOffice跳過，odt檔JROdtExporter，ods檔JROdsExporter
		// rtf跳過
		匯出word檔: {// 沒有舊的doc格式
			JRDocxExporter exporter = new JRDocxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("z:/jasperoutput/StyledTextReport.docx"));
			exporter.exportReport();
		}
		匯出powerPoint檔: {
			JRPptxExporter exporter = new JRPptxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("z:/jasperoutput/StyledTextReport.pptx"));
			exporter.exportReport();
		}

		System.out.println("done");
	}
}
