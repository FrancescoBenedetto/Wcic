/**
 * New typescript file
 */
import { Component } from '@angular/core';
import { DishService } from '../services/dish.service';
import { Dish } from '../model/dish';

@Component({
  selector: 'dish-list',
  templateUrl: './dish-list.component.html',
  styleUrls: ['./dish-list.component.css']
})

export class DishListComponent {

  dishes: Dish[];

  constructor(private dishService: DishService) {
    this.dishes = [];
   }


  searchRecipes(params): void {
    this.dishService
      .getDishes(params.selectedIngredients, params.atLeast, params.dishType, params.page)
      .subscribe(dishes => this.dishes = dishes);
  }

}
