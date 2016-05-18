package springAop.ex2;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 比例子1的aop多加了一個彎Advisor，可以指定正規表示式去做aop
 * 或是指定methodArray去做Aop
 * </pre>
 * @author ai
 */
@Component
public class Ex002代理aop implements MethodBeforeAdvice {

	@Autowired
	@Qualifier("myProxy")
	private JustBean justBean;

	public static void main(String[] args) {
		String path = "springAop/ex2/ex2.xml";
		ApplicationContext appContext = new ClassPathXmlApplicationContext(path);
		Ex002代理aop aop = (Ex002代理aop) appContext.getBean("ex002代理aop");
		aop.justBean.say();
		aop.justBean.sayNo();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("before......" + method);

	}

}
