package com.ecommerce.service;

import java.util.Map;

import com.ecommerce.db.DataBase;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;

public class ProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product p) {
		DataBase.getProdustsList().add(p);
		System.out.print("Product added in products");
		String CategoryId = p.getCategoryId();
		for (Map.Entry<Integer, Category> category : DataBase.getCategoriesList().entrySet()) {
			if (category.getValue().getCategoryId().equals(CategoryId)) {
				category.getValue().getProductsList().add(p);
				System.out.println("and added in Category");
				return;
			}
		}
		System.out.println("and Not added in Category");

	}

	@Override
	public void displayProducts() {
		for (Product p : DataBase.getProdustsList()) {
			boolean lowStock = false;
			if (p.getQuantity() < p.getMinProduct()) {
				lowStock = true;
			}
			System.out.println("ID:" + p.getId() + "\nName:" + p.getName() + "\nPrice:" + p.getPrice()
					+ "\nStock Available:" + p.getQuantity());
			System.out.println();
			if (lowStock) {
				System.err.println("Status:Low in Stock !");
			} else {
				System.out.println("Status:Availabe");

			}
		}
	}

	@Override
	public void deleteProduct(Product p) {
		DataBase.getProdustsList().remove(p);
		for (Map.Entry<Integer, Category> category : DataBase.getCategoriesList().entrySet()) {
			if (category.getValue().getCategoryId().equals(p.getCategoryId())) {
				category.getValue().getProductsList().remove(p);
				System.out.println("Product deleted successfully");
				return;
			}
		}
		System.out.println("Not Deleted");

	}

	@Override
	public Product selectProductById(int id) {
		for (Product p : DataBase.getProdustsList()) {
			if (id == p.getId()) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void upadteQuantity(Product p,int quantity) {
		p.setQuantity(quantity);
		
	}

}
