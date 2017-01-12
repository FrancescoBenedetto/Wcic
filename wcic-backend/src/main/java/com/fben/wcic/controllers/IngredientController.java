package com.fben.wcic.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fben.wcic.model.Ingredient;
import com.fben.wcic.persistence.IngredientRepository;

public class IngredientController {

	private IngredientRepository repo;
	
	@RequestMapping("/ingredients/retrieve")
    @ResponseBody
    public String createMovie(String name) {
        Ingredient ingredient = new Ingredient(name);
        try {
            repo.findByName("Pera");
        } catch (Exception e) {
            //Application.getLogger().error(e.getMessage());
            return e.getMessage();
        }
        return "retrieval successful: " + String.valueOf(ingredient.getId());
    }
}
