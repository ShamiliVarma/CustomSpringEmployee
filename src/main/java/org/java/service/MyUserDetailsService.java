package org.java.service;

import org.java.auth.MyUserPrincipal;
import org.java.bean.User;
import org.java.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDAO userDAO;

	
	  public UserDetails loadUserByUsername(String username) throws
	  UsernameNotFoundException { User user = userDAO.findByUsername(username); if
	  (user == null) { throw new UsernameNotFoundException(username); } return new
	  MyUserPrincipal(user); }
	 

}
