package com.wcic.view;

import com.vaadin.ui.VerticalLayout;
import com.wcic.view.impl.SearchViewImpl;

public class SearchPageBodyView extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchPageBodyView() {
		super();
		init();
	}

	private void init() {
		SearchViewImpl sc = new SearchViewImpl();
		DishListView rc = new DishListView();
		this.addComponent(sc);
		this.addComponent(rc);
	}
}
