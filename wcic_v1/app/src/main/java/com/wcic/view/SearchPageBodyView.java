package com.wcic.view;

import com.vaadin.ui.VerticalLayout;

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
		SearchView sc = new SearchView();
		DishListView rc = new DishListView();
		this.addComponent(sc);
		this.addComponent(rc);
	}
}
