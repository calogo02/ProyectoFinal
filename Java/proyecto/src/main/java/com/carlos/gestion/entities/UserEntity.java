package com.carlos.gestion.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private Integer enabled;

	public UserEntity(String username, String password, Integer enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	

	public UserEntity() {
		super();
	}


	public UserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

}
