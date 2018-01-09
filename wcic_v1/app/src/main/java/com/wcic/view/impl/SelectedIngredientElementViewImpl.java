package com.wcic.view.impl;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.ValoTheme;
import com.wcic.view.SelectedIngredientElementViewListener;

public class SelectedIngredientElementViewImpl extends CssLayout {
	
	SelectedIngredientElementViewListener listener;
	String ingredientName;

	public SelectedIngredientElementViewImpl(String ingredientName) {
		super();
		this.ingredientName = ingredientName;
		Panel ingredientNamePanel = new Panel(ingredientName);
		ingredientNamePanel.setSizeUndefined();
	    Button removeIngredientBtn = new Button(FontAwesome.TIMES);
	    removeIngredientBtn.addClickListener(clickEvent -> onRemove(this.ingredientName));
	    this.addComponents(ingredientNamePanel, removeIngredientBtn);
	    this.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
	}
	
	public void onRemove(String ingredient) {
		this.listener.onRemove(ingredient);
	}
	
	public void setListener(SelectedIngredientElementViewListener listener) {
		this.listener = listener;
	}
	
}
