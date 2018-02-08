package com.asyf.manager.common.shiro;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthorizingRealm;
import org.springframework.stereotype.Service;

/**
 * 表单验证
 * 
 * @author Thomas_yang
 *
 */
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

	private static Logger logger = Logger.getLogger(AuthorizingRealm.class);

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		logger.info("创建token");
		System.out.println("token----------");
		String username = getUsername(request);
		String password = getPassword(request);
		if (username != null && password != null) {
			logger.info("创建token---" + username + "---" + password);
			return new UsernamePasswordToken(username, password.toCharArray());
		} else {
			return null;
		}
	}

}