package com.wcic.presenter;

import com.wcic.view.SelectedIngredientElementViewListener;

public class SelectedIngredientElementPresenter implements SelectedIngredientElementViewListener {

	SelectedIngredientListPresenter listener;
	
	public SelectedIngredientElementPresenter() {}
	
	@Override
	public void onRemove(String ingredient) {
		this.listener.removeIngredient(ingredient);
	}
	
	public void setParentListener(SelectedIngredientListPresenter listener) {
		this.listener = listener;
	}

}
