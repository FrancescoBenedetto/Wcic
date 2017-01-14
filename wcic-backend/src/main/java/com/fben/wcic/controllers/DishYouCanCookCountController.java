package com.fben.wcic.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fben.wcic.persistence.DishRepository;

@RestController
public class DishYouCanCookCountController {
	
	private final DishRepository repository;
	
	@Autowired
	public DishYouCanCookCountController(DishRepository repo){
		repository = repo;
	}
	
	@RequestMapping(value="/dish/search/countMatchingDishes")
    public @ResponseBody Integer countMatchingDishes(
    									 @RequestParam("ingredients") String[] ingredients,
    									 @RequestParam(value="types", defaultValue="Bevande,Antipasto,Pesce,Salsa,Dessert,Primo,Carne,Contorno,Pollame") String[] types,
    									 @RequestParam(value="atLeast", defaultValue="1") Integer atLeast
    									 )
    {
    	System.out.println("Qui");
		// TODO: validate input
	 return repository.countMatchingDishes(ingredients, types, atLeast).intValue();
	}

}
