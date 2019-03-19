package com.lms.dto;

import java.io.Serializable;

public class BookReservedDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String bookReserveId;
	private String warnings;
	private String reserveDate;
	private String returnDate;
	private String bookReturn;
	private String active;
	private BookDTO bookBean;
	private SuscriberDTO suscriberBean;
	
	public String getBookReserveId() {
		return bookReserveId;
	}
	public void setBookReserveId(String bookReserveId) {
		this.bookReserveId = bookReserveId;
	}
	public String getWarnings() {
		return warnings;
	}
	public void setWarnings(String warnings) {
		this.warnings = warnings;
	}
	public String getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getBookReturn() {
		return bookReturn;
	}
	public void setBookReturn(String bookReturn) {
		this.bookReturn = bookReturn;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public BookDTO getBookBean() {
		return bookBean;
	}
	public void setBookBean(BookDTO bookBean) {
		this.bookBean = bookBean;
	}
	public SuscriberDTO getSuscriberBean() {
		return suscriberBean;
	}
	public void setSuscriberBean(SuscriberDTO suscriberBean) {
		this.suscriberBean = suscriberBean;
	}
}
