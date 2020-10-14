package springAnnotations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class Config 
{

	@Bean
	public AccountHolder accHolder()
	{
		return new AccountHolder(12345699,"Shreya","shreya@gmail.com","Shimogga", trans());
	}
	
	@Bean
	public Transactions trans()
	{
		return new Transactions("Deposit",10000);
	}

}
