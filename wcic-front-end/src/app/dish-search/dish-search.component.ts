/**
 * New typescript file
 */
import { Component, Output, EventEmitter } from '@angular/core';
import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';
import { Ingredient } from '../model/ingredient';
import { DishService } from '../services/dish.service';

@Component({
  selector: 'dish-search',
  templateUrl: './dish-search.component.html',
  styleUrls: [ './dish-search.component.css' ]
})
export class DishSearchComponent {

  ingredients: Ingredient[];
  dishType: string;
  atLeast: number;
  page: number;

  constructor(private dishService: DishService) {}

  @Output() triggerDishSearch = new EventEmitter();

  searchDishes(selectedIngredients: Ingredient[], atLeast: number, dishType: string, page: number): void {
    this.setSearchParams(selectedIngredients, atLeast, dishType, page);
    this.triggerDishSearch.emit({
      selectedIngredients: selectedIngredients,
      atLeast: atLeast,
      dishType: dishType,
      page: page
    })
  }

  setSearchParams(selectedIngredients: Ingredient[], atLeast: number, dishType: string, page: number): void {
    this.ingredients = selectedIngredients;
    this.atLeast = atLeast;
    this.dishType = dishType;
    this.page = page;
  }

  changePage(page: number) : void{
    this.page = page;
    this.triggerDishSearch.emit({
      selectedIngredients: this.ingredients,
      atLeast: this.atLeast,
      dishType: this.dishType,
      page: this.page
    })
  }
}
