package testNG;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NG004 {
	@Test(dataProvider = "大量測試1")
	public void test(int 數字1, int 數字2, Object map) {
		System.out.println(map);
		Assert.assertEquals(數字1 + 10, 數字2);
	}

	@DataProvider(name = "大量測試1")
	public Object[][] provideData() {
		HashMap map = new HashMap();
		map.put("key1", "value1");
		return new Object[][] { { 10, 20, map }, { 100, 110, map }, { 200, 210, map } };
	}

	/**
	 * 多次觸發，而且可以是多執行緒的測試
	 */
	@Test(invocationCount = 6, threadPoolSize = 3)
	public void testThreadPools() {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
	}

}
