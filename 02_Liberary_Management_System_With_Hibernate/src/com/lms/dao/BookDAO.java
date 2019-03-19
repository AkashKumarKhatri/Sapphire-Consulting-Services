package com.lms.dao;

import java.util.List;

import com.lms.beans.BookBean;

public interface BookDAO {
	Integer save(BookBean bookBean);
	Integer update(BookBean bookBean);
	Integer delete(BookBean bookBean);
	List<BookBean> getAllBooks();
	BookBean getBookById(Integer bookId);
	BookBean getAvailableBookCopies(Integer bookId);
	Integer updateCopies(Integer bookCopies);
	BookBean getMaxBorrowPeriod(Integer bookId);
}
