package com.lms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lms.beans.BookReserved;
import com.lms.dao.BookReservedDAO;
import com.lms.dao.connection.DBManager;

public class BookReservedDAOImpl implements BookReservedDAO {
	
	private SessionFactory factory = DBManager.getConnection();
	private Session session;

	@Override
	public Integer reserveBook(BookReserved bookReserved) {
		int row = 0;
		session = factory.openSession();
		session.beginTransaction();
		session.save(bookReserved);
		//String hql = "INSERT INTO `book_reserved` (`fk_book_id`, `fk_suscriber_id`, `reserve_date`, `return_date`) VALUES (?,?,?,?)";
		session.getTransaction().commit();
		session.close();
		return row;
	}

	@Override
	public Integer returnBook(BookReserved bookReserved) {
		int row = 0;
		session = factory.openSession();
		session.beginTransaction();
		String hql = "update BookReserved br set br.bookReturn = 'YES', br.active = 0 where br.bookReserveId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, bookReserved.getBookReserveId());
		row = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return row;
	}

	@Override
	public Integer delete(BookReserved bookReserved) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookReserved> getAllReservedBooks() {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "SELECT br FROM BookBean b INNER JOIN b.bookReserveds as br"
				+ " INNER JOIN br.suscriberBean s WHERE br.active = 1 AND "
				+ "br.bookReturn =  'NO'";
		Query query = session.createQuery(hql);
		List<BookReserved> bookReserveds = query.list();
		session.getTransaction().commit();
		session.close();
		return bookReserveds;
	}

	@Override
	public Integer warnSubscriber(Integer reservedId) {
		int row = 0;
		session = factory.openSession();
		session.beginTransaction();
		String hql = "UPDATE BookReserved SET warnings = warnings + 1 WHERE bookReserveId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, reservedId);
		row = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return row;
	}

	@Override
	public List<BookReserved> getReservedTwoDaysBooks() {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "SELECT br FROM BookBean b INNER JOIN b.bookReserveds as br INNER JOIN br.suscriberBean s WHERE br.active = 1 AND "
				+ "DATEDIFF(br.reserveDate, br.returnDate) <= 2 AND br.bookReturn =  'NO' and s.status <> 'BANNED'";
		Query query = session.createQuery(hql);
		List<BookReserved> bookReserveds = query.list();
		session.getTransaction().commit();
		session.close();
		return bookReserveds;
	}

	@Override
	public List<BookReserved> getBannedSubscriber() {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "SELECT br FROM BookBean b INNER JOIN b.bookReserveds as br INNER JOIN br.suscriberBean s WHERE br.active = 1 AND br.bookReturn =  'NO' AND (br.warnings)> 3 AND s.active = 1 AND s.status <> 'BANNED'";
		Query query = session.createQuery(hql);
		List<BookReserved> bannedList = query.list();
		session.getTransaction().commit();
		session.close();
		return bannedList;
	}

	@Override
	public List<BookReserved> getAllBookBySubscriberId(Integer subscriberId) {
		// TODO Auto-generated method stub
		return null;
	}
}
