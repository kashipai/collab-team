package junit.testing;

import org.springframework.stereotype.Component;

@Component
public class StringJoin {
  public String concatenate(String one, String two) {
	  return one+two;
  }
}
