package com.ndd.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.zip.DataFormatException;

import com.ndd.dto.BookImageDTO;
import com.ndd.model.BookImageModel;
import com.ndd.utils.ImageUtil;

public class BookImageConverter {
	public static BookImageModel toModel(BookImageDTO dto) {
		BookImageModel result = new BookImageModel();
		
		result.setName(dto.getName());
		result.setFormat(dto.getType());
		try {
			result.setImgData(ImageUtil.compressImage(dto.getImageData()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.setCreatedBy(dto.getCreatedBy());
		
		return result;
	}
	
	public static List<BookImageModel> toListModel(List<BookImageDTO> listDTO) {
		List<BookImageModel> results = new ArrayList<>();
		
		for (BookImageDTO item : listDTO) {
			results.add(toModel(item));
		}
		return null;
	}
	
	public static BookImageDTO toDTO(BookImageModel model) {
		BookImageDTO result = new BookImageDTO();
		
		result.setId(model.getId());
		result.setType(model.getFormat());
		result.setName(model.getName());
		result.setCreatedDate(model.getCreatedDate());
		result.setCreatedBy(model.getCreatedBy());
		byte[] dataImg = null;
		try {
			dataImg = ImageUtil.decompressImage(model.getImgData());
		} catch (IOException | DataFormatException e) {
			e.printStackTrace();
		}
		String base64Img = Base64.getEncoder().encodeToString(dataImg);
		result.setBase64Image(base64Img);
		
		return result;
	}
	
	
	public static List<BookImageDTO> toListDTO(List<BookImageModel> listModel) {
		List<BookImageDTO> result = new ArrayList<>();
		for (BookImageModel model : listModel) {
			result.add(toDTO(model));
		}
		return result;
		
	}
} 
