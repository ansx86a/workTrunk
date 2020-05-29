package 數學相關;

import org.junit.Test;

public class 位元運算 {
    @Test
    public void 位元運算() {
        // 位元運算 ~(not) |(or) &(and) ^(xor) <<(左移) >>(右移)
        System.out.println(Integer.toHexString(1024).toUpperCase());
        System.out.println(Integer.toHexString(~1024).toUpperCase());
        System.out.println("7|3=" + (7 | 3));
        System.out.println("7&3=" + (7 & 3));
        System.out.println("7^3=" + (7 ^ 3));
        System.out.println("7>>1=" + (7 >> 1));// 小數點會不見
        System.out.println("7<<1=" + (7 << 1));
        System.out.println("忽略>>>和<<<的測試，有機會再補");
    }

    @Test
    public void 位元運算byte2value_java7() {
        // 8位byte
        byte aByte = 0b0010_0001;
        // 16位short
        short aShort = (short) 0b1010000101000101;
        // 32位int
        int anInt1 = 0b10100001010001011010000101000101;
        System.out.println("0b0010_0001[_可選要不要加] =" + aByte);
        // 0b0010_0001[_可選要不要加] =33
    }

}
