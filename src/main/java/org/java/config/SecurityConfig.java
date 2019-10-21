package org.java.config;

import org.java.auth.CustomAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("org.java")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	  @Autowired 
	  private CustomAuthentication authProvider;
	 

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("In :SecurityConfig: configure(AuthenticationManagerBuilder auth)  "); 
		//auth.inMemoryAuthentication().withUser("MICKEY").password("123456").roles("USER");
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("In :SecurityConfig: configure(HttpSecurity http)  "); 
		/*
		 * http.authorizeRequests() .antMatchers("/").permitAll()
		 * .antMatchers("/**").access("hasRole('ROLE_ADMIN')") .and().formLogin();
		 */
		/*
		 * http.authorizeRequests() .antMatchers("/").permitAll()
		 * .antMatchers("/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
		 * .and().formLogin();
		 */
		/*
		 * http.authorizeRequests().anyRequest().authenticated().and()
		 * .formLogin().loginPage("/login").permitAll();
		 */
		/*
		 * http.authorizeRequests().anyRequest().authenticated().and() .formLogin();
		 */
		//Request that matches /** pattern will be authenticated (form based authentication)
		//http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
		
		//Added customogin page
		http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin().loginPage("/login").permitAll();
		http.csrf().disable();
	}
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { System.out.
	 * println("In :SecurityConfig: configure(AuthenticationManagerBuilder auth)  "
	 * ); auth.authenticationProvider(authProvider); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http.authorizeRequests().anyRequest().authenticated() .and().httpBasic();
	 * 
	 * System.out.println("In :SecurityConfig: configure(HttpSecurity http)");
	 * http.authorizeRequests().anyRequest().authenticated()
	 * .and().formLogin().loginPage("/login").permitAll(); }
	 */
}
