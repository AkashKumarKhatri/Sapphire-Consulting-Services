package com.lms.dto;

import java.io.Serializable;
import java.util.Set;

public class BookDTO extends DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String bookId;
	private String content;
	private String title;
	private String author;
	private String quantity;
	private String borrow;
	private String picture;
	private Set<BookReservedDTO> bookReserveds;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getBorrow() {
		return borrow;
	}
	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Set<BookReservedDTO> getBookReserveds() {
		return bookReserveds;
	}
	public void setBookReserveds(Set<BookReservedDTO> bookReserveds) {
		this.bookReserveds = bookReserveds;
	}
}
