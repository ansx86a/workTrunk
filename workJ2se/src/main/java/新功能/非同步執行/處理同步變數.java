package 新功能.非同步執行;

import java.util.concurrent.atomic.AtomicLong;

public class 處理同步變數 {
	// 這個就不會有i++之類的問題，i++是兩個動作當兩個同時執行時會跑掉一個
	private static AtomicLong atomicLong = new AtomicLong();

	// volatile可保證不同的thread看到最近的變化，不然就要使用method在get set加上 sync
	private static volatile int aaa = 0;

	public static void main(String[] args) {
		atomicLong.getAndIncrement();// i++
		atomicLong.incrementAndGet();// ++i
		atomicLong.get();

		// 兩個thread safe的hashmap，而hashMap本身不是thread safe
		// ConcurrentHashMap
		// Hashtable

		// https://zhuanlan.zhihu.com/p/48784500
		// arrayList本身不是thread safe
		// Vector//比較舊
		// CopyOnWriteArrayList

		// other
		// CopyOnWriteArraySet

		// 如果使用Collections.synchronizedList(new
		// ArrayList())来使ArrayList变成是线程安全的话，也是几乎都是每个方法都加上synchronized关键字的，只不过它不是加在方法的声明处，而是方法的内部。

	}

}
