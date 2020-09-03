package hello.web;

import common.annotation.LogTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingWebController {


    //    http://127.0.0.1:8080/web/greeting
    @GetMapping("/web/greeting")
    @LogTime
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "myPage";
    }

    //做一個一樣的來測AOP
    //    http://127.0.0.1:8080/web/greetingAOP
    @GetMapping("/web/greetingAOP")
    @LogTime
    public String greetingAOP(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "myPage";
    }


}