package 新功能.非同步執行;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.common.base.Stopwatch;

/**
 * <pre>
 * https://www.baeldung.com/java-completablefuture
 * </pre>
 * 
 * @author ai
 *
 */

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING) // 依照method的名字來執行junit
public class CompletableFutureTest {

	@Test
	public void test01_submit和CompletableFuture的基本() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		Future<String> future = test01_getCompletableFuture(); // 取得一個未來會執行完成的結果
		Thread.sleep(200);// 執行一堆有的沒的要200毫秒
		System.out.println(timer);
		String result = future.get();// 測試還要等多久才能拿到結果
		System.out.println(timer);
		System.out.println(result);
		System.out.println("========test01_submit和CompletableFuture的基本結束======================================");
	}

	private CompletableFuture<String> test01_getCompletableFuture() {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		Executors.newCachedThreadPool().submit(() -> {// 用別的thread來執行程式
			Thread.sleep(500);// 要執行一堆有的沒的要500毫秒
			completableFuture.complete("Hello completableFuture完成");
			return null;// 這裡不知道是要幹嘛的
		});
		return completableFuture;
	}

	@Test
	public void test02_使用lembda簡化CompletableFuture() throws InterruptedException, ExecutionException {
		// 和test01完全相同的功能
		Stopwatch timer = Stopwatch.createStarted();
		Future<String> future = CompletableFuture.supplyAsync(() -> waitMethod(500, "Hello completableFuture完成")); // 取得一個未來會執行完成的結果
		Thread.sleep(200);// 執行一堆有的沒的要200毫秒
		System.out.println(timer);
		String result = future.get();// 測試還要等多久才能拿到結果
		System.out.println(timer);
		System.out.println(result);
		System.out.println("========test02_使用lembda簡化CompletableFuture======================================");

	}

	@Test
	public void test03_當Future有相依時如何串接Future() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello"));
		CompletableFuture<String> completableFuture2 = completableFuture.thenApply(s -> s + waitMethod(200, "_World"));
		// thenApply也有非同步的用法thenApplyAsync，只知道兩個的差異在那
		// 因為下面的測試就一開始非同步執行就非同步串到結束的感覺
		Thread.sleep(200);
		System.out.println(timer);
		System.out.println(completableFuture.get());// 這裡因為已執行完成，就直接回傳
		System.out.println(timer);
		System.out.println(completableFuture2.get());// 這裡只要再等100ms就可以執行完成
		System.out.println(timer);
		System.out.println("========test03_當Future有相依時如何串接Future======================================");
	}

	@Test
	public void test04_當Future完成後有自動執行的能力() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello"));
		CompletableFuture<Void> completableFuture2 = completableFuture.thenAccept(s -> {
			System.out.println(s + "_自動完成中_" + timer);
			s += waitMethod(100, "_World");
			System.out.println(s + "_自動完成了_" + timer);
		});
		completableFuture.thenRun(() -> System.out.println("同thenAccept，只是沒source可用，不用lambda可用Runnable傳進來" + timer));
		System.out.println(timer);
		completableFuture2.get();
		System.out.println(timer);
		System.out.println("========test04_當Future完成後有自動執行的能力======================================");
	}
	
	@Test
	public void test05_當Future未完成時Main結束就馬上結束() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello"));
		completableFuture.thenRun(() -> System.out.println("test05自動執行結束"));
		Thread.sleep(200);//註解這行就不會出來test05自動執行結束
		System.out.println("========test05_當Future未完成時Main結束就馬上結束======================================");
	}

	private <T> T waitMethod(int waitMs, T result) {
		try {
			System.out.println("strat sleep " + waitMs);
			Thread.sleep(waitMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
