package com.gng.gngbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name="user_id", length = 45)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;

	@Column(name="username", length = 255)
	private String username;

	@Column(name="email", length = 255)
	private String email;

	@Column(name="password", length = 255)
	private String password;

	public User() {
	}

	public User(Long userid, String username, String email, String password) {
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return userid;
	}

	public void setId(Long id) {
		this.userid = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}