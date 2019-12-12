package 新功能.非同步執行;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.common.base.Stopwatch;

import tool.Utils;

/**
 * <pre>
 * https://www.baeldung.com/java-completablefuture
 * https://colobu.com/2018/03/12/20-Examples-of-Using-Java%E2%80%99s-CompletableFuture/
 * https://github.com/wangchenshu/CompletableFuture-share
 * 
 * 下面這個是功能強化的樣子，有空再看看吧
 * https://github.com/spotify/completable-futures
 * </pre>
 *
 * @author ai
 */

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING) // 依照method的名字來執行junit
public class CompletableFutureTest {

	@Test
	public void test01_CompleableFuture基本沒意義的同步例子() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		Future<String> future = CompletableFuture.completedFuture(waitMethod(500, "Hello completableFuture完成"));
		System.out.println(timer);
		System.out.println(future.isDone());
		String result = future.get();// 測試還要等多久才能拿到結果
		System.out.println(timer);
		System.out.println(result);
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test01_submit和CompletableFuture的基本() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		Future<String> future = test01_getCompletableFuture(); // 取得一個未來會執行完成的結果
		Thread.sleep(200);// 執行一堆有的沒的要200毫秒
		System.out.println(timer);
		String result = future.get();// 測試還要等多久才能拿到結果
		System.out.println(timer);
		System.out.println(result);
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	private CompletableFuture<String> test01_getCompletableFuture() {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		Executors.newCachedThreadPool().submit(() -> {// 用別的thread來執行程式
			completableFuture.complete(waitMethod(500, "Hello completableFuture完成"));
			return null;// submit會回傳future，要不回傳就submit把改成用execute
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
		System.out.println(result);//和runAsync的差別是有回傳值
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test02_使用lembda簡化CompletableFuture無回傳值() throws InterruptedException, ExecutionException {
		// thenAccept也是無回傳值
		Stopwatch timer = Stopwatch.createStarted();
		Future<Void> future = CompletableFuture.runAsync(() -> waitMethod(500, "Hello completableFuture完成")); // 取得一個未來會執行完成的結果
		Thread.sleep(200);// 執行一堆有的沒的要200毫秒
		System.out.println(timer);
		System.out.println(future.isDone());
		System.out.println(future.get());//和supplyAsync的差別是沒有回傳值
		System.out.println(timer);
		System.out.println(future.isDone());
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test03_當Future有相依時如何串接Future() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello"));
		CompletableFuture<String> completableFuture2 = completableFuture.thenApply(s -> s + waitMethod(200, "_World"));
		// thenApply可以看成call back
		// thenApply也有非同步的用法thenApplyAsync，不知道差在那，好像是指前後會不會在同一個thread跑？
		// 因為下面的測試就一開始非同步執行就非同步串到結束的感覺
		Thread.sleep(200);
		System.out.println(timer);
		System.out.println(completableFuture.get());// 這裡因為已執行完成，就直接回傳
		System.out.println(timer);
		System.out.println(completableFuture2.get());// 這裡只要再等100ms就可以執行完成
		System.out.println(timer);
		System.out.println(completableFuture2.get());// 第二次執行get就是直接取值了
		System.out.println(timer);
		System.out.println("========" + Utils.getMethodName() + "======================================");
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
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test05_當Future未完成時Main結束就馬上結束() throws InterruptedException {
		//可見預設是背景的執行緒吧，所以main結束就沒了
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello"));
		completableFuture.thenRun(() -> System.out.println("test05自動執行結束"));
		Thread.sleep(200);// 註解這行就不會出來test05自動執行結束
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test06_結合多個completable的處理有回傳值() throws InterruptedException, ExecutionException {
		// 同時執行 a和b，並把a b 串接回傳
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello"))
				.thenCombine(CompletableFuture.supplyAsync(() -> waitMethod(100, " My World")), (s1, s2) -> s1 + s2);
		System.out.println(timer);// 這裡花了一點時間處理結合的動作，大概多花10ms吧
		System.out.println(completableFuture.get());// 2個並發執行，大約花100ms多一點點的時間
		System.out.println(timer);
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test06_結合多個completable的處理無回傳值() throws InterruptedException, ExecutionException {
		// 同時執行 a和b，並把a b 串接回傳
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello"))
				.thenAcceptBoth(CompletableFuture.supplyAsync(() -> waitMethod(100, " My World")), (s1, s2) -> {
					System.out.println("除處前" + timer);
					System.out.println(s1 + s2);
					System.out.println("除處後" + timer);
				});
		System.out.println(timer);// 這裡花了一點時間處理結合的動作，大概多花10ms吧
		completableFuture.get();// 2個並發執行，大約花100ms多一點點的時間
		System.out.println(timer);
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test07_thenCompose() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello"));
		CompletableFuture<String> completableFuture2 = completableFuture.thenCompose(this::computeAnother);
		System.out.println(timer);// 10 ms
		// 由時間來看是和apply一樣，是串接的感覺，我只分得出傳入參數不同，thenApply是一個處理result的lambda
		// 而Compose感覺是去發起另一個CompletableFuture，文件說是像map和flatMap但我不太能理解
		System.out.println(completableFuture2.get());
		System.out.println(timer);// 230 ms
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	CompletableFuture<String> computeAnother(String s) {
		return CompletableFuture.supplyAsync(() -> waitMethod(100, s + "___冏"));
	}

	@Test
	// 當一次有多個執行結束後，才能執行後面的step時，就適合這麼用
	// 應該有機會沒有順序性吧
	public void test07_並行執行結構化() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello future1"));
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> waitMethod(200, "Hello future2"));
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> waitMethod(300, "Hello future3"));
		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
		System.out.println(timer);//
		combinedFuture.get();
		System.out.println(future1.isDone());
		System.out.println(future2.isDone());
		System.out.println(future3.isDone());
		System.out.println(timer);// 230 ms
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	// 使用lambda，用join，應該是和thread中的join一樣的設計吧，反等就是會等到都跑完吧
	// 這種寫法不太清楚，先不要亂用
	public void test07_並行執行結構化使用lambda() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello future1"));
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> waitMethod(200, "Hello future2"));
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> waitMethod(300, "Hello future3"));
		System.out.println(timer);
		// 這邊的join應該是和thread中的join一樣吧，反正把3個都join下去，thread應該就會等到他跑完，應該就有結構了吧？
		String combined = Stream.of(future1, future2, future3).map(CompletableFuture::join)
				.collect(Collectors.joining(" "));
		System.out.println(combined);
		System.out.println(future1.isDone());
		System.out.println(future2.isDone());
		System.out.println(future3.isDone());
		System.out.println(timer);
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test07_並行執行結構化等待執行完成() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		// thenApplyAsync好像比thenApply慢一點，是在不一樣thread的關系嗎？是不是ThreadLoacl的應用要注意呢？
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello "))
				.thenApplyAsync(s -> s + waitMethod(200, "_World"));
		System.out.println(timer);
		System.out.println(future1.isDone());
		Thread.sleep(80);
		System.out.println(timer);
		System.out.println(future1.isDone());
		System.out.println(future1.join());
		System.out.println(timer);
		System.out.println(future1.isDone());
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test08_例外處理() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		String name = null;
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			if (name == null) {
				throw new RuntimeException("Computation error!");
			}
			return "Hello, " + name;
		}).handle((s, t) -> t != null ? t.toString() : "Hello, Stranger!");
		System.out.println(timer);
		System.out.println(completableFuture.isCompletedExceptionally());// false
		System.out.println(completableFuture.isDone());
		System.out.println(timer);
		System.out.println(completableFuture.get());
		System.out.println(completableFuture.isCompletedExceptionally());// false
		System.out.println(completableFuture.isDone());
		System.out.println(timer);
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test08_例外處理失敗() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		String name = null;
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			waitMethod(100, null);
			if (name == null) {
				throw new RuntimeException("Computation error!");
			}
			return "Hello, " + name;
		});
		System.out.println(timer);

		System.out.println(completableFuture.isCompletedExceptionally());// false
		System.out.println(completableFuture.isDone());// false
		Thread.sleep(500);
		System.out.println(completableFuture.isCompletedExceptionally());// true
		System.out.println(completableFuture.isDone());// true
		System.out.println(timer);
		System.out.println(completableFuture.get());// 這行有java.util.concurrent.ExecutionException:
		// java.lang.RuntimeException: Computation error!
		System.out.println(timer);// 這行以下會因為上面的例外失敗
		System.out.println("========" + Utils.getMethodName() + "======================================");
	}

	@Test
	public void test08_強制例外失敗() {
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(500, "成功"))
				.handle((s, t) -> "手動失敗這裡就被無視了");
		System.out.println(timer);
		try {
			System.out.println(completableFuture.isCompletedExceptionally());// false
			System.out.println(completableFuture.isDone());// false
			completableFuture.completeExceptionally(new RuntimeException("手動失敗完成"));
			System.out.println(completableFuture.get());
		} catch (Exception ex) {
			System.out.println(timer);
			System.out.println(completableFuture.isCompletedExceptionally());// false
			System.out.println(completableFuture.isDone());// false
			System.out.println(ex);
		}

		System.out.println("========" + Utils.getMethodName() + "======================================");

	}

	@Test
	public void test08_待實作測試cancel和iscanceled的例子() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		// 為了測delayedExecutor才寫得這麼長，就先註解，可能用不到
//		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello"))
//				.thenApplyAsync(s -> s + waitMethod(200, "_World"),
//						CompletableFuture.delayedExecutor(50, TimeUnit.MILLISECONDS));
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> waitMethod(1000, "Hello"));
		System.out.println(timer);
		System.out.println(completableFuture.isCancelled());// false
		System.out.println(completableFuture.isDone());// false
		System.out.println(completableFuture.isCompletedExceptionally());// false
		// 可以重覆cancel，完成前call會回傳true，完成後call會回傳false
		// cancel等同completeExceptionally(new CancellationException())。
		System.out.println(completableFuture.cancel(false));// 參數無用只用來說明
		System.out.println(timer);
		System.out.println(completableFuture.isCancelled());// true
		System.out.println(completableFuture.isDone());// true
		System.out.println(completableFuture.isCompletedExceptionally());// true

		System.out.println("取消後不能再get不然會出錯");
		try {
			System.out.println(completableFuture.get());
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		System.out.println("========" + Utils.getMethodName() + "======================================");

	}

	@Test
	public void test09_測試get和getNow和timeout和join() {

		/**
		 * <pre>
		 和get一樣，只是他是uncheckedException
		 join()
		 Returns the result value when complete, or throws an (unchecked) exception if completed exceptionally.
		 應該是等待完成，和join一樣只是他必須handler ckecked Exception
		 T	get()
		 Waits if necessary for this future to complete, and then returns its result.
		 不知道timeout會發生什麼事
		 T	get(long timeout, TimeUnit unit)
		 Waits if necessary for at most the given time for this future to complete, and then returns its result, if available.
		 直接get，如果未完成就回傳給的default值
		 T	getNow(T valueIfAbsent)
		 Returns the result value (or throws any encountered exception) if completed, else returns the given valueIfAbsent.
		 * </pre>
		 */
	}

	@Test
	public void test10_2擇一() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello future1"))
				.thenApply(s -> s + waitMethod(200, " apply01"));
		CompletableFuture<String> future2 = future1.applyToEither(CompletableFuture
				.supplyAsync(() -> waitMethod(100, "Hello future2")).thenApply(s -> s + waitMethod(200, " apply02")),
				s -> s + " from applyToEither");
		System.out.println(future2.get());
		// 測試結果是兩個supplyAsync並行，apply也一樣，但是只回傳最早完成的結果
		// 就算get結束後也是會慢慢執行完成的，除非exit
		System.out.println("========" + Utils.getMethodName() + "======================================");

	}

	@Test
	public void test10_2擇一無回傳() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello future1"))
				.thenAccept(s -> System.out.println("apply01"));
		CompletableFuture<String> future2 = future1.applyToEither(CompletableFuture
				.supplyAsync(() -> waitMethod(100, "Hello future2")).thenAccept(s -> System.out.println("apply02")),
				s -> s + " from acceptToEither");
		System.out.println(future2.get());
		// 測試結果是兩個並行，就算get完還是會慢慢跑完

		// 附上範例，他使用acceptEither的方式比較複雜一點，先不學
//	    String original = "Message";
//	    StringBuilder result = new StringBuilder();
//	    CompletableFuture cf = CompletableFuture.completedFuture(original)
//	            .thenApplyAsync(s -> delayedUpperCase(s))
//	            .acceptEither(CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
//	                    s -> result.append(s).append("acceptEither"));
//	    cf.join();
//	    assertTrue("Result was empty", result.toString().endsWith("acceptEither"));

		System.out.println("========" + Utils.getMethodName() + "======================================");

	}

	@Test
	public void test10_2個都執行完成再執行() throws InterruptedException, ExecutionException {
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<String> future1 = CompletableFuture
				.supplyAsync(() -> waitMethod(100, "Hello future1 " + timer))
				.thenApply(s -> s + waitMethod(200, " apply01 " + timer));
		CompletableFuture<Void> future2 = future1
				.runAfterBoth(
						CompletableFuture.supplyAsync(() -> waitMethod(200, "Hello future2 " + timer))
								.thenApply(s -> s + waitMethod(200, " apply02 " + timer)),
						() -> System.out.println("done = " + timer));
		// 其它例子thenAcceptBoth，thenCombine

		System.out.println(timer);
		future2.get();// 兩個是並發執行的，然後都執行完都跑runAfterBoth
		System.out.println(timer);
		System.out.println("========" + Utils.getMethodName() + "======================================");

	}

	@Test
	public void test10_任何一個執行完成後就XXX() {
		Stopwatch timer = Stopwatch.createStarted();
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> waitMethod(100, "Hello future1"));
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> waitMethod(200, "Hello future2"));
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> waitMethod(300, "Hello future3"));

		CompletableFuture.anyOf(future1, future2, future3).whenComplete((res, th) -> {
			System.out.println("any of -- " + timer);
			System.out.println("response=" + res);
			System.out.println("exception=" + th);
		});

		CompletableFuture.allOf(future1, future2, future3).whenComplete((res, th) -> {
			System.out.println("all of -- " + timer);
			System.out.println("response=" + res);
			System.out.println("exception=" + th);
		});
		waitMethod(500, "等待完成中……");
		System.out.println("========" + Utils.getMethodName() + "======================================");

	}

	private <T> T waitMethod(int waitMs, T result) {
		try {
			System.out.println("strat sleep " + waitMs + " -- " + result);
			Thread.sleep(waitMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
