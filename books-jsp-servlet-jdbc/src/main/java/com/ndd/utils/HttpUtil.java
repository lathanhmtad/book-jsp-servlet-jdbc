package com.ndd.utils;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.ndd.mapper.PartMapper;

public class HttpUtil {
	public static <T> T toModel(String json, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(json, clazz);
	}

	public static <T> T toModel(Part part, PartMapper<T> partMapper) {
		T object = null;
		try {
			object = partMapper.mapPart(part);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return object;
	}

	public static <T> List<T> toListModel(Collection<Part> parts, PartMapper<T> partMapper, String partName) {
		List<T> list = parts.stream()
						.filter(part -> partName.equals(part.getName()))
						.map(part -> HttpUtil.toModel(part, partMapper))
						.collect(Collectors.toList());
		return list;
	}

	public static String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
}
