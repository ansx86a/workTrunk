package hello.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {
    /**
     * http://localhost:8080/upload
     * 以上網扯用猜的，沒測過不過應該不會錯
     *
     * @param file
     * @param aaa
     * @param ccc
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file, String aaa, @RequestParam("bbb") String ccc) throws IOException {
        System.out.println(new String(file.getBytes()));
        System.out.println(aaa);
        System.out.println(ccc);
        return "abcd";
    }

}
