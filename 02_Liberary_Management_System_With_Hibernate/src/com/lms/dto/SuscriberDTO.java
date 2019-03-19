package com.lms.dto;

import java.io.Serializable;
import java.util.Set;

public class SuscriberDTO extends DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String suscriberId;
	private String name;
	private String contact;
	private String address;
	private String email;
	private String password;
	private String quota;
	private String approvalStatus;
	private String status;
	private Set<BookReservedDTO> bookReserveds;
	
	public String getSuscriberId() {
		return suscriberId;
	}
	public void setSuscriberId(String suscriberId) {
		this.suscriberId = suscriberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<BookReservedDTO> getBookReserveds() {
		return bookReserveds;
	}
	public void setBookReserveds(Set<BookReservedDTO> bookReserveds) {
		this.bookReserveds = bookReserveds;
	}

}
