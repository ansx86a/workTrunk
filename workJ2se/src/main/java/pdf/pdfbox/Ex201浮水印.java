package pdf.pdfbox;

import image.Java2D;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.graphics.image.CCITTFactory;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import tool.Utils;

public class Ex201浮水印 {

	public static void main(String args[]) throws IOException {
		// 可參照下列
		// http://www.cnphp6.com/archives/58379

		// 以下沒有參考上面的，下面我先自已做一次
		Ex101pdModel e = new Ex101pdModel();
		e.$5pdfBox內建字型();// z:/005內建字型.pdf
		Ex201浮水印 e2 = new Ex201浮水印();
		e2.$1文字浮水印();
		System.out.println("okok");
	}

	public void $1文字浮水印() throws IOException {
		// 先建好文字圖的浮水印，這邊的調整仍然有問題，先不care建檔位置小問題
		// 重點是真的有把文字轉圖印到pdf上面去又是有透明度的，而且不是文字不能被選，這就是我想要的
		// 再進階一點就是加上旋轉了
		BufferedImage bim = Java2D.建立文字透明的圖("我測試好了", 600, 300, 255, 0, 0, 50);
		PDDocument doc = null;
		try {
			doc = PDDocument.load(new File("z:/005內建字型.pdf"));
			PDPage page = doc.getPage(0);
			// png,gif,bmp
			PDImageXObject pdImage = LosslessFactory.createFromImage(doc, bim);
			// jpg
			// PDImageXObject imageXObject = JPEGFactory.createFromStream(doc, fis);
			// tif
			// CCITTFactory.createFromFile(doc, file);

			PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, true);
			float scale = 1f;
			contentStream.drawImage(pdImage, -200, 400, pdImage.getWidth() * scale, pdImage.getHeight() * scale);
			contentStream.close();
			doc.save("z:/001_2加入文字轉圖片浮水印.pdf");
		} finally {
			if (doc != null) {
				doc.close();
			}
		}

	}
}
