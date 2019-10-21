package org.java.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.java.bean.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserPrincipal implements UserDetails{

	private User user;
	public MyUserPrincipal(User user){
		this.user = user;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedList = new ArrayList<GrantedAuthority>();
		grantedList.add(new SimpleGrantedAuthority("ROLE_USER"));
		grantedList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return grantedList;
	}
	public String getPassword() {
		return user.getPassword();
	}
	public boolean isAccountNonExpired() {
		return false;
	}

	public boolean isAccountNonLocked() {
		return false;
	}

	public boolean isCredentialsNonExpired() {
		return false;
	}

	public boolean isEnabled() {
		return (user.getEnabled()==1)? true : false;
	}
	public String getUsername() {
		return user.getUsername();
	}

}
