package com.wcic.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wcic.model.Ingredient;
import com.wcic.service.IngredientService;
import com.wcic.view.SearchBarView;
import com.wcic.view.SearchBarViewListener;

public class SearchBarPresenter implements SearchBarViewListener {
	
	IngredientService service; 
	SearchBarView view;
	List<Ingredient> topNIngredients = new ArrayList<>();

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


}
