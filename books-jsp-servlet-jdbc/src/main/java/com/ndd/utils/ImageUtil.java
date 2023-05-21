package com.ndd.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtil {

	public static byte[] compressImage(byte[] data) throws IOException {
	    Deflater deflater = new Deflater();
	    deflater.setLevel(Deflater.BEST_COMPRESSION);
	    deflater.setInput(data);
	    deflater.finish();

	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	    byte[] tmp = new byte[4*1024];
	    while (!deflater.finished()) {
	        int size = deflater.deflate(tmp);
	        outputStream.write(tmp, 0, size);
	    }
	    outputStream.close();
	    return outputStream.toByteArray();
	}

	public static byte[] decompressImage(byte[] data) throws IOException, DataFormatException {
	    Inflater inflater = new Inflater();
	    inflater.setInput(data);
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	    byte[] tmp = new byte[4*1024];
	    while (!inflater.finished()) {
	        int count = inflater.inflate(tmp);
	        outputStream.write(tmp, 0, count);
	    }
	    outputStream.close();
	    return outputStream.toByteArray();
	}


}