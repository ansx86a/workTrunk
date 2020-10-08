package http;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Spring的restTemplate {

    @Test
    public void testLocal() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8080/greeting?name=User", String.class);
        System.out.println(result);
        
    }

    @Test
    public void testHtml() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://127.0.0.1:8080/web/greeting", String.class);
        System.out.println(result);
    }

    @Test
    //沒測過先記錄
    public void testPost() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //這裡的String其實要帶Json對應的物件嗎？
        HttpEntity<String> request = new HttpEntity<>("body", headers);

    }

}
