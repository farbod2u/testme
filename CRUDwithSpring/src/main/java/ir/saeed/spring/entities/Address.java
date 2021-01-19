package ir.saeed.spring.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "t_address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2594878157192936299L;

	@Id
	@GenericGenerator(name = "myGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
	@GeneratedValue(generator = "myGenerator")
	@Column(name = "f_personId", nullable = false, unique = true)
	private Integer personId;

	@Column(name = "f_city", nullable = false)
	private String city;

	@Column(name = "f_province", nullable = false)
	private String province;

	@OneToOne(mappedBy = "address")
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public static Address getAddress() {
		Address res = new Address();
		res.setCity("Shahr-e-rey");
		res.setProvince("Tehran");
		return res;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
