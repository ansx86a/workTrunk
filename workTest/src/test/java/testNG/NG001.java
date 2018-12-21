package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * NG不能用中文的Class名稱，再舊一點的版本連Method也不能用中文的名稱
 * @author ai
 *
 */
public class NG001 {

	@Test
	public void 測試1() {
		System.out.println("testNg===========");
		String email = "abc@abc.abc";
		Assert.assertNotNull(email);
		Assert.assertEquals(email, "abc@abc.abc");
		// SfJson實作.main(null);
	}

	
	@Test(dependsOnGroups = { "shopping" })
	public void otherGroup() {
		System.out.println("@Test -- 相依的group，自已可以是method或group都沒問題");
	}

	@Test(groups = "shopping")
	public void group1() {
		System.out.println("@Test - group1");
	}

	@Test(groups = "shopping")
	public void group2() {
		System.out.println("@Test - group2");
	}

	@BeforeTest
	public void 測試之前() {
		System.out.println("@BeforeTest測試之前的動作=============");
	}

	@AfterTest
	public void 測試之後() {
		System.out.println("@@AfterTest測試之後的動作=============");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass===========只會跑一次，適合放一些init");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass===========只會跑一次，適合放一些destroy");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod======每個testMethod都會跑");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod======每個testMethod都會跑");
	}

	@BeforeGroups("shopping")
	// 一定要帶參數shopping，無法說不設參數 by 每個group跑一次
	public void beforeGroups() {
		System.out.println("@BeforeGroups======每個Group跑一次");
	}

	@AfterGroups("shopping")
	// 一定要帶參數shopping，無法說不設參數 by 每個group跑一次
	public void afterGroups() {
		System.out.println("@AfterGroups=======每個Group跑一次");
	}

}
