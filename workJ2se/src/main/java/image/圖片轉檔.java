package image;

import image.TIFFUtilities.TIFFPage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

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
		p.$6();
		p.$7();
		p.$8();
		p.$9();
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

	public void $2() throws IOException {
		Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("tiff");
		ImageWriter writer = it.next();
		// 拿到了tiff的plugin的writter了

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

	public void $6() {
	}

	public void $7() {
	}

	public void $8() {
	}

	public void $9() {
	}

	public void $10() {
	}

}
