package html2pdf;

import com.google.common.base.Verify;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class HtmlToPdfMain {

    public static void main(String[] args) {
        //limit come from commandline
        if (args.length == 0 && new File("html2pdf.bat").exists()) {
            CommandUtils.runCommand("cmd.exe", "/c", "start html2pdf.bat");
        }
        try {
            if (new File("html2pdf.properties").exists()) {
                //EnvConfig.loadConfig(new File("html2pdf.properties"));
            }
            run();
        } catch (Exception ex) {
            ex.printStackTrace();
            Scanner in = new Scanner(System.in);
            System.out.println("run end please close window");
            in.next();
        }
    }

    private static void run() throws GitAPIException, IOException {
        Map<String, Ref> map = GITUtils.fetchGitBranches(EnvConfig.gitUrl);

        File patchFile = GITUtils.diff(null,"","");
        Verify.verify(patchFile.exists());
        File htmlFile = HtmlUtils.patchToHtml(patchFile);
        File pdfFile =PdfUtils.htmlToPdf(htmlFile);
        System.out.println("pdf ok");
    }


}
