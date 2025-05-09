package com.ecommerce.controller;

import com.ecommerce.entity.Category;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.CategoryServiceImpl;
import com.ecommerce.utils.InputUtil;

public class CategoryController {
	
	CategoryService cserv=new CategoryServiceImpl();
	
	public void addCategory() {
		String name=InputUtil.getStringInput("Enter The Category Name:");
		cserv.addCategory(new Category(name));
	}
	
	public Category selectCategory() {
		System.out.println("The Number Of Categories Are:"+cserv.noItemsInCategory());
		cserv.displayCategory();
		int id=InputUtil.getIntegerInput("Enetr the id of the Category as Displayed");
		return cserv.selectCategoryById(id);
	}

	public void displayProductsByCategory() {
		cserv.displayProductsByCategory();
		
	}

}
