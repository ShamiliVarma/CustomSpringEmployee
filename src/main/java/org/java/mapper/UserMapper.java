package org.java.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.java.bean.User;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEnabled(rs.getInt("enabled"));
		return user;
	}

}
