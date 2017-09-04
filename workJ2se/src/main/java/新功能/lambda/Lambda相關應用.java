package 新功能.lambda;

import java.util.Optional;

public class Lambda相關應用 {

	public static void main(String[] args) {

		Lambda相關應用 l = new Lambda相關應用();
		// 可以來這裡看看
		// blog.tonycube.com/search/label/Java
		l.$1Optional應用_可設null的default值();
		
		//functional，找時間看一下
		//http://blog.tonycube.com/2015/10/java-java8-1-functional-interfaces.html
	}

	public void $1Optional應用_可設null的default值() {
		// 將值轉為 Optional 的方法
		// of()：接受非 null 的值並回傳 Optional 物件。
		// ofNullable()：可以接受 null 的值，回傳 Optional 物件。
		// ===========================================
		// 取得放在 Optional 物件內的值的方法
		// get()：如果值存在就回傳這個值，否則就丟出 NoSuchElementException。
		// orElse(T other)：如果值存在就回傳這個值，否則回傳 other
		System.out.println("orElse(T other)：如果值存在就回傳這個值，否則回傳 other");
		Integer i = null;
		System.out.println("Optional.ofNullable(i is null).orElse(100)->" + Optional.ofNullable(i).orElse(100));
		i = 50;
		System.out.println("Optional.ofNullable(i is 50).orElse(100) =" + Optional.ofNullable(i).orElse(100));
		System.out.println();

		System.out.println("orElseGet(Supplier<? extends T> other)：如果值存在就回傳這個值，否則就呼叫 other 並回傳它的結果。");
		i = null;
		System.out.println("Optional.ofNullable(i is null).orElseGet(() -> 3 * 3) = "
				+ Optional.ofNullable(i).orElseGet(() -> 3 * 3));
		String s = null;
		System.out.println("Optional.ofNullable(s is null).orElseGet(() -> \"字串是空的耶\" +\"，這裡可以做很多事\") = "
				+ Optional.ofNullable(s).orElseGet(() -> "字串是空的耶" + "，這裡可以做很多事"));
		System.out.println();
		try {
			System.out.println(
					"orElseThrow(Supplier<? extends X> exceptionSupplier)：如果值存在就回傳這個值，否則就丟出由 exceptionSupplier 建立的例外。");
			i = null;
			System.out.println("Optional.ofNullable(s).orElseThrow(() -> new Exception(\"自已客製null point Exception\")");
			Optional.ofNullable(s).orElseThrow(() -> new Exception("自已客製null point Exception"));
			System.out.println("上面ex發生，這一行不會被執行");
		} catch (Exception ex) {
			System.out.println("ex message:" + ex.getMessage());
		}
		System.out.println();

		// isPresent()：如果值存在，回傳 true；不存在則回傳 false。
		// void ifPresent(Consumer<? super T> consumer)：如果值存在，呼叫指定的 consumer
		// 物件並將值傳給它處理；不存在則什麼都不做。

		i = 7;
		System.out.print("Optional.ofNullable(i is 7).ifPresent(System.out::println) = ");
		Optional.ofNullable(i).ifPresent(System.out::println);
		System.out.println("可用o->sysout(o) ,好像只能1個指令不能有回傳，可參考Lambda整理.$4模仿delgate委派");
		Optional.ofNullable(i).ifPresent(o -> System.out.println(o * o));
	}

}
