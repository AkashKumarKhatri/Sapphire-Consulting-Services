package com.lms.dto;

import java.util.List;

public class CommonDTO {
	
	private DTO dto;
	private BookDTO bookDTO;
	private SuscriberDTO suscriberDTO;
	private BookReservedDTO bookReservedDTO;
	private UserDTO userDTO;
	
	private List<DTO> dtos;
	private List<BookDTO> bookDTOs;
	private List<SuscriberDTO> suscriberDTOs;
	private List<BookReservedDTO> reservedDTOs;
	private List<UserDTO> userDTOs;
	
	public DTO getDto() {
		return dto;
	}
	public void setDto(DTO dto) {
		this.dto = dto;
	}
	public BookDTO getBookDTO() {
		return bookDTO;
	}
	public void setBookDTO(BookDTO bookDTO) {
		this.bookDTO = bookDTO;
	}
	public SuscriberDTO getSuscriberDTO() {
		return suscriberDTO;
	}
	public void setSuscriberDTO(SuscriberDTO suscriberDTO) {
		this.suscriberDTO = suscriberDTO;
	}
	public BookReservedDTO getBookReservedDTO() {
		return bookReservedDTO;
	}
	public void setBookReservedDTO(BookReservedDTO bookReservedDTO) {
		this.bookReservedDTO = bookReservedDTO;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	public List<DTO> getDtos() {
		return dtos;
	}
	public void setDtos(List<DTO> dtos) {
		this.dtos = dtos;
	}
	public List<BookDTO> getBookDTOs() {
		return bookDTOs;
	}
	public void setBookDTOs(List<BookDTO> bookDTOs) {
		this.bookDTOs = bookDTOs;
	}
	public List<SuscriberDTO> getSuscriberDTOs() {
		return suscriberDTOs;
	}
	public void setSuscriberDTOs(List<SuscriberDTO> suscriberDTOs) {
		this.suscriberDTOs = suscriberDTOs;
	}
	public List<BookReservedDTO> getReservedDTOs() {
		return reservedDTOs;
	}
	public void setReservedDTOs(List<BookReservedDTO> reservedDTOs) {
		this.reservedDTOs = reservedDTOs;
	}
	public List<UserDTO> getUserDTOs() {
		return userDTOs;
	}
	public void setUserDTOs(List<UserDTO> userDTOs) {
		this.userDTOs = userDTOs;
	}
	
}
