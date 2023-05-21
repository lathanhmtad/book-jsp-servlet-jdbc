package com.ndd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndd.constants.SystemConstants;
import com.ndd.model.UserModel;
import com.ndd.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String uri = request.getRequestURI();
		if(uri.contains("/admin")) {
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			if(userModel != null) {
				if(userModel.getRole().getCode().equals(SystemConstants.ADMIN)) {
					chain.doFilter(servletRequest, servletResponse);
				}
				else if(userModel.getRole().getCode().equals(SystemConstants.USER)) {
					response.sendRedirect(request.getContextPath() + "/auth?action=login&message=not_permission&alert=danger");
				}
			}
			else {
				response.sendRedirect(request.getContextPath() + "/auth?action=login&message=not_login&alert=danger");
			}
		} 
		else {
			chain.doFilter(servletRequest, servletResponse);
		}
		chain.doFilter(servletRequest, servletResponse);
	}

	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}

}
