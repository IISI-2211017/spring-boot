package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AaabDao;
import com.example.model.Aaab;
import com.example.service.AaabService;

@Service
public class AaabServiceImpl implements AaabService{
	
	@Autowired
	private AaabDao aaaDao;
	
	@Override
	public String insertAaa(int a, int b) {
		return aaaDao.insertAaa(a, b);
	}

	@Override
	public String deleteAaa(int a, int b) {
		return aaaDao.deleteAaa(a, b);
		
	}

	@Override
	public String updateAaa(int a, int b) {
		return aaaDao.updateAaa(a, b);
		
	}

	@Override
	public Aaab queryAaa(int a, int b) {
		return aaaDao.queryAaa(a, b);
	}
}
