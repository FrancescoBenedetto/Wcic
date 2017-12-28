package com.wcic.view;

import java.util.ArrayList;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.Orientation;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class SearchToolsComponent extends VerticalLayout{

	public SearchToolsComponent() {
		super();
		init();
	}
	
	private void init() {
		CssLayout searchBar = createSearchBar();
		Slider slider = createNumberOfIngredientsSlider();
		Button b = createSearchButton();
		VerticalLayout cbox = createDishTypeCheckBox();
		this.addComponent(searchBar);
		this.addComponent(slider);
		this.addComponent(cbox);
		this.addComponent(b);
		
	}
	
	private CssLayout createSearchBar() {
		  TextField searchIngredient = new TextField();
		  searchIngredient.setPlaceholder("Search an ingredient...");
		  searchIngredient.setValueChangeMode(ValueChangeMode.LAZY);
		  
	      Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
	      clearFilterTextBtn.addClickListener(e -> searchIngredient.clear());
	      
	      CssLayout searchBarLayout = new CssLayout();
	      searchBarLayout.addComponents(searchIngredient, clearFilterTextBtn);
	      searchBarLayout.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
	      
	      return searchBarLayout;
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
}
