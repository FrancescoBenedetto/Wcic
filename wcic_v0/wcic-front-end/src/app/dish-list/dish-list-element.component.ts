import { Component, Input } from '@angular/core';
import { Dish } from '../model/dish';

@Component({
  selector: 'dish-list-element',
  templateUrl: './dish-list-element.component.html',
  styleUrls: ['./dish-list-element.component.css']
})

export class DishListElementComponent {

  @Input('dish') dish: Dish;
  
}
