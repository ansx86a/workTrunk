package myjava.test;

public class Test1 {
	public static void main(String... args) {
		FinalTest t = new FinalTest();
		t.t();
		SuperClass t2 = t;
		//t2.t();//Super這個method是private的

	}
}

class SuperClass {//注意private可在子類別再寫一次，不算override
	private final void t() {
		System.out.println("SuperClass");
	}
}

class FinalTest extends SuperClass {
	public final void t() {//不算override
		System.out.println("FinalTest");
	}
}