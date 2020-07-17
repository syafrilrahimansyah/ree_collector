package com.tselree.collector.DAO;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CollectDAOimpl implements CollectDAO{
	private JdbcTemplate jdbcTemplate;
	 
	public CollectDAOimpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public String getOmniform(String id) {
		// TODO Auto-generated method stub
		String sql = "SELECT payload FROM omniform WHERE omniform_id = '"+id+"'";
		return jdbcTemplate.queryForObject(sql, String.class);
	}

}
