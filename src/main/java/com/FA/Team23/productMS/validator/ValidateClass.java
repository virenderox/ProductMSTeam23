package com.FA.Team23.productMS.validator;

import com.FA.Team23.productMS.dto.ProductDTOClass;
import com.FA.Team23.productMS.exception.ProductExceptionClass;

public class ValidateClass {
	
	public static void validateMyProduct(ProductDTOClass prod) throws ProductExceptionClass {
		
		if(!validateMyName(prod.getProductName()))
			throw new ProductExceptionClass("Validator.VALIDATE_NAME");
		
		if(!validateMyDescription(prod.getDescription()))
			throw new ProductExceptionClass("Validator.VALIDATE_DESCRIPTION");
			
		if(!validateMyPrice(prod.getPrice()))
			throw new ProductExceptionClass("Validator.VALIDATE_PRICE");
		
		if(!validateMyStock(prod.getStock()))
			throw new ProductExceptionClass("Validator.VALIDATE_STOCK");
		
		if(!validateMyImage(prod.getImage()))
			throw new ProductExceptionClass("Validator.VALIDATE_IMAGE");
		
	}
	
	//Validate the Name using regular Expression
	public static boolean validateMyName(String name)
	{
		String reg = "([A-Za-z]+([ ][A-Za-z]+)*){1,100}";
		
		if(name.matches(reg))
		{
			return true;
		}
		return false;
	}
	
	//validate the Description
	public static boolean validateMyDescription(String desc)
	{
		String reg = "([A-Za-z]+([ ][A-Za-z]+)*){1,500}";
		
		if(desc.matches(reg))
		{
			return true;
		}
		return false;
	}
	
	//Validate the Price
	public static boolean validateMyPrice(Float price)
	{
		if(price >=200)
		{
			return true;
		}
		
		return false;
	}
	
	//validate the stock
	public static boolean validateMyStock(Integer stock)
	{
		if(stock>=10)
		{
			return true;
		}
		return false;
	}
	
	//validate the image
	public static boolean validateMyImage(String image)
	{
		String reg = "[A-Za-z]+[\\.](png|jpeg)";
		
		if(image.matches(reg))
			return true;

		return false;
	}

}