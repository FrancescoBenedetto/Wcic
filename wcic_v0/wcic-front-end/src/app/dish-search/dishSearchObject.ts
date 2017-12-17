/**
 * New typescript file
 */
import { Ingredient } from '../model/ingredient';

export class DishSearchObject {

  ingredients: Ingredient[];
  atLeast: number;
  types: string[];
  pageNumber: number;

  constructor() {}

  setSearchParams(ingredients: Ingredient[], atLeast: number, types: string[], pageNumber: number) {
    this.ingredients = ingredients;
    this.atLeast = atLeast;
    this.types = types;
    this.pageNumber = pageNumber;
  }

  setPage(page:number):void{
    this.pageNumber = page;
  }

  getIngredients(): Ingredient[] {
    return this.ingredients;
  }

  getAtLeast(): number {
    return this.atLeast;
  }

  getPageNumber(): number {
    return this.pageNumber;
  }

  getTypes(): string[] {
    return this.types;
  }

  getSearchParams() {
    return {
      ingredients: this.ingredients,
      atLeast: this.atLeast,
      pageNumber: this.pageNumber,
      types: this.types
    }
  }

}
