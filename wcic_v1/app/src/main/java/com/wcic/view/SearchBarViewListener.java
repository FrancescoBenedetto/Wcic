package com.wcic.view;

import java.util.List;

import com.wcic.presenter.SelectedIngredientListPresenter;


public interface SearchBarViewListener {

	List<String> suggestIngredients(String query, int cap);

	void setSiblingPresenter(SelectedIngredientListPresenter selectedIngPresenter);

	public void ingredientSelected(String ingredientName);
}
