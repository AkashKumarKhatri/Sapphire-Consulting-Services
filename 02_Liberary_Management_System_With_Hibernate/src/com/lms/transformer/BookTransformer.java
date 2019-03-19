package com.lms.transformer;

import com.lms.beans.BookBean;
import com.lms.dto.BookDTO;

public class BookTransformer {
	
	public static BookDTO transform(BookBean bookBean) {
		BookDTO bookDTO = new BookDTO();
		
		if (bookBean.getBookId() != null) {
			bookDTO.setBookId(bookBean.getBookId().toString());
		}
		
		if (bookBean.getTitle() != null) {
			bookDTO.setTitle(bookBean.getTitle());
		}
		
		if (bookBean.getAuthor() != null) {
			bookDTO.setAuthor(bookBean.getAuthor());
		}
		
		if (bookBean.getBorrow() != null) {
			bookDTO.setBorrow(bookBean.getBorrow().toString());
		}
		
		if (bookBean.getContent() != null) {
			bookDTO.setContent(bookBean.getContent());
		}
		
		if (bookBean.getPicture() != null) {
			bookDTO.setPicture(bookBean.getPicture());
		}
		
		if (bookBean.getQuantity() != null) {
			bookDTO.setQuantity(bookBean.getQuantity().toString());
		}
		
		return bookDTO;
	}
}
