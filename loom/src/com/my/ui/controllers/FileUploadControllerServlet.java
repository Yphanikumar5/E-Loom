package com.my.ui.controllers;



import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class FileUploadControllerServlet extends HttpServlet{
	private boolean isMultipart;
	   private String filePath;
	   //private int maxFileSize = 50 * 1024;
	  // private int maxMemSize = 4 * 1024;
	   private File file ;

	   public void init( ){
	      // Get the file location where it would be stored.
	      filePath = 
	              getServletContext().getRealPath("/"); 
	   }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  isMultipart = ServletFileUpload.isMultipartContent(request);
	    //  response.setContentType("text/html");
	      java.io.PrintWriter out = response.getWriter( );
	      
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      //factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	     // factory.setRepository(new File("c:\\temp"));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	    //  upload.setSizeMax( maxFileSize );

	      try{ 
	      // Parse the request to get file items.
	      List fileItems = upload.parseRequest(request);
		
	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();
	      String fn="";
	    
	      while ( i.hasNext () ) 
	      {
	         FileItem fi = (FileItem)i.next();
	         if ( !fi.isFormField () )	
	         {

	        	
	        	  // Get the uploaded file parameters
		            String fieldName = fi.getFieldName();
		            
		            String fileName = fi.getName();
		            fn=fileName;
		            String contentType = fi.getContentType();
		            boolean isInMemory = fi.isInMemory();
		            long sizeInBytes = fi.getSize();
		            // Write the file
		            if( fileName.lastIndexOf("\\") >= 0 ){
		               file = new File( filePath + 
		               fileName.substring( fileName.lastIndexOf("\\"))) ;
		            }else{
		               file = new File( filePath + 
		               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		            }
		            fi.write( file ) ;
		            HttpSession session=request.getSession();
		           // String regNo=(String)session.getAttribute("studentRegNo");
		        //    StudentDAO studentDAO=new StudentDAOImpl();
		            System.out.println(fieldName);
		           // studentDAO.updateStudent(regNo, fileName);
		            
		            
		           
		         
	      }
	      }
	    System.out.println(filePath);
	   out.print(fn);
	   out.flush();
	   }catch(Exception ex) {
	       System.out.println(ex);
	   }
	      
	     // response.sendRedirect("deptstudents.jsp");
		
	}

}
