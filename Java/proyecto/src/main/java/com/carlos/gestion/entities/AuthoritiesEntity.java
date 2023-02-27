package com.carlos.gestion.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class AuthoritiesEntity {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "authority")
	private String authority;

	public AuthoritiesEntity(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}

	public AuthoritiesEntity() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
