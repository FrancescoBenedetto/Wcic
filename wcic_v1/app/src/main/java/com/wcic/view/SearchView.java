package com.wcic.view;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wcic.view.impl.SearchToolsViewImpl;

public class SearchView extends HorizontalLayout {

	public SearchView() {
		init();
	}
	
	private void init() {
		VerticalLayout ingredientsContainer = new IngredientSearchParamListView();
		SearchToolsViewImpl searchToolsContainer = new SearchToolsViewImpl();

		this.addComponent(searchToolsContainer);
		this.addComponent(ingredientsContainer);
	}
	

}
