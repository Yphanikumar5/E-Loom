package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.ProductService;
import com.my.service.dto.ProductDTO;
import com.my.ui.Controller;

public class EditProductController implements Controller{
	private ProductService productService;
	public EditProductController(ProductService productService)
	{
		this.productService=productService;
	}
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pId=request.getParameter("pId");
		ProductDTO product=productService.load(new Integer(pId));
		request.setAttribute("product", product);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/EditProduct.jsp");
		rd.forward(request, response);
		
	}

}
