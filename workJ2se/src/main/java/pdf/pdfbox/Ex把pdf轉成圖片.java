package pdf.pdfbox;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.util.filetypedetector.FileType;
import org.junit.Test;
import tool.Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Ex把pdf轉成圖片 {


    @Test
    public void 轉成圖片() throws IOException {
        File pdfFile = Utils.getResourceFromRoot("pdf/pdfbox/Ex203.pdf");
        BufferedImage image = new PDFRenderer(PDDocument.load(pdfFile)).renderImageWithDPI(0, 72);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ImageIO.write(image, FileType.PNG.name(), bs);
        FileUtils.writeByteArrayToFile(new File("z:/testpdf.png"), bs.toByteArray());
    }
}
