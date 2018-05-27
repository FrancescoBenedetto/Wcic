package com.wcic.view;

import com.wcic.view.impl.SelectedIngredientElementViewImpl;

public interface SelectedIngredientListView {

	void addListener(SelectedIngredientListViewListener listener);
	
	void addIngredient(SelectedIngredientElementViewImpl ingView);
	
	void removeIngredient(SelectedIngredientElementViewImpl ingView);
}
