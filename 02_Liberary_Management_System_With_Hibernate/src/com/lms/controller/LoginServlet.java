package com.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lms.beans.SuscriberBean;
import com.lms.beans.UserBean;
import com.lms.dao.SuscriberDAO;
import com.lms.dao.UserDAO;
import com.lms.dao.impl.SuscriberDAOImpl;
import com.lms.dao.impl.UserDAOImpl;
import com.lms.dto.SuscriberDTO;
import com.lms.transformer.SuscriberTransformer;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
		if (type != null) {
			if (type.equals("agent")) {
				UserDAO userDAO = new UserDAOImpl();
				UserBean userBean = userDAO.getUser(username, password);
				
				Gson gson = new Gson();
				out.print(gson.toJson(userBean));
			}
			else if (type.equals("subscriber")) {
				SuscriberDAO suscriberDAO = new SuscriberDAOImpl();
				SuscriberBean suscriberBean = suscriberDAO.getSuscriber(username, password);
				
				Gson gson = new Gson();
				SuscriberDTO suscriberDTO = SuscriberTransformer.transform(suscriberBean);
				out.println(gson.toJson(suscriberDTO));
			}
		}
		
		
	}
}
