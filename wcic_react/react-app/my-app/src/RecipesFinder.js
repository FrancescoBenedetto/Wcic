import React from 'react'
import RecipeList from './RecipeList.js'
import IngredientsHandler from './IngredientsHandler.js'
import RecipeFinderFiltersHandler from './RecipeFinderFiltersHandler.js'
import {InfiniteLoader} from 'react-virtualized'
import 'bootstrap/dist/css/bootstrap.min.css';


let recipes2 = [
  {name:"Spaghetti all'amatriciana 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta alla norma 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta e ceci 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta alla norma 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta e ceci 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Merluzzo e patate 4",cost:"medio", difficulty:"media", time:"2'"}];

const url = new URL("http://localhost:8080/dish/search/getDishes");
const rowCount = 1000000;

class RecipesFinder extends React.Component {
  constructor(props){
    super(props);
    this.addIngredient = this.addIngredient.bind(this);
    this.removeIngredient = this.removeIngredient.bind(this);
    this.updateFilters = this.updateFilters.bind(this);
    this.updateAtLeast = this.updateAtLeast.bind(this);

    this._isRowLoaded = this._isRowLoaded.bind(this);
    this._loadMoreRows = this._loadMoreRows.bind(this);

    this.fetchRecipes = this.fetchRecipes.bind(this);
    this.getRecipesTotalCount = this.getRecipesTotalCount.bind(this);

    this.state = {
      filters: {
        atLeast: 1,
        dishType:
        [{name:"Antipasto", value:true},
         {name:"Primo Piatto", value:true},
         {name:"Secondo Piatto", value: true},
         {name:"Dessert", value:true}
        ]
      },
      selectedIngredients: [],
      recipes: [],
      totalRecipes: 0
    }
  }

  updateRecipes(){
    //console.log("trigger update")
    this.getRecipesTotalCount();
    this.fetchRecipes(0,10);
  }

  addIngredient(ingredient){
    var temp = this.state.selectedIngredients.slice();
    if(!temp.includes(ingredient)){
      temp.unshift(ingredient);
      this.setState({selectedIngredients: temp}, this.updateRecipes);
      }
    }

  removeIngredient(ingredient){
    var temp = this.state.selectedIngredients.slice();
    var index = temp.indexOf(ingredient);
    if (index > -1) {
      temp.splice(index, 1);
      this.setState({selectedIngredients: temp}, this.updateRecipes);
    }
  }

  updateFilters(dishType){
    var filters = this.state.filters;
    filters.dishType = dishType;
    this.setState({filters: filters}, this.updateRecipes);
  }

  updateAtLeast(value) {
    //console.log(value);
    var filters = this.state.filters;
    filters.atLeast = value;
    this.setState({filters: filters}, this.updateRecipes);
  }

  _isRowLoaded({index}){
    return !!this.state.recipes[index];
  }

  _loadMoreRows({startIndex, stopIndex}) {
    console.log(startIndex,stopIndex);
    //console.log(otherParams);
    //let params = {atLeast: 1, ingredients:this.state.}
    //this.fetchRecipes(0,1);
    /*
    return new Promise((startIndex, stopIndex)=>
    {this.setState({recipes : this.state.recipes.concat(recipes2)});});
    */
    return this.fetchRecipes(startIndex, stopIndex);
  }

  getRecipesTotalCount(){
    if(this.state.selectedIngredients.length>0){
      fetch("http://localhost:8080/dish/search/countMatchingDishes?"
      +"ingredients="+this.state.selectedIngredients
      +"&atLeast="+this.state.filters.atLeast)
      .then(response => response.json())
      .then(parsedJson => {this.setState({totalRecipes: parsedJson})})
      //.then(response => {this.setState({totalRecipes: response})})
    }
  }

  fetchRecipes(startIndex, stopIndex){
    if(this.state.selectedIngredients.length>0) {
      let page = Math.floor(stopIndex / 10);
      fetch(url + "?ingredients="+this.state.selectedIngredients
        + "&atLeast="+this.state.filters.atLeast
        + "&page="+page)
        .then(response => response.json() )
        .then(
          parsedJson => parsedJson.map((el) => {return {name: el.name, cost:"medio", difficulty:"media", time:"2'"}})
        )
        .then(mappedResults => {
          if(page>1){
            let buffered = this.state.recipes;
            this.setState({recipes: buffered.concat(mappedResults)})
          }
          else{
            this.setState({recipes: mappedResults});
          }
        }
        )

    }
  }

  render(){
    return (
        <div class="row">
          <div class="col-4">
            <RecipeFinderFiltersHandler
              ingredientsNumber={this.state.selectedIngredients.length}
              dishType={this.state.filters.dishType}
              onDishTypeChange={this.updateFilters}
              onSliderValueChange={this.updateAtLeast}
              >
              </RecipeFinderFiltersHandler>
          </div>
          <div class="col-3">
            <IngredientsHandler
              onAdd={this.addIngredient}
              onRemove={this.removeIngredient}
              ingredients={this.state.selectedIngredients}
              >
            </IngredientsHandler>
          </div>
          <div class="col-5">
            <h5>Ricette</h5>
            <div class="">
              <InfiniteLoader
                isRowLoaded={this._isRowLoaded}
                loadMoreRows={this._loadMoreRows}
                rowCount={rowCount}
              >
              {({ onRowsRendered, registerChild }) => (
                <RecipeList
                  onRowsRendered={onRowsRendered}
                  ref={registerChild}
                  list={this.state.recipes}
                  rowCount={this.state.totalRecipes}
                  >
                </RecipeList>
            )}
              </InfiniteLoader>
            </div>
          </div>
      </div>

    )
  }
}

export default RecipesFinder;
