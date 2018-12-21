package testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 要跑xml才會展現出來，可參照testng.xml，右鍵在eclipse跑testNG即可
 * @author ai
 *
 */
public class NG002 {

	@BeforeSuite()
	public void beforeSuite() {
		System.out.println("***@BeforeSuite");
	}

	@AfterSuite()
	public void afterSuite() {
		System.out.println("***@AfterSuite");
	}

	@BeforeTest()
	public void beforeTest() {
		System.out.println("***@BeforeTest");
	}

	@AfterTest()
	public void afterTest() {
		System.out.println("***@AfterTest");
	}
	
	/**
	 * 此例證明，param塞到method是用順序塞的
	 * @param path
	 * @param 連接池大小
	 */
	@Test
	@Parameters({ "dbconfig", "連接池大小" })
	public void loadParam(String path, int 連接池大小){
		System.out.println("dbconfig : " + path);
		System.out.println("連接池大小 : " + 連接池大小);
	}

}
