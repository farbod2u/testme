package hibernate.annotation.two.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee_annotation")
public class Employee {

	@Id
	@Column(name = "pkId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "FirstName", length = 150, nullable = false)
	private String firstName;

	@Column(name = "LaseName", length = 200, nullable = false)
	private String lastName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

}
