package com.wcic.service;

import java.util.ArrayList;

import com.wcic.model.Ingredient;

public class IngredientsDummyService {

	ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public IngredientsDummyService() {
		this.ingredients.add(new Ingredient("cipolla"));
		this.ingredients.add(new Ingredient("cocco"));
		this.ingredients.add(new Ingredient("pasta grossa"));
		this.ingredients.add(new Ingredient("salame"));
		this.ingredients.add(new Ingredient("uova"));
		this.ingredients.add(new Ingredient("prosciutto"));
	}
	
	public ArrayList<Ingredient> getIngredients() {
		return this.ingredients;
	}
}
