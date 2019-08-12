package 小技巧;

import org.junit.Test;

public class 數字相關 {

    public void 看到一些其它有點興趣的東西() {
        //mchange-commons-java 中的lang有byteutils可以用來轉一些東西
        //apache中的加解密應該也有一些應用
        
    }
    
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
