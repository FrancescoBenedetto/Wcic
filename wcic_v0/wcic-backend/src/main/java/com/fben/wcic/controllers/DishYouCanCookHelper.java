package com.fben.wcic.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fben.wcic.model.Dish;
import com.fben.wcic.model.Ingredient;

public class DishYouCanCookHelper {

	public DishYouCanCookHelper(){}
	
	//works only if ojects list is ordered
	public List<Dish> parseResult(List<Object[]> objects) {
		List<Dish> result = new ArrayList<Dish>();
		if(objects.size()==0){
			return result;
		}
		Dish temp = new Dish(objects.get(0));
		for(Object[] obj : objects){
			if(!temp.getId().equals(((BigInteger)obj[0]).longValue()))
			{
				result.add(temp);
				temp = new Dish(obj);
			}
			temp.getIngredients().add(
						new Ingredient(
						((BigInteger)obj[9]).longValue(),
						(String)obj[10]
								));
		}
		result.add(temp);
		return result;
	}
}
