package com.my.dao;

import java.util.List;

import com.my.dao.model.ProductPaymentTL;

public interface ProductPaymentDAO {
	public Integer insertProductPayment(ProductPaymentTL productPaymentTL);
	public ProductPaymentTL getProductPayment(Integer productPayId);
	public void updateProductPayment(ProductPaymentTL productPaymentTL);
	public List<ProductPaymentTL> getProductPayments();

}
