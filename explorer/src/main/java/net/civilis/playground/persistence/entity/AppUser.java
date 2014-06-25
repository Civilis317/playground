package net.civilis.playground.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity()
@Table(name = "jaas.users")
public class AppUser {
	@Id
	@Column (name="user_name")
	private String username;
	
	@Column (name="user_pass")
	private String password;

	@OneToOne(mappedBy="appUser", cascade=CascadeType.ALL)
	private UserDetail userDetail;

	// getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}
