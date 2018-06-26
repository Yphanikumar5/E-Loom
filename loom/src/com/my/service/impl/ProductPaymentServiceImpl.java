package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.ProductPaymentDAO;
import com.my.dao.impl.ProductPaymentDAOImpl;
import com.my.dao.model.ProductPaymentTL;
import com.my.service.ProductPaymentService;
import com.my.service.dto.ProductPaymentDTO;

public class ProductPaymentServiceImpl implements ProductPaymentService{
	
	private ProductPaymentDAO productPaymentDAO;
	public ProductPaymentServiceImpl()
	{
		this.productPaymentDAO=new ProductPaymentDAOImpl();
	}

	public ProductPaymentDTO load(Integer productPayId) {
		// TODO Auto-generated method stub
		ProductPaymentDTO productPaymentDTO=null;
		ProductPaymentTL productPaymentTL=productPaymentDAO.getProductPayment(productPayId);
		if(productPaymentTL!=null)
		{
			
			productPaymentDTO=new ProductPaymentDTO();
			productPaymentDTO.setProductPayId(productPaymentTL.getProductPayId());
			productPaymentDTO.setProductType(productPaymentTL.getProductType());
			productPaymentDTO.setAmount(productPaymentTL.getAmount());
			productPaymentDTO.setStatus(productPaymentTL.getStatus());
			productPaymentDTO.setCreatedBy(productPaymentTL.getCreatedBy());
			productPaymentDTO.setCreatedOn(productPaymentTL.getCreatedOn());
			
		}
		
		return productPaymentDTO;
	}

	public List<ProductPaymentDTO> loadProductPayments() {
		// TODO Auto-generated method stub

		List<ProductPaymentDTO> productPayments=null;
		List<ProductPaymentTL> productPayment=productPaymentDAO.getProductPayments();
		if(productPayment!=null)
		{
			productPayments=new ArrayList();
			ListIterator<ProductPaymentTL> li=productPayment.listIterator();
			while(li.hasNext())
			{
				ProductPaymentDTO productPaymentDTO=new ProductPaymentDTO();
				ProductPaymentTL productPaymentTL=li.next();
				productPaymentDTO.setProductPayId(productPaymentTL.getProductPayId());
				productPaymentDTO.setProductType(productPaymentTL.getProductType());
				productPaymentDTO.setAmount(productPaymentTL.getAmount());
				productPaymentDTO.setStatus(productPaymentTL.getStatus());
				productPaymentDTO.setCreatedBy(productPaymentTL.getCreatedBy());
				productPaymentDTO.setCreatedOn(productPaymentTL.getCreatedOn());
				productPayments.add(productPaymentDTO);
			}
		}
		
		return productPayments;
		
		
	
	}

	

	public Integer saveProductPayment(ProductPaymentDTO productPaymentDTO) {
		// TODO Auto-generated method stub
		Integer productPayId;
		ProductPaymentTL productPaymentTL=new ProductPaymentTL();
		productPaymentTL.setProductType(productPaymentDTO.getProductType());
		productPaymentTL.setAmount(productPaymentDTO.getAmount());
		productPayId=productPaymentDAO.insertProductPayment(productPaymentTL);
		return productPayId;
	}

	public void modify(ProductPaymentDTO productPaymentDTO) {
		// TODO Auto-generated method stub
		ProductPaymentTL productPaymentTL=new ProductPaymentTL();
		productPaymentTL.setProductType(productPaymentDTO.getProductType());
		productPaymentTL.setAmount(productPaymentDTO.getAmount());
		productPaymentDAO.updateProductPayment(productPaymentTL);
		
	}
	

}
