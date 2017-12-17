package my.vaadin.app;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.VerticalLayout;

public class IngredientsContainerComponent extends VerticalLayout{
	
	CssLayout container;
	
	public IngredientsContainerComponent() {
		super();
		initContainer();
		container = initContainer();
		this.addComponent(container);
		this.addIngredient(new IngredientPanel("ingredient1"));
		this.addIngredient(new IngredientPanel("ingredient2"));
		this.addIngredient(new IngredientPanel("loooooooooooooooooooooooooooooongIngredient"));


	}
	
	private CssLayout initContainer() {
		CssLayout c = new CssLayout();
		return c;
	}
	
	public void addIngredient(IngredientPanel ingredient) {
		this.container.addComponent(ingredient);
	}
	
	
	
	
}
