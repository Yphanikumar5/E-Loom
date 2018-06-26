package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.SalesDAO;
import com.my.dao.impl.SalesDAOImpl;
import com.my.dao.model.SalesTL;
import com.my.service.SalesService;
import com.my.service.dto.SalesDTO;

public class SalesServiceImpl implements SalesService{

	private SalesDAO salesDAO;
	public SalesServiceImpl()
	{
		this.salesDAO=new SalesDAOImpl();
	}
	
	/* public SalesDTO load(Integer salesId) {
		// TODO Auto-generated method stub
		SalesDTO salesDTO=null;
		SalesTL salesTL=salesDAO.getSales(salesId);
		if(salesTL!=null)
		{
			salesDTO=new SalesDTO();
			salesDTO.setProductId(salesTL.getProductId());
			salesDTO.setQuantity(salesTL.getQuantity());
			salesDTO.setPrice(salesTL.getPrice());
			salesDTO.setCustomerId(salesTL.getCustomerId());
			salesDTO.setStatus(salesTL.getStatus());
			salesDTO.setCreatedBy(salesTL.getCreatedBy());
			salesDTO.setCreatedOn(salesTL.getCreatedOn());
		}
		return salesDTO;
	}

	public List<SalesDTO> loadSaless() {
		// TODO Auto-generated method stub
		
		

		List<SalesDTO> saless=null;
		List<SalesTL> sales=salesDAO.getSaless();
		if(sales!=null)
		{
			saless=new ArrayList();
			ListIterator<SalesTL> li=sales.listIterator();
			while(li.hasNext())
			{
				SalesDTO salesDTO=new SalesDTO();
				SalesTL salesTL=li.next();
				salesDTO.setSalesId(salesTL.getSalesId());
				salesDTO.setProductId(salesTL.getProductId());
				salesDTO.setQuantity(salesTL.getQuantity());
				salesDTO.setPrice(salesTL.getPrice());
				salesDTO.setCustomerId(salesTL.getCustomerId());
				salesDTO.setStatus(salesTL.getStatus());
				salesDTO.setCreatedBy(salesTL.getCreatedBy());
				salesDTO.setCreatedOn(salesTL.getCreatedOn());
				saless.add(salesDTO);
			}
		}
		
		return saless;
		
		
		
	}
	public void modify(SalesDTO salesDTO) {
		// TODO Auto-generated method stub
		SalesTL salesTL=new SalesTL();
		salesTL.setQuantity(salesDTO.getQuantity());
		salesTL.setPrice(salesDTO.getPrice());
		salesDAO.updateSales(salesTL);
	} */

	

	public Integer saveSales(SalesDTO salesDTO) {
		// TODO Auto-generated method stub
		Integer salesId;
		SalesTL salesTL=new SalesTL();
		salesTL.setSalesId(salesDTO.getSalesId());
		salesTL.setBillId(salesDTO.getBillId());
		salesTL.setProductType(salesDTO.getProductType());
		salesTL.setQuantity(salesDTO.getQuantity());
		salesTL.setPrice(salesDTO.getPrice());
		salesTL.setDiscount(salesDTO.getDiscount());
		salesTL.setCreatedBy(salesDTO.getCreatedBy());
		salesTL.setCreatedOn(new java.sql.Timestamp(salesDTO.getCreatedOn().getTime()));
		salesTL.setStatus(salesDTO.getStatus());
		salesId=salesDAO.insertSales(salesTL);
		return salesId;
	}

	

}
