package com.fben.wcic.comparators;

import java.util.Comparator;

import com.fben.wcic.model.Dish;

public class DishComparatorByName implements Comparator<Dish>{

	@Override
	public int compare(Dish arg0, Dish arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}

}
