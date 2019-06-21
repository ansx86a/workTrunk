package 小技巧;

import org.junit.Test;

public class 迴圈相關 {

    @Test
    public void 特別的for迴圈寫法() {
        int a = 10;
        for (int i = 1, j = i * 2, z = j * 3; i <= 10; i++, j++, z = i * j, a = z * j, a++) {
            System.out.println(i);
            System.out.println(j);
            System.out.println(z);
            System.out.println(a);
            System.out.println("==================");
        }
        for (int i = 1; i <= 3; System.out.println("xxx=" + (++i))) {
            
        }
    }    
}
