/**
 * New typescript file
 */
import { Injectable }     from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Ingredient } from '../model/ingredient';
import { IngredientDTO } from '../dto/ingredientDTO';

@Injectable()
export class IngredientService {

  dto: IngredientDTO;

  constructor(private http: Http) {
    this.dto = new IngredientDTO();
  }

  /*
  search(term: string): Observable<Ingredient[]> {
    return this.http
               .get('app/ingredients/?name=^' + term + '')
               .map((r: Response) => r.json().data as Ingredient[]);
  }
   */
  search(term: string): Observable<Ingredient[]> {
    return this.http
               .get('http://localhost:8080/ingredient/search/nameStartingWith?term=' + term + '&size=5')
               .map((r: Response) => r.json()._embedded.ingredient
                      .map(this.dto.transformFromHATEOAS) as Ingredient[]);
  }

}
