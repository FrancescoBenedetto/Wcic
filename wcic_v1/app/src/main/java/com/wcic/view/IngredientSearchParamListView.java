package com.wcic.view;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.VerticalLayout;

public class IngredientSearchParamListView extends VerticalLayout{
	
	CssLayout container;
	
	public IngredientSearchParamListView() {
		super();
		initContainer();
		container = initContainer();
		this.addComponent(container);
		this.addIngredient(new IngredientSearchParamView("ingredient1"));
		this.addIngredient(new IngredientSearchParamView("ingredient2"));
		this.addIngredient(new IngredientSearchParamView("loooooooooooooooooooooooooooooongIngredient"));
		this.addIngredient(new IngredientSearchParamView("loooooooooooooooooooooooooooooongIngredient"));


	}
	
	private CssLayout initContainer() {
		CssLayout c = new CssLayout();
		return c;
	}
	
	public void addIngredient(IngredientSearchParamView ingredient) {
		this.container.addComponent(ingredient);
	}
	
	
	
	
}
