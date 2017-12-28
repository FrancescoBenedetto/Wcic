package my.vaadin.app;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class ContentComponent extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContentComponent() {
		super();
		init();
	}

	private void init() {
		SearchComponent sc = new SearchComponent();
		ResultsContainer rc = new ResultsContainer();
		this.addComponent(sc);
		this.addComponent(rc);
	}
}
