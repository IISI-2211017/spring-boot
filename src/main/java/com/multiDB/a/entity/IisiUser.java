package com.multiDB.a.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "iisi_user")
public class IisiUser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String email;
    private String userName;
    private String password;
    private String authority;
    
    
	public IisiUser(Long id, String email, String userName, String password,String authority) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.authority = authority;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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

	public IisiUser() {
		super();
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
