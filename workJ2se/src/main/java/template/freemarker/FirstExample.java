package template.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//進階內容參照 freemarker.foofun.cn/toc.html
public class FirstExample {
    private static Configuration cfg;

    static {
        buildConfig();
    }

    public static void buildConfig() {
        try {
            cfg = new Configuration(Configuration.VERSION_2_3_30);
            cfg.setDirectoryForTemplateLoading(ResourceUtils.getFile("classpath:freeMarkerTemplateDir"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void 第一個template() throws IOException, TemplateException {
        Template template = cfg.getTemplate("001HelloWorld.ftl");
        Writer out = new OutputStreamWriter(System.out);
        template.process(new TempObject(), out);
    }

    @Test
    public void 第二個template() throws IOException, TemplateException {
        //想要測試只捉其中的一部分，還試不出來
        Template template = cfg.getTemplate("002Select.ftl");
        TempObject t = new TempObject();
        t.name = "id1";
        Writer out = new OutputStreamWriter(System.out);
        template.process(t, out);
        System.out.println("next==========");
        t.name = "id2";
        template.process(t, out);
        System.out.println("next==========");
    }


    public static class TempObject {
        String name = "名字";
        boolean thisIsTrue = true;
        boolean thisIsFalse = false;
        List<Pair<String, String>> keyList = new ArrayList<>();

        public String getName() {
            return name;
        }

        public List<Pair<String, String>> getKeyList() {
            if (keyList.isEmpty()) {
                IntStream.range(0, 3).forEach(o -> keyList.add(Pair.of("key" + o, "value" + o)));
            }
            return keyList;
        }

        public boolean isThisIsTrue() {
            return thisIsTrue;
        }

        public boolean isThisIsFalse() {
            return thisIsFalse;
        }
    }

}
