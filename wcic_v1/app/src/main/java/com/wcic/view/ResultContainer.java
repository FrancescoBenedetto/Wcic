package com.wcic.view;

import java.io.File;
import java.util.List;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;
import com.wcic.model.Dish;
import com.wcic.model.Ingredient;

public class ResultContainer extends HorizontalLayout{
	
	private final String difficultyDetailImgLocation = "src/main/webapp/VAADIN/themes/mytheme/difficulty_lvl_1.png";
	private final String personsDetailImgLocation = "src/main/webapp/VAADIN/themes/mytheme/persons.png";
	private final String timeDetailImgLocation = "src/main/webapp/VAADIN/themes/mytheme/clock.png";

	
	public ResultContainer(Dish dish) {
		super();
		this.setWidth(100, Unit.PERCENTAGE);
		VerticalLayout dishInfoContainer = createDishInfoComponent(
				dish.getDishType(),
				dish.getDishName(),
				dish.getIngredients(),
				dish.getDifficulty(),
				dish.getPersons(),
				dish.getTime());
		this.addComponent(dishInfoContainer);
		VerticalLayout linkLayout = createLinkComponent(dish.getHyperlink(), dish.getWebsiteName());
		this.addComponent(linkLayout);
		this.setComponentAlignment(linkLayout, Alignment.MIDDLE_CENTER);
		this.setExpandRatio(dishInfoContainer, 2);
		this.setExpandRatio(linkLayout, 1);
	}

	private VerticalLayout createDishInfoComponent(String dishType, String dishName, List<Ingredient> ingredients, String difficulty, String persons, String time) {
		VerticalLayout dishInfoContainer = new VerticalLayout();
		dishInfoContainer.addComponent(createDishTypeView(dishType));
		dishInfoContainer.addComponent(createDishNameView(dishName));
		dishInfoContainer.addComponent(createIngredientsContainer(ingredients));
		dishInfoContainer.addComponent(createDetailsContainer(difficulty, persons, time));
		return dishInfoContainer;
	}

	private VerticalLayout createLinkComponent(String hyperlink, String websiteName) {
		VerticalLayout linkLayout = new VerticalLayout();
		Link l = new Link("Guarda", new ExternalResource(hyperlink));
		l.setTargetName("_blank");
		linkLayout.addComponent(l);
		linkLayout.setComponentAlignment(l, Alignment.MIDDLE_CENTER);
		return linkLayout;
	}

	
	private Label createDishTypeView(String dishType) {
		Label dishTypeLabel = new Label(dishType);
		dishTypeLabel.setStyleName("dish-type");
		return dishTypeLabel;
	}
	
	private Label createDishNameView(String dishName) {
		Label dishNameLabel = new Label(dishName);
		dishNameLabel.setStyleName("dish-name");
		return dishNameLabel;
	}
	
	private CssLayout createIngredientsContainer(List<Ingredient> ingredients) {
		CssLayout ingredientsContainer = new CssLayout();
		for(Ingredient ingredient: ingredients) {
			Label label = new Label(" • " + ingredient.getName());
			label.setSizeUndefined();
			label.setStyleName("dish-ingredient");
			ingredientsContainer.addComponent(label);
		}
		return ingredientsContainer;
	}
	
	
	
	private HorizontalLayout createDetailsContainer(String difficulty, String persons, String time) {
		HorizontalLayout hv = new HorizontalLayout();
		hv.addStyleName("details-container");
		CssLayout difficultyLayout = createDetail("difficulty", difficulty, difficultyDetailImgLocation);
		CssLayout personsLayout = createDetail("persons", persons, personsDetailImgLocation);
		CssLayout timeLayout = createDetail("time", time, timeDetailImgLocation);
		hv.addComponent(difficultyLayout);
		hv.addComponent(personsLayout);
		hv.addComponent(timeLayout);
		return hv;
	}
	
	private CssLayout createDetail(String detailName, String detailValue, String imgLocation) {
		CssLayout layout = new CssLayout();
		Label detailLabel = new Label(detailName + ":");
		Label detailValueLabel = new Label(detailValue);
		detailLabel.setStyleName("dish-detail");
		detailValueLabel.setStyleName("dish-detail-value");
		FileResource resource = new FileResource(new File(imgLocation));
		Image image = new Image(null,resource);
		image.setHeight(10, Unit.PERCENTAGE);
		image.setWidth(10, Unit.PERCENTAGE);
		layout.addComponent(image);
		layout.addComponent(detailLabel);
		layout.addComponent(detailValueLabel);
		return layout;
	}
		
 }
