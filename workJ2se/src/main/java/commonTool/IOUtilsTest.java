package commonTool;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import tool.Utils;

public class IOUtilsTest {

	public static void main(String[] args) throws Exception {
		IOUtilsTest io = new IOUtilsTest();
		io.可轉型別或讀取();
		//
		FileUtils f = new FileUtils();
		io.好用的method();
		File tf = Utils.getResourceFromRoot("commonTool/kimo.txt");
		System.out.println(tf.getAbsolutePath());
		//這裡太陽春了，要設User-Agent才不會被擋403
		f.copyURLToFile(new URL("https://translate.google.com.tw/?hl=en&tab=wT#en/zh-TW/ok"), tf);
		System.out.println("okok");

	}

	/**
	 * <pre>
	 * toBufferedInputStream
	 * toBufferedReader
	 * toByteArray
	 * toByteArray(URLConnection urlConn)
	 * toString
	 * List<String> readLines，用來讀檔好用
	 * toInputStream，正常是要toOutput，toInput反到可以給電腦自已用
	 * write，這裡要自已產生一個output，再把東西寫出去
	 * writeLines 同上
	 * copy，放一個input和一個output就可以直接copy完成
	 * </pre>
	 */
	public void 可轉型別或讀取() {

	}

	/**
	 * <pre>
	 * getFile，雞助，不用new而已
	 * openInputStream(File file)
	 * listFiles(File directory,String[] extensions,boolean recursive)作掉副檔名和遞迴
	 * copyFileToDirectory(File srcFile, File destDir)
	 * copyFile(File srcFile,File destFile)
	 * copyDirectoryToDirectory
	 * copyDirectory 不知道和上面的差別在那裡
	 * copyURLToFile把url的東西寫到檔案去了
	 * copyInputStreamToFile
	 * deleteDirectory
	 * directoryContains
	 * cleanDirectory
	 * readFileToString ，這個好用
	 * readFileToByteArray 這些都和IOUtils重覆吧
	 * readLines 這些都和IOUtils重覆吧
	 * writeStringToFile，這個好用
	 * writeByteArrayToFile
	 * forceDelete 刪檔，假如是目錄就刪目錄包含子檔案
	 * isFileNewer 比對2檔案的新舊
	 * moveDirectoryToDirectory
	 * moveFileToDirectory 類似的省略
	 * </pre>
	 */
	public void 好用的method() {
	}
}
