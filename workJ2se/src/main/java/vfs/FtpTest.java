package vfs;

import java.io.File;
import java.net.URLEncoder;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.provider.ftp.FtpFileSystemConfigBuilder;

import tool.Utils;

/**
 * <pre>
 * 這個例子的重點就是不止是要上vfs的jar還要上net的jar，
 * 不然會出錯，看到maven的設定他當初沒設得很好
 * </pre>
 * @author ai
 *
 */
public class FtpTest {
	private String userStr = "sa";
	private String passStr = "sa";
	private String host = "127.0.0.1";

	// http://www.memorylack.com/2011/06/apache-commons-vfs-for-sftp.html
	// http://stackoverflow.com/questions/14932439/how-to-list-files-directory-files-using-apache-common-vfs
	// http://stackoverflow.com/questions/6046220/apache-commons-vfs-working-with-ftp
	//
	// good
	// http://programcreek.com/java-api-examples/index.php?api=org.apache.commons.vfs.FileSystemManager
	public static void main(String[] args) throws Exception {
		FtpTest f = new FtpTest();
		f.列印ftp目錄("home");
		File localFile = Utils.getResourceFromRoot("vfs/ftp2/中文.txt");
		System.out.println(localFile);
		f.下載檔案("home/中文.txt", localFile.getAbsolutePath());
		f.上傳檔案並且改名(localFile, "home/上傳新檔.txt");

	}

	public void 列印ftp目錄(String path) throws Exception {
		FileSystemOptions opts = new FileSystemOptions();
		FileSystemManager fsManager = VFS.getManager();
		FtpFileSystemConfigBuilder c = FtpFileSystemConfigBuilder.getInstance();
		c.setControlEncoding(opts, "utf-8");
		// 取目錄
		FileObject ftplFileObject = fsManager.resolveFile("ftp://" + userStr + ":" + passStr + "@" + host + "/"
				+ URLEncoder.encode(path, "utf-8"), opts);
		if (ftplFileObject.exists()) {
			System.out.println("目錄存在，這是一定要");
		} else {
			System.out.println("目錄不存在，這裡要丟出Exception");
			throw new RuntimeException("錯誤的ftp目錄");
		}
		FileObject[] children = ftplFileObject.getChildren();
		for (int i = 0; i < children.length; i++) {
			String name = children[i].getName().getBaseName();
			System.out.println(name);
		}
		ftplFileObject.close();

	}

	public void 下載檔案(String ftpPath, String localPath) throws Exception {
		FileSystemOptions opts = new FileSystemOptions();
		FileSystemManager fsManager = VFS.getManager();
		沒用到opts可註解: {
			// FtpFileSystemConfigBuilder c = FtpFileSystemConfigBuilder.getInstance();
			// c.setControlEncoding(opts, "utf-8");
			/**
			 * <pre>
			 * 以下這一行不支援中文檔名???，但可能不用import common-net套件？
			 * FileObject ftpFileObject = fsManager.resolveFile("ftp://" + userStr + ":" + passStr + "@" +host + "/"+ URLEncoder.encode(ftpPath, "utf-8"), opts);
			 * </pre>
			 */
		}

		// 支援中文檔名，因為底層用http，所以ftp的路徑要轉回urlencoding就可以上下轉ftp了
		FileObject ftpFileObject = fsManager.resolveFile("ftp://" + userStr + ":" + passStr + "@" + host + "/"
				+ URLEncoder.encode(ftpPath, "utf-8"));
		if (ftpFileObject.exists()) {
			System.out.println("ftp檔案存在，這是一定要的");
		} else {
			System.out.println("ftp檔案不存在，這裡要丟錯誤");
			throw new RuntimeException("ftp路徑錯誤");
		}

		FileObject localFileObject = fsManager.resolveFile(localPath, opts);

		if (localFileObject.exists()) {
			System.out.println("local檔案存在，或許你要避免蓋檔");
		} else {
			System.out.println("local檔案不存在，vfs會運作得得好，不需要自已建目錄");
		}
		System.out.println("開始copy檔案");
		localFileObject.copyFrom(ftpFileObject, Selectors.SELECT_FILES);
		System.out.println("結束copy檔案");
		// 結束
		ftpFileObject.close();
		localFileObject.close();
	}

	public void 上傳檔案並且改名(File localFile, String ftpPath) throws Exception {
		FileSystemOptions opts = new FileSystemOptions();
		FileSystemManager fsManager = VFS.getManager();
		沒用到opts可註解: {
			// FtpFileSystemConfigBuilder c = FtpFileSystemConfigBuilder.getInstance();
			// c.setControlEncoding(opts, "utf-8");
			/**
			 * 同下載註解，可能可以不用匯入net的jar，但是不支援中文檔名
			 */
			// FileObject ftpFileObject = fsManager.resolveFile("ftp://" + userStr + ":" + passStr + "@" + host + "/"
			// +ftpPath, opts);
		}

		FileObject localFileObject = fsManager.resolveFile(localFile.getAbsolutePath(), opts);
		if (localFileObject.exists()) {
			System.out.println("local檔案存在");
		} else {
			System.out.println("local檔案不存在，沒辦法做上傳，丟出一個exception");
			throw new RuntimeException("localFile 不存在");
		}

		// 因為底層用http，所以ftp的路徑要轉回urlencoding就可以上下轉ftp了
		FileObject ftpFileObject = fsManager.resolveFile("ftp://" + userStr + ":" + passStr + "@" + host + "/"
				+ URLEncoder.encode(ftpPath, "utf-8"));

		if (ftpFileObject.exists()) {
			System.out.println("ftp檔案存在，會蓋過去");
		} else {
			System.out.println("ftp檔案不存在");
		}

		System.out.println("開始copy檔案");
		ftpFileObject.copyFrom(localFileObject, Selectors.SELECT_FILES);
		System.out.println("結束copy檔案");

		// 把後面的3改成4
		FileObject destFile = fsManager.resolveFile("ftp://" + userStr + ":" + passStr + "@" + host + "/"
				+ URLEncoder.encode(ftpPath+"重新命名.txt", "utf-8"));
		ftpFileObject.moveTo(destFile);
		localFileObject.close();
		ftpFileObject.close();
		destFile.close();
	}

}
