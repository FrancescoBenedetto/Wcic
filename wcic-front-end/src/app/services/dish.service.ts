/**
 * New typescript file
 */

import { Injectable } from '@angular/core';
import { Http, URLSearchParams } from '@angular/http';
import { Dish } from '../model/dish';
import { Ingredient } from '../model/ingredient';
import { CommonService } from './common-service.service';
import 'rxjs/add/operator/map';


@Injectable()
export class DishService extends CommonService {

  private dishRoot = 'dish';
  private dishBaseUrl: string;

  constructor(protected http: Http) {
    super(http);
    this.dishBaseUrl = this.baseUrl + '/' + this.dishRoot;
  }

  getDishes(ingredients: Ingredient[], atLeast: number, dishTypes: string[], page: number) {
    let methodName = 'search/getDishes';
    let params = new URLSearchParams();
    params.set('ingredients', ingredients.map(ingredient => ingredient.name).toString());
    params.set('types', dishTypes.toString());
    params.set('atLeast', atLeast.toString());
    params.set('page', page.toString());

    return this.http.get(
      this.dishBaseUrl + '/' + methodName, {search: params})
      .map(response => <Dish[]>response.json());
  }

  getDishTypes() {
    let methodName = 'search/getDishTypes';
    return this.http.get(this.dishBaseUrl + '/' + methodName)
    .map(response => <string[]> response.json());
  }
}
