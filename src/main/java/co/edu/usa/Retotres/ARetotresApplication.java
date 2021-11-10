package co.edu.usa.Retotres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.edu.usa.Retrotres"})

@SpringBootApplication
public class ARetotresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ARetotresApplication.class, args);
	}

}
