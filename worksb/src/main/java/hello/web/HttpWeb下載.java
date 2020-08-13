package hello.web;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.text.MessageFormat.format;

@Controller
public class HttpWeb下載 {

    @Autowired
    private ServletContext servletContext;

    //請參考https://baeldung.com/java-file-mime-type
    public void getMimeType() throws IOException {
        //使用Servlet來獲取mimeType，我覺得可以再優化，就找了一下其它的方法
        //System.out.println(servletContext.getMimeType("/aaa.txt"));
        //java7
        String mime = Files.probeContentType(Paths.get("aaa.txt"));
        System.out.println(MimeType.valueOf(mime));
        System.out.println(MediaType.parseMediaType(mime));
        // 用crl提供猜的方法
        mime = URLConnection.guessContentTypeFromName("aaa.txt");
        //java6
        mime = new MimetypesFileTypeMap().getContentType("aaa.txt");
        //其它解法要引用lib
        //jMimeMagic 或是 Apache Tika


    }

    //    http://127.0.0.1:8080/web/testDownload
    @GetMapping("/web/testDownload")
    public HttpEntity<byte[]> testDownload() throws UnsupportedEncodingException {
        //使用HttpEntity的好處是可以一次定義完status code和設定header和contentType在同一個類別
        //不需要去動response
        byte[] bs = "測試".getBytes("UTF-8");
        //中文檔名的解法
        String fileName = new String("中文檔名測試.txt".getBytes("BIG5"), "ISO8859_1");
        fileName = URLEncoder.encode("中文檔名測試.txt", "UTF-8");
        //如果IE11仍有問題，要成attachment;filename*=UTF-8''{0}
        //{0}為URLEncoder後的值


        //感覺filename的編碼還是沒有明確的規範，使用''+編碼+URLENCODING可能已經是最好的解法了
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition",
                        format("attachment;filename={0}", fileName))
                .body(bs);
    }

    //    http://127.0.0.1:8080/web/testDownload2
    @GetMapping("/web/testDownload2")
    public void testDownload2(HttpServletResponse response) throws IOException {
        byte[] bs = "測試".getBytes("UTF-8");
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Content-Disposition",
                format("attachment;filename={0}",
                        new String("中文檔名測試.txt".getBytes("BIG5"), "ISO8859_1")));
        IOUtils.write(bs, response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}
