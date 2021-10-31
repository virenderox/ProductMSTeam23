package com.FA.Team23.productMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FA.Team23.productMS.dto.ProductDTOClass;
import com.FA.Team23.productMS.entity.ProductClass;
import com.FA.Team23.productMS.exception.ProductExceptionClass;
import com.FA.Team23.productMS.repository.ProductRepositoryClass;
import com.FA.Team23.productMS.validator.ValidateClass;

@Service(value = "productServiceClass")
@Transactional
public class ProductServiceImpl implements ProductServiceClass {

	@Autowired
	private ProductRepositoryClass productRepository;
	
	//used to create unique product id like "P" + index = P1, P2, P3...
	private static int index;
	
	static {
		index=100;
	}
	
	//method to add product
	@Override
	public String addMyProduct(ProductDTOClass productDTO) throws ProductExceptionClass {
		
		ValidateClass.validateMyProduct(productDTO);
		
		ProductClass product = productRepository.findByProductName(productDTO.getProductName());
		
		if(product != null)
			throw new ProductExceptionClass("Service.PRODUCT_ALREADY_EXISTS");
		
		product = new ProductClass();
		
		String id = "P"+index++;
		
		product.setProdId(id);
		product.setProductName(productDTO.getProductName());
		product.setPrice(productDTO.getPrice());
		product.setCategory(productDTO.getCategory());
		product.setDescription(productDTO.getDescription());
		product.setImage(productDTO.getImage());
		product.setSubCategory(productDTO.getSubCategory());
		product.setSellerId(productDTO.getSellerId());
		product.setProductRating(productDTO.getProductRating());
		product.setStock(productDTO.getStock());
		
		productRepository.save(product);
		
		return product.getProdId();
	}

	//method to get product by product name
	@Override
	public ProductDTOClass getProductName(String name) throws ProductExceptionClass {
		
		ProductClass product = productRepository.findByProductName(name);
		
		if(product == null)
			throw new ProductExceptionClass("Service.PRODUCT_DOES_NOT_EXISTS");
		
		ProductDTOClass productDTO = new ProductDTOClass();
		
		productDTO.setProdId(product.getProdId());
		productDTO.setCategory(product.getCategory());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setPrice(product.getPrice());
		productDTO.setProductName(product.getProductName());
		productDTO.setProductRating(product.getProductRating());
		productDTO.setSellerId(product.getSellerId());
		productDTO.setStock(product.getStock());
		productDTO.setSubCategory(product.getCategory());
		
		return productDTO;
	}
	
	//method to get product by product id
	@Override
	public ProductDTOClass getProductById(String id) throws ProductExceptionClass {
		
		ProductClass product = productRepository.findByProdId(id);
		
		if(product == null)
			throw new ProductExceptionClass("Service.PRODUCT_DOES_NOT_EXISTS");
		
		ProductDTOClass productDTO = new ProductDTOClass();
		
		productDTO.setProdId(product.getProdId());
		productDTO.setCategory(product.getCategory());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setPrice(product.getPrice());
		productDTO.setProductName(product.getProductName());
		productDTO.setProductRating(product.getProductRating());
		productDTO.setSellerId(product.getSellerId());
		productDTO.setStock(product.getStock());
		productDTO.setSubCategory(product.getCategory());
		
		return productDTO;
	}

	//method to delete product by product id
	@Override
	public String deleteMyProduct(String id) throws ProductExceptionClass {
		
		ProductClass product = productRepository.findByProdId(id);
		
		if(product == null)
			throw new ProductExceptionClass("Service.CANNOT_DELETE_PRODUCT");
		
		productRepository.delete(product);
		
		return "Product successfully deleted";
		
	}

	//method to get product by category
	@Override
	public List<ProductDTOClass> getProductCategory(String category) throws ProductExceptionClass {
		
		List<ProductClass> list = productRepository.findByCategory(category);
		
		if(list.isEmpty())
			throw new ProductExceptionClass("Service.CATEGORY_ERROR");
		
		List<ProductDTOClass> li = new ArrayList<>();
		
		for(ProductClass product : list)
		{
			ProductDTOClass productDTO = new ProductDTOClass();
			
			productDTO.setProdId(product.getProdId());
			productDTO.setCategory(product.getCategory());
			productDTO.setDescription(product.getDescription());
			productDTO.setImage(product.getImage());
			productDTO.setPrice(product.getPrice());
			productDTO.setProductName(product.getProductName());
			productDTO.setProductRating(product.getProductRating());
			productDTO.setSellerId(product.getSellerId());
			productDTO.setStock(product.getStock());
			productDTO.setSubCategory(product.getCategory());
			
			li.add(productDTO);
		}
		
		return li;
	}

	//method to update stock
	@Override
	public Boolean updateStockOfProd(String prodId, Integer quantity) throws ProductExceptionClass {
		Optional<ProductClass> optProduct = productRepository.findById(prodId);
		ProductClass product = optProduct.orElseThrow(()-> new ProductExceptionClass("Product does not exist"));
		if(product.getStock()>=quantity) {
			product.setStock(product.getStock()-quantity);
			return true;
		}
		return false;		
	}

	//method to view all the products
	@Override
	public List<ProductDTOClass> viewAllMyProducts() throws ProductExceptionClass {
		
		List<ProductClass> list = productRepository.findAll();
		
		if(list.isEmpty())
			throw new ProductExceptionClass("There are no products to be shown");
		
		List<ProductDTOClass> li = new ArrayList<>();
		
		list.forEach(l -> {
			ProductDTOClass prod = new ProductDTOClass();
			prod.setCategory(l.getCategory());
			prod.setDescription(l.getDescription());
			prod.setImage(l.getImage());
			prod.setPrice(l.getPrice());
			prod.setProdId(l.getProdId());
			prod.setProductName(l.getProductName());
			prod.setProductRating(l.getProductRating());
			prod.setSellerId(l.getSellerId());
			prod.setStock(l.getStock());
			prod.setSubCategory(l.getSubCategory());
			
			li.add(prod);
		});
		
		return li;
	}


}
