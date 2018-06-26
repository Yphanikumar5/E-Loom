package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.dao.ProductDAO;
import com.my.dao.model.ProductTL;
import com.my.service.ProductService;
import com.my.service.dto.AdminDTO;
import com.my.service.dto.ProductDTO;
import com.my.ui.forms.AddProductForm;

public class AddProductFormController extends AbstractFormController{
	
	private ProductService productService;
	public AddProductFormController(ProductService productService) {
		this.productService=productService;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		
		AddProductForm addProductForm=(AddProductForm)command;
		ProductDTO productDTO=new ProductDTO();
		productDTO.setProductId(addProductForm.getProductId());
		productDTO.setEmpId(addProductForm.getEmpId());
		productDTO.setProductType(addProductForm.getProductType());
		productDTO.setPrice(addProductForm.getPrice());
		productDTO.setProductName(addProductForm.getProductName());
		productDTO.setQuantity(addProductForm.getQuantity());
		productDTO.setCreatedOn(new java.util.Date());
		productDTO.setStatus(addProductForm.getStatus());
		productDTO.setCreatedOn(new java.util.Date());
		HttpSession session=request.getSession(false);
		AdminDTO admin=(AdminDTO)session.getAttribute("admin");
		productDTO.setCreatedBy(admin.getAdminId());
		productService.saveProduct(productDTO);
		response.sendRedirect("products.htm");
		
		
		// TODO Auto-generated method stub
		
	}

}
