package ir.saeed.multi.model;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "t_User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2989207689400465338L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_Id")
	private Integer id;

	@Column(name = "t_UserName", nullable = false)
	private String userName;

	@Column(name = "t_Password", nullable = false)
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
