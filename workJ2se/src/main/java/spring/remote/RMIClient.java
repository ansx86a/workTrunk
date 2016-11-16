package spring.remote;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIClient {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/remote/RMIClient.xml");

		Irmi service = (Irmi) context.getBean("rmiServiceProxy");

		System.out.println(service.sayName("Kkmanzz"));
		System.out.println(service.sayHowMach(100, 37));

		HashMap map = new HashMap();
		map.put("method", "測試啦");
		map.put("input", "輸入資料");

		System.out.println(service.masterMethod(map));

	}

}
