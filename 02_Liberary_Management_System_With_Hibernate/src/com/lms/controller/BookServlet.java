package com.lms.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.lms.beans.BookBean;
import com.lms.beans.UserBean;
import com.lms.dao.BookDAO;
import com.lms.dao.UserDAO;
import com.lms.dao.impl.BookDAOImpl;
import com.lms.dao.impl.UserDAOImpl;
import com.lms.dto.BookDTO;
import com.lms.transformer.BookTransformer;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String UPLOAD_DIRECTORY = "D:/eclips-workspace/02_Liberary_Management_System_With_Hibernate/WebContent/uploaded_data";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String refresh = request.getParameter("refresh");
		if(refresh.equals("book")) {
			out.write(getBooks(response));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer bookId = null;
		String action;
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		BookDAO bookDAO = new BookDAOImpl();
		BookBean book = new BookBean();
		
		if(ServletFileUpload.isMultipartContent(request)) {
			ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
			try {
				List<FileItem> fileItems = upload.parseRequest(request);
				for (FileItem item : fileItems) {
					if(!item.isFormField()){
						System.out.println("I am in file if condition");
						String name = new File(item.getName()).getName();
                    	item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        book.setPicture("uploaded_data/"+name);
                    }
					if(item.isFormField()) {
					
						if(item.getFieldName().equals("id")) {
							bookId = Integer.parseInt(item.getString());
							book.setBookId(bookId);
						}
						
						if(item.getFieldName().equals("title")){
                    		String title = item.getString();
                    		book.setTitle(title);
                    	}
                    	
                    	if(item.getFieldName().equals("author")){
                    		String author = item.getString();
                    		book.setAuthor(author);
                    	}
                    	
                    	if(item.getFieldName().equals("content")){
                    		String content = item.getString();
                    		book.setContent(content);
                    	}
                    	
                    	if(item.getFieldName().equals("copies")){
                    		String copies = item.getString();
                    		book.setQuantity(Integer.parseInt(copies));
                    	}
                    	
                    	if(item.getFieldName().equals("borrow")){
                    		String borrow = item.getString();
                    		book.setBorrow(Integer.parseInt(borrow));
                    	}
                    	
                    	if(item.getFieldName().equals("action")){
                    		action = item.getString();
                    		if(action.equals("add")) {
                    			HttpSession httpSession = request.getSession();
                				UserDAO userDAO = new UserDAOImpl();
                				UserBean userBean = userDAO.getUserByName(httpSession.getAttribute("user").toString());
                				book.setCreatedBy(userBean.getUserId());
                				Date date = new Date();  
                		        Timestamp ts = new Timestamp(date.getTime());
                				book.setCreatedDate(ts);
                				int row = bookDAO.save(book);
                				out.print(getBooks(response));
                    		}
                    		if (action.equals("update")) {
                    			HttpSession httpSession = request.getSession();
                				UserDAO userDAO = new UserDAOImpl();
                				UserBean userBean = userDAO.getUserByName(httpSession.getAttribute("user").toString());
                				book.setModifiedBy(userBean.getUserId());
                				Date date = new Date();  
                		        Timestamp ts = new Timestamp(date.getTime());  
                				book.setModifiedDate(ts);
                				int row = bookDAO.update(book);
                				out.println(getBooks(response));
							}
                    	}
                    }
				}
				System.out.println("File Uploaded");
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else {
			
			String method = request.getParameter("method");
			action = request.getParameter("action");
			bookId = Integer.parseInt(request.getParameter("id"));
			
			if(method != null) {
				BookBean bookBean = bookDAO.getBookById(bookId);
				Gson gSon = new Gson();
				BookDTO bookDTO = new BookTransformer().transform(bookBean);
				out.write(gSon.toJson(bookDTO));
			}
			
			if (action != null && action.equals("delete")) {
				book.setBookId(bookId);
				int row = bookDAO.delete(book);
				out.print(getBooks(response));
			}
			
			else if (action != null && action.equals("copy")) {
				book = bookDAO.getAvailableBookCopies(bookId);
				Gson gSon = new Gson();
				BookDTO bookDTO = new BookTransformer().transform(book);
				out.write(gSon.toJson(bookDTO));
			}
		}
		
		/*String method = request.getParameter("method");
		String action = request.getParameter("action");
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String picture = request.getParameter("picture");
		Integer bookId = null;
		Integer copies = null;
		Integer maxBorrowPeriod = null;
		if (request.getParameter("copies") != null && request.getParameter("borrow") != null) {
			copies = Integer.parseInt(request.getParameter("copies"));
			maxBorrowPeriod = Integer.parseInt(request.getParameter("borrow"));
		}
		
		if (request.getParameter("id") != null) {
			bookId = Integer.parseInt(request.getParameter("id"));
		}
		
		if(method != null) {
			BookBean bookBean = bookDAO.getBookById(bookId);
			Gson gSon = new Gson();
			out.write(gSon.toJson(bookBean));
		}
		
		else if (action != null) {
			if(action.equals("add")) {
				BookBean bookBean = new BookBean();
				bookBean.setAuthor(author);
				bookBean.setBorrow(maxBorrowPeriod);
				bookBean.setContent(content);
				bookBean.setTitle(title);
				bookBean.setQuantity(copies);
				HttpSession httpSession = request.getSession();
				UserDAO userDAO = new UserDAOImpl();
				UserBean userBean = userDAO.getUserByName(httpSession.getAttribute("user").toString());
				bookBean.setCreatedBy(userBean.getUserId());
				Date date = new Date();  
		        Timestamp ts = new Timestamp(date.getTime());
				bookBean.setCreatedDate(ts);
				int row = bookDAO.save(bookBean);
				out.print(getBooks(response));
				
			}
			else if (action.equals("update")) {
				BookBean bookBean = new BookBean();
				bookBean.setAuthor(author);
				bookBean.setBookId(bookId);
				bookBean.setBorrow(maxBorrowPeriod);
				bookBean.setContent(content);
				bookBean.setTitle(title);
				bookBean.setQuantity(copies);
				HttpSession httpSession = request.getSession();
				UserDAO userDAO = new UserDAOImpl();
				UserBean userBean = userDAO.getUserByName(httpSession.getAttribute("user").toString());
				bookBean.setModifiedBy(userBean.getUserId());
				Date date = new Date();  
		        Timestamp ts = new Timestamp(date.getTime());  
				bookBean.setModifiedDate(ts);
				int row = bookDAO.update(bookBean);
				out.print(getBooks(response));
			}
			else if (action.equals("delete")) {
				BookBean bookBean = new BookBean();
				bookBean.setBookId(bookId);
				int row = bookDAO.delete(bookBean);
				out.print(getBooks(response));
			}
		}*/
	}
	
	public static String getBooks(HttpServletResponse response) throws IOException {
    	BookDAO bookDAO = new BookDAOImpl();
	 	Gson gSon = new Gson();
    	response.setContentType("application/json");
    	
    	List<BookBean> bookBeans = bookDAO.getAllBooks();
    	List<BookDTO> bookDTOs = new ArrayList<>();
    	
    	for (BookBean bookBean : bookBeans) {
			BookDTO bookDTO = new BookTransformer().transform(bookBean);
			bookDTOs.add(bookDTO);
		}
    	
		return gSon.toJson(bookDTOs);
	}
}