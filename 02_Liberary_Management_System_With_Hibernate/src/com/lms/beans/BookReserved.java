package com.lms.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "book_reserved")
public class BookReserved implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "book_reserve_id")
	private Integer bookReserveId;
	
	@Column (name = "warnings")
	private Integer warnings;
	
	@Column (name = "reserve_date")
	private Timestamp reserveDate;
	
	@Column (name = "return_date")
	private Timestamp returnDate;
	
	@Column (name = "book_return")
	private String bookReturn;
	
	@Column (name = "active")
	private Integer active = 1;
	
	@ManyToOne
	@JoinColumn (name = "fk_book_id")
	private BookBean bookBean;
	
	@ManyToOne
	@JoinColumn (name = "fk_suscriber_id")
	private SuscriberBean suscriberBean;
	
	public BookReserved() {
	
	}

	public Integer getWarnings() {
		return warnings;
	}

	public void setWarnings(Integer warnings) {
		this.warnings = warnings;
	}

	public BookBean getBookBean() {
		return bookBean;
	}

	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}

	public SuscriberBean getSuscriberBean() {
		return suscriberBean;
	}

	public void setSuscriberBean(SuscriberBean suscriberBean) {
		this.suscriberBean = suscriberBean;
	}

	public Integer getBookReserveId() {
		return bookReserveId;
	}

	public void setBookReserveId(Integer bookReserveId) {
		this.bookReserveId = bookReserveId;
	}

	public Timestamp getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Timestamp reserveDate) {
		this.reserveDate = reserveDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public String getBookReturn() {
		return bookReturn;
	}

	public void setBookReturn(String bookReturn) {
		this.bookReturn = bookReturn;
	}

	@Override
	public String toString() {
		return "BookReserved [bookReserveId=" + bookReserveId + ", warnings=" + warnings + ", reserveDate="
				+ reserveDate + ", returnDate=" + returnDate + ", bookReturn=" + bookReturn + ", bookBean=" + bookBean
				+ ", suscriberBean=" + suscriberBean + "]";
	}

}
