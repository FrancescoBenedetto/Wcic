package com.wcic.model;

import java.util.ArrayList;

public class Dish {

	private String dishType, dishName, difficulty, time, hyperlink, websiteName;
	private ArrayList<Ingredient> ingredients;





	public Dish(String dishType, String dishName, String difficulty,
			String time, String hyperlink, String websiteName) {
		this.dishType = dishType;
		this.dishName = dishName;
		this.difficulty = difficulty;
		this.time = time;
		this.hyperlink = hyperlink;
		this.websiteName = websiteName;
	}
	
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}



	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

}
