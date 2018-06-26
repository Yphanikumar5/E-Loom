package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.ProductDAO;
import com.my.dao.impl.ProductDAOImpl;
import com.my.dao.model.ProductTL;
import com.my.service.ProductService;
import com.my.service.dto.ProductDTO;

public class ProductServiceImpl implements ProductService{
	private ProductDAO productDAO;
	public ProductServiceImpl()
	{
		this.productDAO=new ProductDAOImpl();
	}
	public ProductDTO load(Integer productId) {
		// TODO Auto-generated method stub
		ProductDTO productDTO=null;
		ProductTL productTL=productDAO.getProduct(productId);
		if(productTL!=null)
		{
			productDTO=new ProductDTO();
			productDTO.setEmpId(productTL.getEmpId());
			productDTO.setProductType(productTL.getProductType());
			productDTO.setPrice(productTL.getPrice());
			productDTO.setProductName(productTL.getProductName());
			productDTO.setQuantity(productTL.getQuantity());
		    productDTO.setStatus(productTL.getStatus());
			productDTO.setCreatedBy(productTL.getCreatedBy());
			productDTO.setCreatedOn(productTL.getCreatedOn());
		}
		
		return productDTO;
	}

	public List<ProductDTO> loadProducts() {
		// TODO Auto-generated method stub

		List<ProductDTO> products=null;
		List<ProductTL> product=productDAO.getProducts();
		if(product!=null)
		{
			products=new ArrayList();
			ListIterator<ProductTL> li=product.listIterator();
			while(li.hasNext())
			{
				ProductDTO productDTO=new ProductDTO();
				ProductTL productTL=li.next();
				productDTO.setProductId(productTL.getProductId());
				productDTO.setEmpId(productTL.getEmpId());
				productDTO.setProductType(productTL.getProductType());
				productDTO.setPrice(productTL.getPrice());
				productDTO.setProductName(productTL.getProductName());
				productDTO.setQuantity(productTL.getQuantity());
			    productDTO.setStatus(productTL.getStatus());
				productDTO.setCreatedBy(productTL.getCreatedBy());
				productDTO.setCreatedOn(productTL.getCreatedOn());
				products.add(productDTO);
			}
		}
		
		return products;
		
		
	}

	
	public Integer saveProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		Integer productId=0;
		ProductTL productTL=new ProductTL();
		productTL.setProductId(productDTO.getProductId());
		productTL.setEmpId(productDTO.getEmpId());
		productTL.setProductType(productDTO.getProductType());
		productTL.setPrice(productDTO.getPrice());
		productTL.setProductName(productDTO.getProductName());
		productTL.setQuantity(productDTO.getQuantity());
		productTL.setStatus(productDTO.getStatus());
		productTL.setCreatedBy(productDTO.getCreatedBy());
		productTL.setCreatedOn(new java.sql.Timestamp(productDTO.getCreatedOn().getTime()));
		productId=productDAO.insertProduct(productTL);
		
		return productId;
	}
	public void modify(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		ProductTL productTL=new ProductTL();
		productTL.setProductType(productDTO.getProductType());
		productTL.setPrice(productDTO.getPrice());
		productTL.setProductName(productDTO.getProductName());
		productTL.setQuantity(productDTO.getQuantity());
		productDAO.updateProduct(productTL);
	}

}
