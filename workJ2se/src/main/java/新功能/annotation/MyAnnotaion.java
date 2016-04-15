package 新功能.annotation;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MyAnnotaion {
	@Retention(RetentionPolicy.RUNTIME)
	@Target({FIELD,METHOD})
	public @interface Test3 {
		String value() default "xxx";
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({FIELD,METHOD})
	public @interface Test33 {
		int value() default 333;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({FIELD,METHOD})
	public @interface Testaa {
		int aa() default 0;
		String bb() default "";
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({FIELD,METHOD})
	public @interface Testbb {
		String[] args();
	}

}
