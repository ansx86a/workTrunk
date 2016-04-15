package 新功能.lambda;

import java.util.function.Function;

public class Lambda整理 {

	public static void main(String[] args) {
		Lambda整理 l = new Lambda整理();
		l.$4模仿delgate委派();
		// http://www.tutorialspoint.com/java8/java8_functional_interfaces.htm
		// https://www.oreilly.com/learning/java-8-functional-interfaces
		// https://magiclen.org/java-8-lambda/
	}

	public void $1無參數寫法() {
		// 單行不回傳
		Runnable runnbale = () -> System.out.println("run me!");
		// 多行，可回傳
		Runnable runnbale2 = () -> {
			System.out.println("run me!");
		};
	}

	public void $2有參數寫法() {
		// 省略()和型別
		Comparable<Integer> c = i -> {
			return 0;
		};
		// 省略型別
		Comparable<Integer> c2 = (i) -> {
			return 0;
		};
		// 什麼都沒省
		Comparable<Integer> c3 = (Integer i) -> {
			return 0;
		};
	}

	public void $3應用在thread上() {
		Thread t1 = new Thread(() -> System.out.println("xxxx"));
		Thread t2 = new Thread(() -> System.out.println("yyyy"));
		t1.start();
		t2.start();
		// 這裡不用sleep是因為要寫try catch很麻煩
		t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++)
				System.out.println("t1t1");
		});
		t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++)
				System.out.println("t2t2");
		});
		// 這裡有交錯就可以了
		t1.start();
		t2.start();

	}

	public void $4模仿delgate委派() {
		// 前面是input，後面是return;
		Function<String, Integer> f = x -> Integer.valueOf(x + x);
		System.out.println(f.apply("23"));

		Function<Integer, Double> f2 = x -> x / 3.0;
		System.out.println(f2.apply(23));

		// 完整的寫法
		Function<String, Integer> f3 = (String x) -> {
			System.out.println("這裡是委派的內部");
			return Integer.valueOf(x + x);
		};
		System.out.println(f3.apply("34"));

	}

	public void $9轉成List() {

	}

}
