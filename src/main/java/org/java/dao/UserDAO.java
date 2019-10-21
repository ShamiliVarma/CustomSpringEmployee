package org.java.dao;

import javax.sql.DataSource;

import org.java.bean.User;
import org.java.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public UserDAO(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public User findByUsername(String username) {
		System.out.println("In UserDAO findByUsername");
		String selectQuery ="select USERNAME, PASSWORD, ENABLED FROM USERS WHERE ENABLED =1 AND USERNAME=?";
		return jdbcTemplate.queryForObject(selectQuery,new Object[] {username}, new
				UserMapper()); }



}