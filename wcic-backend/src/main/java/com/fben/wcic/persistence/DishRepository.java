package com.fben.wcic.persistence;

import java.math.BigInteger;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fben.wcic.model.Dish;

@RepositoryRestResource(collectionResourceRel = "dish", path = "dish")
public interface DishRepository extends PagingAndSortingRepository<Dish, Long>{

	public List<Dish> findByIngredients_NameIn(@Param("ingredients") List<String> ingredients);


	@Query(value=
		"SELECT desired_dishes.id as id, desired_dishes.name,instructions,type,time,persons,difficulty,origin,primary_ingredient,ingredient.id as ingredient_id,ingredient.name as ingredient_name"
		+ " FROM"
		+ " ("
		+ " SELECT *"
		+ " FROM"
		+ "	( SELECT recipe_composition.id_dish, COUNT(id_dish) as ings_matched FROM dish, ingredient, recipe_composition"
		+ " WHERE ingredient.name IN ?1"
		+ "	AND dish.id = recipe_composition.id_dish "
		+ "	AND ingredient.id = recipe_composition.id_ingredient"
		+ " AND dish.type IN ?2"
		+ "	GROUP BY `recipe_composition`.`id_dish` ) as counting_table,"
		+ " dish "
		+ "	WHERE counting_table.ings_matched >= ?3 AND counting_table.id_dish=dish.id"
		+ "	ORDER BY name"
		+ "	LIMIT ?4,?5"
		+ " )"
		+ " as desired_dishes, ingredient, recipe_composition"
		+ " WHERE desired_dishes.id=recipe_composition.id_dish AND ingredient.id=recipe_composition.id_ingredient",
		nativeQuery = true)
	public List<Object[]> getDishContainingAtLeastNOfTheseIngredients(
			String[] ingredients,
			String[] types,
			Integer atLeast,
			Integer from,
			Integer offset);
	
	@Query(value="SELECT COUNT(*) " +
			" FROM ("+
			" SELECT recipe_composition.id_dish, COUNT(id_dish) as ings_matched"+ 
			" FROM recipe_composition, ingredient, dish"+
			" WHERE ingredient.name IN ?1"+ 
		 	" AND ingredient.id = recipe_composition.id_ingredient"+
		 	" AND dish.id = recipe_composition.id_dish"+
			" AND dish.type IN ?2"+
		 	" GROUP BY recipe_composition.id_dish ) as counting_table"+
		 	" WHERE counting_table.ings_matched >= ?3",
			nativeQuery=true)
	public BigInteger countMatchingDishes(
		    String[] ingredients,
			String[] types,
			Integer atLeast);
	
	
	@Query(value="SELECT DISTINCT d.type FROM Dish d")
	public List<String> getDishTypes();
}
