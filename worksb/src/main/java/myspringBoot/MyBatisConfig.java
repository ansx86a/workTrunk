package myspringBoot;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;

@Component
@Profile("DEV")
@MapperScan(basePackages = "dao.mapper.xxx", sqlSessionFactoryRef = "xxxSqlSessionFactory")
public class MyBatisConfig {
    @Autowired
    @Qualifier("xxxDataSource")
    private DataSource xxxDataSource;

    private static String MAPPING_PATH = "classpath*:doa/mapping/*Mapper.xml";

    @Primary
    @Bean(name = "xxxSqlSessionFactory")
    public SqlSessionFactory xxxSqlSessionFactory() throws Exception {
        //記得去調整dev時的初始連線數，這裡先跳過
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(xxxDataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPING_PATH));
        sessionFactoryBean.setTypeAliasesPackage("dao.domain.xxx");
        return sessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "xxxTransactionManager")
    public DataSourceTransactionManager xxxTmg() {
        return new DataSourceTransactionManager(xxxDataSource);
    }

}
