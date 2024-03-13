package com.example.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;

@Component
public class Aaab {
	
	private String a;
	
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
	
	public Aaab() {
		super();
	}
	
	public Aaab(String a, String b) {
		super();
		this.a = a;
		this.b = b;
	}


}
