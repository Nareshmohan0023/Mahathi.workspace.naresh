package com.Services;

import java.util.List;

import com.entity.Food;

public interface Service {
	Food selectById(int id,List<Food> Menu);
	
	void foodLoader(List<Food> menu);

}
