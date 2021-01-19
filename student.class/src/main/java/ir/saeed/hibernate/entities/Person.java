package ir.saeed.hibernate.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "t_person")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 816572099531051356L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "f_firastName", nullable = false, length = 150)
	private String firstName;

	@Column(name = "f_lastName", nullable = false, length = 200)
	private String lastName;

	@Column(name = "f_birthDate", nullable = false)
	private Date birthDate;

	@OneToOne(cascade = CascadeType.ALL)	
	@PrimaryKeyJoinColumn
	//@JoinColumn(name = "f_personId")
	//@MapsId("f_personId")
	private Student student;

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
