package 數學相關;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.SplittableRandom;

public class 亂數 {

    @Test
    public void java原生的亂數_取得區間亂數() throws NoSuchAlgorithmException {
        System.out.println(new SplittableRandom().nextInt(5, 10));// 指5-9

        //先宣告再塞值
        byte[] result = new byte[100];
        new SplittableRandom().nextBytes(new byte[100]);
        new SplittableRandom().nextBytes(result);
        System.out.println(Arrays.toString(result));

        //使用更強的亂數？
        SecureRandom.getInstanceStrong().nextBytes(result);
        System.out.println(Arrays.toString(result));

    }

    @Test
    public void apache的亂數() {

        byte[] result = RandomUtils.nextBytes(20);
        System.out.println(Arrays.toString(result));

        System.out.println(RandomUtils.nextInt(1, 10));
    }


}
