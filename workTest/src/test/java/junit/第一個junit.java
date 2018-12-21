package junit;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import 新功能.Java7Ex;
import 新功能.列舉中文範例;
import 新功能.lambda.Lambda整理;
import commonTool.IOUtilsTest;

//1）  **/Test*.java ：任何子目录下所有命名以 Test 开头的 Java 类。
//2）  **/*Test.java ：任何子目录下所有命名以 Test 结尾的 Java 类。
//3）  **/*TestCase.java ：任何子目录下所有命名以 TestCase 结尾的 Java 类。

/*
 * <pre>
 * 三個部分
 * 一 beforeClass和afterClass
 * 二 test的運行
 * 三 test運行的 beforMethod和afterMethod
 * 
 * 斷言 assertTrue，assertFalse，assertEquals，assertNotEquals，assertArrayEquals，assertNull
 * </pre>
 */
public class 第一個junit {

	private Collection collection;

	@BeforeClass
	public static void oneTimeSetUp() {
		// one-time initialization code
		System.out.println("@BeforeClass - 單元測式物件建立之前的動作");
	}

	@AfterClass
	public static void oneTimeTearDown() {
		// one-time cleanup code
		System.out.println("@AfterClass - 單元測式物件結束之後的動作");
	}

	@Before
	public void setUp() {
		collection = new ArrayList();
		System.out.println("@Before - 單元測式Method之前的動作");
	}

	@After
	public void tearDown() {
		collection.clear();
		System.out.println("@After - 單元測式Method之後的動作");
	}

	@Test
	public void 測試覆蓋率() {
		try {
			System.out.println("@Test ========測式覆蓋率");
			IOUtilsTest.main(null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testEmptyCollection() {
		Assert.assertTrue(collection.isEmpty());
		System.out.println("@Test - ====測試空的集合");
	}

	@Test
	public void testOneItemCollection() {
		collection.add("itemA這裡斷言錯誤的數字，在maven package時失敗就會造成不會包檔");
		System.out.println("@Test - ====測試有內容的集合開始");
		Assert.assertEquals(1, collection.size());
		System.out.println("@Test - ====測試有內容的集合結束");
	}

	@Test
	public void 測試新功能() {
		try {
			Java7Ex.byte2value();
			列舉中文範例.main(null);
			Lambda整理.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
