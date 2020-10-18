package junit.testing;

import static org.junit.Assert.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import org.junit.Test;
@ContextConfiguration(classes = AppconfigOne.class)
@ActiveProfiles("addition")

import org.junit.Test;

public class TestOne {

	@Test
	public void test() {
		Addition unit = new Addition();
		int out = unit.add(10, 20);
		assertEquals(30, out);
		
	}

}
