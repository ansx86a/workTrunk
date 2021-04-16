package http;

import hello.vo.Greeting;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.net.ssl.SSLContext;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Spring的restTemplate {

    /**
     * spring 5 多了一個webClient可以用，先記錄一下，還不懂怎麼用
     * maven要加入spring-webflux才能用，下面變成只能記錄跑出來會fail
     */
    @Test
    public void testWebClient() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080")
//                .defaultCookie("", "")
//                .defaultHeader("", "")
                .build();
        Mono<String> result = webClient.get().uri("/resttest/greeting?name=User").retrieve().bodyToMono(String.class);
        System.out.println(result.block());
    }


    @Test
    public void testLocal使用getForObject直接把body轉成POJO() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8080/resttest/greeting?name=User", String.class);
        System.out.println(result);
        //使用變數如下，用大括號可以帶變數
        //改變編碼如下，可用下行或是method，都不是很安全的樣子
        //restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        changeEncoding(restTemplate, StandardCharsets.UTF_8);
        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
        //以下可証中括號的值不影嚮塞入的順序，一切用出現的位置來決定，最後的uriVariables可改成map，可能會讓{}中的值有意義，就不測試了
        result = restTemplate.getForObject("http://localhost:8080/resttest/greeting?name={name}{1}{0}", String.class, "我是abc", "一", "零");
        System.out.println(result);

    }

    //補充，這裡用的是StringHttpMessageConverter預設使用iso8859才會亂碼所以修正
    //但是class用一般的class而不是String的話，好像會變成MappingJacksonHttpMessageConverter，好像就不會有亂碼的問題
    private static RestTemplate changeEncoding(RestTemplate restTemplate, Charset encoding) {
        //注意，這裡的順序可能會影嚮使用的convert，原始碼放1，我放0可以，放最後會有exception，順序可能不能亂放？？？
        //另一個方法是new resttemplate時，就只使用需要的converters就行了，有這個建構子
        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters().stream().filter(o -> o.getClass() != StringHttpMessageConverter.class).collect(toList());
        list.add(0, new StringHttpMessageConverter(encoding));
        restTemplate.setMessageConverters(list);
        return restTemplate;
    }

    @Test
    public void testLocal使用getForEntity可以處理response和用其它的lib來轉換POJO() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/resttest/greeting?name=User中文", String.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
        System.out.println(new String(responseEntity.getBody().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
    }

    @Test
    public void testHtml() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://127.0.0.1:8080/web/greeting", String.class);
        System.out.println(result);
    }

    @Test
    //沒測過先記錄
    public void testPostObject() {
        RestTemplate restTemplate = changeEncoding(new RestTemplate(), StandardCharsets.UTF_8);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("name", "name is 西索");
        HttpEntity httpEntity = new HttpEntity(multiValueMap, headers);
        //上面好像也可以沒有headers，下面直接使用Object也行辟
        HttpEntity httpEntity1 = new HttpEntity<>(new Greeting());

        String result = restTemplate.postForObject("http://localhost:8080/resttest/post1", httpEntity, String.class);
        System.out.println(result);
        Greeting result2 = restTemplate.postForObject("http://localhost:8080/resttest/post1", httpEntity, Greeting.class);
        System.out.println(result2);
    }

    @Test
    public void test上傳檔案() throws FileNotFoundException {
        RestTemplate restTemplate = changeEncoding(new RestTemplate(), StandardCharsets.UTF_8);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("file", new FileSystemResource(ResourceUtils.getFile("classpath:generatorConfig.xml")));
        multiValueMap.add("aaa", "我是aaa");
        multiValueMap.add("bbb", "我是bbb");

        String result = restTemplate.postForObject("http://localhost:8080/upload", new HttpEntity(multiValueMap, headers), String.class);
        System.out.println(result);

    }

    @Test
    public void testExchange_感覺就是getForEntity的變形_多一層HtteMethod的彎() {
        RestTemplate restTemplate = changeEncoding(new RestTemplate(), StandardCharsets.UTF_8);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/resttest/greeting?name=User",
                HttpMethod.GET, HttpEntity.EMPTY, String.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
        //exchange中有ParameterizedTypeReference，下面手寫範例未經過測試
        //ResponseEntity<List<XxxObject>> responseEntity =  restTemplate.exchange(url,get,empty,new ParameterizedTypeReference<List<XxxObject>>());
    }

    public void 相關設定() {
        //使用Apache HttpComponents
        HttpComponentsClientHttpRequestFactory apacheFactory = new HttpComponentsClientHttpRequestFactory();
        //可在factory設定timeout，但好像沒太多東西可以調整
        apacheFactory.setConnectTimeout(10_000);
        //有細節要調整的話，大概是要改在apache的httpClient中
        //apacheFactory.setHttpClient();

        RestTemplate templateApache = new RestTemplate(apacheFactory);
        //這個雁該是jdk預設的HttpUrlConnection，spring應該優先使用這個
        //可以設定ConnectTimeout 和ReadTimeout
        RestTemplate templateJdkDefault = new RestTemplate(new SimpleClientHttpRequestFactory());
        //OkHttpClientHttpRequestFactory , OkHttp3ClientHttpRequestFactory 就不例舉了
        //factory也可以後設：restTemplate.setRequestFactory();
    }

    @Test
    public void testHttps() {
        String url = "https://tw.dictionary.search.yahoo.com/";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
    }

    /**
     * 沒試過有沒有用，先抄一下
     */
    public void testSkipHttps() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
    }

    @Test
    public void testSkipHttps自已簡化程式碼() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(SSLContexts.custom()
                .loadTrustMaterial(null, (chain, authType) -> true)
                .build(), NoopHostnameVerifier.INSTANCE);
        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory(HttpClients.custom().setSSLSocketFactory(csf).build());
        //以下留下來參考，應該要能disable hostname verifier但我測好像沒用，要加此method的第三行在建構子裡面才有用
        //HttpClients.custom().setSSLHostnameVerifier((hostName, session) -> true);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
    }

    /**
     * 抄到一個更短的
     */
    public void testSkipHttps2() {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        new RestTemplate(requestFactory);
    }

    public void test使用exchage有用get有header要怎麼用() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + "base64");
        //也可以用下面這個，可指定明碼不用base64
        //headers.setBasicAuth();
        HttpEntity httpEntity = new HttpEntity(null, headers);
        ResponseEntity<byte[]> result = restTemplate.exchange("url", HttpMethod.GET, httpEntity, byte[].class);
        System.out.println(result.getBody().length);
    }

}
