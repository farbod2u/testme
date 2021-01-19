package ir.saeed.hibernate.crud.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "t_mark")
public class Mark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 263530949318982472L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
	private Long id;

	@Column(name = "f_coursename", length = 1000, nullable = false)
	private String courseName;

	@Column(name = "f_value", nullable = false)
	private Float value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

}
