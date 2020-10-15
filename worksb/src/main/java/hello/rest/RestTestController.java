package hello.rest;

import hello.vo.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("resttest")
public class RestTestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * <pre>
     *     2個測試的例子
     *     http://localhost:8080/resttest/greeting
     *     http://localhost:8080/resttest/greeting?name=User
     * </pre>
     *
     * @param name
     * @return
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    /**
     * http://localhost:8080/resttest/post1
     * @param name
     * @return
     */
    @PostMapping("/post1")
    public Greeting greetingPost1(String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

}
