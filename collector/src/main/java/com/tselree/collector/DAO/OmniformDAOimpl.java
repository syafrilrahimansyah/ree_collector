package com.tselree.collector.DAO;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class OmniformDAOimpl implements OmniformDAO{
	private JdbcTemplate jdbcTemplate;
	 
	public OmniformDAOimpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void addOmniform(String id, String payload) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO omniform(id,payload,stage) VALUES('"+id+"','"+payload+"','col')";
		jdbcTemplate.update(sql);
	}
	@Override
	public void updOmniform(String id, String payload) {
		// TODO Auto-generated method stub
		String sql = "UPDATE omniform SET payload = '"+payload+"', stage = 'col' WHERE id = '"+id+"'";
		jdbcTemplate.update(sql);		
	}
	@Override
	public String checkOmniform(String id) {
		// TODO Auto-generated method stub
		try {
		String sql = "SELECT id FROM omniform WHERE id = '"+id+"'";
		return jdbcTemplate.queryForObject(sql, String.class);
		}
		catch (EmptyResultDataAccessException e) {
			  
			   return "";
		}
	}

}
