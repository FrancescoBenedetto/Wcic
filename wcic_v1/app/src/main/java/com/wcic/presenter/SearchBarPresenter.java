package com.wcic.presenter;

import java.util.List;
import java.util.stream.Collectors;
import com.wcic.service.IngredientService;
import com.wcic.view.SearchBarView;
import com.wcic.view.SearchBarViewListener;

public class SearchBarPresenter implements SearchBarViewListener {
	
	IngredientService service; 
	SearchBarView view;
	SelectedIngredientListPresenter selectedIngPresenter;

	public SearchBarPresenter(IngredientService service, SearchBarView view) {
		this.service = service;
		this.view = view;
		this.view.setListener(this);
	}
	
	@Override
	public List<String> suggestIngredients(String query, int cap) {
		// TODO Auto-generated method stub
		return service.getTopNMatchingIngredients(query).stream()
				.map(i -> i.getName())
				.limit(cap)
				.collect(Collectors.toList());
	}
	
	public void setSiblingPresenter(SelectedIngredientListPresenter selectedIngPresenter) {
		this.selectedIngPresenter = selectedIngPresenter;
	}
	
	public void ingredientSelected(String ingredientName) {
		this.selectedIngPresenter.addIngredient(ingredientName);
	}


}
