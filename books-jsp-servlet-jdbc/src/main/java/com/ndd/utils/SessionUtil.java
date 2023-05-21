package com.ndd.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	
	private static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		return sessionUtil == null ? new SessionUtil() : sessionUtil;
	}
	
	public void putValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
}
