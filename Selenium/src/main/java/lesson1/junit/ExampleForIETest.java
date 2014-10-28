package lesson1.junit;

import static org.junit.Assert.*;
import lesson1.ExampleForIE;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ExampleForIETest {
	ExampleForIE test = new ExampleForIE();
	@Test
	public void testLoginTest() {
		//fail("Not yet implemented");
		test.loginTest();
		assertEquals(Boolean.TRUE,  test.isResult());
	}
	public static void main(String[] args) throws Exception {                    
	       JUnitCore.main(
	         "lesson1.junit.ExampleForIETest");            
	}
}
