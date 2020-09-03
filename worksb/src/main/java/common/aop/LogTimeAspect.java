package common.aop;

import com.google.common.base.Stopwatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogTimeAspect {
    //改成trage或是within，代表有此annotation的class
    @Pointcut("@annotation(common.annotation.LogTime)")
    public void 有此annotation的method() {

    }

    //arg用法還不熟，要用時再查查吧，有@表annotation要注意
    @Pointcut("@args(common.annotation.LogTime)")
    public void 參數有此annotation() {

    }

    //用..或*可以用來做多層是匹配，第一個描述是public之類的修飾
    @Pointcut("execution(* hello.web.GreetingWebController.greeting(..))")
    public void 有符合的method() {

    }

    @Pointcut("this(common.aop.MyAopInterface)")
    public void 實作此介面的所有類別() {

    }

    @Pointcut("within(hello.web.*)")
    public void 此套件的全部類別() {

    }

    @Around("有此annotation的method() && 有符合的method()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Stopwatch sp = Stopwatch.createStarted();
        try {
            return joinPoint.proceed();
        } finally {
            System.out.println("進到了aop");
            System.out.println(joinPoint.getSignature());
            System.out.println(Arrays.toString(joinPoint.getArgs()));
            System.out.println("執行秒數：" + sp.stop());
        }
    }
}

interface MyAopInterface {

}