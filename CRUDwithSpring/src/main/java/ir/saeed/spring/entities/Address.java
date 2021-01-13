package ir.saeed.spring.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "t_address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2594878157192936299L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "f_city", nullable = false)
	private String city;

	@Column(name = "f_province", nullable = false)
	private String province;

	@OneToOne
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
