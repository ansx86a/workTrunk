package junit;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import commonTool.IOUtilsTest;

//1）  **/Test*.java ：任何子目录下所有命名以 Test 开头的 Java 类。
//2）  **/*Test.java ：任何子目录下所有命名以 Test 结尾的 Java 类。
//3）  **/*TestCase.java ：任何子目录下所有命名以 TestCase 结尾的 Java 类。
public class 第一個junit {

	private Collection collection;

	@BeforeClass
	public static void oneTimeSetUp() {
		// one-time initialization code
		System.out.println("@BeforeClass - oneTimeSetUp");
	}

	@AfterClass
	public static void oneTimeTearDown() {
		// one-time cleanup code
		System.out.println("@AfterClass - oneTimeTearDown");
	}

	@Before
	public void setUp() {
		collection = new ArrayList();
		System.out.println("@Before - setUp");
	}

	@After
	public void tearDown() {
		collection.clear();
		System.out.println("@After - tearDown");
	}

	@Test
	public void 測試覆蓋率() {
		try {
			IOUtilsTest.main(null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testEmptyCollection() {
		Assert.assertTrue(collection.isEmpty());
		System.out.println("@Test - testEmptyCollection");
	}

	@Test
	public void testOneItemCollection() {
		collection.add("itemA");
		Assert.assertEquals(1, collection.size());
		System.out.println("@Test - testOneItemCollection");
	}
}
