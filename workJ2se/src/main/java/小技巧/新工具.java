package 小技巧;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.SplittableRandom;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class 新工具 {
    @Test
    public void Objects的應用_java7() {
        System.out.println("==有一些用來判斷null和deepEqual就不列，只是容易讀和程式會變長的不列");

        System.out.println("使用Objects.equal，避免null exception");
        System.out.println("Objects.equal(100, null) = " + Objects.equals(100, null));
        System.out.println("");
        System.out.println("toString 給default值，避免null 有exception");
        System.out.println("Objects.toString(null)=" + Objects.toString(null));
        System.out.println("Objects.toString(null, \"defaultString\")=" + Objects.toString(null, "defaultString"));
    }

    public void 亂數() throws NoSuchAlgorithmException {
        new SplittableRandom().nextInt(5, 10);// 指5-9
        new SplittableRandom().nextBytes(new byte[100]);
        SecureRandom.getInstanceStrong().nextBytes(new byte[100]);
        byte[] randomBytes = RandomUtils.nextBytes(20);
    }
}
