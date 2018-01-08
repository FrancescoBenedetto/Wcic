package com.wcic.view;

import java.util.List;


public interface SearchBarViewListener {

	List<String> suggestIngredients(String query, int cap);
	
}
