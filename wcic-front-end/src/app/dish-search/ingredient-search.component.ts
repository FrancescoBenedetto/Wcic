/**
 * New typescript file
 */
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';
import { IngredientService } from '../services/ingredient.service';
import { Ingredient } from '../model/ingredient';

@Component({
  selector: 'ingredient-search',
  templateUrl: './ingredient-search.component.html',
  styleUrls: [ './ingredient-search.component.css' ]
})
export class IngredientSearchComponent implements OnInit {

  ingredients: Observable<Ingredient[]>;
  dishType: string;
  atLeast: number;
  page: number;
  private searchTerms = new Subject<string>();

  constructor(private ingredientService: IngredientService) {
        this.dishType = 'Qualsiasi';
        this.page = 1;
  }

  @Output() onSelect = new EventEmitter<Ingredient>();

  selectIngredient(ingredient: Ingredient) {
    this.onSelect.emit(ingredient);
  }

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.ingredients = this.searchTerms
      .debounceTime(300)        // wait for 300ms pause in events
      .distinctUntilChanged()   // ignore if next search term is same as previous
      .switchMap(term => term   // switch to new observable each time
        // return the http search observable
        ? this.ingredientService.search(term)
        // or the observable of empty heroes if no search term
        : Observable.of<Ingredient[]>([]))
      .catch(error => {
        // TODO: real error handling
        console.log(error);
        return Observable.of<Ingredient[]>([]);
      });
}
  setDishType(dishType: string) {
    this.dishType = dishType;
  }

}
