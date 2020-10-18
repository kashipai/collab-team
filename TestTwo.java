package junit.testing;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;

import org.junit.Test;
@ContextConfiguration(classes = AppconfigTwo.class)
@ActiveProfiles("stringJoin")
public class TestTwo {

	@Test
	public void test() {
		StringJoin unit = new StringJoin();
		String out = unit.concatenate("one","two");
		assertEquals("onetwo", out);
	}

}
