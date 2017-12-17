package my.vaadin.app;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.Orientation;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
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
		this.addComponent(searchBar);
		this.addComponent(slider);
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
}
