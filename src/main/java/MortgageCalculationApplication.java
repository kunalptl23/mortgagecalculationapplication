/**
* This is the main application class for the project
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.demo.app.resource")  
@ComponentScan({"com.demo.app.controller","com.demo.app.service","com.demo.app.validator"})
public class MortgageCalculationApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MortgageCalculationApplication.class, args);
	}

}
