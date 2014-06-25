package net.civilis.playground.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity()
@Table(name = "jaas.user_details")
public class UserDetail {
	@Id
	@Column (name="user_name")
	private String username;

	@Column (name="display_name")
	private String displayName;

	@OneToOne
    @PrimaryKeyJoinColumn
	private AppUser appUser;
	
	// getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}
