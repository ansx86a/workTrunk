package html2pdf;

import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Pattern;

import static html2pdf.EnvConfig.PDF_HEIGHT;
import static html2pdf.EnvConfig.PDF_WIDTH;

public class PdfUtils {
    public static File htmlToPdf(File htmlFile) throws IOException {
        String inputHTML = FileUtils.readFileToString(htmlFile, "utf8");
        inputHTML = inputHTML.replaceAll(
                Pattern.quote("<span class=\"d2h-code-line-prefix\">&nbsp;</span>"), "");
        inputHTML = inputHTML.replaceAll(
                Pattern.quote("<span class=\"d2h-code-line-prefix\">+</span>"), "");
        inputHTML = inputHTML.replaceAll(
                Pattern.quote("<span class=\"d2h-code-line-prefix\">-</span>"), "");
        inputHTML = inputHTML.replaceAll(
                Pattern.quote("<span class=\"d2h-code-line-ctn\">- </span>"), "");

        Document document = Jsoup.parse(inputHTML, "UTF-8");
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);

        File pdfFile = new File(htmlFile.getPath().replaceAll("html$", "pdf"));

        try (OutputStream os = new FileOutputStream(pdfFile)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withUri(pdfFile.getPath());
            builder.toStream(os);
            builder.withW3cDocument(new W3CDom().fromJsoup(document), "/");
            builder.useDefaultPageSize(Integer.parseInt(PDF_WIDTH), Integer.parseInt(PDF_HEIGHT), BaseRendererBuilder.PageSizeUnits.MM);
            builder.useFont(new File("C:\\Windows\\Fonts\\mingliu.ttc"), "PMingLiU");
            builder.run();
        }
        return pdfFile;
    }
}
