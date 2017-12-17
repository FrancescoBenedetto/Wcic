package my.vaadin.app;

import java.io.File;

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

public class ResultContainer extends HorizontalLayout{

	public ResultContainer(Dish dish) {
		super();
		VerticalLayout dishInfoContainer = createDishInfoComponent(
				dish.getDishType(),
				dish.getDishName(),
				dish.getDifficulty(),
				dish.getTime());
		this.addComponent(dishInfoContainer);
		VerticalLayout linkLayout = createLinkComponent(dish.getHyperlink(), dish.getWebsiteName());
		this.addComponent(linkLayout);
		this.setComponentAlignment(linkLayout, Alignment.MIDDLE_CENTER);
	}

	private VerticalLayout createDishInfoComponent(String dishType, String dishName, String difficulty, String time) {
		VerticalLayout dishInfoContainer = new VerticalLayout();
		dishInfoContainer.addComponent(createDishTypeView(dishType));
		dishInfoContainer.addComponent(createDishNameView(dishName));
		dishInfoContainer.addComponent(createDetailsContainer(difficulty, time));
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
	
	private HorizontalLayout createDetailsContainer(String difficulty, String time) {
		HorizontalLayout hv = new HorizontalLayout();
		CssLayout difficultyLayout = new CssLayout();
		Label difficultyLabel = new Label(difficulty);
		difficultyLabel.setStyleName("dish-detail");
		FileResource resource = new FileResource(new File(
                "src/main/webapp/VAADIN/themes/mytheme/difficulty_lvl_1.png"));
		Image image = new Image(null,resource);
		image.setHeight(10, Unit.PERCENTAGE);
		image.setWidth(10, Unit.PERCENTAGE);
		difficultyLayout.addComponent(image);
		difficultyLayout.addComponent(difficultyLabel);
		//Label timeLabel = new Label(time);
		//timeLabel.setStyleName("dish-detail");
		hv.addComponent(difficultyLayout);
		//hv.addComponent(timeLabel);
		return hv;
	}
		
 }
