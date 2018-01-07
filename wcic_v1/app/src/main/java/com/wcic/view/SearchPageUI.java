package com.wcic.view;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.swing.GroupLayout.Alignment;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class SearchPageUI extends UI {
    
      /* (non-Javadoc)
     * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        HorizontalLayout header = new SearchPageHeaderView();
        SearchPageBodyView content = new SearchPageBodyView();
        SearchPageFooterView footer = new SearchPageFooterView();
        layout.addComponent(header);
        layout.addComponent(content);
        layout.addComponent(footer);
        
        
        
//        layout.addComponent(header);
//
//        filterText.setPlaceholder("filter by name...");
//        filterText.addValueChangeListener(e -> updateList());
//        filterText.setValueChangeMode(ValueChangeMode.LAZY);
//
//        Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
//        clearFilterTextBtn.setDescription("Clear the current filter");
//        clearFilterTextBtn.addClickListener(e -> filterText.clear());
//
//        CssLayout filtering = new CssLayout();
//        filtering.addComponents(filterText, clearFilterTextBtn);
//        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
//
//        grid.setColumns("firstName", "lastName", "email");
//
//        HorizontalLayout main = new HorizontalLayout(grid, form);
//        main.setSizeFull();
//        grid.setSizeFull();
//        main.setExpandRatio(grid, 1);
//
//        layout.addComponents(filtering, main);
//
//        // fetch list of Customers from service and assign it to Grid
//        updateList();

        setContent(layout);
    }

    public void updateList() {
       }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = SearchPageUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
