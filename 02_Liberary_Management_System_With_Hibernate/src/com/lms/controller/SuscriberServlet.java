package com.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lms.beans.SuscriberBean;
import com.lms.dao.BookDAO;
import com.lms.dao.SuscriberDAO;
import com.lms.dao.impl.BookDAOImpl;
import com.lms.dao.impl.SuscriberDAOImpl;
import com.lms.dto.SuscriberDTO;
import com.lms.transformer.SuscriberTransformer;

@WebServlet("/SuscriberServlet")
public class SuscriberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String refresh = request.getParameter("refresh");
		if(refresh.equals("request")) {
			out.write(getRequest(response));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String subscriberId = request.getParameter("subscriberId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		String qouta = request.getParameter("qouta");
		String action = request.getParameter("action");
		
		if(name != null && email != null && password != null && contact != null && address != null) {
			if(action.equals("add")) {
				SuscriberBean suscriber = new SuscriberBean();
				SuscriberDAO suscriberDAO = new SuscriberDAOImpl();
				suscriber.setName(name);
				suscriber.setEmail(email);
				suscriber.setContact(contact);
				suscriber.setAddress(address);
				suscriber.setPassword(password);
				int row = suscriberDAO.save(suscriber);
				Gson gson = new Gson();
				out.println(gson.toJson(row));
			}
		}
		
		if (action != null) {
			if (action.equals("reject")) {
				SuscriberBean suscriber = new SuscriberBean();
				SuscriberDAO suscriberDAO = new SuscriberDAOImpl();
				suscriber.setSuscriberId(Integer.parseInt(subscriberId));
				int row = suscriberDAO.delete(suscriber);
				out.print(getRequest(response));
			}
			
			else if (action.equals("accept")) {
				SuscriberDAO suscriberDAO = new SuscriberDAOImpl();
				int row = suscriberDAO.acceptRequest(Integer.parseInt(subscriberId));
				out.print(getRequest(response));
			}
			
			else if (action.equals("banned")) {
				SuscriberDAO suscriberDAO = new SuscriberDAOImpl();
				int row = suscriberDAO.bannedSubscriber(Integer.parseInt(subscriberId));
				Gson gSon = new Gson();
				out.println(gSon.toJson(row));
			}
			else if (action.equals("qouta")) {
				SuscriberDAO suscriberDAO = new SuscriberDAOImpl();
				SuscriberBean suscriberBean = suscriberDAO.checkQuota(Integer.parseInt(subscriberId));
				Gson gSon = new Gson();
				SuscriberDTO suscriberDTO = new SuscriberTransformer().transform(suscriberBean);
				out.println(gSon.toJson(suscriberDTO));
			}
		}
	}
	
	public static String getRequest(HttpServletResponse response) throws IOException {
    	SuscriberDAO suscriberDAO = new SuscriberDAOImpl();
	 	Gson gSon = new Gson();
    	response.setContentType("application/json");
    	
    	List<SuscriberBean> suscriberBeans = suscriberDAO.getPendingRequests();
    	List<SuscriberDTO> suscriberDTOs = new ArrayList<>();
    	
    	for (SuscriberBean suscriberBean : suscriberBeans) {
    		SuscriberDTO suscriberDTO = new SuscriberTransformer().transform(suscriberBean);
    		suscriberDTOs.add(suscriberDTO);
    	}
    	
		return gSon.toJson(suscriberDTOs);
	} 
}
