package 小技巧;

import org.junit.Test;

public class 數字相關 {

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

}
