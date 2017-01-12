import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { DishListComponent } from './dish-list/dish-list.component';
import { DishListElementComponent } from './dish-list/dish-list-element.component'
import { IngredientSearchComponent } from './dish-search/ingredient-search.component';
import { SelectedIngredientsComponent } from './dish-search/selected-ingredients.component';
import { DishSearchComponent } from './dish-search/dish-search.component';
import { DishTypeSelectionComponent } from './dish-search/dish-type-selection.component';
import { AppComponent } from './app.component';

import { DishService } from './services/dish.service';
import { IngredientService } from './services/ingredient.service';

import './utils/rxjs-extensions';

import { TruncatePipe } from './custom-pipes/string-truncate.pipe';
import { UppercaseFirst } from './custom-pipes/uppercase-first-letter.pipe';

// Imports for loading & configuring the in-memory web api(fake rest service)
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './utils/in-memory-data.service';


@NgModule({
  declarations: [
    AppComponent,
    DishListComponent,
    DishListElementComponent,
    IngredientSearchComponent,
    SelectedIngredientsComponent,
    DishTypeSelectionComponent,
    DishSearchComponent,
    TruncatePipe,
    UppercaseFirst
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule/*,
    InMemoryWebApiModule.forRoot(InMemoryDataService),*/ // fake api
  ],
  providers: [DishService, IngredientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
