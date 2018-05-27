import React from 'react';
import {InfiniteLoader} from 'react-virtualized'
import RecipeList from './RecipeList.js';

let list2 = [
  {name:"Spaghetti all'amatriciana 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta alla norma 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta e ceci 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Merluzzo e patate 4",cost:"medio", difficulty:"media", time:"2'"}];

const rowCount = 100;

class RecipesLoader extends React.Component {
  constructor(props){
    super(props);
    this.rowCount = rowCount;
    this._isRowLoaded = this._isRowLoaded.bind(this);
    this._loadMoreRows = this._loadMoreRows.bind(this);
    this.state = {list : []};
  }

  componentDidUpdate(prevProps, prevState){
    console.log('prevProps: ');console.log(prevProps);
    console.log('prevState: '); console.log(prevState);
    console.log('updated!')
  }

  _isRowLoaded({index}){
    return !!this.state.list[index];
  }

  _loadMoreRows({startIndex, stopIndex}) {
    return new Promise((startIndex, stopIndex)=>{this.setState({list : this.state.list.concat(list2)});});
  }

  render(){
    return (
      <InfiniteLoader
        isRowLoaded={this._isRowLoaded}
        loadMoreRows={this._loadMoreRows}
        rowCount={this.rowCount}
      >
      {({ onRowsRendered, registerChild }) => (
        <RecipeList
          onRowsRendered={onRowsRendered}
          ref={registerChild}
          list={this.state.list}
          >
        </RecipeList>
      )
      }
    </InfiniteLoader>
  )
  }
}

export default RecipesLoader;
