package com.wcic.view.impl;

import java.util.ArrayList;

import org.vaadin.addons.autocomplete.AutocompleteExtension;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wcic.view.SearchToolsView;
import com.wcic.view.SearchToolsViewListener;

public class SearchToolsViewImpl extends CustomComponent
implements SearchToolsView {

	private SearchBar searchBar;
	private SearchToolsViewListener listener;


	public SearchToolsViewImpl() {
		VerticalLayout searchToolsLayout = new VerticalLayout();
		searchBar = new SearchBar();
		searchBar.getsearchIngredientTextField()
		.addValueChangeListener(
				event -> listener.ingredientNameChanged(event.getValue())
				);
		Slider slider = createNumberOfIngredientsSlider();
		Button b = createSearchButton();
		VerticalLayout cbox = createDishTypeCheckBox();
		searchToolsLayout.addComponent(searchBar);
		searchToolsLayout.addComponent(slider);
		searchToolsLayout.addComponent(cbox);
		searchToolsLayout.addComponent(b);
		this.setCompositionRoot(searchToolsLayout);
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

	private class SearchBar extends CustomComponent {

		private TextField searchIngredientTextField;
		private Button clearTextButton;

		public SearchBar() {
			searchIngredientTextField = new TextField();
			searchIngredientTextField.setPlaceholder("Search an ingredient...");
			searchIngredientTextField.setValueChangeMode(ValueChangeMode.LAZY);
			
			//watch https://github.com/wbadam/autocomplete-extension
			AutocompleteExtension<String> ingredientSuggestions = new AutocompleteExtension<>(
					searchIngredientTextField);
			//ingredientSuggestions.setSuggestionGenerator(this::suggestPlanet);


			clearTextButton = new Button(FontAwesome.TIMES);
			clearTextButton.addClickListener(e -> searchIngredientTextField.clear());

			CssLayout searchBarLayout = new CssLayout();
			searchBarLayout.addComponents(searchIngredientTextField, clearTextButton);
			searchBarLayout.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
			this.setCompositionRoot(searchBarLayout);
		}

		public TextField getsearchIngredientTextField() {
			return this.searchIngredientTextField;
		}

	}
}
