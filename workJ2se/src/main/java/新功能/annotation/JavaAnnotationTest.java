package 新功能.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import 新功能.annotation.MyAnnotaion.Test3;
import 新功能.annotation.MyAnnotaion.Test33;
import 新功能.annotation.MyAnnotaion.Testaa;
import 新功能.annotation.MyAnnotaion.Testbb;

//這裡有我的annotaion
public class JavaAnnotationTest {
	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException {

		JavaAnnotationTest ja = new JavaAnnotationTest();
		Method m = ja.getClass().getMethod("run4");
		Annotation[] ans = m.getAnnotations();
		System.out.println(ans.length);
		for (Annotation a : ans) {
			if (a instanceof Testaa) {
				System.out.println(((Testaa) a).aa());
				System.out.println(((Testaa) a).bb());
			}
		}

		System.out.println("end");
	}

	@Test3("qqqq")
	public void run1() {
		System.out.println("run1");
	}

	@Test33(123)
	public void run2() {
		System.out.println("run2");
	}

	@Testaa(aa = 123, bb = "xxxx")
	@Deprecated
	public void run4() {
		System.out.println("run4");
	}

	@Testbb(args = { "arg1", "arg2" })
	public void run5() {
		System.out.println("run5");
	}
}
