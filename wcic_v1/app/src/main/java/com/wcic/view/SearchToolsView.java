package com.wcic.view;

import com.vaadin.ui.Component;

public interface SearchToolsView extends Component {

	public void init();
	
	public void setListener(SearchToolsViewListener listener);
	
	public void addComponent(Component component);
}
