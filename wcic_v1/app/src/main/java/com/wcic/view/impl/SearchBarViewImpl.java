package com.wcic.view.impl;

import org.vaadin.addons.autocomplete.AutocompleteExtension;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import com.wcic.view.SearchBarView;
import com.wcic.view.SearchBarViewListener;

@SuppressWarnings("deprecation")
public class SearchBarViewImpl extends CustomComponent implements SearchBarView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3286997091185467047L;
	/**
	 * 
	 */
	private TextField searchIngredientTextField;
	private Button clearTextButton;
	private SearchBarViewListener listener;
	AutocompleteExtension<String> ingredientSuggestions;

	public SearchBarViewImpl() {
		searchIngredientTextField = new TextField();
		searchIngredientTextField.setPlaceholder("Search an ingredient...");
		searchIngredientTextField.setValueChangeMode(ValueChangeMode.LAZY);
		ingredientSuggestions = new AutocompleteExtension<>(
				searchIngredientTextField);
		ingredientSuggestions.setSuggestionDelay(500);
		ingredientSuggestions.setSuggestionGenerator(listener::suggestIngredients);
		ingredientSuggestions.addSuggestionSelectListener(event -> {
		    event.getSelectedItem().ifPresent(Notification::show);
		});

		clearTextButton = new Button(FontAwesome.TIMES);
		clearTextButton.addClickListener(e -> searchIngredientTextField.clear());

		CssLayout searchBarLayout = new CssLayout();
		searchBarLayout.addComponents(searchIngredientTextField, clearTextButton);
		searchBarLayout.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		this.setCompositionRoot(searchBarLayout);
	}
	
	public void setListener(SearchBarViewListener listener) {
		this.listener = listener;
}
	
}