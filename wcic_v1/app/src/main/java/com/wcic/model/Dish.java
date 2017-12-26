package com.wcic.model;

import java.util.ArrayList;
import java.util.List;

public class Dish {

	private String dishType, dishName, difficulty, persons, time, hyperlink, websiteName;
	private List<Ingredient> ingredients;





	public Dish(String dishType, String dishName, String difficulty,
			String persons, String time, String hyperlink, String websiteName) {
		this.dishType = dishType;
		this.dishName = dishName;
		this.difficulty = difficulty;
		this.persons = persons;
		this.time = time;
		this.hyperlink = hyperlink;
		this.websiteName = websiteName;
		this.ingredients = new ArrayList<Ingredient>();
	}
	
	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
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

	public String getPersons() {
		return persons;
	}

	public void setPersons(String persons) {
		this.persons = persons;
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
