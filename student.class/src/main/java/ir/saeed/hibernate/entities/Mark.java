package ir.saeed.hibernate.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "t_mark")
public class Mark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4084180168945047908L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "f_value")
	private Float value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	@ManyToOne
	@JoinColumn(name = "f_studentId")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
