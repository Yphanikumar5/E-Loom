package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.ProductDAO;
import com.my.dao.model.ProductTL;
import com.my.service.EmpService;
import com.my.service.ProductService;
import com.my.service.dto.ProductDTO;
import com.my.ui.Controller;

public class ProductsController implements Controller{
	private ProductService productService;
	//private Integer empId;
	//private EmpService empService;
	public ProductsController(ProductService productService) {
		this.productService=productService;
		//this.empService=empService;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ProductDTO> products=productService.loadProducts();
		request.setAttribute("products", products);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/products.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
