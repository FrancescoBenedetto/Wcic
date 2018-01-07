package com.wcic.view;

import com.vaadin.addon.pagination.Pagination;
import com.vaadin.addon.pagination.PaginationResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;

public class SearchPageFooterView extends HorizontalLayout {

	
	
	public SearchPageFooterView() {
		this.setWidth(100, Unit.PERCENTAGE);
		Pagination pager = createPager(50, 1, 10);
		this.addComponent(pager);
		this.setComponentAlignment(pager, Alignment.BOTTOM_CENTER);
	}
	
	private Pagination createPager(long total, int page, int limit) {
		PaginationResource paginationResource = PaginationResource.newBuilder()
				.setTotal(total)
				.setPage(page)
				.setLimit(limit)
				.build();
	    Pagination pagination = new Pagination(paginationResource);
	    pagination.setItemsPerPageVisible(false);
	    return pagination;
	}
}
