package com.wcic.view.impl;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;
import com.wcic.view.SelectedIngredientListView;
import com.wcic.view.SelectedIngredientListViewListener;

public class SelectedIngredientListViewImpl extends CustomComponent implements SelectedIngredientListView{
	
	private CssLayout container;
	private SelectedIngredientListViewListener listener;
	
	public SelectedIngredientListViewImpl() {
		VerticalLayout baseLayout = new VerticalLayout();
		container = new CssLayout();
		baseLayout.addComponent(container);
		this.setCompositionRoot(baseLayout);

	}
	
	public void addIngredient(SelectedIngredientElementViewImpl ingredientView) {
		this.container.addComponent(ingredientView);
	}
	
	public void removeIngredient(SelectedIngredientElementViewImpl ingredientView) {
		this.container.removeComponent(ingredientView);
	}

	@Override
	public void addListener(SelectedIngredientListViewListener listener) {
		this.listener = listener;
	}
	
	
	
	
}
