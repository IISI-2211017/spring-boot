package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AAA")
public class Aaa {
	@Id
	@Column(name = "a")
	private String a;
	
	@Column(name = "b")
	private String b;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public Aaa() {
		super();
	}

	public Aaa(String a, String b) {
		super();
		this.a = a;
		this.b = b;
	}
}
