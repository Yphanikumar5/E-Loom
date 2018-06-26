package com.my.service;

import java.util.List;

import com.my.service.dto.ProductDTO;

public interface ProductService {
	
	public Integer saveProduct(ProductDTO productDTO);
	public ProductDTO load(Integer productId);
	public void modify(ProductDTO productDTO);
	public List<ProductDTO> loadProducts();
}
