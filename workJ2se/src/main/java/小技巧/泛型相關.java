package 小技巧;

public class 泛型相關 {
	static class 泛型類別<E> {
		E a;

		void run() {
			System.out.println(a);
		}

		void add(E a) {
			this.a = a;
		}
	}
}
