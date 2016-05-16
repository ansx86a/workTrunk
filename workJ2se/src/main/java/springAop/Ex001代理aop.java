package springAop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 優點：容易，只要繼承就可以了
 * 缺點：無法指定aop那個method，只能全部
 * 一個代理只能對到一個traget，也就是對到一個class
 * 也可以(多個代理對同一個traget)=一組，但是沒什麼義意啦
 * 用途：當你有一個程式不想要改他的原始碼，就可以用這個proxy，例如別人寫的，你只要加一些log之類的
 * 因為拿到了traget和method和args，可以用beanUtils做一些事，如用methodName分流
 * 
 * 
 * </pre>
 * @author ai
 */
@Component
public class Ex001代理aop implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

	@Autowired
	@Qualifier("myProxy")
	private JustBean justBean;
	@Autowired
	@Qualifier("myProxy2")
	private JustBean justBean2;

	public static void main(String args[]) {
		String path = "springAop/ex1.xml";
		ApplicationContext appContext = new ClassPathXmlApplicationContext(path);
		Ex001代理aop j = (Ex001代理aop) appContext.getBean("ex001代理aop");
		System.out.println(j.justBean.say());
		System.out.println(j.justBean.sayNo());
		System.out.println("再來測沒經過xml，由class設的proxy=====================");
		System.out.println(j.justBean2.say());
		try {
			j.justBean2.sayEx();
		} catch (Exception ex) {
			System.out.println("ex = "+ex.toString());
		}
		System.out.println("=========end");
	}

	@Override
	public void before(Method arg0, Object[] arg1, Object target) throws Throwable {
		System.out.println("before aop start");
		System.out.print("methods:" + arg0.getName());
		System.out.print("  ,arg1:" + Arrays.toString(arg1));
		System.out.println("  ,target:" + target);
		System.out.println("before aop end");
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("afterReturning aop start");
		System.out.print("returnValue:" + returnValue);
		System.out.print("  ,methods:" + method.getName());
		System.out.print("  ,args:" + Arrays.toString(args));
		System.out.println("  ,target:" + target);
		System.out.println("afterReturning aop end");
	}

	// ThrowsAdvice後有作用，確沒有空的函式可以實作比較奇怪一點
	public void afterThrowing(Exception e) throws Throwable {
		System.out.println("跑出Exception了啦，完蛋了");
	}

	// 會對到比較精準的那一個Ex
	public void afterThrowing(ArithmeticException e) throws Throwable {
		System.out.println("跑出ArithmeticException了啦，完蛋了");
	}

}
