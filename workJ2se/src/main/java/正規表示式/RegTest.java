package 正規表示式;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * <pre>
 * 
 * 
 * 
 * 
 * </pre>
 */
public class RegTest {
    // 這個網站寫得不錯
    // http://ccckmit.wikidot.com/regularexpression
    public static void main(String[] args) {

    }

    /**
     * lookingAt就像加上^，而matches就像加上^和$，而find就是捉出多個匹配
     */
    @Test
    public void 測試Matchs() {
        Pattern p = Pattern.compile("(abc)");// 要預先compile，所以可以宣告成static共用吧
        String input = "abcabcabcdefabc";
        System.out.println("input=" + input);
        Matcher m = p.matcher(input);// m.find可用來做部分匹配和捉位置
        // lookingAt不到開頭就匹配不到
        System.out.println("使用lookingAt可以判斷是否開頭有部分匹配，但index會跑到第一個匹配後面而影嚮find():" + m.lookingAt());
        while (m.find()) {
            System.out.println(String.format("match str=%s, positions=%d - %d", m.group(), m.start(), m.end() - 1));
        }
        System.out.println("使用lookingAt可以判斷是否有部分匹配，但index會跑到第一個匹配後面而影嚮find():" + m.lookingAt());
        System.out.println("造成m.find() = false又可以而find()=true了，但是只匹配第2個之後的部分");
        System.out.println(m.matches());// 嘗試將整個區域與模式匹配。好像就不用再加^$了吧
        System.out.println("aaaa".matches("aaaa"));// true
        System.out.println("aaaa".matches("aa"));// false
    }

    /**
     * <pre>
     * 勉強在特別字元後多一個?，佔有多一個+
    貪婪型 勉強型 佔有型             
    X?      X??     X?+         一個或0個X
    X*      X*?     X*+         零個或多個X
    X+      X+?     X++         一個或多個X
    X{n}    X{n}?   X{n}+       恰好n個X
    X{n,}   X{n,}?  X{n,}+      至少n個X
    X{n,m}  X{n,m}? X{n,m}+     至少n個X，而不超過m
     * </pre>
     */
    @Test
    public void 測試特殊型別() {
        String input = "abccccabccccabcdefabc";
        System.out.println("貪婪型->abc?");
        Matcher m = Pattern.compile("abc?").matcher(input);// m.find可用來做部分匹配和捉位置
        while (m.find()) {
            System.out.println(String.format("match str=%s, positions=%d - %d", m.group(), m.start(), m.end() - 1));
        }
        System.out.println("勉強型->abc??");
        m = Pattern.compile("abc??").matcher(input);// m.find可用來做部分匹配和捉位置
        while (m.find()) {
            System.out.println(String.format("match str=%s, positions=%d - %d", m.group(), m.start(), m.end() - 1));
        }
        System.out.println("貪婪型->abc+");
        m = Pattern.compile("abc+").matcher(input);// m.find可用來做部分匹配和捉位置
        while (m.find()) {
            System.out.println(String.format("match str=%s, positions=%d - %d", m.group(), m.start(), m.end() - 1));
        }
        System.out.println("勉強型->abc+?");
        m = Pattern.compile("abc+?").matcher(input);// m.find可用來做部分匹配和捉位置
        while (m.find()) {
            System.out.println(String.format("match str=%s, positions=%d - %d", m.group(), m.start(), m.end() - 1));
        }
    }

    @Test
    public void 預查模式() {
        System.out.println("(?:pattern)：表示pattern會串接在後面");
        String regex = "window(?:95|xp)";// 應該等於window(95|xp)
        Matcher m = Pattern.compile(regex).matcher("window95");
        System.out.println(m.find());
        System.out.println(m.group());
        System.out.println("(?=pattern)：表示pattern只檢查，不匹配");
        regex = "window(?=95|xp)";
        m = Pattern.compile(regex).matcher("window95");
        System.out.println(m.find());
        System.out.println(m.group());
        System.out.println("(?!pattern)：表示pattern只反向檢查，不匹配");
        regex = "window(?!95|xp)";
        m = Pattern.compile(regex).matcher("window10");
        System.out.println(m.find());
        System.out.println(m.group());
        System.out.println("(?<=pattern)：表示pattern在檢查字之前且預先檢查，不匹配");
        regex = "(?<=95|xp)window";
        m = Pattern.compile(regex).matcher("95window");
        System.out.println(m.find());
        System.out.println(m.group());
        System.out.println("(?<!pattern)：表示pattern在檢查字之前且預先反向檢查，不匹配");
        regex = "(?<!95|xp)window";
        m = Pattern.compile(regex).matcher("window");
        System.out.println(m.find());
        System.out.println(m.group());
    }

    @Test
    // 注意，如果有正規表式示中有Scanner的delimiter的話，就會永遠匹配不到
    // 要用還是要注意需求不會增加不然很容易爆炸
    public void 配合Scanner使用可以讓架構更明確一些() {
        String threatData = "58.27.82.161@02/10/2005\n" + "204.45.234.40@02/11/2005\n" + "58.27.82.161@02/11/2005\n"
                + "58.27.82.161@02/12/2005\n" + "58.27.82.161@02/12/2005\n"
                + "[Next log section with different data format]";
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" + "(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.format("Threat on %s from %s\n", date, ip);
        }
        scanner.close();
    }

    /**
     * <pre>
        final public static int UNIX_LINES
        啟用 Unix 行模式。  在此模式中，.、^ 和 $ 的行為中僅識別 '\n'行結束符。
      通過嵌入式標誌表達式 (?d) 也可以啟用 Unix 行模式。
       
      final public static int CASE_INSENSITIVE
        啟用不區分大小寫的匹配。
      默認情況下，不區分大小寫的匹配假定僅匹配 US-ASCII 字符集中的字符。可以通過指定 #UNICODE_CASE標誌連同此標誌來啟用 Unicode 感知的、不區分大小寫的匹配。
      通過嵌入式標誌表達式  (?i)也可以啟用不區分大小寫的匹配。
      指定此標誌可能對性能產生一些影響。
    
      final public static int COMMENTS
        模式中允許空白和註釋。
      此模式將忽略空白和在結束行之前以 #開頭的嵌入式註釋。
      通過嵌入式標誌表達式  (?x) 也可以啟用註釋模式。
       
      final public static int MULTILINE
        啟用多行模式。
      在多行模式中，表達式 ^ 和 $僅分別在行結束符前後匹配，或者在輸入序列的結尾處匹配。默認情況下，這些表達式僅在整個輸入序列的開頭和結尾處匹配。
      通過嵌入式標誌表達式 (?m) 也可以啟用多行模式。
    
      final public static int LITERAL 
        啟用模式的字面值解析。
      指定此標誌後，指定模式的輸入字符串就會作為字面值字符序列來對待。輸入序列中的元字符或轉義序列不具有任何特殊意義。
      標誌 CASE_INSENSITIVE 和 UNICODE_CASE 在與此標誌一起使用時將對匹配產生影響。其他標誌都變得多餘了。
      不存在可以啟用字面值解析的嵌入式標誌字符。
      since   1.5
       
      final public static int DOTALL
        啟用 dotall 模式。
      在 dotall 模式中，表達式 .可以匹配任何字符，包括行結束符。默認情況下，此表達式不匹配行結束符。
      通過嵌入式標誌表達式 (?s) 也可以啟用 dotall 模式（s 是 "single-line" 模式的助記符，在 Perl 中也使用它）。
    
      final public static int UNICODE_CASE
        啟用 Unicode 感知的大小寫摺疊。
      指定此標誌後，由 #CASE_INSENSITIVE標誌啟用時，不區分大小寫的匹配將以符合 Unicode Standard 的方式完成。默認情況下，不區分大小寫的匹配假定僅匹配 US-ASCII 字符集中的字符。
      通過嵌入式標誌表達式 (?u)也可以啟用 Unicode 感知的大小寫摺疊。
      指定此標誌可能對性能產生影響。
    
      final public static int CANON_EQ
        啟用規範等價。
      指定此標誌後，當且僅當其完整規範分解匹配時，兩個字符才可視為匹配。例如，當指定此標誌時，表達式 "a\u030A" 將與字符串 "\u00E5"匹配。默認情況下，匹配不考慮採用規範等價。
      不存在可以啟用規範等價的嵌入式標誌字符。
      指定此標誌可能對性能產生影響。
     * </pre>
     */
    @Test
    public void 特殊模式() {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher("java has regex\nJava has regex\n" + "JAVA has pretty good regular expressions\n"
                + "Regular expressions are in Java");
        while (m.find())
            System.out.println(m.group());
    }

    public void 實作replace() {
        // 用這個方式可以實作replace N個
        String REGEX = "a*b";
        String INPUT = "aabfooaabfooabfoob";
        String REPLACE = "-";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();// 重點，要一個空的
        while (m.find()) {
            m.appendReplacement(sb, REPLACE);// group之前的字塞到sb，把塞REPLACE的字
        }
        m.appendTail(sb);// 把最後一組group之後的字塞到sb
        System.out.println(sb.toString());

    }
}
