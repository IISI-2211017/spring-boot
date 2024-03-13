package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class AaabRowMapper implements RowMapper<Aaab> {

	@Override
	public Aaab mapRow(ResultSet rs, int rowNum) throws SQLException {
		String a = rs.getString("A");
		String b = rs.getString("B");
		Aaab aaa = new Aaab(a, b);
		return aaa;
	}

}
