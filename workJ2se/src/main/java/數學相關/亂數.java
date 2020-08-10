package 數學相關;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

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
    public void 一般用的亂數java7() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        TreeSet<Integer> t = new TreeSet<>();
        for (int i = 0; i < 10000; i++) {
            t.add(random.nextInt(10));
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
    public void java8用Stream取亂數() {
        new Random(47)
                .ints(5, 20)//取5-19的int，看原始碼是非parallel
                .distinct()//範例是放在這裡，結果limit會是10個，如果先limit再distinct可能會小於10個
                .limit(10)//不用limit會一直跑最大的long值
                .sorted()
                .forEach(System.out::println);
        //可直接用ints，並從IntStream轉成Stream
        new Random(47).ints().boxed();

    }

    @Test
    public void apache的亂數() {

        byte[] result = RandomUtils.nextBytes(20);
        System.out.println(Arrays.toString(result));

        System.out.println(RandomUtils.nextInt(1, 10));
        //比較特殊的是有一個 RandomStringUtils，可以取ascii的亂數
    }


}
