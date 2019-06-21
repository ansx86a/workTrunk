package 小技巧;

import org.junit.Test;

public class 巢狀類別 {

    private String a = "a";
    private String b = "b";

    @Test
    public void 內部靜態類別讀不到外部類別() {
        System.out.println("內部靜態類別讀不到外部類別");
        // this會指到內部類別
        new 巢狀類別.InnerStaticClass().test();
    }

    @Test
    public void 內部類別this的用法() {
        System.out.println("1.內部類別讀外部類別不能用this");
        System.out.println("2.非靜態method可直接new巢狀類別");
        // this會指到內部類別
        new 巢狀類別.InnerClass().test();
    }

    public static void main() {
        // new InnerClass();//編譯錯誤
        new 巢狀類別().new InnerClass();// OK
        // new 巢狀類別().new InnerStaticClass();// 編譯錯誤
        new InnerStaticClass();// OK
        new 巢狀類別.InnerStaticClass();// OK
    }

    private static class InnerStaticClass {
        private String ai = "ai";
        private String b = "bi";

        private void test() {
            System.out.println(this.ai);
            System.out.println(this.b);
        }
    }

    private class InnerClass {
        private String ai = "ai";
        private String b = "bi";

        private void test() {
            System.out.println(a);
            System.out.println(b);
            System.out.println(this.ai);
            System.out.println(this.b);
            System.out.println(巢狀類別.this.a);
            System.out.println(巢狀類別.this.b);
        }
    }

}
