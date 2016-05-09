package testNG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 重點是要繼承一下AbstractTestNGSpringContextTests這個類別
 * @author ai
 */
@ContextConfiguration(locations = { "classpath:testNG/NGSpring.xml" })
public class NGSpring extends AbstractTestNGSpringContextTests {
	@Autowired
	MySpringObj mySpringObj;

	@Test
	public void testEmailGenerator() {
		System.out.println("===================");
		System.out.println(mySpringObj.getAge());
		System.out.println("===================");
	}

}
