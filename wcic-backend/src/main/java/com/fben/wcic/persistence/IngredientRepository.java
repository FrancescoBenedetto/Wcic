package com.fben.wcic.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fben.wcic.model.Ingredient;

@RepositoryRestResource(collectionResourceRel = "ingredient", path = "ingredient")
public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Long> {

	List<Ingredient> findByName(@Param("name") String name);
	
	@RestResource(path = "nameIn", rel = "nameIn")
	Page<Ingredient> findIngredientByNameContainingIgnoreCase(@Param("term") String term, Pageable page);
	
	@RestResource(path = "nameStartingWith", rel = "nameStartingWith")
	Page<Ingredient> findIngredientByNameStartingWithIgnoreCase(@Param("term") String term, Pageable page);

}
