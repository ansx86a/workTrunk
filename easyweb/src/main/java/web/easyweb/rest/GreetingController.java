package web.easyweb.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * <pre>
     *     2個測試的例子
     *     http://localhost:8080/greeting
     *     http://localhost:8080/greeting?name=User
     * </pre>
     *
     * @param name
     * @return
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        name = name + "456";

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    public static class Greeting {

        private long id;
        private String content;

        public Greeting() {

        }

        public Greeting(long id, String content) {
            this.id = id;
            this.content = content;
        }

        public long getId() {
            return id;
        }

        public String getContent() {
            return content;
        }
    }

}