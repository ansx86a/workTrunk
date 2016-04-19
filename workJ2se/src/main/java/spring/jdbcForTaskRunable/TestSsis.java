package spring.jdbcForTaskRunable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSsis {

	public static void main(String args[]) {
		String path = "spring/jdbcForTaskRunable/test-context.xml";
		ApplicationContext appContext = new ClassPathXmlApplicationContext(path);
	}
}
