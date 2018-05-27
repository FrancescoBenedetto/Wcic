import React from 'react'
import RecipeList from './RecipeList.js'
import IngredientsHandler from './IngredientsHandler.js'
import RecipeFinderFiltersHandler from './RecipeFinderFiltersHandler.js'
import RecipesLoader from './RecipesLoader.js'
import 'bootstrap/dist/css/bootstrap.min.css';


class RecipesFinder extends React.Component {
  constructor(props){
    super(props);
    this.addIngredient = this.addIngredient.bind(this);
    this.removeIngredient = this.removeIngredient.bind(this);
    this.updateFilters = this.updateFilters.bind(this);

    this.state = {
      ingredientSearchText: '',
      filters: {
        dishType:
        [{name:"Antipasto", value:true},
         {name:"Primo Piatto", value:true},
         {name:"Secondo Piatto", value: true},
         {name:"Dessert", value:true}
        ]
      },
      selectedIngredients: [
        "Melanzana", "Spaghetti", "Pomodori",
        "Spaghetti alla chitarra", "Zverev",
        "Funghi Porcini", "Ceci"]
    }
  }

  addIngredient(ingredient){
    var temp = this.state.selectedIngredients.slice();
    if(!temp.includes(ingredient)){
      temp.unshift(ingredient);
      this.setState({selectedIngredients: temp})
      }
    }

  removeIngredient(ingredient){
    var temp = this.state.selectedIngredients.slice();
    var index = temp.indexOf(ingredient);
    if (index > -1) {
      temp.splice(index, 1);
      this.setState({selectedIngredients: temp})
    }
  }

  updateFilters(dishType){
    this.setState({filters: {dishType: dishType}})
  }

  render(){
    return (
        <div class="row">
          <div class="col-4">
            <RecipeFinderFiltersHandler
              ingredientsNumber={this.state.selectedIngredients.length}
              dishType={this.state.filters.dishType}
              onDishTypeChange={this.updateFilters}
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
              <RecipesLoader sparams={this.state}/>
            </div>
          </div>
      </div>

    )
  }
}

export default RecipesFinder;
