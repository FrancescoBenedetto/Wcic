import React from 'react';
import {InfiniteLoader} from 'react-virtualized'
import RecipesFinder from './RecipesFinder.js';

let recipes2 = [
  {name:"Spaghetti all'amatriciana 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta alla norma 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta e ceci 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta alla norma 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta e ceci 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Merluzzo e patate 4",cost:"medio", difficulty:"media", time:"2'"}];

const url = new URL("http://localhost:8080/dish/search/getDishes");
const rowCount = 1000000;

class RecipesLoader extends React.Component {
  constructor(props){
    super(props);
    this._isRowLoaded = this._isRowLoaded.bind(this);
    this._loadMoreRows = this._loadMoreRows.bind(this);
    this.reloadRows = this.reloadRows.bind(this);
    this.state = {recipes : [], totalNumber:10};
  }

  _isRowLoaded({index}){
    return !!this.state.recipes[index];
  }

  _loadMoreRows({startIndex, stopIndex}, otherParams) {
    console.log(startIndex,stopIndex);
    console.log(otherParams);
    //let params = {atLeast: 1, ingredients:this.state.}
    return new Promise((startIndex, stopIndex)=>
    {this.setState({recipes : this.state.recipes.concat(recipes2)});});
  }

  reloadRows(searchParams){
    this.setState({totalNumber: 20})
    return new Promise((startIndex, stopIndex)=>{this.setState({recipes : recipes2});});
  }

  render(){
    return (
      <InfiniteLoader
        isRowLoaded={this._isRowLoaded}
        loadMoreRows={this._loadMoreRows}
        rowCount={rowCount}
      >
      {({ onRowsRendered, registerChild }) => (
        <RecipesFinder
          onRowsRendered={onRowsRendered}
          ref={registerChild}
          recipes={this.state.recipes}
          reloadRecipes={this.reloadRows}
          rowCount={this.state.totalNumber}
          >
          </RecipesFinder>
      )
      }
    </InfiniteLoader>
  )
  }
}

export default RecipesLoader;
