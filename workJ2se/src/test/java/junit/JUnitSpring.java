package junit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


@ContextConfiguration(locations = { "classpath:junit/junitSpring.xml" })
public class JUnitSpring extends AbstractJUnit4SpringContextTests {

	@Autowired
	MySpringObj mySpringObj;

	@Test
	public void testEmailGenerator() {
		System.out.println("===================");
		System.out.println(mySpringObj.getAge());
		System.out.println("===================");
	}

}
