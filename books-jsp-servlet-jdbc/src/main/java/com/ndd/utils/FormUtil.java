package com.ndd.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
		T object = null;

		try {
			object = clazz.getDeclaredConstructor().newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException | InstantiationException | IllegalArgumentException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		return object;
	}
}
