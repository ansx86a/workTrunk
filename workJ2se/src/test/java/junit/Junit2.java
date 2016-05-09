package junit;

import org.junit.Ignore;
import org.junit.Test;

public class Junit2 {

	/**
	 * <pre>
	 * 測試Exception，沒有算錯，這邊應該是測試錯誤，有錯要掛掉不能過的情況
	 * 沒丟Exception算失敗，把下面的0改成10就知道，是藍色的錯誤，成功是綠色
	 * expected = 預期的
	 * </pre>
	 */
	@Test(expected = ArithmeticException.class)
	public void 預期會發生的Exception() {
		System.out.println("預期會發生的Exception");
		int i = 1 / 0;
	}

	/**
	 * 沒加annotation就會出現紅色的測試失敗
	 */
	@Test
	public void 預期會發生的Exception反證明() {
		System.out.println("預期會發生的Exception反證明");
		int i = 1 / 0;
	}

	/**
	 * 註解掉這個test method，會出現白色的圖示表示忽略，內容不會被執行
	 */
	@Ignore("Not Ready to Run")
	@Test
	public void divisionWithException() {
		System.out.println("Method is not ready yet");
	}

	/**
	 * 對method加入時限，超過就丟出逾時的紅色錯誤
	 */
	@Test(timeout = 1000)
	public void 測試逾時() {
		System.out.println("測試逾時");
		while (true)
			;
	}
}
