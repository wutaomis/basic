package config.sql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import mysql.dao.Tstrfv2Dao;
import mysql.imp.Tstrfv2Imp;

@Configuration
public class MysqlConfig {
	@Bean
	public Tstrfv2Dao tstrfv2Dao(JdbcTemplate jdbcTemplate)
	{
		return new Tstrfv2Imp(jdbcTemplate);
	}
}
