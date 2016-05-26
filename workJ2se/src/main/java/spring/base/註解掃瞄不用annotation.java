package spring.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class 註解掃瞄不用annotation {

	public static void main(String[] args) {
		String path = "spring/base/註解掃瞄不用annotation.xml";
		ApplicationContext appContext = new ClassPathXmlApplicationContext(path);
		註解掃瞄不用annotation a = (註解掃瞄不用annotation) appContext.getBean("註解掃瞄不用annotation");
		a.test();

	}

	public void test() {
		System.out.println("this is test");
	}

}
