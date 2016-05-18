package springAop.ex2;

import org.springframework.stereotype.Component;

@Component
public class JustBean {

	public static void main(String[] args) {

	}

	public String say() {
		System.out.println("=====this is just bean====");
		return "ok";
	}

	public String sayNo() {
		System.out.println("=====just bean no no no====");
		return "No";
	}

	public String sayEx() {
		System.out.println("====will has ex======");
		int i = 1010 / 0;
		return "ex";
	}

}
