package com.lms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lms.beans.SuscriberBean;
import com.lms.dao.SuscriberDAO;
import com.lms.dao.connection.DBManager;

public class SuscriberDAOImpl implements SuscriberDAO {

	private SessionFactory factory = DBManager.getConnection();
	private Session session;
	
	@Override
	public Integer save(SuscriberBean suscriberBean) {
		Integer row = 0;
		session = factory.openSession();
		session.beginTransaction();
		session.save(suscriberBean);
		session.getTransaction().commit();
		session.close();
		return row;
	}
	@Override
	public Integer update(SuscriberBean suscriberBean) {
		Integer row = 0;
		session = factory.openSession();
		session.beginTransaction();
		session.update(suscriberBean);
		session.getTransaction().commit();
		session.close();
		return row;
	}
	
	@Override
	public Integer delete(SuscriberBean suscriberBean) {
		Integer row = 0;
		session = factory.openSession();
		session.beginTransaction();
		String hql = "update SuscriberBean set active = 0 where suscriberId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, suscriberBean.getSuscriberId());
		row = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return row;
	}
	
	@Override
	public List<SuscriberBean> getAllSuscribers() {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from SuscriberBean where action = 1");
		List<SuscriberBean> suscribersList = query.list();
		session.getTransaction().commit();
		session.close();
		return suscribersList;
	}
	
	@Override
	public SuscriberBean getSuscriber(String username, String password) {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "from SuscriberBean where email = ? and password = ? and active = 1 and approvalStatus = 'APPROVED'";
		Query query = session.createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		SuscriberBean suscriberBean = (SuscriberBean) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return suscriberBean;
	}
	
	@Override
	public SuscriberBean getSuscriberById(Integer suscriberId) {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "select * from SuscriberBean where suscriberId = ? and  active = 1";
		Query query = session.createQuery(hql);
		query.setParameter(0, suscriberId);
		SuscriberBean suscriberBean = (SuscriberBean) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return suscriberBean;
	}
	
	@Override
	public List<SuscriberBean> getPendingRequests() {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "FROM SuscriberBean WHERE approvalStatus = 'NOT APPROVED' AND active = 1";
		Query query = session.createQuery(hql);
		List<SuscriberBean> suscribersList = query.list();
		session.getTransaction().commit();
		session.close();
		return suscribersList;
	}
	
	@Override
	public List<SuscriberBean> getWarningSubscriber() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Integer acceptRequest(Integer subscriberId) {
		Integer row = 0;
		session = factory.openSession();
		session.beginTransaction();
		String hql = "update SuscriberBean set approvalStatus = 'APPROVED' where suscriberId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, subscriberId);
		row = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return row;
	}
	
	@Override
	public Integer bannedSubscriber(Integer subscriberId) {
		Integer row = 0;
		session = factory.openSession();
		session.beginTransaction();
		String hql = "update SuscriberBean set status = 'BANNED' where suscriberId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, subscriberId);
		row = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return row;
	}
	
	@Override
	public SuscriberBean getSubsciberByName(String name) {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "from SuscriberBean where email = ? and  active = 1";
		Query query = session.createQuery(hql);
		query.setParameter(0, name);
		SuscriberBean suscriberBean = (SuscriberBean) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return suscriberBean;
	}
	@Override
	public SuscriberBean checkQuota(Integer subsId) {
		session = factory.openSession();
		session.beginTransaction();
		String hql = "select quota from SuscriberBean where suscriberId = ? and active = 1";
		Query query = session.createQuery(hql);
		SuscriberBean suscriberBean = (SuscriberBean) query.setParameter(0, subsId);
		session.getTransaction().commit();
		session.close();
		return suscriberBean;
	}
	@Override
	public Integer assginQouta(Integer qouta, Integer subsId) {
		Integer row = 0;
		session = factory.openSession();
		session.beginTransaction();
		String hql = "update SuscriberBean set quota = ? where suscriberId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, qouta);
		query.setParameter(1, subsId);
		row = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return row;
	}
	@Override
	public Integer updateQouta(Integer subsId) {
		Integer row = 0;
		session = factory.openSession();
		session.beginTransaction();
		String hql = "update SuscriberBean set quota = quota - 1 where suscriberId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, subsId);
		row = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return row;
	}
}
