package org.java.auth;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.java.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthentication implements AuthenticationProvider{

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	
	  @Autowired 
	  HttpServletRequest httpReq;
	 
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String user = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println("In CustomAuthentication :: authenticate :: user "+user);
		
		boolean authSuccess = false;
		
		UserDetails userObject = userDetailsService.loadUserByUsername(user);
		if(user.equals(userObject.getUsername()) && password.equals(userObject.getPassword())) {
			authSuccess = true;
		}
		/*
		 * if((user.equals("DEEP") && password.equals("123456")) ||
		 * (user.equals("MICKEY") && password.equals("123456"))) { authSuccess = true; }
		 */
		
		if(!authSuccess) {
			throw new BadCredentialsException("Incorrect Credentials!!");
		}
		
		List<GrantedAuthority> grantedList = new ArrayList<GrantedAuthority>();
		grantedList.add(new SimpleGrantedAuthority("ROLE_USER"));
		grantedList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		/*
		 * HttpSession session = httpReq.getSession(); session.setAttribute("user",
		 * user);
		 */
		return new UsernamePasswordAuthenticationToken(user, password, grantedList);
		
	}

	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
