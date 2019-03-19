package com.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lms.beans.BookBean;
import com.lms.beans.BookReserved;
import com.lms.beans.SuscriberBean;
import com.lms.dao.BookDAO;
import com.lms.dao.BookReservedDAO;
import com.lms.dao.SuscriberDAO;
import com.lms.dao.impl.BookDAOImpl;
import com.lms.dao.impl.BookReservedDAOImpl;
import com.lms.dao.impl.SuscriberDAOImpl;

@WebServlet("/BookReservedServlet")
public class BookReservedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		/*PrintWriter out = response.getWriter();
		String refresh = request.getParameter("refresh");
		if(refresh.equals("request")) {
			out.write(getReservedBooks(response));
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String action = request.getParameter("action");
		String bookReservedId = request.getParameter("reserverId");
		
		BookReservedDAO reservedDAO = new BookReservedDAOImpl();
		if (action != null) {
			if(action.equals("warn")) {
				int row = reservedDAO.warnSubscriber(Integer.parseInt(bookReservedId));
					/*request.getRequestDispatcher("warning.jsp").forward(request, response);*/
					/*response.sendRedirect("warning.jsp");*/
					Gson gson = new Gson();
					out.println(gson.toJson(row));
			}
			else if (action.equals("reserve")) {
				String bookId = request.getParameter("bId");
				String subsId = request.getParameter("sId");
				BookDAO bookDAO = new BookDAOImpl();
				SuscriberDAO suscriberDAO = new SuscriberDAOImpl();
				
				BookBean bookBean = bookDAO.getMaxBorrowPeriod(Integer.parseInt(bookId));
				
				Date reserveDate = new Date();
        		Date returnDate = new Date();
        		Calendar c = Calendar.getInstance(); 
        		c.setTime(returnDate); 
        		c.add(Calendar.DATE, bookBean.getBorrow());
        		//returnDate = c.getTime();
        		
        		bookBean.setBookId(Integer.parseInt(bookId));
        		SuscriberBean suscriberBean = new SuscriberBean();
        		suscriberBean.setSuscriberId(Integer.parseInt(subsId));
        		BookReserved bookReserved = new BookReserved();
        		bookReserved.setBookBean(bookBean);
        		bookReserved.setSuscriberBean(suscriberBean);
        		bookReserved.setBookReturn(new Timestamp(c.getTimeInMillis()).toLocaleString());
        		bookReserved.setReserveDate(new Timestamp(new Date().getTime()));
        		int row = reservedDAO.reserveBook(bookReserved);
        		if (row > 0) {
					int copyRow = bookDAO.updateCopies(Integer.parseInt(bookId));
					if (copyRow > 0)
						System.out.println("Copy updated");
					int subsRow = suscriberDAO.updateQouta(Integer.parseInt(subsId));
					if (subsRow > 0) {
						System.out.println("Qouta updated");
					}
				}
        		Gson gson = new Gson();
        		out.print(gson.toJson(row));
			}
		}
		
	}
	
	public static String getReservedBooks(HttpServletResponse response) throws IOException {
    	BookReservedDAO reservedDAO = new BookReservedDAOImpl();
	 	Gson gSon = new Gson();
    	response.setContentType("application/json");
    	System.out.println(reservedDAO.getReservedTwoDaysBooks());
		return gSon.toJson(reservedDAO.getReservedTwoDaysBooks());
	}

}
