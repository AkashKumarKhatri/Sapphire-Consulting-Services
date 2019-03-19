package com.lms.transformer;

import com.lms.beans.BookReserved;
import com.lms.dto.BookReservedDTO;

public class BookReservedTransformer {
	public static BookReservedDTO transform(BookReserved bookReserved) {
		BookReservedDTO reservedDTO = new BookReservedDTO();
		
		if (bookReserved.getBookReserveId() != null) {
			reservedDTO.setBookReserveId(bookReserved.getBookReserveId().toString());
		}
		
		if (bookReserved.getBookReturn() != null) {
			reservedDTO.setReturnDate(bookReserved.getReturnDate().toString());
		}
		
		if (bookReserved.getReserveDate() != null) {
			reservedDTO.setReserveDate(bookReserved.getReserveDate().toString());
		}
		
		if (bookReserved.getWarnings() != null) {
			reservedDTO.setWarnings(bookReserved.getWarnings().toString());
		}
		
		return reservedDTO;
	}
}
