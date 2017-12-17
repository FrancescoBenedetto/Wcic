package com.fben.wcic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fben.wcic.model.Dish;
import com.fben.wcic.persistence.DishRepository;

@RestController
public class DishYouCanCookController {
	
	private final DishRepository repository;
	private DishYouCanCookHelper helper;
	private DishYouCanCookValidator validator;
	private final Integer pageSize = 10;
	
	@Autowired
	public DishYouCanCookController(DishRepository repo){
		repository = repo;
		helper = new DishYouCanCookHelper();
		validator = new DishYouCanCookValidator();
	}
	

	@RequestMapping(value="/dish/search/getDishes")
    public @ResponseBody List<Dish> getDishYouCanCook(
    									 @RequestParam("ingredients") String[] ingredients,
    									 @RequestParam(value="types", defaultValue="Bevande,Antipasto,Pesce,Salsa,Dessert,Primo,Carne,Contorno,Pollame") String[] types,
    									 @RequestParam("atLeast")Integer atLeast,
    									 @RequestParam("page")Integer page){
		validator.isValid(ingredients, atLeast, page);
		return helper.parseResult(
				 repository.getDishContainingAtLeastNOfTheseIngredients(
						 					  ingredients,
						 					  types,
						 					  atLeast,
						 					  (page-1)*pageSize,
				 							   pageSize));
	}


}
