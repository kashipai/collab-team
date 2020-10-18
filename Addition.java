package junit.testing;

import org.springframework.stereotype.Component;

@Component
public class Addition {
	public int add(int a, int b) {
		return a+b;
	}

}
