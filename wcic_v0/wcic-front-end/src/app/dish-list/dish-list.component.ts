/**
 * New typescript file
 */
import { Component, EventEmitter, Output, Input } from '@angular/core';
import { Dish } from '../model/dish';

@Component({
  selector: 'dish-list',
  templateUrl: './dish-list.component.html',
  styleUrls: ['./dish-list.component.css']
})

export class DishListComponent {

  constructor() {}

   @Input('dishes') dishes: Dish[];

  getDishes(): Dish[] {
    return this.dishes;
  }

}
