package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Aaab;
import com.example.service.AaabService;

@RestController
public class AaabController {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private AaabService aaaService;
	
	@RequestMapping("/test")
	public String test() {
		System.out.print("測試");
		String sql = "INSERT INTO aaa(a, b) VALUES ('100', '100')";
//		String sql = "CREATE TABLE aaa (\r\n"
//				+ "    a VARCHAR2(50),\r\n"
//				+ "    b VARCHAR2(50)\r\n"
//				+ ")";
		Map<String, Object> map = new HashMap<>();
		namedParameterJdbcTemplate.update(sql, map);
		return "執行SQL";
	}
	
	
	@RequestMapping("/insert")
	public String insert(@RequestBody Aaab aaa) {
		return aaaService.insertAaa(Integer.parseInt(aaa.getA()), Integer.parseInt(aaa.getB()));
	}	
	
	@RequestMapping("/delete")
	public String delete(@RequestBody Aaab aaa) {
		return aaaService.deleteAaa(Integer.parseInt(aaa.getA()), Integer.parseInt(aaa.getB()));
	}
	
	@RequestMapping("/update")
	public String update(@RequestBody Aaab aaa) {
		return aaaService.updateAaa(Integer.parseInt(aaa.getA()), Integer.parseInt(aaa.getB()));
	}
	
	@RequestMapping("/query")
	public Aaab query(@RequestBody Aaab aaa) {
		Aaab aa =aaaService.queryAaa(Integer.parseInt(aaa.getA()), Integer.parseInt(aaa.getB()));
//		return "查詢成功" + "["+aa.getA()+","+aa.getB() + "]" ;
		return aa;
	}
}


