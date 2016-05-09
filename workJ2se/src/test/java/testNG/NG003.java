package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NG003 {

	/**
	 * 預期發生exception，這是測試錯誤會死掉，有錯不死掉也是有問題，大括號裡面可放多個Exception
	 */
	@Test(expectedExceptions = { ArithmeticException.class, ArithmeticException.class })
	public void divisionWithException() {
		int i = 1 / 0;
	}

	/**
	 * 有效的測試，中文Method會掛掉
	 */
	@Test(enabled = true)
	public void test1() {
		Assert.assertEquals(true, true);
	}

	/**
	 * 忽略的測試，中文Method會掛掉
	 */
	@Test(enabled = false)
	public void test3() {
		Assert.assertEquals(true, true);
	}

	/**
	 * 逾時測試，這裡用中文Method掛掉
	 */
	@Test(timeOut = 1000)
	public void timeOutTest() {
		while (true)
			;
	}
}
