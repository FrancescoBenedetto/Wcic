package com.fben.wcic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fben.wcic.persistence.DishRepository;

@RestController
public class DishTypesController {
	
	private final DishRepository repository;

	@Autowired
	public DishTypesController(DishRepository repo){
		repository = repo;
	}
	
	@RequestMapping(value="/dish/search/getDishTypes")
    public @ResponseBody List<String> getDishYouCanCook() {
		return repository.getDishTypes();
	}
}
