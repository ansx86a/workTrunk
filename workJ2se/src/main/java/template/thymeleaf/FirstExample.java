package template.thymeleaf;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.util.Set;

public class FirstExample {
    private static TemplateEngine templateEngine = new TemplateEngine();

    static {
        FileTemplateResolver ft = new FileTemplateResolver();
        ft.setTemplateMode(TemplateMode.HTML);
        ft.setPrefix("src/main/resources/thymeleafTemplateDir/");
        ft.setSuffix(".html");
        templateEngine.setTemplateResolver(ft);
    }

    @Test
    public void test1帶出最原始的檔案() {
        Context context = new Context();
        String result = templateEngine.process("001HelloWorld", context);
        System.out.println("test1帶出最原始的檔案======================");
        System.out.println(result);
    }

    @Test
    public void test2加入cssSelect檔案() {
        Context context = new Context();
        Set<String> selects = ImmutableSet.of("div");
        String result = templateEngine.process("001HelloWorld", selects, context);
        System.out.println("test2加入cssSelect檔案======================");
        System.out.println(result);
    }

}
