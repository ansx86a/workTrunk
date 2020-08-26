package 數學相關;

import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;

public class Format {


    @Test
    public void HexToInt() {
        String hexNumber = "12345678";// 注意7碼ok，8碼有一些就會失敗
        int decimal = Integer.parseInt(hexNumber, 16);
        System.out.println("Hex value is " + decimal);
    }

    @Test
    public void intToHex() {
        int i = -1;
        String hex = Integer.toHexString(i);
        System.out.println("Hex value is " + hex);

    }

    @Test
    public void intToByte() {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
    }

    @Test
    public void floatToBit() {
        //應該是把bits改用int來解讀
        System.out.println(Float.floatToIntBits(1f));
        System.out.println(Integer.toString(Float.floatToIntBits(1f), 16));
        System.out.println(Double.doubleToLongBits(1d));
        System.out.println(Long.toString(Double.doubleToLongBits(1d), 16));

    }

    public void 看到一些其它有點興趣的東西() {
        //mchange-commons-java 中的lang有byteutils可以用來轉一些東西
        //apache中的加解密應該也有一些應用

    }

    @Test
    public void Double轉數字格式和去小數點() {
        DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
        DecimalFormat df2 = new DecimalFormat("###,###,###,##0.00");
        DecimalFormat df3 = new DecimalFormat("###,###,#00,000.00");
        df.setRoundingMode(RoundingMode.DOWN);
        double d = 0.229;
        System.out.println(df.format(d));
        System.out.println(df2.format(d));
        System.out.println(df3.format(d));
    }

    @Test
    public void 比DecimalFormat簡單的格式化() {
        //NumberFormat是DecimalFormat的父類別，使用getInstance可以拿到DecimalFormat
        //好處是可以自動把.00拿掉，但是只到小數點3位數而已
        System.out.println(NumberFormat.getInstance().format(123456789.00));
        System.out.println(NumberFormat.getInstance().format(123456789.1234500));
        System.out.println(NumberFormat.getCurrencyInstance().format(123456789.00));
        System.out.println(NumberFormat.getCurrencyInstance().format(123456789.1234500));
        System.out.println(NumberFormat.getNumberInstance().format(123456789.00));
        System.out.println(NumberFormat.getNumberInstance().format(123456789.1234500));


        System.out.println(MessageFormat.format("可以針對數字格式化小數點，會4捨5入{0,number,##.##} ", 456.789));


    }

}
