package ir.saeed.crudwithspringboot.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "t_User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7443089446767844365L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_Id")
	private Long id;

	@Column(name = "f_UserName", nullable = false)
	private String userName;

	@Column(name = "f_Password", nullable = false)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
