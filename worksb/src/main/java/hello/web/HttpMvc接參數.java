package hello.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

// 範例碼都寫在 httpRequest.html
// 但是沒有經過測試
@RestController
public class HttpMvc接參數 {
    //    http://127.0.0.1:8080/web/mvc001
    @GetMapping("/web/mvc001")
    public String getParam001(String aaa) {
        return "ok";
    }

    //    http://127.0.0.1:8080/web/mvc002
    @GetMapping("/web/mvc002")
    public String getParam002(String name, Vo vo) {
        //ajax進來的參數，一律也會塞到物件裡面，所以物件必需要可以new而且有空的建構子
        //如果物件裡的參數和api參數名稱相同的話：spring會同時塞到參數和物件裡面
        //所以ajax那邊都是用form的形式傳值過來，或是formData都用
        //我猜json應該不行，不過用json都是用post吧，沒試過get能不能用，不過也懶得去試了
        return "ok";
    }

    //    http://127.0.0.1:8080/web/mvc003
    @PostMapping("/web/mvc003")
    public String getParam003(@RequestBody Vo vo) {
        //上面的例子都是支援一層的
        //如果是很複雜的結構或是多筆，如vo中的pets
        // ajax直接使用json傳入組成object即可
        return "ok";
    }

    public static class Vo {
        String name;
        int age;
        List<String> pets;
    }
}
