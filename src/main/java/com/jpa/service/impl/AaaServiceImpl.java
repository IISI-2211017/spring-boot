package com.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Aaa;
import com.jpa.repository.TestRepository;
import com.jpa.service.AaaService;
@Service
public class AaaServiceImpl implements AaaService{
	
	@Autowired
	private TestRepository testRepository;
	
	@Override
	public String insert(Aaa aaa) {
		testRepository.save(aaa);
		return "新增成功";
	}

	@Override
	public String update(Aaa aaa) {
		testRepository.save(aaa);
		return "儲存成功";
	}

	@Override
	public String delete(String a) {
		testRepository.deleteById(a);
		return "刪除成功";
	}

	@Override
	public List<Aaa> query() {
		return testRepository.findAll();
	}

}
