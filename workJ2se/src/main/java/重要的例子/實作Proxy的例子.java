package 重要的例子;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;
import java.util.TreeSet;

public class 實作Proxy的例子 {

    public static void main(String args[]) {
        System.out.println("開始");
        DynamicProxyHandler p = new DynamicProxyHandler();
        p.proxied = new TreeSet<String>();
        // 注意這裡的Set一定要是介面不能是類別
        // 注意使用method.invoke要包含類別資訊吧，不能隨便用一個Object有相同的method，要有介面去串才行

        // 第一個參數的classLoader是幹嘛的還不清楚，好像可以亂寫
        // new Class[] { Set.class } 表示實作了幾個介面，這裡有的介面都可以強制轉型(i)
        // p是實作InvocationHandler的class都行
        Set i = (Set) Proxy.newProxyInstance(Set.class.getClassLoader(), new Class[] { Set.class }, p);
        i.add("444");
        i.add("333");
        i.add("222");
        i.add("111");
        System.out.println(i.toString());
    }

    static class DynamicProxyHandler implements InvocationHandler {
        Object proxied;

        public DynamicProxyHandler() {
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
            if (args != null)
                for (Object arg : args)
                    System.out.println("  " + arg);
            return method.invoke(proxied, args);
        }
    }
}
