package thread;
/**
 * 每個thread裡都有一table在放key:threadLocal和value:threadLocalValue
 * 所以每個thread結束後，資源應該會被釋放沒錯
 * 一個thread裡可以有多組threadLocal記參數
 * 所以只要new 一個static的threadLocal就很夠用了
 * 我想到的用途是在mvc的c中把request記下來，那之後在service和dao就可以記log了
 * 也可以在dao記sql，然後在controller或是service再寫出log
 * 
 * @author ai
 *
 */
public class Thread資源共用範例 implements Runnable {

	private static int mycount = 0;

	public static ThreadLocal t = new ThreadLocal();

	public static void main(String[] args) throws Exception {
		t.set("ffff");
		System.out.println(t.get());
		//每個ThreadLocal都是thread的key，所以下行是null
		//表示thread支援多個threadLocal，good
		System.out.println(new ThreadLocal().get());
		for (int i = 0; i < 3; i++) {
			new Thread(new Thread資源共用範例()).start();
		}
	}
	@Override
	public void run() {
		try {
			long threadId = Thread.currentThread().getId();
			t.set("" + threadId * threadId + " -- " + threadId);
			for (int i = 0; i < 10; i++) {
				System.out.println(t.get());
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
