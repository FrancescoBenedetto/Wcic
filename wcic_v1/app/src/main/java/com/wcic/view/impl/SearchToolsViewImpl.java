package com.wcic.view.impl;

import java.util.ArrayList;


import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Slider;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wcic.presenter.SearchBarPresenter;
import com.wcic.service.IngredientsDummyService;
import com.wcic.view.SearchBarViewListener;
import com.wcic.view.SearchToolsView;
import com.wcic.view.SearchToolsViewListener;

public class SearchToolsViewImpl extends CustomComponent
implements SearchToolsView {


	private static final long serialVersionUID = -3627823991707009190L;
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private SearchToolsViewListener listener;
	VerticalLayout searchToolsLayout;


	public SearchToolsViewImpl() {
		searchToolsLayout = new VerticalLayout();		
		this.setCompositionRoot(searchToolsLayout);
	}
	
	public void init() {
		Slider slider = createNumberOfIngredientsSlider();
		Button b = createSearchButton();
		VerticalLayout cbox = createDishTypeCheckBox();
		searchToolsLayout.addComponent(slider);
		searchToolsLayout.addComponent(cbox);
		searchToolsLayout.addComponent(b);
	}
	
	public void addComponent(Component component) {
		searchToolsLayout.addComponent(component);
	}

	private Slider createNumberOfIngredientsSlider() {
		Slider s = new Slider("select min # of ingredients:",1,5);
		s.setStyleName("ingredients-slider");
		return s;
	}

	private Button createSearchButton() {
		Button b = new Button("search recipes");
		b.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		//b.addStyleName("recipe-search-button");
		return b;
	}

	private VerticalLayout createDishTypeCheckBox() {
		ArrayList<String> dishTypes = new ArrayList<String>();
		dishTypes.add("Primi Piatti");
		dishTypes.add("Secondi Piatti");
		dishTypes.add("Dessert");
		VerticalLayout cbContainer = new VerticalLayout();
		for(String type: dishTypes) {
			CheckBox cb = new CheckBox(type);
			cb.setValue(true);
			cbContainer.addComponent(cb);
		}
		return cbContainer;
	}

	@Override
	public void setListener(SearchToolsViewListener listener) {
		this.listener = listener;
	}
}
