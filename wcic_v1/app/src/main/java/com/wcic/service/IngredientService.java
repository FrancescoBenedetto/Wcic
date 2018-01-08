package com.wcic.service;

import java.util.ArrayList;

import com.wcic.model.Ingredient;

public interface IngredientService {

	ArrayList<Ingredient> getTopNMatchingIngredients(String pattern);
	
}
