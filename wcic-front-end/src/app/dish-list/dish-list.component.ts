/**
 * New typescript file
 */
import { Component, EventEmitter, Output } from '@angular/core';
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

   @Output() done = new EventEmitter();

  searchRecipes(params): void {
    this.dishService
      .getDishes(params.selectedIngredients, params.atLeast, params.dishType, params.page)
      .subscribe(dishes => {
        this.dishes = dishes
        if(params.page === 1) {
          this.done.emit(params);
        }
      });
  }

  getDishes(): Dish[] {
    return this.dishes;
  }

}
