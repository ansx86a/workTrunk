package springAop.ex3;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * autoProxy最大的好處是不用注入proxy，直接注入aop的bean即可
 * 
 * DefaultAdvisorAutoProxyCreator範例是最簡單的，每個method只要有對到設定，就會用advice來aop
 * 也因為太簡單了，只靠methodName AOP，不容易鎖定package或類別來設定AOP
 * 
 * 所以BeanNameAutoProxyCreator就不錯用了
 * 可以設定Bean和method，method更可以用正規表示式
 * </pre>
 * @author ai
 */
@Component
public class Ex003AutoProxy implements MethodBeforeAdvice {

	public static void main(String[] args) {
		String path = "springAop/ex3/ex3.xml";
		ApplicationContext appContext = new ClassPathXmlApplicationContext(path);

		JustBean justBean = (JustBean) appContext.getBean("justBean");
		justBean.say();
		justBean.sayNo();

	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("=====before " + method);

	}

}
