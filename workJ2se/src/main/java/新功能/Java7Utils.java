package 新功能;

import java.util.Objects;

public class Java7Utils {

	public static void main(String[] args) {
		Java7Utils u = new Java7Utils();
		u.$1Objects的應用();

	}

	public void $1Objects的應用() {
		System.out.println("==有一些用來判斷null和deepEqual就不列，只是容易讀和程式會變長的不列");

		System.out.println("使用Objects.equal，避免null exception");
		System.out.println("Objects.equal(100, null) = " + Objects.equals(100, null));
		System.out.println("");
		System.out.println("toString 給default值，避免null 有exception");
		System.out.println("Objects.toString(null)=" + Objects.toString(null));
		System.out.println("Objects.toString(null, \"defaultString\")=" + Objects.toString(null, "defaultString"));

		
	}

}
