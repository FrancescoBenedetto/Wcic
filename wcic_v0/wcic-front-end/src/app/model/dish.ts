/**
 * New typescript file
 */
import { Ingredient } from './ingredient';

export class Dish {
  id: number;
  name: string;
  instructions: string;
  type: string;
  ingredients: Ingredient[];
}
