package mysql.imp;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import mysql.dao.Tstrfv2Dao;

public class Tstrfv2Imp implements Tstrfv2Dao {

	//interface of JdbcTemplate
	private JdbcOperations jdbcOperations;
	public Tstrfv2Imp(JdbcTemplate jdbcTemplate)
	{
		this.jdbcOperations = jdbcTemplate;
	}
	
	@Override
	public List<Map<String, Object>> findALL(String sql) {
		// TODO Auto-generated method stub
		return jdbcOperations.queryForList(sql);
	}

	@Override
	public void execute(String sql) {
		// TODO Auto-generated method stub

	}

}
