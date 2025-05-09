package com.Services;

import java.util.List;

import com.entity.Food;

public class Service_Impl implements Service {

	@Override
	public Food selectById(int id,List<Food> Menu) {
		for(Food f:Menu) {
			if(f.getId()==id) {
				return f;
			}
		}
		return null;
	}

	@Override
	public void foodLoader(List<Food> menu) {
		menu.add(new Food(1, 180.00, "Burger"));
		menu.add(new Food(2, 200.10, "Pizza"));
		menu.add(new Food(3, 80.00, "Mojito"));
		menu.add(new Food(4, 100.20, "Sandwich"));
		menu.add(new Food(5, 120.00, "French Fries"));
		System.out.println(menu.size()+"Items are in Menu");
		
	}

}
