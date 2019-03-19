package com.lms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lms.beans.UserBean;
import com.lms.dao.UserDAO;
import com.lms.dao.connection.DBManager;

public class UserDAOImpl implements UserDAO {

	private SessionFactory factory = DBManager.getConnection();
	private Session session;
	
	@Override
	public Integer save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBean> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UserBean getUser(String userName, String userPassword) {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "from UserBean ub where ub.username = ? and ub.password = ? and ub.active = 1";
		Query query = session.createQuery(hql);
		query.setParameter(0, userName);
		query.setParameter(1, userPassword);
		UserBean userBean = (UserBean) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return userBean;
	}
	
	/*public static void main(String[] args) {
		UserDAO daoImpl = new UserDAOImpl();
		UserBean userBean = daoImpl.getUser("aakash.khatri@sapphire.co", "1234");
		System.out.println(userBean.getUsername());
		System.out.println(userBean.getPassword());
	}*/

	@Override
	public UserBean getUserByName(String username) {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "from UserBean ub where ub.username = ? and ub.active = 1";
		Query query = session.createQuery(hql);
		query.setParameter(0, username);
		UserBean userBean = (UserBean) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return userBean;
	}
}
