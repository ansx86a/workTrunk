package springAop.ex5;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * </pre>
 * @author ai
 */
@Component
public class E005AspectJ {

	public static void main(String[] args) {
		String path = "springAop/ex5/ex5.xml";
		ApplicationContext appContext = new ClassPathXmlApplicationContext(path);
		JustBean justBean = (JustBean) appContext.getBean("justBean");
		justBean.say();
		justBean.sayNo();
		justBean.sayEx();
		System.out.println("class end");
	}

	public void logBefore(JoinPoint joinPoint) {
		System.out.print("logBefore() is running!");
		System.out.print("\t" + joinPoint.getSignature().getName());
		System.out.print("\t" + Arrays.toString(joinPoint.getArgs()));
		System.out.println();
	}
	
	public void logAfter(JoinPoint joinPoint) {

		System.out.print("logAfter() is running!");
		System.out.print("\t" + joinPoint.getSignature().getName());
		System.out.print("\t" + Arrays.toString(joinPoint.getArgs()));
		System.out.println();
	}

	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.print("logAfterReturning() is running!");
		System.out.print("\t" + joinPoint.getSignature().getName());
		System.out.print("\t" + Arrays.toString(joinPoint.getArgs()));
		System.out.print("\tresult=" + result);
		System.out.println();
	}

	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.print("logAfterThrowing() is running!");
		System.out.print("\t" + joinPoint.getSignature().getName());
		System.out.print("\t" + Arrays.toString(joinPoint.getArgs()));
		System.out.print("Exception : " + error);
		System.out.println();

	}

	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.print("logAround() is running!");
		System.out.print("\t" + joinPoint.getSignature().getName());
		System.out.print("\t" + Arrays.toString(joinPoint.getArgs()));
		System.out.println();
		System.out.println("logAround() before!");
		try {
			Object result = joinPoint.proceed(); // continue on the intercepted method
			System.out.println("result = " + result);
		} catch (Exception ex) {
			System.out.println("ex:" + ex);
			// throw ex;
		}
		System.out.println("logAround() end!******");
	}

}
