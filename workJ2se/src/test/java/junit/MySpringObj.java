package junit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MySpringObj {
	private int age = 11;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String args[]){
		String path = "springTest/test-context.xml";
		ApplicationContext appContext = new ClassPathXmlApplicationContext(path);
		MySpringObj m = (MySpringObj)appContext.getBean("mySpringObj");
		System.out.println(m.getAge());
	}
	
}
