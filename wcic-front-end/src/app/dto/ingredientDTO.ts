/**
 * New typescript file
 */
/**
 * New typescript file
 */
import { Ingredient } from '../model/ingredient';

export class IngredientDTO {

  transformFromHATEOAS(hateoasIngredient): Ingredient {
    let name = hateoasIngredient.name;
    let id = hateoasIngredient._links.self.href.split('/')[4];
    return new Ingredient(id, name);
  }
}
