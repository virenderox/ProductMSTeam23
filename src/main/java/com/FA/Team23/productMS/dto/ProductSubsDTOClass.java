package com.FA.Team23.productMS.dto;

public class ProductSubsDTOClass {
	
	private String buyerId;
	private String prodId;
	private Integer quantity;
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductSubsDTO [buyerId=" + buyerId + ", prodId=" + prodId + ", quantity=" + quantity + "]";
	}
	
	
	
}