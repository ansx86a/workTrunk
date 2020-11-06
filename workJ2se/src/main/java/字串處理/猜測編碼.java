package 字串處理;

import org.junit.Test;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.UnsupportedEncodingException;

public class 猜測編碼 {


    @Test
    public void 猜編碼() throws UnsupportedEncodingException {
        //沒特色的字是猜不出來的，所以UTF8之類的比較好猜
        do猜編碼("123".getBytes("UTF-8"));//null
        do猜編碼("123中文".getBytes("UTF-8"));//utf-8
        do猜編碼("123中文".getBytes("BIG5"));//windows-1252 錯誤
        do猜編碼("123中文再補幾個字".getBytes("BIG5"));//big5
        do猜編碼("123中文".getBytes("MS950"));//windows-1252 錯誤
        do猜編碼("123中文再補幾個字".getBytes("MS950"));//big5
        do猜編碼("123中文再補幾個字".getBytes("CP937"));//windows-1251 錯誤
        System.out.println(new String("123中文再補幾個字".getBytes("CP937"),"WINDOWS-1251"));
    }
    private static void do猜編碼(byte[] bs){
        UniversalDetector universalDetector = new UniversalDetector(null);
        //取有特徵的區段來猜編碼吧
        universalDetector.handleData(bs,0,bs.length);
        //不太清楚這一行的用意，有用再看一下原始碼吧，感覺不用沒差的樣子
        //System.out.println(universalDetector.isDone());
        universalDetector.dataEnd();
        System.out.println(universalDetector.getDetectedCharset());
        //感覺是可以重覆使用
        universalDetector.reset();
    }

}
