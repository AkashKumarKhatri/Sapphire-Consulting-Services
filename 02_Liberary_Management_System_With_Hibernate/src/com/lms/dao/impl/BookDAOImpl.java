package com.lms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lms.beans.BookBean;
import com.lms.dao.BookDAO;
import com.lms.dao.connection.DBManager;
import com.lms.util.Constants;

public class BookDAOImpl implements BookDAO {
	
	private SessionFactory factory = DBManager.getConnection();
	private Session session;
	
	@Override
	public Integer save(BookBean bookBean) {
		session = factory.openSession();
		session.beginTransaction();
		session.save(bookBean);
		session.getTransaction().commit();
		session.close();
		return 1;
	}

	@Override
	public Integer update(BookBean bookBean) {
		int row = 0;
		session = factory.openSession();
		session.beginTransaction();
		//String hql = "update BookBean b set b.title = ?, b.author = ?, b.content = ?, b.quantity = ?, b.borrow = ?, b.modified_by = ?, b.modified_date = ?, b.picture = ? where b.bookId = ?";
		session.update(bookBean);
		session.getTransaction().commit();
		session.close();
		return row;
	}
	@Override
	public Integer delete(BookBean bookBean) {
		int row = 0;
		session = factory.openSession();
		session.beginTransaction();
		String hql = "update BookBean b set b.active = 0 where b.bookId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, bookBean.getBookId());
		row = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return row;
	}

	@Override
	public List<BookBean> getAllBooks() {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "from BookBean where active = 1";
		Query query = session.createQuery(hql);
		List<BookBean> booksList = query.list();
		session.getTransaction().commit();
		session.close();
		return booksList;
	}

	@Override
	public BookBean getBookById(Integer bookId) {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "from BookBean b where b.bookId = ? and b.active = 1";
		Query query = session.createQuery(hql);
		query.setParameter(0, bookId);
		BookBean bookBean = (BookBean) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return bookBean;
	}

	@Override
	public BookBean getAvailableBookCopies(Integer bookId) {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "select b.quantity from BookBean b where b.bookId = ? and b.active = 1";
		Query query = session.createQuery(hql);
		query.setParameter(0, bookId);
		BookBean bookBean = (BookBean) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return bookBean;
	}

	@Override
	public Integer updateCopies(Integer bookId) {
		int row = 0;
		session = factory.openSession();
		session.beginTransaction();
		String hql = "update BookBean b set b.quantity = b.quantity - 1 where b.bookId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, bookId);
		row = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return row;
	}

	@Override
	public BookBean getMaxBorrowPeriod(Integer bookId) {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "select b.borrow from BookBean b where b.bookId = ? and b.active = 1";
		Query query = session.createQuery(hql);
		query.setParameter(0, bookId);
		BookBean bookBean = (BookBean) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return bookBean;
	}
}