package ir.saeed.spring.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name ="t_person")
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3765610353195473391L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "f_first_name")
	private String firstName;
	
	@Column(name = "f_last_name")
	private String lastName;
	
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;

	public Person() {

	}

	public Person(Integer id, String firstName, String lastName, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student no. " + this.id.toString() + " ==> " + this.firstName + " " + this.lastName
				+ "\n\t Address ==> " + this.address.getProvince() + " , " + this.address.getCity();
	}

}
