package spring.remote;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIClient {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/remote/RMIClient.xml");

		Irmi service = (Irmi) context.getBean("rmiServiceProxy");

		System.out.println(service.sayName("Kkmanzz"));
		System.out.println(service.sayHowMach(100, 37));

	}

}
