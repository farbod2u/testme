package ir.saeed.hibernate.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "t_student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8726422285681460382L;

	@Id
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
	@GeneratedValue(generator = "generator")
	@Column(name = "f_personId", unique = true, nullable = false)
	private Integer personId;

	@Column(name = "f_studentNumber", length = 20, nullable = false)
	private String studentNumber;

	@Column(name = "f_entranceYear")
	private Short entranceYear;

	@OneToOne(mappedBy = "student")
//	@JoinColumn(name = "f_personId")
	//@PrimaryKeyJoinColumn
	private Person person;

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Short getEntranceYear() {
		return entranceYear;
	}

	public void setEntranceYear(Short entranceYear) {
		this.entranceYear = entranceYear;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@OneToMany(targetEntity = Mark.class, mappedBy = "student", cascade = CascadeType.ALL)
	private Set<Mark> marks;

	public Set<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

}
