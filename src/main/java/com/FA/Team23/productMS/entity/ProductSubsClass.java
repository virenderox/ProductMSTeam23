package com.FA.Team23.productMS.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.FA.Team23.productMS.utility.PrimaryKeyClass;

@Entity
@Table(name = "subscribed_product")
public class ProductSubsClass {
	
	
	//Embedded the primary key
	@EmbeddedId
	private PrimaryKeyClass customId;

	//Getter and Setter
	public PrimaryKeyClass getCustomId() {
		return customId;
	}

	public void setCustomId(PrimaryKeyClass customId) {
		this.customId = customId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductSubsClass other = (ProductSubsClass) obj;
		return Objects.equals(customId, other.customId);
	}

	@Override
	public String toString() {
		return "ProductSubsClass [customId=" + customId + "]";
	}
	
	
	

}
