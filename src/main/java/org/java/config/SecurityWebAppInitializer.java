package org.java.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

	public SecurityWebAppInitializer() {
		super(SecurityConfig.class);
	}
}
