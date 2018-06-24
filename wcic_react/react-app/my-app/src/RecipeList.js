import React from 'react'
import Recipe from './Recipe.js'
import 'bootstrap/dist/css/bootstrap.min.css';
import {List, AutoSizer, InfiniteLoader} from 'react-virtualized';


class RecipeList extends React.Component {
  constructor(props){
    super(props);
    this._rowRenderer = this._rowRenderer.bind(this);
  }

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
        rowCount={this.props.rowCount}
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
