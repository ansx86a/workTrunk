package 字串編碼;

import org.junit.Test;

import java.nio.charset.Charset;

public class 字串編碼 {


    @Test
    public void 取得目前JVM編碼() {
        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding);
    }

    @Test
    public void 取得全部可用編碼() {
        Charset.availableCharsets().forEach((k, v) -> {
            System.out.println("k:" + k + ", v:" + v);
        });

    }

}
