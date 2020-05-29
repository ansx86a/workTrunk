package 數學相關;

import org.junit.Test;

public class 常見的陷井 {
    @Test
    public void 溢位和浮點誤差() {
        // 浮點數宣告
        float b = 12.3e-3f;// 預設是double
        // 沒有溢位的exception
        int a = Integer.MAX_VALUE;
        a++;
        System.out.println("int溢位：" + a);// -2147483648
        // double會有誤差，不好用來算錢，雖然誤差很小
        System.out.println("浮點數誤差1.0-0.8：" + (1.0 - 0.8));// 0.19999999999999996
    }
}
