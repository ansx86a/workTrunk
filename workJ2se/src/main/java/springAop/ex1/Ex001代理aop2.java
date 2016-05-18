package springAop.ex1;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 這邊因為aop也有設一個proxy，這裡也一個又指到相同的bean，造成了這裡呼叫了2次
 * 但是aop1似乎不會被這個影嚮
 * 要避免衝突最好是用了MethodInterceptor就不要用MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice
 * 而用MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice最好就一個bean proxy一次就好，不要多次
 * 如果能一個class就把before、after、throw做完最好
 * 而如果在一個class實作MethodInterceptor，會把MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice吃掉
 * 
 * </pre>
 * @author ai
 */
@Component
public class Ex001代理aop2 implements MethodInterceptor {

	@Autowired
	@Qualifier("myProxy3")
	private JustBean justBean;

	public static void main(String args[]) {
		String path = "springAop/ex1/ex1.xml";
		ApplicationContext appContext = new ClassPathXmlApplicationContext(path);
		Ex001代理aop2 j = (Ex001代理aop2) appContext.getBean("ex001代理aop2");
		System.out.println(j.justBean.say());
		System.out.println("=========end");
	}

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("Method name : " + methodInvocation.getMethod().getName());
		System.out.println("Method arguments : " + Arrays.toString(methodInvocation.getArguments()));
		System.out.println("HijackAroundMethod : Before method hijacked!");

		try {
			Object result = methodInvocation.proceed();
			System.out.println("HijackAroundMethod : after method hijacked!");
			System.out.println("result=" + result);
			int i = 1 / 0;
			return result;
		} catch (Exception e) {
			System.out.println("HijackAroundMethod : Throw exception hijacked!");
			throw e;
		}
	}

}
