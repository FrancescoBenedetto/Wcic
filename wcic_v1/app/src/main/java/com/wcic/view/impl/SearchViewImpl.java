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
import com.wcic.presenter.SelectedIngredientListPresenter;
import com.wcic.service.IngredientsDummyService;
import com.wcic.view.SearchToolsView;
import com.wcic.view.SelectedIngredientListView;


public class SearchViewImpl extends CustomComponent {
	

	HorizontalLayout baseLayout;
	
	public SearchViewImpl() {
		
		baseLayout = new HorizontalLayout();
		SelectedIngredientListViewImpl ingredientsContainer = new SelectedIngredientListViewImpl();
		SelectedIngredientListPresenter ingContainerpresenter = new SelectedIngredientListPresenter(ingredientsContainer);
		SearchToolsView searchToolsContainer = new SearchToolsFactory().buildSearchToolsComponent(ingContainerpresenter);

		this.baseLayout.addComponent(searchToolsContainer);
		this.baseLayout.addComponent(ingredientsContainer);
		
		this.setCompositionRoot(baseLayout);
	}
	

}
