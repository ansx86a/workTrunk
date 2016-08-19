package thread;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class 弱引用 {// 隨時可能被回收
	public static void main(String[] args) throws InterruptedException {

		WeakReference r = new WeakReference(new String("I'm here"));
		WeakReference sr = new WeakReference("I'm here");
		System.out.println("before gc: r=" + r.get() + ", static=" + sr.get());
		System.gc();
		Thread.sleep(100);

		// 只有r.get()??null
		System.out.println("after gc: r=" + r.get() + ", static=" + sr.get());

		String s = new String("mm");
		String s2 = new String("mm2");
		WeakReference r2 = new WeakReference(s);
		s = null;
		WeakReference sr2 = new WeakReference(s2);
		System.out.println("before gc: r2=" + r2.get() + ", static2=" + sr2.get());
		System.gc();
		Thread.sleep(100);
		System.out.println("after gc: r2=" + r2.get() + ", static2=" + sr2.get());

		// 軟引用，記憶体不足時才會回收

		String str = new String("abc"); // 强引用
		SoftReference<String> softRef = new SoftReference<String>(new String("abc")); // 软引用
		System.gc();
		Thread.sleep(100);
		System.out.println(softRef.get());
	}

}