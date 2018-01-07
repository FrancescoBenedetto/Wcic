package com.wcic.view;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.ValoTheme;

public class IngredientSearchParamView extends CssLayout {

	public IngredientSearchParamView(String ingredientName) {
		super();
		Panel ingredientNamePanel = new Panel(ingredientName);
		ingredientNamePanel.setSizeUndefined();
	    Button removeIngredientBtn = new Button(FontAwesome.TIMES);
	    this.addComponents(ingredientNamePanel, removeIngredientBtn);
	    this.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
	}
	
}
