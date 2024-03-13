package com.example.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.AaabDao;
import com.example.model.Aaab;
import com.example.model.AaabRowMapper;


@Repository
public class AaabDaoImpl implements AaabDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired 
	private AaabRowMapper aaaRowMapper;
	
	@Autowired Aaab aaa;
	
	@Override
	public String insertAaa(int a, int b) {
		String sql = "INSERT INTO aaa (a,b) VALUES (:a,:b)";
		Map<String, Object> map = new HashMap<>();
		map.put("a",String.valueOf(a));
		map.put("b",String.valueOf(b));
		namedParameterJdbcTemplate.update(sql, map);
		return "新增成功"+a+","+b;
	}

	@Override
	public String deleteAaa(int a, int b) {
		String sql = "DELETE aaa WHERE a=:a and b=:b";
		Map<String, Object> map = new HashMap<>();
		map.put("a",String.valueOf(a));
		map.put("b",String.valueOf(b));
		namedParameterJdbcTemplate.update(sql, map);
		return "刪除成功";
		
	}

	@Override
	public String updateAaa(int a, int b) {
		String sql = "UPDATE aaa set b='999' WHERE a=:a and b=:b";
		Map<String, Object> map = new HashMap<>();
		map.put("a",String.valueOf(a));
		map.put("b",String.valueOf(b));
		namedParameterJdbcTemplate.update(sql, map);
		return "更新成功";
	}

	@Override
	public Aaab queryAaa(int a, int b) {
		String sql = "select * from aaa WHERE a=:a or b =:b";
		Map<String, Object> map = new HashMap<>();
		map.put("a",String.valueOf(a));
		map.put("b",String.valueOf(b));
//		List<Aaab> la = namedParameterJdbcTemplate.query(sql, map, aaaRowMapper);
//		return la.get(0); 
		Aaab ab =namedParameterJdbcTemplate.queryForObject(sql, map, aaaRowMapper);
		return ab;
	}
}
