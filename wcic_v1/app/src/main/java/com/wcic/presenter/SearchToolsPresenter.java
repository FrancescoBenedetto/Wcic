package com.wcic.presenter;

import java.util.ArrayList;
import java.util.List;

import com.wcic.model.Ingredient;
import com.wcic.service.IngredientsDummyService;
import com.wcic.view.SearchToolsViewListener;
import com.wcic.view.SearchView;

public class SearchToolsPresenter implements SearchToolsViewListener {

	IngredientsDummyService model;
	SearchView view;
	
	List<Ingredient> topNIngredients = new ArrayList<Ingredient>();

	public SearchToolsPresenter(IngredientsDummyService model, SearchView view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void ingredientNameChanged(String ingredientName) {
		List<Ingredient> ingredients = this.model.getIngredients();
	}
	
	
}
