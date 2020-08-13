package template.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import static tool.Utils.getResourceFromRoot;

public class Test1 {
    private static Configuration cfg;

    static {
        buildConfig();
    }

    public static void buildConfig() {
        try {
            cfg = new Configuration(Configuration.VERSION_2_3_30);
            cfg.setDirectoryForTemplateLoading(getResourceFromRoot("freeMarkerTemplateDir"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void 第一個template() throws IOException, TemplateException {
        Template template = cfg.getTemplate("test.ftl");
        Writer out = new OutputStreamWriter(System.out);
        template.process(new Object(), out);
    }

}
