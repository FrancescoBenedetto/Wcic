package com.fben.wcic.controllersTest;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fben.wcic.controllers.DishYouCanCookHelper;
import com.fben.wcic.model.Dish;

public class DishYouCanCookHelperTest {

	List<Object[]> objects;
	DishYouCanCookHelper helper;
	
	@Before
	public void setUp() throws Exception {
		objects = new ArrayList<Object[]>();
		objects.add(new Object[]{new BigInteger("1"),"17 Marzo","Mettere i primi tre ingredienti nello shaker con ghiaccio. Mischiare la panna liquida con lo zabaglione. Versare il contenuto dello shaker nel bicchiere (doppia coppetta da cocktail) ed aggiungere il resto.","Bevande",null,"1",null,null,"China Martini",new BigInteger("3"),"Vanil Zucca"});
		helper = new DishYouCanCookHelper();		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseQueryResultOneIngredient() {
		List<Dish> result = helper.parseResult(objects);
		assertEquals(1,result.size());
		assertEquals(1,result.get(0).getIngredients().size());
	}
	
	@Test
	public void testParseQueryResult2Ingredients(){
		objects.add(new Object[]{new BigInteger("1"),"17 Marzo","Mettere i primi tre ingredienti nello shaker con ghiaccio. Mischiare la panna liquida con lo zabaglione. Versare il contenuto dello shaker nel bicchiere (doppia coppetta da cocktail) ed aggiungere il resto.","Bevande",null,"1",null,null,"China Martini",new BigInteger("174631"),"China Martini"});
		List<Dish> result = helper.parseResult(objects);
		assertEquals(1,result.size());
		assertEquals(2,result.get(0).getIngredients().size());
	}
	
	@Test
	public void testParseQueryResult2Dishes(){
		objects.add(new Object[]{new BigInteger("2"),"Piatto Mio","Mettere i primi tre ingredienti nello shaker con ghiaccio. Mischiare la panna liquida con lo zabaglione. Versare il contenuto dello shaker nel bicchiere (doppia coppetta da cocktail) ed aggiungere il resto.","Bevande",null,"1",null,null,"China Martini",new BigInteger("174631"),"China Martini"});
		List<Dish> result = helper.parseResult(objects);
		assertEquals(2,result.size());
		assertEquals(1,result.get(1).getIngredients().size());
	}
	
	@Test
	public void testParseQueryResult2DishesFirst2Ings(){
		objects.add(new Object[]{new BigInteger("1"),"17 Marzo","Mettere i primi tre ingredienti nello shaker con ghiaccio. Mischiare la panna liquida con lo zabaglione. Versare il contenuto dello shaker nel bicchiere (doppia coppetta da cocktail) ed aggiungere il resto.","Bevande",null,"1",null,null,"China Martini",new BigInteger("174631"),"China Martini"});
		objects.add(new Object[]{new BigInteger("2"),"Piatto Mio","Mettere i primi tre ingredienti nello shaker con ghiaccio. Mischiare la panna liquida con lo zabaglione. Versare il contenuto dello shaker nel bicchiere (doppia coppetta da cocktail) ed aggiungere il resto.","Bevande",null,"1",null,null,"China Martini",new BigInteger("174631"),"China Martini"});
		List<Dish> result = helper.parseResult(objects);
		assertEquals(2,result.size());
		assertEquals(2,result.get(0).getIngredients().size());
		assertEquals(1,result.get(1).getIngredients().size());
		System.out.println(result);
	}
	
	

}
