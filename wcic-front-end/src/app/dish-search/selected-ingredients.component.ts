/**
 * New typescript file
 */
import { Component, OnInit } from '@angular/core';
import { Ingredient } from '../model/ingredient';

@Component({
  selector: 'selected-ingredients',
  templateUrl: './selected-ingredients.component.html',
  styleUrls: [ './selected-ingredients.component.css' ]
})

export class SelectedIngredientsComponent {

  private selectedIngredients: Ingredient[];
  atLeast: number;


  constructor() {
    this.selectedIngredients = [];
    this.atLeast = 1;
  }

  addIngredient(ingredient: Ingredient): void {
    if (this.selectedIngredients.find(ing => ingredient.id === ing.id) === undefined) {
          this.selectedIngredients.push(ingredient);
    }
  }

  deleteIngredient(ingredient: Ingredient): void {
    let index = this.selectedIngredients.indexOf(ingredient, 0);
    if (index > -1) {
      this.selectedIngredients.splice(index, 1);
      if(this.atLeast>this.selectedIngredients.length){
        this.selectedIngredients.length>0 ? this.atLeast=this.selectedIngredients.length : this.atLeast=1;
      }
    }
  }

  getSelectedIngredients() {
    return this.selectedIngredients;
  }

  setAtLeast(atLeast: number) {
    this.atLeast = atLeast;
  }
}
