package com.my.dao;

import java.util.List;

import com.my.dao.model.ProductReturnTL;

public interface ProductReturnDAO {
	public Integer insertProductReturn(ProductReturnTL productReturnTL);
	public ProductReturnTL getProductReturn(Integer productReturnId);
	public void updateProductReturn(ProductReturnTL productReturnTL);
	public List<ProductReturnTL> getProductReturns();



}
