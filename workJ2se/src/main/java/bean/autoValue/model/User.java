package bean.autoValue.model;

import com.google.auto.value.AutoValue;

/**
 * <pre>
 * https://www.jianshu.com/p/0e2be3536a4e
 * 加上annotation之後，complie會幫你產java和class在traget，可能要maven時才會build
 * eclipse 要裝m2e-apt才行
 * 
 * 另外有其它的東西可以幫你做掉json轉檔之類的，感覺是很屌
 * 重點是你可以看到gen出來的code，而lombok是更好用，但他不是java的規範才是hack的方式實作
 * 可能會有無法預期的風險
 * 
 * 目前遇到的困難是如何吧maven build的code搬到source去吧
 * 
 * https://ryanharter.com/blog/2016/05/16/autovalue-extensions/
 * 這個文章寫得不錯，有介紹轉gson之類的
 * 
 * 個人評估了一下，感覺是 不可變Immutable的class比較適合，因為建構子就是設定final進去
 * 好處就是幫你用了toString之類的東西
 * 
 * 套件的應用如轉gson
 * https://zhuanlan.zhihu.com/p/24193465
 * 
 * auto value plugin，可以幫你弄builder
 * https://www.youtube.com/watch?v=sMX9PT3ecu8
 * 
 * 
 * 另外可以看看AutoFactory，感覺就是幫你多一個create instatnce的Factory，用建構子，感覺沒什屁用
 * 
 * 
 * </pre>
 * 
 * @author ai
 *
 */
@AutoValue
abstract public class User {
//    static User create(String name, int age, String address) {
//        return new AutoValue_User(name, age, address);
//    }
//
//    abstract public String name();
//
//    abstract public int age();
//
//    abstract public String address();
//
//    private String ignoredProperty; // sadly, it can't be `final`
}
