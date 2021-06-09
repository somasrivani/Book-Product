package com.cg.grocery.entities;

import java.security.Timestamp;
//import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name="Products")
public class ProductEntity extends BaseEntity {

	@NotBlank(message = "Product name can not be blank")
	@Size(min=0,max=25,message="Product name must be between 0 and 25 character")
	private String name;
	
	@NotBlank(message = "Product code can not be blank")
	@Size(min=1,max=10,message="Product code must be between 1 and 10")
	private String code;
	
	@NotBlank(message = "Product Price Details can not be blank")
	@Min(value=5,message="Product price must be greater than 5")
   private String price;
	
	@NotBlank(message = "Product Description can not be blank")
  private String description;
	
	@NotBlank(message = "Product Quantity can not be blank")
	private String quantity;
	
	private byte[] image;

	
	public ProductEntity(long id, String createdBy, String modifiedBy, Timestamp createdDateTime,
			Timestamp modifiedDateTime, String name, String code, String price, String description, String quantity,
			byte[] image) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProductEntity [name=" + name + ", code=" + code + ", price=" + price + ", description=" + description
				+ ", quantity=" + quantity + ", image=" + Arrays.toString(image) + "]";
	}

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return name;
	}

}
