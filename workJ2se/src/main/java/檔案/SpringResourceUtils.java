package 檔案;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class SpringResourceUtils {

    @Test
    //好像有人說使用spring boot不要用resourceUtils，因為被包成了jar檔會有問題，實際上jboss上會讀不到已經遇到
    //解法是改使用classPathResource，但是只能使用resource.getInputStram()，getFile仍然會出錯
    public void 取得檔案用classPath() throws FileNotFoundException {
        //使用classpath，可以捉到target/classes和target/test-classes
        File file = ResourceUtils.getFile("classpath:checkstyle.xml");
        checkFileStatus(file);
        file = ResourceUtils.getFile("classpath:spring/base/註解掃瞄不用annotation.xml");
        checkFileStatus(file);
        file = ResourceUtils.getFile("file:src/main/resources/checkstyle.xml");
        checkFileStatus(file);
        file = ResourceUtils.getFile("file:src/main/java/spring/base/註解掃瞄不用annotation.xml");
        checkFileStatus(file);
        //加不加file好像都一樣沒什麼差異
        file = ResourceUtils.getFile("src/main/resources/checkstyle.xml");
        checkFileStatus(file);
    }

    @Test
    public void 當無法使用getFile時使用Java的原生解法() throws IOException {
        //注意要/開頭，而且這樣要用getClass()才行，用其它的類別好像會null，我試過Object.class就會傳null回來
        String path = "/checkstyle.xml";
        //String path = "/logback.xml";
        InputStream inputStream = getClass().getResourceAsStream(path);
        System.out.println(inputStream);
        byte[] bs = IOUtils.toByteArray(inputStream);
        System.out.println(bs.length);
    }

    @Test
    public void 使用Spring的ResourceLoader來解() throws IOException {
        //可以用@Autowired Resourceloader resourceLoader直接使用，就不用new了
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:checkstyle.xml");
        byte[] bs = IOUtils.toByteArray(resource.getInputStream());
        System.out.println(bs.length);
    }


    @Test
    public void 取得檔案用classPathResource_可以解ResourceUtils不能用時來getInputStream() throws IOException {
        //可以直接用@value("calsspath:checkstyle.xml") Resource resource;
        //還有FileResource和VfzResource等東西可以玩
        Resource resource = new ClassPathResource("checkstyle.xml");
        checkFileStatus(resource.getFile());
        resource = new ClassPathResource("spring/base/註解掃瞄不用annotation.xml");
        checkFileStatus(resource.getFile());
    }

    private static void checkFileStatus(File file) {
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
    }


}
