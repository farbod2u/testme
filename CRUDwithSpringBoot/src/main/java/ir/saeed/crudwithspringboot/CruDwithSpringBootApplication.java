package ir.saeed.crudwithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ir.saeed.crudwithspringboot.entities.User;
import ir.saeed.crudwithspringboot.repository.UserRepository;

@SpringBootApplication
public class CruDwithSpringBootApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CruDwithSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUserName("saeed");
		user.setPassword("1234");
		userRepository.save(user);
		
		System.out.println("SAeed");	
	}

	
}
