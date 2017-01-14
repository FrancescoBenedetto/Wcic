/**
 * New typescript file
 */
import { Component, Output, EventEmitter } from '@angular/core';
import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';
import { Dish } from '../model/dish';
import { Ingredient } from '../model/ingredient';
import { DishSearchObject } from './dishSearchObject'
import { DishService } from '../services/dish.service';

@Component({
  selector: 'dish-search',
  templateUrl: './dish-search.component.html',
  styleUrls: [ './dish-search.component.css' ]
})
export class DishSearchComponent {

  private searchObject: DishSearchObject;
  dishes: Dish[];

  constructor(private dishService: DishService) {
    this.searchObject = new DishSearchObject();
    this.dishes = [];
  }

  @Output() searchCompleted = new EventEmitter();

  onDishSearchButtonClick(selectedIngredients: Ingredient[], atLeast: number, dishTypes: string[], page: number):void {
    this.searchObject.setSearchParams(selectedIngredients, atLeast, dishTypes, page);
      this.searchDishes(false);
  }

  changePage(page: number):void {
    this.searchObject.setPage(page);
    this.searchDishes(true);
  }

  searchDishes(isAPageChange:boolean):void {
    this.dishService
      .getDishes(this.searchObject)
      .subscribe(dishes => {
        this.dishes = dishes;
        if(!isAPageChange){ // pager has to init his pages number asking it to the server
          this.searchCompleted.emit(this.searchObject);
        }
      });
  }

}
