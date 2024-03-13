package com.example.dao;

import com.example.model.Aaab;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AaabDao {
	
	String insertAaa(int a,int b);
	
	String deleteAaa(int a,int b);
	
	String updateAaa(int a,int b);
	
	Aaab queryAaa(int a,int b);
	
}