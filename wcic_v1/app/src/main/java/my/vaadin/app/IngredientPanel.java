package my.vaadin.app;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.ValoTheme;

public class IngredientPanel extends CssLayout {

	public IngredientPanel(String ingredientName) {
		super();
		Panel ingredientNamePanel = new Panel(ingredientName);
		ingredientNamePanel.setSizeUndefined();
	    Button removeIngredientBtn = new Button(FontAwesome.TIMES);
	    this.addComponents(ingredientNamePanel, removeIngredientBtn);
	    this.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
	}
	
}
