package com.FA.Team23.productMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.FA.Team23.productMS.dto.ProductDTOClass;
import com.FA.Team23.productMS.service.ProductServiceClass;

@RestController
public class ProductControllerClass {
	
	@Autowired
	private ProductServiceClass productMyService;
	
	@Autowired
	private Environment environment;
	
	
	//to add product
	@RequestMapping(value = "/prodMS/addProduct", method = RequestMethod.POST)
	public ResponseEntity<String> addMyProduct(@RequestBody ProductDTOClass prod){
		
		try {
			String msg = productMyService.addMyProduct(prod);
			return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(environment.getProperty(e.getMessage()),HttpStatus.UNAUTHORIZED);
		}
		
	}
	
	//to get product by its name
	@RequestMapping(value = "/prodMS/getByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<ProductDTOClass> getProductName(@PathVariable String name)
	{
		System.out.println("Entered here");
		try {
			ProductDTOClass productDTO = productMyService.getProductName(name);
			return new ResponseEntity<>(productDTO,HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()), e);
		}
	}
	
	//to get product by its product_id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/prodMS/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductDTOClass> getProductId(@PathVariable String id)
	{
		try {
			ProductDTOClass productDTO = productMyService.getProductById(id);
			return new ResponseEntity<>(productDTO,HttpStatus.OK);
		}
		catch(Exception e)
		{
			//throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()), e);
			return new ResponseEntity(environment.getProperty(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
	
	//to get product by its  category name
	@RequestMapping(value = "/prodMS/getByCategory/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDTOClass>> getProductCategory(@PathVariable String name)
	{
		System.out.println("Entered here");
		try {
			List<ProductDTOClass> prodDTO = productMyService.getProductCategory(name);
			return new ResponseEntity<List<ProductDTOClass>>(prodDTO,HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()), e);
		}
	}
	
	//delete its product(product id) by id
	@RequestMapping(value = "/prodMS/deleteProduct/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTheProduct(@PathVariable String id){
		
		try {
			String msg = productMyService.deleteMyProduct(id);
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(environment.getProperty(e.getMessage()),HttpStatus.NOT_FOUND);
		}
	}
	
	//to update stock of the  product 
	@RequestMapping(value = "/prodMS/updateStock/{prodId}/{quantity}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateMyStock(@PathVariable String prodId, @PathVariable Integer quantity){		
		try {
			Boolean stat = productMyService.updateStockOfProd(prodId,quantity);
			return new ResponseEntity<>(stat,HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()), e);
		}		
	}
	
	//view all products at once
	@RequestMapping(value = "/prodMS/viewAllProducts", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDTOClass>> viewAllMyProducts()
	{
		try {
			List<ProductDTOClass> lst = productMyService.viewAllMyProducts();
			return new ResponseEntity<>(lst,HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
		}
	}

}
