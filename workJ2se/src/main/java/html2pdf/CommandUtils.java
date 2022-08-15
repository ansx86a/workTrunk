package html2pdf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class CommandUtils {

    //網路抄的一個簡單執行cmd的程式
    public static String runCommand(String... params) {
        ProcessBuilder pb = new ProcessBuilder(params);
        Process p;
        StringJoiner joiner = new StringJoiner(System.getProperty("line.separator"));
        try {
            p = pb.start();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), "utf-8"));
            reader.lines().iterator().forEachRemaining(joiner::add);
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return joiner.toString();


    }
}
