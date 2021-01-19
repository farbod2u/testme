package ir.saeed.hibernate.crud.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "t_Student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8065464661554330232L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
	private Integer id;

	@Column(name = "f_name", nullable = false, length = 200)
	private String name;

	@Column(name = "f_course", length = 500)
	private String course;

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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Id = " + this.id.toString() +
			   ", Name = " + this.name +
			   ", Course = " + this.course;
	}

}
