package com.my.service;

import java.util.List;

import com.my.service.dto.ProductPaymentDTO;

public interface ProductPaymentService {
	public Integer saveProductPayment(ProductPaymentDTO productPaymentDTO);
	public ProductPaymentDTO load(Integer productPayId);
	public void modify(ProductPaymentDTO productPaymentDTO);
	public List<ProductPaymentDTO> loadProductPayments();


}
