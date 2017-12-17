/**
 * New typescript file
 */

import { Injectable } from '@angular/core';
import { Http, URLSearchParams } from '@angular/http';
import { Dish } from '../model/dish';
import { Ingredient } from '../model/ingredient';
import { CommonService } from './common-service.service';
import { DishSearchObject } from '../dish-search/dishSearchObject'
import 'rxjs/add/operator/map';


@Injectable()
export class DishService extends CommonService {

  private dishRoot = 'dish';
  private dishBaseUrl: string;

  constructor(protected http: Http) {
    super(http);
    this.dishBaseUrl = this.baseUrl + '/' + this.dishRoot;
  }

  getDishes(searchObject: DishSearchObject) {
    let methodName = 'search/getDishes';
    let params = new URLSearchParams();
    params.set('ingredients', searchObject.getIngredients().map(ingredient => ingredient.name).toString());
    params.set('types', searchObject.getTypes().toString());
    params.set('atLeast', searchObject.getAtLeast().toString());
    params.set('page', searchObject.getPageNumber().toString());

    return this.http.get(
      this.dishBaseUrl + '/' + methodName, {search: params})
      .map(response => <Dish[]>response.json());
  }

  getDishTypes() {
    let methodName = 'search/getDishTypes';
    return this.http.get(this.dishBaseUrl + '/' + methodName)
    .map(response => <string[]> response.json());
  }

  getTotalDishNumber(searchObject: DishSearchObject) {
    let methodName = 'search/countMatchingDishes';
    let params = new URLSearchParams();
    params.set('ingredients', searchObject.getIngredients().map(ingredient => ingredient.name).toString());
    params.set('types', searchObject.getTypes().toString());
    params.set('atLeast', searchObject.getAtLeast().toString());
    
    return this.http.get(this.dishBaseUrl + '/' + methodName, { search: params })
    .map(response => <number> response.json());
  }
}
