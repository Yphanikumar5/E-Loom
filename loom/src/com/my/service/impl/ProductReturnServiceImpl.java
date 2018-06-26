package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.ProductReturnDAO;
import com.my.dao.impl.ProductReturnDAOImpl;
import com.my.dao.model.ProductReturnTL;
import com.my.service.ProductReturnService;
import com.my.service.dto.ProductReturnDTO;

public class ProductReturnServiceImpl implements ProductReturnService{

	private ProductReturnDAO productReturnDAO;
	public ProductReturnServiceImpl()
	{
		this.productReturnDAO=new ProductReturnDAOImpl();
	}
	public ProductReturnDTO load(Integer productReturnId) {
		// TODO Auto-generated method stub
		ProductReturnDTO productReturnDTO=null;
		ProductReturnTL productReturnTL=productReturnDAO.getProductReturn(productReturnId);
		if(productReturnTL!=null);
		{
			productReturnDTO=new ProductReturnDTO();
			productReturnDTO.setProductReturnId(productReturnTL.getProductReturnId());
			productReturnDTO.setProductId(productReturnTL.getProductId());
			productReturnDTO.setCustomerId(productReturnTL.getCustomerId());
		    productReturnDTO.setQuantity(productReturnTL.getQuantity());
			productReturnDTO.setSalesId(productReturnTL.getSalesId());
		    productReturnDTO.setStatus(productReturnTL.getStatus());
			productReturnDTO.setCreatedBy(productReturnTL.getCreatedBy());
			productReturnDTO.setCreatedOn(productReturnTL.getCreatedOn());
		}
		
		return productReturnDTO;
	}

	public List<ProductReturnDTO> loadProductReturns() {
		// TODO Auto-generated method stub
		
		List<ProductReturnDTO> productReturns=null;
		List<ProductReturnTL> productReturn=productReturnDAO.getProductReturns();
		if(productReturn!=null)
		{
			productReturns=new ArrayList();
			ListIterator<ProductReturnTL> li=productReturn.listIterator();
			while(li.hasNext())
			{
				ProductReturnDTO productReturnDTO=new ProductReturnDTO();
				ProductReturnTL productReturnTL=li.next();
				productReturnDTO.setProductReturnId(productReturnTL.getProductReturnId());
				productReturnDTO.setProductId(productReturnTL.getProductId());
				productReturnDTO.setCustomerId(productReturnTL.getCustomerId());
				productReturnDTO.setQuantity(productReturnTL.getQuantity());
				productReturnDTO.setSalesId(productReturnTL.getSalesId());
			    productReturnDTO.setStatus(productReturnTL.getStatus());
				productReturnDTO.setCreatedBy(productReturnTL.getCreatedBy());
				productReturnDTO.setCreatedOn(productReturnTL.getCreatedOn());
				productReturns.add(productReturnDTO);
			}
		}
		
		return productReturns;
		
		
	}


	public Integer saveProductReturn(ProductReturnDTO productReturnDTO) {
		// TODO Auto-generated method stub
		Integer productReturnId;
		ProductReturnTL productReturnTL=new ProductReturnTL();
		productReturnTL.setQuantity(productReturnDTO.getQuantity());
		productReturnId=productReturnDAO.insertProductReturn(productReturnTL);
		return productReturnId;
	}
	public void modify(ProductReturnDTO productReturnDTO) {
		// TODO Auto-generated method stub
		ProductReturnTL productReturnTL=new ProductReturnTL();
		productReturnTL.setQuantity(productReturnDTO.getQuantity());
		productReturnDAO.updateProductReturn(productReturnTL);
	}

}
