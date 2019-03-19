package com.lms.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name = "book")
public class BookBean extends Beans implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "book_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	@Column (name = "content")
	private String content;
	
	@Column (name =  "title")
	private String title;
	
	@Column (name = "author")
	private String author;
	
	@Column (name = "quantity")
	private Integer quantity;
	
	@Column (name = "max_borrow")
	private Integer borrow;
	
	@Column (name = "picture")
	private String picture;
	
	@OneToMany (mappedBy = "bookBean")
	private Set<BookReserved> bookReserveds;
	
	public BookBean() {
		
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getBorrow() {
		return borrow;
	}

	public void setBorrow(Integer borrow) {
		this.borrow = borrow;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "BookBean [bookId=" + bookId + ", content=" + content + ", title=" + title + ", author=" + author
				+ ", quantity=" + quantity + ", borrow=" + borrow + ", picture=" + picture + "]";
	}	
}
