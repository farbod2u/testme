package saeed.hibernate.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "t_student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8726422285681460382L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "f_name", length = 150, nullable = false)
	private String name;

	@Column(name = "f_age")
	private Float age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getAge() {
		return age;
	}

	public void setAge(Float age) {
		this.age = age;
	}

	@OneToMany(targetEntity = Mark.class, mappedBy = "student", cascade = CascadeType.ALL)
	private Set<Mark> marks;

	public Set<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

}
