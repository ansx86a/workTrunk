package image;

import image.Java2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class 捉圖 {

	public static void main(String[] args) throws Exception {
		BufferedImage b = 捉全圖();
		// 這裡是適用png、bmp、jpg
		寫檔(b, "png", "z:/aaa.png");
		寫檔(b, "bmp", "z:/aaa.bmp");

		// 下面的半透明只適用png，其它的都會有問題
		BufferedImage textPng = 取得半透明文字("什麼鬼東西");
		寫檔(textPng, "png", "z:/什麼鬼東西.png");
		寫檔(textPng, "jpg", "z:/什麼鬼東西.jpg");
	}

	public static BufferedImage 捉全圖() throws Exception {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(d.getHeight());
		System.out.println(d.getWidth());
		return 捉圖區域((int) d.getWidth(), (int) d.getHeight());

	}

	public static BufferedImage 捉圖區域(int width, int height) throws Exception {
		// 捉取0,0 ->寬,高的圖
		Robot robot = new Robot();
		BufferedImage screenImage = robot.createScreenCapture(new Rectangle(0, 0, width, height));
		return screenImage;
	}

	public static int 取色(BufferedImage screenImage, int x, int y) {
		int color = screenImage.getRGB(x, y);
		System.out.println(color);
		System.out.println(Integer.toHexString(color));
		return color;
	}

	public static void 寫檔(BufferedImage screenImage, String format, String path) throws Exception {
		// formatName 填jpg、png之類的，亂填檔案出不來
		// ImageIO.write(screenImage, "formatName", new File("e:/temptemp/xxx.png"));
		ImageIO.write(screenImage, format, new File(path));
	}

	public static BufferedImage 取得半透明文字(String text) throws IOException {
		BufferedImage bim = Java2D.建立文字透明的圖(text, 600, 300, 255, 0, 0, 50);
		return bim;
	}

}
