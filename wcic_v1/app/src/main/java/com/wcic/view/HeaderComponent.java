package com.wcic.view;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

public class HeaderComponent extends HorizontalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuBar navBar;
	MenuItem home, search, login;
    
    public HeaderComponent() {
    	super();
    	setHeaderComponents();
    }

	private void setHeaderComponents() {
		MenuBar menuBar = createNavBar();
        Image icon = buildImageIcon();
        this.addComponent(icon);
        this.setExpandRatio(icon, 1);
        this.addComponent(menuBar);
        this.setExpandRatio(menuBar, 3);
        this.setComponentAlignment(icon, Alignment.TOP_LEFT);
        this.setComponentAlignment(menuBar, Alignment.TOP_RIGHT);
        this.setWidth("100%");
        this.setHeight("5%");
	}

	private  MenuBar createNavBar() {
		navBar = new MenuBar();
        home = navBar.addItem("home", null, null);
        search = navBar.addItem("search", null, null);
        login = navBar.addItem("login", null, null);
        return navBar;
	}
	
	private Image buildImageIcon() {
		// Find the application directory
		String basepath = VaadinService.getCurrent()
		                  .getBaseDirectory().getAbsolutePath();

		// Image as a file resource
		FileResource resource = new FileResource(new File(
		                        "src/main/webapp/VAADIN/themes/mytheme/chef_hat_1.jpeg"));

		// Show the image in the application
		Image image = new Image(null,resource);
		image.setHeight(20, Unit.PERCENTAGE);
		image.setWidth(20, Unit.PERCENTAGE);
		
		return image;

	}

}
