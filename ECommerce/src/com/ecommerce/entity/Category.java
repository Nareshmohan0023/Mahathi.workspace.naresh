package com.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.utils.IdGenerator;

public class Category {

	private String Name;
	private static final String CATEGORY_CODE = "CAT";
	private List<Product> productsList = new ArrayList<>();
	private String categoryId;

	public Category(String name) {
		super();
		Name = name;
		this.categoryId = IdGenerator.CATIdGenerator();
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public static String getCategoryCode() {
		return CATEGORY_CODE;
	}

	@Override
	public String toString() {
		return "Category [Name=" + Name + ", productsList=" + productsList + ", categoryId=" + categoryId + "]";
	}

	public void setId(String catIdGenerator) {
		// TODO Auto-generated method stub
		
	}

	

}
