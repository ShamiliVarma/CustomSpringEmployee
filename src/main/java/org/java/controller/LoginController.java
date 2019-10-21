package org.java.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String login() {
		System.out.println("In LoginController :: login ");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		System.out.println("In LoginController :: logout ");
		request.getSession().invalidate();
		return "redirect:/login?logout=true";
	}
	/*
	 * @RequestMapping(value="/logout", method = RequestMethod.GET) public String
	 * logoutPage (HttpServletRequest request, HttpServletResponse response) {
	 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 * if (auth != null){ new SecurityContextLogoutHandler().logout(request,
	 * response, auth); } return "redirect:/login?logout=true"; }
	 */

	
	
}
