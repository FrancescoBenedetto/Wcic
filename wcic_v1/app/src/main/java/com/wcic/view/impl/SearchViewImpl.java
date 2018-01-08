package com.wcic.view.impl;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wcic.factory.SearchToolsFactory;
import com.wcic.presenter.SearchToolsPresenter;
import com.wcic.service.IngredientsDummyService;
import com.wcic.view.IngredientSearchParamListView;
import com.wcic.view.SearchToolsView;


public class SearchViewImpl extends CustomComponent {
	

	HorizontalLayout baseLayout;
	
	public SearchViewImpl() {
		
		baseLayout = new HorizontalLayout();
		VerticalLayout ingredientsContainer = new IngredientSearchParamListView();
		SearchToolsView searchToolsContainer = new SearchToolsFactory().buildSearchToolsComponent();

		this.baseLayout.addComponent(searchToolsContainer);
		this.baseLayout.addComponent(ingredientsContainer);
		
		this.setCompositionRoot(baseLayout);
	}
	

}
