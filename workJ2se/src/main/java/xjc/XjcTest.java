package xjc;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

public class XjcTest {

    public static File xmlToXSD(File xmlFile) {
        String fileBaseName = FilenameUtils.getBaseName(xmlFile.getName());
        //xsd產出的檔名會被加0，所以把0去掉，使用file.rename
        File xsdFile1 = new File(xmlFile.getParentFile(), fileBaseName + "0.xsd");
        File xsdFile2 = new File(xmlFile.getParentFile(), fileBaseName + ".xsd");

        String[] args = new String[]{"-simple-content-types", "string",
                "-design", "ss",
                "-enumerations", "never",
                "-outPrefix", fileBaseName,
                "-outDir", xmlFile.getParent(),
                xmlFile.getAbsolutePath()};
        org.apache.xmlbeans.impl.inst2xsd.Inst2Xsd.main(args);

        xsdFile1.renameTo(xsdFile2);
        return xsdFile2;
    }

    public static File xsdToPojo(File xsdFile, String packagePrefix, File outputDir) throws Exception {
        XJC2Task xjc2Task = new XJC2Task();
        String packageName = "packageName";
        xjc2Task.setPackage(packagePrefix+"."+packageName);
        FileUtils.forceMkdir(outputDir);
        xjc2Task.setDestdir(outputDir);

        //因為沒有導入jar下面先註解，多次註解就不用打開
        //xjc2Task.setExtension(true);
        //xjc2Task.setProject(new Project());
        //xjc2Task.setSchema(xsdFile.getCanonicalPath());

        //////xjc2Task.setClasspath(new Path(xjc2Task.getProject(),pluginJar.getCanonlcalPath()));
        //xjc2Task.createArg().setLine("-camelcass-always");
        //xjc2Task.execute();

        //return new File(outputDir,xjc2Task.options.defaultPacage,replaceAll("\\.","/")).getCanonicalFile();
        return null;
    }


    private static class XJC2Task {
        public void setDestdir(File outputDir) {
        }

        public void setPackage(String s) {
        }
    }
}
