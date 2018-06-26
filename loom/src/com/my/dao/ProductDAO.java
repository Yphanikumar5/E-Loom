package com.my.dao;

import java.util.List;

import com.my.dao.model.ProductTL;

public interface ProductDAO {
	public Integer insertProduct(ProductTL productTL);
	public ProductTL getProduct(Integer productId);
	public void updateProduct(ProductTL productTL);
	public List<ProductTL> getProducts();
}
