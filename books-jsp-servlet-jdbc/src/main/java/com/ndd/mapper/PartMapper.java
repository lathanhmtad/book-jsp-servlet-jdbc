package com.ndd.mapper;

import java.io.IOException;

import javax.servlet.http.Part;

public interface PartMapper<T> {
	T mapPart(Part part) throws IOException;
}
