package com.lms.dao;

import java.util.List;

import com.lms.beans.SuscriberBean;

public interface SuscriberDAO {
	Integer save(SuscriberBean suscriberBean);
	Integer update(SuscriberBean suscriberBean);
	Integer delete(SuscriberBean suscriberBean);
	List<SuscriberBean> getAllSuscribers();
	SuscriberBean getSuscriber(String username, String password);
	SuscriberBean getSuscriberById(Integer suscriberId);
	SuscriberBean getSubsciberByName(String name);
	List<SuscriberBean> getPendingRequests();
	List<SuscriberBean> getWarningSubscriber();
	Integer acceptRequest(Integer subscriberId);
	Integer bannedSubscriber(Integer subscriberId);
	SuscriberBean checkQuota(Integer subsId);
	Integer assginQouta(Integer qouta, Integer subsId);
	Integer updateQouta(Integer subsId);
	
}
