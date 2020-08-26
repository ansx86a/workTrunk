package 新功能;

public class Enum用法 {
    enum 使用抽像實作 {
        A {
            @Override
            void run() {
            }
        }, B {
            @Override
            void run() {
            }
        }, C {
            @Override
            void run() {
            }
        };

        abstract void run();
    }

    enum 實作介面 implements Runnable {
        A, B, C;

        @Override
        public void run() {

        }
    }

    //可一起實作或是分別實作都可以
    enum 實作介面2 implements Runnable {
        A {
            @Override
            public void run() {

            }
        }, B, C;

        @Override
        public void run() {

        }
    }

    enum 使用建構子 {
        A(1, 2, 3),
        B(1, 2, 3),
        C(1, 2, 3);
        使用建構子(int a1, int b1, int c1) {
        }
    }
}