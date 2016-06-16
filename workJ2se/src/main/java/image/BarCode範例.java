package image;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.qrcode.QRCodeMultiReader;
import com.google.zxing.oned.Code128Reader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class BarCode範例 {
	// 參照com.google.zxing.client.j2se專案下的東西去寫出來的
	public static void main(String[] args) throws Exception {
		BarCode範例 p = new BarCode範例();
		p.$1寫出qrcode();
		p.$2讀取qrcode();
		p.$3寫出barCode();
		p.$4讀取barCode();
		System.out.println("end");
	}

	public static Map<EncodeHintType, Object> qrHintMap() {
		Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
		hintMap可以是null也能跑: {
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			// Now with zxing version 3.2.1 you could change border size (white border size to just 1)
			hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		}
		return hintMap;
	}

	public static Map<DecodeHintType, Object> qrHintMap2() {
		Map<DecodeHintType, Object> hintMap = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);
		hintMap可以是null也能跑: {
			hintMap.put(DecodeHintType.CHARACTER_SET, "UTF-8");

		}
		return hintMap;
	}

	public void $1寫出qrcode() throws Exception {
		String contents = "http://www.kimo.com.tw";
		BarcodeFormat format = BarcodeFormat.QR_CODE;
		int width = 200;
		int height = 200;
		// EncodeHintType

		BitMatrix matrix = new MultiFormatWriter().encode(contents, format, width, height, qrHintMap());
		// new QRCodeWriter().encode(contents, format, width, height)

		// imageFormat是用imageio去寫的，所以就是jpg或是bmp或是png吧
		String imageFormat = "jpg";
		MatrixToImageWriter.writeToPath(matrix, imageFormat, Paths.get("z:/001QRCode.jpg"));
		MatrixToImageWriter.writeToPath(matrix, "png", Paths.get("z:/001QRCode.png"));

	}

	public void $2讀取qrcode() throws Exception {
		BufferedImage image = ImageIO.read(new FileInputStream("z:/001QRCode.png"));
		HybridBinarizer hb = new HybridBinarizer(new BufferedImageLuminanceSource(image));
		BinaryBitmap binaryBitmap = new BinaryBitmap(hb);

		Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, qrHintMap2());
		System.out.println(qrCodeResult.getText());
		qrCodeResult = new QRCodeMultiReader().decode(binaryBitmap);
		System.out.println(qrCodeResult.getText());

	}

	public void $3寫出barCode() throws Exception {
		String contents = "AbcD123456";
		BarcodeFormat format = BarcodeFormat.CODE_128;
		int width = 300;
		int height = 100;
		// EncodeHintType

		BitMatrix matrix = new MultiFormatWriter().encode(contents, format, width, height, null);

		// imageFormat是用imageio去寫的，所以就是jpg或是bmp或是png吧
		String imageFormat = "jpg";
		MatrixToImageWriter.writeToPath(matrix, imageFormat, Paths.get("z:/003BarCode.jpg"));
		MatrixToImageWriter.writeToPath(matrix, "png", Paths.get("z:/003BarCode.png"));
	}

	public void $4讀取barCode() throws Exception {
		BufferedImage image = ImageIO.read(new FileInputStream("z:/003BarCode.png"));
		HybridBinarizer hb = new HybridBinarizer(new BufferedImageLuminanceSource(image));
		BinaryBitmap binaryBitmap = new BinaryBitmap(hb);

		Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, qrHintMap2());
		System.out.println(qrCodeResult.getText());
		qrCodeResult = new Code128Reader().decode(binaryBitmap);
		System.out.println(qrCodeResult.getText());
	}

}
