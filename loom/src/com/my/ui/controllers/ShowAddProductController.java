package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.EmpService;
import com.my.service.ProductService;
import com.my.service.dto.EmpDTO;
import com.my.service.dto.ProductDTO;
import com.my.ui.Controller;

public class ShowAddProductController implements Controller{

	private ProductService productService;
	private EmpService empService;
	public ShowAddProductController(ProductService productService,EmpService empService){
		this.productService=productService;
		this.empService=empService;
	}
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ProductDTO> products=productService.loadProducts();
		List<EmpDTO> emps=empService.loadEmps();
		request.setAttribute("products", products);
		request.setAttribute("emps", emps);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/AddProduct.jsp");
		rd.forward(request, response);
		
	}

}
