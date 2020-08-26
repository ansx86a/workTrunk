package cas;


import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import static org.jasig.cas.client.configuration.ConfigurationKeys.*;

//@Configuration//加入這個，應該就是指把xml寫成Bean，本質上就是Component annotation
//@ImportResource("classpath:config.xml")//應該是可以載入xml寫的部分，我想主要是要可相容舊的部分吧
public class Config {

    /*
    <pre>
    cas的動作：
    1.先到AuthenticationFilter，重導到登入頁面
    2.到SingleSignOutFilter中，記錄session和token資訊
    3.Cas20ServiceTicketValidator來驗證是否合法的ticket



    </pre>
     */


    String casServerUrlPrefix = "http://allen,com/cas";
    String casLoginUrl = "http://allen,com/cas/Login";
    String clientHostUrl = "http://127.0.0.1:8080/";//我是沒設appContext的名字，有設的話要加吧

    @Bean
    public FilterRegistrationBean singleSignOutFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("SingleSignOutFilter");//應該可以亂取名字吧
        filterRegistrationBean.setFilter(new SingleSignOutFilter());
        //亂設個2 個參數看看，應該是對應到filter class
        filterRegistrationBean.addInitParameter("logoutCallbackPath", "");//對應到舊版的casServerUrlPrefix
        filterRegistrationBean.addInitParameter("eagerlyCreateSessions", "true");
        //
        filterRegistrationBean.addUrlPatterns("/*");

        //感覺登入和登出都要到cas server，，到會記錄session id 和 tokenid，正查和反查的table 又或都是BITable
        //他可以控制session對token的表，因些如果在這裡控一個人只有一個session時就可達成singleSignOn
        //這個filter應該主要是在控管登入和登出而已

        return filterRegistrationBean;
    }

    public FilterRegistrationBean authenticationFilter() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("AuthenticationFilter");//應該可以亂取名字吧
        filterRegistrationBean.setFilter(new AuthenticationFilter());

        filterRegistrationBean.addInitParameter(CAS_SERVER_LOGIN_URL.getName(), "...");
        filterRegistrationBean.addInitParameter(SERVER_NAME.getName(), "true");
        filterRegistrationBean.addInitParameter(IGNORE_PATTERN.getName(), "true");
        //
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;

    }


}
