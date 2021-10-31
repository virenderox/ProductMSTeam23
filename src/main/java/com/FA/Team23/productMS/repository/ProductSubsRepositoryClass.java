package com.FA.Team23.productMS.repository;

import org.springframework.data.repository.CrudRepository;

import com.FA.Team23.productMS.entity.ProductSubsClass;
import com.FA.Team23.productMS.utility.PrimaryKeyClass;

public interface ProductSubsRepositoryClass extends CrudRepository<ProductSubsClass, PrimaryKeyClass> {
	
	

}

