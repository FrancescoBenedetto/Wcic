package my.vaadin.app;

import com.vaadin.ui.VerticalLayout;
import com.wcic.model.Dish;
import com.wcic.model.Ingredient;

public class ResultsContainer extends VerticalLayout {

	public ResultsContainer() {
		Dish firstDish = new Dish("Primi Piatti", "Short Name", "medium", "3", "10\'", "www.try.com/lasagna", "try");
		firstDish.addIngredient(new Ingredient("cipolla"));
		firstDish.addIngredient(new Ingredient("patata"));
		firstDish.addIngredient(new Ingredient("aglio"));
		firstDish.addIngredient(new Ingredient("pomodori"));
		firstDish.addIngredient(new Ingredient("lattuga"));
		firstDish.addIngredient(new Ingredient("pasta grossa"));
		firstDish.addIngredient(new Ingredient("peperoni"));
		firstDish.addIngredient(new Ingredient("coda"));
		
		



		Dish secondDish = new Dish("Primi Piatti", "Loooooooooooooooooooooong Name", "medium", "4", "10\'", "www.try.com/lasagna", "try");
		secondDish.addIngredient(new Ingredient("olio"));
		secondDish.addIngredient(new Ingredient("acqua"));
		secondDish.addIngredient(new Ingredient("rombo"));
		secondDish.addIngredient(new Ingredient("patate"));
		secondDish.addIngredient(new Ingredient("acciughe"));
		this.addComponent(new ResultContainer(firstDish));
		this.addComponent(new ResultContainer(secondDish));
	}
	
}
