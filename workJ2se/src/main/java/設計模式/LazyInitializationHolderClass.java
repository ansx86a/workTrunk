package 設計模式;

/**
 * 精神就是利用靜態子類別被使用時才載入，達成lazy singleton
 * 
 * @author ai
 *
 */
public class LazyInitializationHolderClass {

    static {
        System.out.println("Class 靜態初始化");
    }

    public LazyInitializationHolderClass() {
        System.out.println("Class 建構子");
    }

    // 字類別的static不會一開始就被初始化，而是用到才載入
    private static class LazyHolderClass {
        static {
            System.out.println("SubClass 靜態初始化");
        }
        private static final LazyInitializationHolderClass INSTANCE = new LazyInitializationHolderClass();

        public LazyHolderClass() {
            System.out.println("SubClass 建構子");
        }

    }

    public static void main(String[] args) {
        System.out.println("進入點");
        System.out.println("第一次");
        System.out.println(LazyInitializationHolderClass.getInstance());
        System.out.println("第二次");
        System.out.println(LazyInitializationHolderClass.getInstance());
        System.out.println("結束");

    }

    public static LazyInitializationHolderClass getInstance() {

        return LazyHolderClass.INSTANCE;
    }

}
