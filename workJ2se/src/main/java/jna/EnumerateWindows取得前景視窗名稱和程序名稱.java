package jna;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.PointerByReference;

public class EnumerateWindows取得前景視窗名稱和程序名稱 {
	private static final int MAX_TITLE_LENGTH = 1024;

	public static void main(String[] args) throws Exception {
		String lastTitle = "none";
		String lastProcess = "none";
		long lastChange = System.currentTimeMillis();

		while (true) {
			String currentTitle = getActiveWindowTitle();
			String currentProcess = getActiveWindowProcess();
			if (!lastTitle.equals(currentTitle)) {
				long change = System.currentTimeMillis();
				long time = (change - lastChange) / 1000;
				lastChange = change;
				System.out.println("Change! Last title: " + lastTitle + " lastProcess: " + lastProcess + " time: "
						+ time + " seconds current:"+currentTitle);
				lastTitle = currentTitle;
				lastProcess = currentProcess;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				// ignore
			}
		}
	}

	/**
	 * 取得前景active的window，並且把window標題的名稱回傳
	 * @return
	 */
	private static String getActiveWindowTitle() {
		char[] buffer = new char[MAX_TITLE_LENGTH * 2];
		HWND foregroundWindow = User32DLL.GetForegroundWindow();
		User32DLL.GetWindowTextW(foregroundWindow, buffer, MAX_TITLE_LENGTH);
		String title = Native.toString(buffer);
		return title;
	}

	/**
	 * 大概是取得process的名稱，和工作管理員上面顯示的會相同吧
	 * @return
	 */
	private static String getActiveWindowProcess() {
		char[] buffer = new char[MAX_TITLE_LENGTH * 2];
		PointerByReference pointer = new PointerByReference();
		HWND foregroundWindow = User32DLL.GetForegroundWindow();
		User32DLL.GetWindowThreadProcessId(foregroundWindow, pointer);
		Pointer process = Kernel32.OpenProcess(Kernel32.PROCESS_QUERY_INFORMATION | Kernel32.PROCESS_VM_READ, false,
				pointer.getValue());
		Psapi.GetModuleBaseNameW(process, null, buffer, MAX_TITLE_LENGTH);
		String processName = Native.toString(buffer);
		return processName;
	}

	static class Psapi {
		static {
			Native.register("psapi");
		}

		public static native int GetModuleBaseNameW(Pointer hProcess, Pointer hmodule, char[] lpBaseName, int size);
	}

	static class Kernel32 {
		static {
			Native.register("kernel32");
		}

		public static int PROCESS_QUERY_INFORMATION = 0x0400;
		public static int PROCESS_VM_READ = 0x0010;

		public static native Pointer OpenProcess(int dwDesiredAccess, boolean bInheritHandle, Pointer pointer);
	}

	static class User32DLL {
		static {
			Native.register("user32");
		}

		public static native int GetWindowThreadProcessId(HWND hWnd, PointerByReference pref);

		public static native HWND GetForegroundWindow();

		public static native int GetWindowTextW(HWND hWnd, char[] lpString, int nMaxCount);
	}
}