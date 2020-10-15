package spring.frame.work;

import org.springframework.stereotype.Component;

@Component
public class JavaBackend implements Teacher {

	public void teach() {
		System.out.println("hii i am  your Teacher");

	}

}
