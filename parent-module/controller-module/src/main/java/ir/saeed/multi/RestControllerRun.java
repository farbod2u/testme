package ir.saeed.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ir.saeed.multi")
@EntityScan("ir.saeed.multi.model")
public class RestControllerRun {

	public static void main(String[] args) {
		SpringApplication.run(RestControllerRun.class, args);
	}

}
