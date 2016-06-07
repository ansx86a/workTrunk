package jna;

import static com.tulskiy.keymaster.windows.User32.PM_REMOVE;
import static com.tulskiy.keymaster.windows.User32.PeekMessage;
import static com.tulskiy.keymaster.windows.User32.RegisterHotKey;
import static com.tulskiy.keymaster.windows.User32.UnregisterHotKey;
import static com.tulskiy.keymaster.windows.User32.WM_HOTKEY;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.KeyStroke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jna.IntegerType;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.win32.W32APIOptions;
import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.MediaKey;
import com.tulskiy.keymaster.common.Provider;
import com.tulskiy.keymaster.windows.KeyMap;
import com.tulskiy.keymaster.windows.User32.MSG;

/**
 * 這算是一個很好用的keyhook，可以直接攔截鍵盤不會輸出，並執行java<br>
 * 只要一行指令，可參照下面main，這邊的例子是硬寫成子類別是為了展示之記筆本的送字功能
 * @author ai
 *
 */
public class TulskiyKeyHookTest {

	public static void main(String[] args) {
		// final Provider provider = Provider.getCurrentProvider(false);
		WindowsProvider2 w = new WindowsProvider2();
		final Provider provider = w;
		w.init();

		System.out.println("gogogo");
		// 把control+alt+F用來停止程式
		provider.register(KeyStroke.getKeyStroke("control alt F"), new HotKeyListener() {
			public void onHotKey(HotKey hotKey) {
				System.out.println(hotKey);
				provider.reset();
				provider.stop();
			}
		});

		//
		HotKeyListener listener = new HotKeyListener() {
			public void onHotKey(HotKey hotKey) {
				System.out.println(hotKey);
			}
		};
		provider.register(KeyStroke.getKeyStroke("control shift 1"), listener);
		provider.register(KeyStroke.getKeyStroke("9"), listener);
		provider.register(KeyStroke.getKeyStroke("control shift released 1"), listener);

	}

	// 我修改過的WindowsProvider2，主要是可以取得純文字檔(前景)，然後送字或是貼字進去
	public static class WindowsProvider2 extends Provider {
		private static final Logger LOGGER = LoggerFactory.getLogger(WindowsProvider2.class);
		private static volatile int idSeq = 0;

		private boolean listen;
		private Boolean reset = false;
		private final Object lock = new Object();
		private Thread thread;

		private Map<Integer, HotKey> hotKeys = new HashMap<Integer, HotKey>();
		private Queue<HotKey> registerQueue = new LinkedList<HotKey>();

		public void init() {
			Runnable runnable = new Runnable() {
				public void run() {
					LOGGER.info("Starting Windows global hotkey provider");
					MSG msg = new MSG();
					listen = true;
					while (listen) {
						while (PeekMessage(msg, null, 0, 0, PM_REMOVE)) {
							if (msg.message == WM_HOTKEY) {
								int id = msg.wParam.intValue();
								HotKey hotKey = hotKeys.get(id);

								if (hotKey != null) {
									System.out.println("befor go");
									HWND foregroundWindow = User32.GetForegroundWindow();

									// HWND editer2 = User32.FindWindowEx(foregroundWindow, null, "Edit", null);
									HWND editer = User32.FindWindowEx(foregroundWindow, null, null, null);

									System.out.println("fw=" + foregroundWindow.getPointer());
									System.out.println("editer=" + editer.getPointer());
									// System.out.println("editer2=" + editer2.getPointer());

									byte[] txt;
									try {
										txt = "吃屎吧111222".getBytes("ms950");
										// User32.SendMessageA(editer, 0x000C, txt.length, txt);//WM_SETTEXT
										User32.SendMessageA(editer, 0x0302, txt.length, txt);// WM_PASTE
										// 以上2例都可以執行，一個是設定字，一個是copy 貼上
										// https://dotblogs.com.tw/optimist9266/2011/06/06/27194

									} catch (UnsupportedEncodingException e) {
										e.printStackTrace();
									}

									fireEvent(hotKey);
								}
							}
						}

						synchronized (lock) {
							if (reset) {
								LOGGER.info("Reset hotkeys");
								for (Integer id : hotKeys.keySet()) {
									UnregisterHotKey(null, id);
								}

								hotKeys.clear();
								reset = false;
								lock.notify();
							}

							while (!registerQueue.isEmpty()) {
								register(registerQueue.poll());
							}
							try {
								lock.wait(300);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					LOGGER.info("Exit listening thread");
				}
			};

			thread = new Thread(runnable);
			thread.start();
		}

		private void register(HotKey hotKey) {
			int id = idSeq++;
			int code = KeyMap.getCode(hotKey);
			if (RegisterHotKey(null, id, KeyMap.getModifiers(hotKey.keyStroke), code)) {
				LOGGER.info("Registering hotkey: " + hotKey);
				hotKeys.put(id, hotKey);
			} else {
				LOGGER.warn("Could not register hotkey: " + hotKey);
			}
		}

		public void register(KeyStroke keyCode, HotKeyListener listener) {
			synchronized (lock) {
				registerQueue.add(new HotKey(keyCode, listener));
			}
		}

		public void register(MediaKey mediaKey, HotKeyListener listener) {
			synchronized (lock) {
				registerQueue.add(new HotKey(mediaKey, listener));
			}
		}

		public void reset() {
			synchronized (lock) {
				reset = true;
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void stop() {
			listen = false;
			if (thread != null) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			super.stop();
		}
	}

	public static class User32 {
		static {
			Native.register(NativeLibrary.getInstance("user32", W32APIOptions.DEFAULT_OPTIONS));
		}

		public static final int MOD_ALT = 0x0001;
		public static final int MOD_CONTROL = 0x0002;
		public static final int MOD_NOREPEAT = 0x4000;
		public static final int MOD_SHIFT = 0x0004;
		public static final int MOD_WIN = 0x0008;
		public static final int WM_HOTKEY = 0x0312;
		public static final int VK_MEDIA_NEXT_TRACK = 0xB0;
		public static final int VK_MEDIA_PREV_TRACK = 0xB1;
		public static final int VK_MEDIA_STOP = 0xB2;
		public static final int VK_MEDIA_PLAY_PAUSE = 0xB3;
		public static final int PM_REMOVE = 0x0001;

		public static native boolean RegisterHotKey(Pointer hWnd, int id, int fsModifiers, int vk);

		public static native boolean UnregisterHotKey(Pointer hWnd, int id);

		public static native boolean PeekMessage(MSG lpMsg, Pointer hWnd, int wMsgFilterMin, int wMsgFilterMax,
				int wRemoveMsg);

		// 第一個參數不管，第2個填12，不知道為什麼，第3個填0，第4個填字
		public static native LRESULT SendMessageA(HWND hWnd, int Msg, int wParam, byte[] lParam);

		// public static native boolean SendMessage(HWND hWnd, UINT Msg,WPARAM wParam, LPARAM lParam );

		public static native HWND GetForegroundWindow();

		public static native HWND GetActiveWindow();

		// public static native HWND FindWindow(String winClass, String title);

		public static native boolean ShowWindow(HWND hWnd, int nCmdShow);

		public static native boolean SetForegroundWindow(HWND hWnd);

		public static native HWND FindWindowEx(HWND hwndParent, HWND childAfter, String className, String windowName);

		public static native HWND FindWindowA(String className, String windowName);

		@SuppressWarnings({ "UnusedDeclaration" })
		public static class MSG extends Structure {
			public Pointer hWnd;
			public int message;
			public Parameter wParam;
			public Parameter lParam;
			public int time;
			public int x;
			public int y;

			@Override
			protected List getFieldOrder() {
				return Arrays.asList("hWnd", "message", "wParam", "lParam", "time", "x", "y");
			}
		}

		public static class Parameter extends IntegerType {
			@SuppressWarnings("UnusedDeclaration")
			public Parameter() {
				this(0);
			}

			public Parameter(long value) {
				super(Pointer.SIZE, value);
			}
		}
	}
}
