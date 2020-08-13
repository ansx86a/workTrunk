package hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.util.Locale;

@Controller
public class Template測試 {
    @Autowired
    private TemplateEngine templateEngine;

    //    http://127.0.0.1:8080/web/greeting2
    @GetMapping("/web/greeting2")
    public String 使用spring注入的templateEngine(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        Context context = new Context();
        context.setVariable("testData", "我是測試資料");
        String pageData = templateEngine.process("test", context);
        model.addAttribute("pageData", pageData);
        //這裡應該是resolver幫我們加prefix("classpath:/templates/")和suffix(".html")
        return "myPage2";
    }

    //    http://127.0.0.1:8080/web/greeting3
    @GetMapping("/web/greeting3")
    public String 使用自已載入載案的templateEngine(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        FileTemplateResolver ft = new FileTemplateResolver();
        ft.setTemplateMode(TemplateMode.HTML);
        ft.setPrefix("src/main/resources/templates/");
        ft.setSuffix(".html");
        TemplateEngine te = new TemplateEngine();
        te.setTemplateResolver(ft);
        //注意，因為pdf文件是用servletContext來初始化TemplateEngine，又有cache等功能，所以應該是整理程式共用一個templateEngine即可

        Context context = new Context(Locale.TAIWAN);
        context.setVariable("testData", "我是測試資料");
        String pageData = te.process("test", context);
        System.out.println(pageData);
        model.addAttribute("pageData", pageData);
        //這裡應該是resolver幫我們加prefix("classpath:/templates/")和suffix(".html")
        return "myPage2";
    }
}
