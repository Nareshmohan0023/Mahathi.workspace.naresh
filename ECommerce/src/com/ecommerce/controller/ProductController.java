package com.ecommerce.controller;

import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.ProductServiceImpl;
import com.ecommerce.utils.InputUtil;

public class ProductController {
	
	private ProductService pserv=new ProductServiceImpl();
	
	public void addProduct() {
		String categoryId=InputUtil.getStringInput("Enter Category ID:");
		String name=InputUtil.getStringInput("Name Of the Product:");
		int price=InputUtil.getIntegerInput("Enter the Price:");
		int quantity=InputUtil.getIntegerInput("Enter the Quantity");
		pserv.addProduct(new Product(name, categoryId, price, quantity));
	}
	
	public void deleteProduct() {
		pserv.displayProducts();
		int prodId=InputUtil.getIntegerInput("Enter The Product Id as Displayed to Delete the Product");
		Product p=pserv.selectProductById(prodId);
		pserv.deleteProduct(p);
	}
	
	public void upadteQuantity() {
		pserv.displayProducts();
		int id=InputUtil.getIntegerInput("Enter Product Id as shown above to update the name:");
		Product p=pserv.selectProductById(id);
		int quantity=InputUtil.getIntegerInput("Enter The Quantity of the Product to add:");
		pserv.upadteQuantity(p, quantity);
	}
	
	public void displayProducts() {
		pserv.displayProducts();
		
	}
	
	
	
	


}
