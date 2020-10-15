package sneha.springAnnotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("sneha.springAnnotation")
public class SpringConfigJavaCode {
	@Bean(name = "ios") 
	public  Os getIos() {
		return new Ios();
	}
	@Bean(name = "android")
	public Os getAndroid() {
		return new Android();
	}
	@Bean(name = "apple")
	public Phone getApple() {
		
		return new Apple("a1");
	}
	@Bean(name = "samsung")
	public Phone getSamsung() {
		
		return new Samsung("M21");
	}
	}
