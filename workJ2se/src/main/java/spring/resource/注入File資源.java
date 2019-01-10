package spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import spring.base.註解掃瞄不用annotation;

import java.io.IOException;

//https://www.baeldung.com/spring-classpath-file-access
//好像intellij怪怪的都找不到file，之後再來補完
@Component
public class 注入File資源 {

    //注意有一些patten可補，有空再補
    @Value("classpath:spring/resource/myfile.txt")
    Resource resourceFile;

    public static void main(String[] args) throws IOException {
        String path = "spring/resource/注入File資源.xml";
        ApplicationContext appContext = new ClassPathXmlApplicationContext(path);
        注入File資源 a = (注入File資源) appContext.getBean("注入File資源");
        System.out.println(IOUtils.toString(a.resourceFile.getInputStream()));

    }

    //還沒試過
    public Resource loadEmployees() {
        return new ClassPathResource("data/employees.dat");
        //以下兩個可能會用到，記錄一下
        //return new ClassPathResource("data/employees.dat").getFile();
        //return new ClassPathResource("data/employees.dat", this.getClass().getClassLoader());
    }

    // Using ResourceLoader

    //Reading Resource Data

}
