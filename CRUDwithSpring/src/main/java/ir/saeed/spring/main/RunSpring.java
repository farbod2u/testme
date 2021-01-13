package ir.saeed.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ir.saeed.spring.entities.Address;
import ir.saeed.spring.entities.Person;
import ir.saeed.spring.service.AddressService;
import ir.saeed.spring.service.PersonService;

public class RunSpring {

	public static void main(String[] args) {
//		Resource resource = new ClassPathResource("applicationContext.xml");
//		BeanFactory beanFactory = new XmlBeanFactory(resource);
//		System.out.println(beanFactory.getBean(Student.class).toString());

		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// System.out.println(applicationContext.getBean("studentBySetter",
		// Student.class));
		// System.out.println(applicationContext.getBean("studentByConstructor",
		// Student.class));

		PersonService personService = applicationContext.getBean(PersonService.class);
		Person person = personService.read(1);

		AddressService addressService = applicationContext.getBean("addressService", AddressService.class);
		Address address = new Address();
		address.setCity("ww");
		address.setProvince("33");
		address.setPerson(person);
		person.setAddress(address);
		addressService.create(address);
	}

}
