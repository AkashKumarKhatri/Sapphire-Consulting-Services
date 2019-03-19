package com.lms.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadDemo")
public class UploadDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "D:/JAVA2/eclipse-workspace/01_Liberary_Management_System/uploaded_data";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello hi hi h");
		System.out.println(request.getParameter("name"));
		int count = 1;
		if(ServletFileUpload.isMultipartContent(request)){
			System.out.println("Yes Multicast");
			
			ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
			try {
				List<FileItem> fileItems = upload.parseRequest(request);
				for (FileItem item : fileItems) {
					System.out.println(count+" ============ "+item.getName());
					if(!item.isFormField()){
						
						System.out.println("*** ============ "+item.getName()+" In file if contion");
                        String name = new File(item.getName()).getName();

                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        
                        //book.setImagePath("images/"+name);

                    }
					if(item.isFormField()){
                    	if(item.getFieldName().equals("name")){
                    		String title = item.getString();
                    		System.out.println(title);
                    		//book.setTitle(title);
                    	}
                    	if(item.getFieldName().equals("middle")){
                    		String middle = item.getString();
                    		System.out.println(middle);
                    	}
                    	if(item.getFieldName().equals("last")){
                    		String last = item.getString();
                    		System.out.println(last);
                    	}
                    }
					count++;
				}
				System.out.println("File Uploaded");
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
