package image;

import image.TIFFUtilities.TIFFPage;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import com.twelvemonkeys.image.ImageUtil;
import com.twelvemonkeys.imageio.plugins.tiff.TIFFImageWriterSpi;

import tool.Utils;

public class 圖片轉檔 {
	// jai
	// http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-java-client-419417.html

	public static void main(String[] args) throws IOException {
		圖片轉檔 p = new 圖片轉檔();
		p.$1最簡單的轉檔();// 有轉灰階的程式
		p.$2();// 放棄tiff和png壓縮等事項
		// TIFFUtilitiesTest有些東西可以參考
		p.$3和併tiff檔();
		p.$4拆開tiff檔();
		p.$5捉出要的那一頁另存新檔();
		p.$6低品質縮圖();
		p.$7低品質縮圖();
		p.$8平滑縮圖();
		p.$9右轉90度();
		p.$10();
		System.out.println("end");
	}

	public void $1最簡單的轉檔() throws IOException {
		File file = Utils.getResourceFromRoot("image/aaa.png");
		File file2 = Utils.getResourceFromRoot("image/bbb.png");
		File file3 = Utils.getResourceFromRoot("image/ccc.png");
		BufferedImage image = ImageIO.read(file);
		BufferedImage image2 = ImageIO.read(file2);
		BufferedImage image3 = ImageIO.read(file3);

		ImageIO.write(image, "jpg", new File("z:/001.jpg"));
		ImageIO.write(image, "png", new File("z:/001.png"));
		ImageIO.write(image, "bmp", new File("z:/001.bmp"));
		ImageIO.write(image, "tif", new File("z:/001.tif"));
		ImageIO.write(image2, "tif", new File("z:/002.tif"));
		ImageIO.write(image3, "tif", new File("z:/003.tif"));

		// 轉成黑白的圖
		BufferedImage out = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		out.getGraphics().drawImage(image, 0, 0, null);
		ImageIO.write(out, "tif", new File("z:/001_gray.tif"));

	}

	// 參考培源的程式寫出來的東西
	public void $2() throws IOException {
		// Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("tiff");
		// ImageWriter writer = it.next();

		BufferedImage bi = ImageIO.read(Utils.getResourceFromRoot("image/aaa.png"));

		TIFFImageWriterSpi tiffspi = new TIFFImageWriterSpi();
		ImageWriter writer = tiffspi.createWriterInstance();

		ImageWriteParam param = writer.getDefaultWriteParam();
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		System.out.println(Arrays.toString(param.getCompressionTypes()));
		param.setCompressionType("LZW");
		param.setCompressionQuality(0.5f);// 不管調多少，tif檔大小都不會有變化怪怪，可以試試上面幾個壓縮的模式

		ImageOutputStream ios = ImageIO.createImageOutputStream(new File("z:/002.tif"));
		writer.setOutput(ios);
		writer.write(null, new IIOImage(bi, null, null), param);
		ios.close();

	}

	public void $3和併tiff檔() throws IOException {
		List<File> inputFiles = new ArrayList<File>();
		inputFiles.add(new File("z:/001.tif"));
		inputFiles.add(new File("z:/002.tif"));
		inputFiles.add(new File("z:/003.tif"));
		TIFFUtilities.merge(inputFiles, new File("z:/001_002_003.tif"));
	}

	public void $4拆開tiff檔() throws IOException {
		File dir = new File("z:/001_002_003");
		dir.mkdirs();
		TIFFUtilities.split(new File("z:/001_002_003.tif"), dir);
	}

	// 和rotatePage相同的功能吧，把要的那一頁tiff捉出來
	public void $5捉出要的那一頁另存新檔() throws IOException {
		File file = new File("z:/001_002_003.tif");
		ImageInputStream input = null;
		ImageOutputStream imageOutput = null;
		try {
			input = ImageIO.createImageInputStream(file);
			imageOutput = ImageIO.createImageOutputStream(new File("z:/005.tif"));
			List<TIFFPage> pages = TIFFUtilities.getPages(input);
			TIFFPage page = pages.get(1);
			pages.clear();
			pages.add(page);
			TIFFUtilities.writePages(imageOutput, pages);
		} finally {
			if (input != null) {
				input.close();
			}
			if (imageOutput != null) {
				imageOutput.close();
			}
		}
	}

	public void $6低品質縮圖() {
		try {
			File fi = Utils.getResourceFromRoot("image/aaa.png"); // 大圖文件
			int nw = 100;// 指定寬度，用寬度來做縮放

			AffineTransform transform = new AffineTransform();
			BufferedImage bis = ImageIO.read(fi);
			int w = bis.getWidth();
			int h = bis.getHeight();
			double scale = (double) w / h;// 取得寬和高的比例
			int nh = (nw * h) / w;// 取得縮圖後的高，也可以寫成nw*scale;
			double sx = (double) nw / w;// 取得寬度的縮小倍率
			double sy = (double) nh / h;// 取得高度的縮小倍率
			transform.setToScale(sx, sy);// 設定倍率
			System.out.println(w + " " + h);
			System.out.println(nw + " " + nh);
			AffineTransformOp ato = new AffineTransformOp(transform, null);
			BufferedImage bid = new BufferedImage(nw, nh, BufferedImage.TYPE_3BYTE_BGR);
			ato.filter(bis, bid);// 把原圖寫到新圖去
			ImageIO.write(bid, "jpg", new File("z:/006低品質縮圖.jpg"));// 輸出新圖
			ImageIO.write(bid, "png", new File("z:/006低品質縮圖.png"));// 輸出新圖
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 因為這裡有限制寬和高，寫得不到，但縮圖依然是低品質
	public void $7低品質縮圖() throws IOException {
		File fi = Utils.getResourceFromRoot("image/aaa.png"); // 大圖文件
		BufferedImage original = ImageIO.read(fi);
		int maxWidth = 100;
		int maxHeight = 100;

		if ((maxWidth >= original.getWidth()) && (maxHeight >= original.getHeight())) {
			maxWidth = original.getWidth();
			maxHeight = original.getHeight();
		}
		BufferedImage bufOut = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());

		double xScale = new Integer(maxWidth).doubleValue() / original.getWidth();
		double yScale = new Integer(maxHeight).doubleValue() / original.getHeight();
		double scale = java.lang.Math.min(xScale, yScale);
		try {
			java.awt.geom.AffineTransform atx = new java.awt.geom.AffineTransform();
			atx.scale(scale, scale);
			AffineTransformOp atop = new AffineTransformOp(atx, AffineTransformOp.TYPE_BILINEAR);
			int newWidth = new Double(original.getWidth() * scale).intValue();
			int newHeight = new Double(original.getHeight() * scale).intValue();
			BufferedImage b = atop.filter(original,
					new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_3BYTE_BGR));
			ImageIO.write(b, "jpg", new File("z:/007低品質縮圖.jpg"));// 輸出新圖
			ImageIO.write(b, "png", new File("z:/007低品質縮圖.png"));// 輸出新圖
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void $8平滑縮圖() throws IOException {
		File fi = Utils.getResourceFromRoot("image/aaa.png"); // 大圖文件
		BufferedImage original = ImageIO.read(fi);
		int pHints = Image.SCALE_SMOOTH;
		BufferedImage bf = ImageUtil.createScaled(original, 100, 100, pHints);
		ImageIO.write(bf, "jpg", new File("z:/008平滑縮圖.jpg"));// 輸出新圖
		ImageIO.write(bf, "png", new File("z:/008平滑質縮圖.png"));// 輸出新圖
	}

	public void $9右轉90度() throws IOException {
		File fi = Utils.getResourceFromRoot("image/aaa.png"); // 大圖文件
		BufferedImage original = ImageIO.read(fi);
		int pDirection = ImageUtil.ROTATE_90_CW;
		BufferedImage bf = ImageUtil.createRotated(original, pDirection);
		/**
		 * 真是天殺的， jpg竟然會變色，來源的圖是png和jpg都一樣
		 */
		ImageIO.write(bf, "jpg", new File("z:/009右轉90度.jpg"));// 輸出新圖
		ImageIO.write(bf, "png", new File("z:/009右轉90度.png"));// 輸出新圖

		/**
		 * 套用培源和書凱的方式，如下，仍然不行
		 */
		Iterator writers = ImageIO.getImageWritersBySuffix("jpeg");
		ImageWriter writer = (ImageWriter) writers.next();
		ImageWriteParam imageWriteParam = writer.getDefaultWriteParam();
		imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);

		IIOImage iioImage = new IIOImage(bf, null, null);
		imageWriteParam.setCompressionQuality(1.0f);

		ImageOutputStream out = ImageIO.createImageOutputStream(new File("z:/009右轉90度2.jpg"));
		writer.setOutput(out);
		writer.write(null, iioImage, imageWriteParam);
		out.flush();
		out.close();

	}

	public void $10() {
	}

}
