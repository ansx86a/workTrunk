package thread;

public class ThreadLocal記憶體問題 {
	public static ThreadLocal<Object> tlObject = new ThreadLocal<Object>();

	// 在vm參數中加上-verbosegc可以看gc的過程
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0;; i++) {
			// don't subclass Thread.
			new Thread() {
				// this is somewhat pointless as you are defining a ThreadLocal per thread.

				public void run() {
					tlObject.set(new byte[8 * 1024 * 1024]);
	
				}
			}.start();
			Thread.sleep(1);
			if (i % 1000 == 0) {
				System.gc();
				System.out.println(i);
			}
		}

	}

}
