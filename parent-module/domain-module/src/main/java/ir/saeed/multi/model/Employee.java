package ir.saeed.multi.model;

import javax.persistence.*;

@Entity
@Table(name = "t_Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_Id")
	private Integer id;

	@Column(name = "f_Name")
	private String name;

	@Column(name = "f_Message")
	private String message;

	public Employee(int id, String name, String message) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
	}
	
	public Employee() {

	}

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
