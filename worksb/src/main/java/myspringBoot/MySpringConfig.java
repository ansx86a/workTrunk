package myspringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"hello", "dao", "my", "common"})
@Configuration
@MapperScan("dao")
public class MySpringConfig {
}
