package com.example.dao;

import com.example.model.Aaab;

public interface AaabDao {
	
	String insertAaa(int a,int b);
	
	String deleteAaa(int a,int b);
	
	String updateAaa(int a,int b);
	
	Aaab queryAaa(int a,int b);
	
}