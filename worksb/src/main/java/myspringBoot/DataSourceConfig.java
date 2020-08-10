package myspringBoot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.NamingException;
import javax.sql.DataSource;

//以下內容可以去捉sprint-boot-reference.pdf來看
//下面是用JNDI的方式
@Profile({"SIT", "UAT", "反正要要用JNDI的都加進來"})
@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.xxxx.jndi-name}")
    private String jndiName;


    @Primary
    @Bean(name = "xxxDataSource")
    public DataSource xxxDataSource() throws NamingException {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName(jndiName);
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);

        jndiObjectFactoryBean.setLookupOnStartup(false);
        jndiObjectFactoryBean.afterPropertiesSet();
        return (DataSource) jndiObjectFactoryBean.getObject();
    }

    @Value("${spring.datasource.yyy.jndi-name}")
    private String jndiName2;

    @Bean(name = "yyyDataSource")
    public DataSource yyyDataSource() throws NamingException {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName(jndiName2);
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);

        jndiObjectFactoryBean.setLookupOnStartup(false);
        jndiObjectFactoryBean.afterPropertiesSet();
        return (DataSource) jndiObjectFactoryBean.getObject();
    }
}

//補上用DEV的方式
@Profile("DEV")
@Configuration
class DevDataSource {
    @Primary
    @Bean(name = "xxxDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.xxxx")
    public DataSource xxxDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "yyyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.yyyy")
    public DataSource yyyDataSource() {
        return DataSourceBuilder.create().build();
    }
}
