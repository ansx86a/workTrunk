package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 複合單元測試，可執行多個單元測試，像controller，而本身如果有寫單元測試並不會執行<br>
 * 適合用來組一個複合測試使用
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ 第一個junit.class, Junit2.class })
public class 測試複合單元 {

}
