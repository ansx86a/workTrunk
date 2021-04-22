package http;

import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class Uri的建立 {

    @Test
    public void testCreateUri() {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://127.0.0.1/{001}/{002}/")
                .queryParam("a", "avalue")
                .queryParam("b", "bvalue1", "bvalue2")
                .queryParam("c", "cvalue1", "cvalue2")
                .build("001url", "002url");
        System.out.println(uri.toString());
        //http://127.0.0.1/001url/002url/?a=avalue&b=bvalue1&b=bvalue2&c=cvalue1&c=cvalue2

        URI uri2 = UriComponentsBuilder.fromHttpUrl(uri.toString())
                .replaceQueryParam("c", "newC").build().toUri();
        System.out.println(uri2);
        //http://127.0.0.1/001url/002url/?a=avalue&b=bvalue1&b=bvalue2&c=newC
        //c只有一個值可見replace是replace全部
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(uri.toString())
                .replaceQueryParam("c", "newC").build();
        System.out.println(uriComponents.getHost());//127.0.0.1
        System.out.println(uriComponents.getScheme());//http


    }
}
