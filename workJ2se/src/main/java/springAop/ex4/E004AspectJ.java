package springAop.ex4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <pre>
 * <aop:aspectj-autoproxy />要加，這個最重要，再來就和ex3差不多，但是直接寫annotation蠻方便的
 * 好處是不用寫xml，等於是ex3的再簡化的感覺
 * AOP檔要上註解@Aspect+@Component
 * 注意點是Around如果把ex catch住，那AfterThrowing就不會有動作
 * </pre>
 *
 * @author ai
 */
@Component
@Aspect
public class E004AspectJ {

    public static void main(String[] args) {
        String path = "springAop/ex4/ex4.xml";
        ApplicationContext appContext = new ClassPathXmlApplicationContext(path);
        JustBean justBean = (JustBean) appContext.getBean("justBean");
        justBean.say();
        justBean.sayNo();
        justBean.sayEx();
        System.out.println("class end");
    }

    @Pointcut("execution(* springAop.ex4.JustBean.sayYes(..))")
    public void exp01() {

    }

    @Pointcut("execution(* springAop.ex4.JustBean.sayYes(..))")
    public void exp02() {

    }

    @AfterThrowing(pointcut = "exp01() || exp02()", throwing = "ex")
    public void handlerEx(Throwable ex) {
        //沒測試，但這裡是可以用pointcut來簡化寫execution(.........)
        //throwing="ex" 不知是否影嚮到到注入的名稱
    }


    @Before("execution(* springAop.ex4.JustBean.sayYes(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.print("logBefore() is running!");
        System.out.print("\t" + joinPoint.getSignature().getName());
        System.out.print("\t" + Arrays.toString(joinPoint.getArgs()));
        System.out.println();
    }

    @After("execution(* springAop.ex4.JustBean.say*(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.print("logAfter() is running!");
        System.out.print("\t" + joinPoint.getSignature().getName());
        System.out.print("\t" + Arrays.toString(joinPoint.getArgs()));
        System.out.println();
    }

    @AfterReturning(pointcut = "execution(* springAop.ex4.JustBean.say*(..))", returning = "result")
    // public void logAfterReturning(JoinPoint joinPoint,Object result) {
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.print("logAfterReturning() is running!");
        System.out.print("\t" + joinPoint.getSignature().getName());
        System.out.print("\t" + Arrays.toString(joinPoint.getArgs()));
        System.out.print("\tresult=" + result);
        System.out.println();
    }

    @AfterThrowing(pointcut = "execution(* springAop.ex4.JustBean.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.print("logAfterThrowing() is running!");
        System.out.print("\t" + joinPoint.getSignature().getName());
        System.out.print("\t" + Arrays.toString(joinPoint.getArgs()));
        System.out.print("Exception : " + error);
        System.out.println();

    }

    @Around("execution(* springAop.ex4.JustBean.*(..))")
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
