package com.FA.Team23.productMS.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.FA.Team23.productMS.entity.ProductClass;

public interface ProductRepositoryClass extends CrudRepository<ProductClass, String> { // Extends CrubRepository Class
	
	//find product by its product id
	public ProductClass findByProdId(String id);
	
	//find prouct by its name
	public ProductClass findByProductName(String name);
	
	//find product by its category
	public List<ProductClass> findByCategory(String category);
	
	//find all at once
	public List<ProductClass> findAll();

}
