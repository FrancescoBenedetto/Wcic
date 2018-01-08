package com.wcic.presenter;


import com.vaadin.ui.Component;
import com.wcic.service.IngredientService;
import com.wcic.view.SearchBarView;
import com.wcic.view.SearchBarViewListener;
import com.wcic.view.SearchToolsView;
import com.wcic.view.SearchToolsViewListener;

public class SearchToolsPresenter implements SearchToolsViewListener {

	IngredientService service;
	SearchToolsView view;
	Component searchBar;
	SearchBarViewListener searchBarListener;
	
	public SearchToolsPresenter(IngredientService service, SearchToolsView view) {
		this.service = service;
		this.view = view;
		this.view.setListener(this);
	}
		
}