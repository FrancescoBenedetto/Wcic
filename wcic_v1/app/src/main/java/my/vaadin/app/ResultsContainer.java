package my.vaadin.app;

import com.vaadin.ui.VerticalLayout;
import com.wcic.model.Dish;

public class ResultsContainer extends VerticalLayout {

	public ResultsContainer() {
		this.addComponent(new ResultContainer(new Dish("Primi Piatti", "Short Name", "medium", "10", "www.try.com/lasagna", "try")));
		this.addComponent(new ResultContainer(new Dish("Primi Piatti", "Loooooooooooooooooooooong Name", "medium", "10", "www.try.com/lasagna", "try")));
	}
	
}
