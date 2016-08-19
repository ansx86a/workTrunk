package controller2;

public class 測ThreadLocalJ2se {

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 20; i++) {
			Thread t = new Thread(() -> {
				MyThreadLocal2.save();
			});
			t.start();
			System.out.println(i);
			Thread.sleep(2000);
		}
	}

}
