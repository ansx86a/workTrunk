package jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.platform.WindowUtils;
import com.sun.jna.platform.win32.User32;

//http://www.codeweblog.com/java%E8%B0%83%E7%94%A8%E5%8A%A8%E6%80%81%E5%BA%93-jna-jnaerator/
//http://tech-sketch.jp/2013/07/javawindowsdll.html
//C#:https://dotblogs.com.tw/nobel12/2009/10/05/10915
public class Test1 {

	public interface User32Dll extends Library {
		User32Dll INSTANCE = (User32Dll) Native.loadLibrary("user32.dll", User32Dll.class); // DLLをロード

		// int MessageBoxA(int hWnd, String lpText, String lpCaption, int uType); // WindowsAPIをマッピング
		int MessageBoxA(int hWnd, byte[] lpText, String lpCaption, int uType); // WindowsAPIをマッピング

		// int MessageBoxW(int hWnd, String lpText, String lpCaption, int uType); // WindowsAPIをマッピング
		int MessageBoxW(int hWnd, byte[] lpText, String lpCaption, int uType); // WindowsAPIをマッピング

		boolean BlockInput(boolean fBlockIt);
	}

	public interface CLibrary extends Library {
		CLibrary INSTANCE = (CLibrary) Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);

		void printf(String format, Object... args);
	}

	public static void main(String[] args) throws Exception {
		String s = "Hello JNA!中文";
		byte[] bs = s.getBytes("ms950");
		byte[] bu = s.getBytes("utf-16");// 弄不出來它的真實編碼長得怎麼樣子

		User32Dll.INSTANCE.MessageBoxA(0, bs, "jna sample", 0x00000000); // WindowsAPIを呼び出し
		User32Dll.INSTANCE.MessageBoxW(0, bu, "jna sample", 0x00000000); // WindowsAPIを呼び出し
		CLibrary.INSTANCE.printf("Argument %d: %s\n", 1, "aaa");
		CLibrary.INSTANCE.printf("Argument %d: %s\n", 2, "中文");

		
		final User32 lib = User32.INSTANCE;
		

	}
}
