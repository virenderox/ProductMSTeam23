package com.FA.Team23.productMS.service;

import java.util.List;

import com.FA.Team23.productMS.dto.ProductDTOClass;
import com.FA.Team23.productMS.exception.ProductExceptionClass;

public interface ProductServiceClass {
	
	public String addMyProduct(ProductDTOClass productDTO) throws ProductExceptionClass;
	
	public String deleteMyProduct(String id) throws ProductExceptionClass;
	
	public ProductDTOClass getProductName(String name) throws ProductExceptionClass;
	
	public List<ProductDTOClass> getProductCategory(String category) throws ProductExceptionClass;
	
	public ProductDTOClass getProductById(String id) throws ProductExceptionClass;

	public Boolean updateStockOfProd(String prodId, Integer quantity) throws ProductExceptionClass;
	
	public List<ProductDTOClass> viewAllMyProducts() throws ProductExceptionClass;

}