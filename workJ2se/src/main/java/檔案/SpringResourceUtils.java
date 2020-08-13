package 檔案;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SpringResourceUtils {

    @Test
    //好像有人說使用spring boot不要用resourceUtils，因為被包成了jar檔，但是如果還是war檔的包檔方式的話應該沒問題
    //解法好像是改使用classPathResource
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
    public void 取得檔案用classPathResource() throws IOException {
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
