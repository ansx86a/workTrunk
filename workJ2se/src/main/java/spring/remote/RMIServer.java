package spring.remote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/remoting.html
 * 另外參考 http invoker
 * https://sites.google.com/site/stevenattw/java/spring-framework/spring-remoting---http-invoker
 * </pre>
 * @author ai
 *
 */
public class RMIServer implements Irmi {

	public static void main(String args[]) throws IOException {
		new ClassPathXmlApplicationContext("spring/remote/RMIServer.xml");
		System.out.println("Start RMI Server..");
		System.out.println("enter 'quit' to shut down server");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			if (reader.readLine().equals("quit")) {
				System.out.println("exit 0");
				System.exit(0);
			}
		}
	}

	@Override
	public String sayName(String name) {
		System.out.println("client->" + name);
		return "hello " + name;
	}

	@Override
	public int sayHowMach(int a, int b) {
		System.out.println("client " + a + " - " + b);
		return a + b;
	}

	@Override
	public HashMap masterMethod(HashMap map) {
		System.out.println(map);
		map.put("output", "回傳結果");
		return map;
	}

}
