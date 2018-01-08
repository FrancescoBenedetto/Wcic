package com.wcic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wcic.model.Ingredient;

public class IngredientsDummyService implements IngredientService{

	ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public IngredientsDummyService() {
		this.ingredients.add(new Ingredient("cipolla"));
		this.ingredients.add(new Ingredient("cocco"));
		this.ingredients.add(new Ingredient("pasta grossa"));
		this.ingredients.add(new Ingredient("salame"));
		this.ingredients.add(new Ingredient("uova"));
		this.ingredients.add(new Ingredient("prosciutto"));
	}
	
	public ArrayList<Ingredient> getTopNMatchingIngredients(String pattern) {
		return (ArrayList<Ingredient>) this.ingredients.stream()
				.filter(i -> i.getName().toLowerCase().contains(pattern.toLowerCase()))
				.limit(10)
				.collect(Collectors.toList());
	}
}
