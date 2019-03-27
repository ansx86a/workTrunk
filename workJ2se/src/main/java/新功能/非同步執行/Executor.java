package 新功能.非同步執行;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

	// 感想大概是java8之後用completableFuture就行了
	// java8之前這可以用來做個小型的thread pool使用吧
	public static void main(String[] args) throws InterruptedException {
		// 一個小型的thread pool，可以不用管thread的new和start，程式碼可以好看一些
		ExecutorService exe = Executors.newSingleThreadExecutor();
		exe.execute(() -> System.out.println("xxx"));
		exe.execute(() -> System.out.println("yyy"));
		exe.execute(() -> System.out.println("zzz"));
		exe.shutdown();
		System.out.println(exe.isShutdown());// 看解釋好像是強制停止？停排程？，好像不需要呼叫的樣子，和submit有關？
		System.out.println(exe.isTerminated());// 有時會是false，要全執行完才會true
		System.out.println("end");
		Thread.sleep(1000);
		System.out.println(exe.isShutdown());
		System.out.println(exe.isTerminated());

	}
}
