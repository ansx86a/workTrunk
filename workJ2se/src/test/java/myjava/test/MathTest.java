package myjava.test;

import org.junit.Test;

public class MathTest {

	@Test
	/**
	 * ceil為無條件+1後捨去小數點，但整數xx.0就不改變值<br>
	 * 另一個說法就是去找屋頂，和floor相反
	 */
	public void 測試ceil() throws Exception {
		for (double d = -3; d < 9; d += 0.1) {
			System.out.println(String.format("%s\t%s", "" + d, "" + Math.ceil(d)));
		}

		
		
	}
}
