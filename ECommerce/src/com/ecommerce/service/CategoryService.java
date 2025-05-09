package com.ecommerce.service;

import java.util.Map;

import com.ecommerce.db.DataBase;
import com.ecommerce.entity.Category;

public interface CategoryService {
	
	void addCategory(Category c);
	void deleteCategory(String id);
	void displayCategory();
	void displayProductsByCategory();
	void displayCategoryProduct(int id);
	void stockDetails();
	int noItemsInCategory();
	Category selectCategoryById(int id);
	Category selectCategoryByCode(String id);
	
	

}
