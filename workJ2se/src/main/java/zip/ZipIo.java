package zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import tool.Utils;

/**
 * 應該只能壓一層，所以當初有搬檔後重新命名的程式，應該要可以優化<br>
 * 這裡難得的是單純用java來做zip沒有用3rd的元件<br>
 * 在myUtils的filesService有zip4j的例子，這裡就留存備用吧<br>
 * 新的zip 3rd有空試試 https://github.com/zeroturnaround/zt-zip
 * @author ai
 *
 */
public class ZipIo {

	public static void main(String[] args) throws Exception {
		ZipIo io = new ZipIo();
		io.壓縮();// 不會有編碼的問題耶，不錯用，內定應該就是unicode
		io.解壓縮();
	}

	public void 解壓縮() throws Exception {
		File zipFile = Utils.getResourceFromRoot("zip/myZipFile.zip");
		String outputFolder = Utils.getResourceFromRoot("zip/unZipDir").getAbsolutePath();
		byte[] buffer = new byte[1024];
		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
			File folder = new File(outputFolder);
			if (!folder.exists()) {
				folder.mkdir();
			}

			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator + fileName);
				System.out.println("file unzip : " + newFile.getAbsoluteFile());
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				ze = zis.getNextEntry();
			}
			zis.closeEntry();
			System.out.println("Done");
		} finally {
		}
	}

	public void 加入一個檔給壓縮(String 檔路徑, String 壓縮裡的路徑, ZipOutputStream zos) throws Exception {
		byte[] buffer = new byte[1024];
		String path = 檔路徑;
		String zipFilePath = 壓縮裡的路徑;
		ZipEntry ze = new ZipEntry(zipFilePath);
		zos.putNextEntry(ze);
		try (FileInputStream in = new FileInputStream(path)) {
			int len;
			while ((len = in.read(buffer)) > 0) {
				zos.write(buffer, 0, len);
			}
		}
	}

	public void 加入一個檔給壓縮(File 檔, String 壓縮裡的路徑, ZipOutputStream zos) throws Exception {
		加入一個檔給壓縮(檔.getAbsolutePath(), 壓縮裡的路徑, zos);
	}

	public void 壓縮() throws Exception {
		byte[] buffer = new byte[1024];
		File f = Utils.getResourceFromRoot("zip/myZipFile.zip");
		FileOutputStream fos = new FileOutputStream(f);
		try (ZipOutputStream zos = new ZipOutputStream(fos)) {
			zos.setLevel(0);// 設定壓縮率0-9，9是壓縮率最高
			加入一個檔給壓縮(Utils.getResourceFromRoot("zip/testZip.txt"), "什麼鬼.txt", zos);
			加入一個檔給壓縮(Utils.getResourceFromRoot("zip/testZip.txt"), "なに/什麼鬼2.txt", zos);
			zos.closeEntry();
		}
		System.out.println("Done");
	}

}
