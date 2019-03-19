package com.lms.dao;

import java.util.List;

import com.lms.beans.BookReserved;
import com.lms.beans.SuscriberBean;

public interface BookReservedDAO {
	Integer reserveBook(BookReserved bookReserved);
	Integer returnBook(BookReserved bookReserved);
	Integer delete(BookReserved bookReserved);
	List<BookReserved> getAllReservedBooks();
	Integer warnSubscriber(Integer reservedId);
	List<BookReserved> getReservedTwoDaysBooks();
	List<BookReserved> getBannedSubscriber();
	List<BookReserved> getAllBookBySubscriberId(Integer subscriberId);
}
