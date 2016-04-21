package 執行;

/**
 * 給runtimeExe裡的java TestThread測試用的
 * @author ai
 *
 */
public class TestThread {

	public static void main(String[] args) throws Exception {
		long threadId = Thread.currentThread().getId();
		for (int i = 0; i < 10; i++) {
			System.out.println("" + threadId + " -----  " + i);
			Thread.sleep(1000);
		}
		if (args.length > 0 && args[0].equals("error")) {
			throw new RuntimeException("故意錯的");
		}
		if (args.length > 0) {
			System.exit(Integer.parseInt(args[0]));
		}
		System.exit(0);
	}

}