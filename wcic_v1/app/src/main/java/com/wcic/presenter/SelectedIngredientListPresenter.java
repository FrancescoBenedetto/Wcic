package com.wcic.presenter;

import java.util.HashMap;
import java.util.Map;

import com.wcic.view.SelectedIngredientListView;
import com.wcic.view.SelectedIngredientListViewListener;
import com.wcic.view.impl.SelectedIngredientElementViewImpl;

public class SelectedIngredientListPresenter implements SelectedIngredientListViewListener{

	private Map<String, SelectedIngredientElementViewImpl> ingredient2View;
	SelectedIngredientListView view;
	
	public SelectedIngredientListPresenter(SelectedIngredientListView view) {
		ingredient2View = new HashMap<String, SelectedIngredientElementViewImpl>();
		this.view = view;
		this.view.addListener(this);
	}
	
	@Override
	public void addIngredient(String ingredient) {
		if(this.ingredient2View.containsKey(ingredient)) {
			return;
		}
		SelectedIngredientElementViewImpl ingView = new SelectedIngredientElementViewImpl(ingredient);
		this.ingredient2View.put(ingredient, ingView);
		this.view.addIngredient(ingView);
	}

	@Override
	public void removeIngredient(String ingredient) {
		if(!ingredient.contains(ingredient)) {
			return;
		}
		this.view.removeIngredient(this.ingredient2View.get(ingredient));
		this.ingredient2View.remove(ingredient);
	}

}
