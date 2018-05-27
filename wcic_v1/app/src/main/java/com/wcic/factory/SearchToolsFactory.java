package com.wcic.factory;

import com.wcic.presenter.SearchBarPresenter;
import com.wcic.presenter.SearchToolsPresenter;
import com.wcic.presenter.SelectedIngredientListPresenter;
import com.wcic.service.IngredientService;
import com.wcic.service.IngredientsDummyService;
import com.wcic.view.SearchBarView;
import com.wcic.view.SearchBarViewListener;
import com.wcic.view.SearchToolsView;
import com.wcic.view.SearchToolsViewListener;
import com.wcic.view.impl.SearchBarViewImpl;
import com.wcic.view.impl.SearchToolsViewImpl;

public class SearchToolsFactory {
	
	IngredientService service;

	public SearchToolsFactory() {
		if(service==null) {
			this.service = new IngredientsDummyService();
		}
	}
	
	public SearchToolsView buildSearchToolsComponent(SelectedIngredientListPresenter selectedIngsPresenter) {
		SearchBarView searchBarView = new SearchBarViewImpl();
		SearchBarViewListener searchBarViewPresenter = new SearchBarPresenter(service, searchBarView);
		searchBarViewPresenter.setSiblingPresenter(selectedIngsPresenter);
		SearchToolsView view = new SearchToolsViewImpl();
		view.addComponent(searchBarView);
		view.init();
		SearchToolsViewListener presenter = new SearchToolsPresenter(service, view);
		return view;
	}
}
