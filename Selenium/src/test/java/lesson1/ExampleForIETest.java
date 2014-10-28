package lesson1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExampleForIETest {
	ExampleForIE test = new ExampleForIE();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testLoginTest() {
		//fail("Not yet implemented");
		test.loginTest();
		assertEquals(Boolean.TRUE,  test.isResult());
	}

}
