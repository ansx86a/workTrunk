package 數學相關;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.TreeSet;

public class 亂數 {

    @Test
    public void 產生UUID() {
        System.out.println(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void 一般用的亂數() {

        System.out.println(Math.random());//0≤x<1
        System.out.println(new Random().nextInt(10));//0≤x<10
        TreeSet<Integer> t = new TreeSet<>();
        for (int i = 0; i < 10000; i++) {
            t.add(new Random().nextInt(10));
        }
        System.out.println(t);
    }

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
