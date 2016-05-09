package junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class 大量參數的單元測試 {
	private int 參數1;
	private int 參數2;
	private int 結果;

	public 大量參數的單元測試(int a, int b, int c) {
		參數1 = a;
		參數2 = b;
		結果 = c;
	}

	/**
	 * 大量的測試參數，用來new 自已用的
	 * @return
	 */
	@Parameters(name = "{index}: add({0}+{1})={2}")
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] { { 1, 1, 2 }, { 2, 2, 4 }, { 8, 2, 10 }, { 4, 5, 9 } });
	}

	@Test
	public void 測試() {
		assertEquals(結果, 加法());
	}

	public int 加法() {
		return 參數1 + 參數2;
	}

}
