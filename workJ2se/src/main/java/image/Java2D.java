package image;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.FileUtils;

import tool.Utils;

public class Java2D {

	public static void main(String[] args) throws Exception {
		Java2D j2d = new Java2D();
		// $1透明度測試失敗
		// $2顏色用有透明度ok，未測試弄到圖中會怎麼樣，然後png也算ok
		j2d.$2test();
		// $3好像只是一個例子，沒什麼特別的
		j2d.$3test();

		建立文字透明的圖2();
		System.out.println("end j2d");

		// byte[] bs = j2d.建立文字透明的圖("我測試好了", 600, 400, 255, 0, 0, 50);
		// FileUtils.writeByteArrayToFile(new File("z:/newPng.png"), bs);
	}

	public static BufferedImage 建立文字透明的圖(String str, int picWidth, int picHeight, int colorr, int colorg, int colorb,
			int alpha) throws IOException {
		// 創建BufferedImage對象
		BufferedImage image = new BufferedImage(picWidth, picHeight, BufferedImage.TYPE_INT_RGB);
		// 獲取Graphics2D
		Graphics2D g2d = image.createGraphics();
		// ---------- 增加下面的代碼使得背景透明 -----------------
		image = g2d.getDeviceConfiguration().createCompatibleImage(picWidth, picHeight, Transparency.TRANSLUCENT);
		g2d.dispose();
		g2d = image.createGraphics();
		// ---------- 背景透明代碼結束 -----------------

		Font newfont = new Font("微軟正黑體", 0, 48);
		g2d.setFont(newfont);
		Color myColour = new Color(colorr, colorg, colorb, alpha);
		// 畫圖
		g2d.setColor(myColour);
		g2d.setStroke(new BasicStroke(1));
		// 這裡沒有算到很中心點，先差不多就好
		g2d.drawString(str, picWidth / 2, picHeight / 2);
		// 釋放對象
		g2d.dispose();
		// 保存文件
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ImageIO.write(image, "png", bo);
		return image;
		// return bo.toByteArray();
	}

	// 參考培源和書凱的例子
	public static void 建立文字透明的圖2() throws IOException {
		File sourceImageFile = Utils.getResourceFromRoot("image/aaa.png");
		String text = "什麼鬼啊";

		BufferedImage sourceImage = ImageIO.read(sourceImageFile);
		Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
		AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.62f);
		g2d.setComposite(alphaChannel);
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Dialog", Font.BOLD, 48));
		FontMetrics fontMetrics = g2d.getFontMetrics();
		Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);

		// calculates the coordinate where the String is painted
		int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
		int centerY = sourceImage.getHeight() / 2;

		// paints the textual watermark
		g2d.drawString(text, centerX, centerY);

		ImageIO.write(sourceImage, "png", new File("z:/waterMark001.png"));
		ImageIO.write(sourceImage, "jpg", new File("z:/waterMark001.jpg"));

		// 好像可以設定壓縮品質，這一點比較特別
		搞不懂他們為什麼要自已用writer來寫而不用imageIO: {
			// public static void writeJpegImage(BufferedImage image, File path) throws IOException {
			// Iterator writers = ImageIO.getImageWritersBySuffix("jpeg");
			// if (!writers.hasNext())
			// throw new IllegalStateException("No writers for jpeg?!");
			// ImageWriter writer = (ImageWriter) writers.next();
			// ImageWriteParam imageWriteParam = writer.getDefaultWriteParam();
			// imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			// List thumbNails = null;
			// IIOImage iioImage = new IIOImage(image, thumbNails, (IIOMetadata) null);
			// writeFile(writer, imageWriteParam, iioImage, path, 1.0f);
			// }
			//
			// private static void writeFile(ImageWriter writer, ImageWriteParam imageWriteParam,
			// IIOImage iioImage, File filename, float compressionQuality) throws IOException {
			// ImageOutputStream out = ImageIO.createImageOutputStream(filename);
			// imageWriteParam.setCompressionQuality(compressionQuality);
			// writer.setOutput(out);
			// writer.write((IIOMetadata) null, iioImage, imageWriteParam);
			// out.flush();
			// out.close();
			// }
		}
	}

	public void $1test() throws IOException {
		int width = 400;
		int height = 300;
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics();

		// ---------- 背景透明代碼結束 -----------------
		BufferedImage image = g2d.getDeviceConfiguration().createCompatibleImage(width, height,
				Transparency.TRANSLUCENT);
		g2d.dispose();
		g2d = image.createGraphics();
		// ---------- 背景透明代碼結束 -----------------

		// 畫背景
		// bufferedGraphics.setColor(Color.WHITE);
		// bufferedGraphics.fillRect(0, 0, 50, 30);

		// 畫外框
		// g2d.setColor(Color.BLACK);
		// g2d.drawRect(5, 5, 40, 20);

		String number = Integer.toString((int) (Math.random() * 10000));
		while (number.length() < 4) {
			number = "0" + number;
		}

		g2d.drawString(number, 10, 20);

		Iterator ite = ImageIO.getImageWritersByFormatName("png");
		ImageWriter imageWriter = (ImageWriter) ite.next();

		FileOutputStream outstream = new FileOutputStream(new File("z:/testjpg.png"));
		ImageOutputStream ios = ImageIO.createImageOutputStream(outstream);
		imageWriter.setOutput(ios);
		imageWriter.write(bufferedImage);
		ios.flush();
		outstream.close();
	}

	public void $2test() throws IOException {
		int width = 400;
		int height = 300;
		// 創建BufferedImage對象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 獲取Graphics2D
		Graphics2D g2d = image.createGraphics();

		// ---------- 增加下面的代碼使得背景透明 -----------------
		image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
		g2d.dispose();
		g2d = image.createGraphics();
		// ---------- 背景透明代碼結束 -----------------

		Font newfont = new Font("IDAutomationHC39M", 0, 24);
		g2d.setFont(newfont);

		// Color myColour =new Color(200, 200, 200);
		int alpha = 60; //
		Color myColour = new Color(255, 0, 0, alpha);
		// 畫圖
		g2d.setColor(myColour);
		g2d.setStroke(new BasicStroke(1));
		g2d.drawString("什麼鬼東西", 200, 150);
		// 釋放對象
		g2d.dispose();
		// 保存文件
		ImageIO.write(image, "png", new File("z:/test2.png"));

	}

	public void $3test() {

		int width = 300;
		int height = 300;
		String str = "搞什麼鬼啊";
		String path = "z:/test3.jpg";

		File file = new File(path);

		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, width, height);

		Font font = new Font("黑体", Font.BOLD, 25);
		g2.setFont(font);
		g2.setPaint(Color.RED);

		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(str, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;

		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g2.drawString(str, (int) x, (int) baseY);

		try {
			ImageIO.write(bi, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
