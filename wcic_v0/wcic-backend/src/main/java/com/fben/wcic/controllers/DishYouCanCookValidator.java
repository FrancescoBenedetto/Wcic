package com.fben.wcic.controllers;

public class DishYouCanCookValidator {

	public DishYouCanCookValidator(){}
	
	public void isValid(String[] ingredients, Integer atLeast, Integer page){
		ingredientsAreValid(ingredients);
		atLeastIsValid(ingredients, atLeast);
		pageIsValid(page);
	}
	
	private void ingredientsAreValid(String[] ingredients){
		if(ingredients.length==0){
			throw new IllegalArgumentException("You haven't inserted ingredients");
		}
	}
	
	private void atLeastIsValid(String[] ingredients, Integer atLeast) {
		if(atLeast<=0 || ingredients.length<atLeast){
			throw new IllegalArgumentException("atLeast must be positive and"
					+ " not greater than number of ingredients inserted");
		}
	}
	
	private void pageIsValid(Integer page){
		if(page<=0){
			throw new IllegalArgumentException("Page number inserted is "
					+ page.toString()+". Page Number can't be negative.");
		}
	}
}
