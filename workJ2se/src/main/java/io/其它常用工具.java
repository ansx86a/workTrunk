package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class 其它常用工具 {

	public static void main(String[] args) throws IOException {
		其它常用工具 tool = new 其它常用工具();

		// nio的東西，non-block io，目前還沒測通
		// $1使用Files();

		// 直接建立上一層的目錄和刪除目錄+子目錄
		tool.$2使用FileUtils建立目錄和刪目錄();
	}

	public void $1使用Files() throws IOException {
		File f = new File("z:/第一層/第二層/file.abc");
		Path path = f.toPath();

		// 設定檔案的權限，owner group other三個分類
		Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxrwxrwx");
		FileAttribute<Set<PosixFilePermission>> fileAttr = PosixFilePermissions.asFileAttribute(perms);
		Files.createDirectories(path, fileAttr);
		// Files.createDirectories(path, null);
	}

	public void $2使用FileUtils建立目錄和刪目錄() throws IOException {
		File f = new File("z:/第一層/第二層/file.abc");
		FileUtils.forceMkdirParent(f);
		f.createNewFile();
		File dir = new File("z:/第一層");
		FileUtils.forceDelete(dir);// 會幫你delete整個目錄，不用自已寫遞迴

	}

}
