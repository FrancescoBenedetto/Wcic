import React from 'react'
import Recipe from './Recipe.js'
import 'bootstrap/dist/css/bootstrap.min.css';
import {List, AutoSizer, InfiniteLoader} from 'react-virtualized';


/*
let list = [
  {name:"Spaghetti all'amatriciana",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta alla norma",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta e ceci",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Merluzzo e patate ",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Spaghetti all'amatriciana 1",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta alla norma 1",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta e ceci 1",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Merluzzo e patate 1",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Spaghetti all'amatriciana 2",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta alla norma 2",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta e ceci 2",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Merluzzo e patate 2",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Spaghetti all'amatriciana 3",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta alla norma 3",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta e ceci 3",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Merluzzo e patate 3",cost:"medio", difficulty:"media", time:"2'"}
]

let list2 = [
  {name:"Spaghetti all'amatriciana 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta alla norma 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Pasta e ceci 4",cost:"medio", difficulty:"media", time:"2'"},
  {name:"Merluzzo e patate 4",cost:"medio", difficulty:"media", time:"2'"}]
*/

class RecipeList extends React.Component {
  constructor(props){
    super(props);
    this._rowRenderer = this._rowRenderer.bind(this);
  }
/*
  render(){
    let recipes = list.map( (recipe) =>
      <li class="list-group-item">
        <Recipe
          name={recipe.name}
          difficulty={recipe.difficulty}
          time={recipe.time}
          cost={recipe.cost}
          >
        </Recipe>
      </li>
  )
    return (
      <ul class="list-group recipes-list">
          {recipes}
      </ul>
    )
  }
  */
  _rowRenderer({
  index,       // Index of row
  isScrolling, // The List is currently being scrolled
  isVisible,   // This row is visible within the List (eg it is not an overscanned row)
  key,         // Unique key within array of rendered rows
  parent,      // Reference to the parent List (instance)
  style        // Style object to be applied to row (to position it);
               // This must be passed through to the rendered row element.
    })
    {
      let content;
        if (index<this.props.list.length) {
            content = (
               <Recipe
                name={this.props.list[index].name}
                difficulty={this.props.list[index].difficulty}
                time={this.props.list[index].time}
                cost={this.props.list[index].cost}
                >
              </Recipe>)
        }
        else {
          content = (<h6>Loading...</h6>)
        }
      return (
        <div key={key} style={style}>
          <li class="list-group-item" key={key}>
              {content}
          </li>
          </div>
      )
    }

  render() {
    return (
    <AutoSizer disableHeight>
      {({width}) => (
      <List
        rowCount={100}
        width={width}
        height={500}
        rowHeight={86}
        rowRenderer={this._rowRenderer}
        onRowsRendered={this.props.onRowsRendered}
        ref={this.props.registerChild}
        noRowsRender={()=>{return (<h5>non ci sono ulteriori elementi!</h5>)}}
        >
      </List>
    )}
  </AutoSizer>
  )}
}

export default RecipeList
