package springAop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyProxy2 extends ProxyFactoryBean {
	
	@Autowired(required = true)
	private MyProxy2(JustBean justBean) {
		setTarget(justBean);
		setInterceptorNames("ex001代理aop");
	}

}
