package com.wcic.view;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class SearchComponent extends HorizontalLayout {

	public SearchComponent() {
		init();
	}
	
	private void init() {
		VerticalLayout ingredientsContainer = new IngredientsContainerComponent();
		VerticalLayout searchToolsContainer = new SearchToolsComponent();

		this.addComponent(searchToolsContainer);
		this.addComponent(ingredientsContainer);
	}
	

}
