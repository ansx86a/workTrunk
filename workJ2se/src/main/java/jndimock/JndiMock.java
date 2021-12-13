package jndimock;

import org.osjava.sj.loader.JndiLoader;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class JndiMock {

    public void initUserProgram() throws NamingException {
        Properties properties = new Properties();
        properties.setProperty("java:comp/env/jdbc/EC/type", String.class.getName());
        properties.setProperty("jdbc/EC", String.class.getName());
        InitialContext ctx = new InitialContext();
        //只讀jndi.properties的前兩項，後面的jndi由程式來注入
        JndiLoader jndiLoader = new JndiLoader(ctx.getEnvironment());

//        BasicDataSource ds= new BasicDataSource();
//        ds.setDriverClassName;
//        ds.setUrl;
//        ds.setUserName;
//        ds.setPassword;

        //使用jndiLoader載入的值，才會在每個context共用
        //這裡的rebind後，就可以類似一般的map來使用了
//        ctx.rebind("java:comp/env/jdbc/EC",ds);
//        ctx.rebind("jdbc/EC",ds);

    }

    public void initUserProperty() throws NamingException {
        //如果properties設定得值都對的話，就能直接使用
        InitialContext ctx = new InitialContext();
        Object obj = ctx.lookup("java:comp/env/jdbc/EC");
        System.out.println(obj);


    }
}
