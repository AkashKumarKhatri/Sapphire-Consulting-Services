package com.lms.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "suscriber")
public class SuscriberBean extends Beans implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "suscriber_id")
	private Integer suscriberId;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "contact")
	private String contact;
	
	@Column (name = "address")
	private String address;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "qouta")
	private Integer quota;
	
	@Column (name = "approval_status")
	private String approvalStatus = "NOT APPROVED";
	
	@Column (name = "status")
	private String status = "NOT BANNED";
	
	@OneToMany (mappedBy = "suscriberBean")
	private Set<BookReserved> bookReserveds;
	
	public SuscriberBean() {
	
	}

	public Integer getSuscriberId() {
		return suscriberId;
	}

	public void setSuscriberId(Integer suscriberId) {
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

	public Integer getQuota() {
		return quota;
	}

	public void setQuota(Integer quota) {
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

	@Override
	public String toString() {
		return "SuscriberBean [suscriberId=" + suscriberId + ", name=" + name
				+ ", contact=" + contact + ", address=" + address + ", email="
				+ email + ", password=" + password + ", quota=" + quota
				+ ", approvalStatus=" + approvalStatus + ", status=" + status
				+ "]";
	}

	
	
}
