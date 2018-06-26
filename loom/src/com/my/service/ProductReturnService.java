package com.my.service;

import java.util.List;

import com.my.service.dto.ProductReturnDTO;

public interface ProductReturnService {
	public Integer saveProductReturn(ProductReturnDTO productReturnDTO);
	public ProductReturnDTO load(Integer productReturnId);
	public void modify(ProductReturnDTO productReturnDTO);
	public List<ProductReturnDTO> loadProductReturns();

}
