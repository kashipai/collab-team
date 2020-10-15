package sneha.springAnnotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("sneha.springAnnotation")
public class SpringConfigJavaCode {
	@Bean
	public  Os getIos() {
		return new Ios("ios");
	}
	@Bean
	public Os getAndroid() {
		return new Android("android");
	}
	@Bean(name = "apple")
	public Phone getApple() {
		return new Apple(getIos(),"a1");
	}
	@Bean(name = "samsung")
	public Phone getSamsung() {		
		return new Samsung(getAndroid(),"M21");
	}
}
