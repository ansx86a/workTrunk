package html2pdf;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.lang3.SystemUtils.getHostName;

public class HtmlUtils {

    public static final String shellContent = "var Diff2Html=require('./diff2html.min.js')\n" +
            "var dirPath = \"%s\";\n" +
            "const fs = require('fs')\n" +
            "var diffText = fs.readFileSync(dirPath + \"%s\",\"utf8\");\n" +
            "var style = fs.readFileSync(dirPath + \"/diff2html.min.css\",\"utf8\");\n" +
            "var head = '<head><style>'+styls+'</style><head>\\n';\n" +
            "var diffHtml = Diff2Html.html(diffText,{drawFileList:false,matching:'lines',outputFormat:'line-by-line',});\n" +
            "fs.writeFile(dirPath+'%shtml.html','<html>\\n'+head+diffHtml+'\\n</html>',err=>{\n" +
            "if(err){\n" +
            "console.err(err)\n" +
            "return\n" +
            "}\n" +
            "})";

    public static File patchToHtml(File patchFile) throws IOException {
        String hostName = getHostName();

        FileUtils.copyFile(patchFile, new File(new File(EnvConfig.NODE_PATH).getParentFile(), patchFile.getName()));
        String dirPath = new File(EnvConfig.NODE_PATH).getParentFile().getPath().replaceAll("\\\\", "/") + "/";
        File shFile = new File(new File(EnvConfig.NODE_PATH).getParentFile(), "patchToHtml.js");
        FileUtils.writeStringToFile(shFile, String.format(shellContent, dirPath, patchFile.getName(), hostName), "utf-8");
        CommandUtils.runCommand(EnvConfig.NODE_PATH, shFile.getPath());
        return new File(dirPath, hostName + "html.html");
    }

}




