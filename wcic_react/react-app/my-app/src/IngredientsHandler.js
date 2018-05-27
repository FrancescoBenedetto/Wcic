import React from 'react'
import SearchBox from './SearchBox.js';
import IngredientList from './IngredientList.js'


class IngredientsHandler extends React.Component {

  constructor(props){
    super(props);
  }

  render() {
    return (
      <div>
      <h5>Ingredienti</h5>
      <div class="searchbox-container">
      <SearchBox
        onIngredientSelected={this.props.onAdd}
        ></SearchBox>
      </div>
      <div class="ingredients-div">
      <IngredientList
        ingredients={this.props.ingredients}
        onIngredientRemove={this.props.onRemove}
        >
      </IngredientList>
      </div>
      </div>
    )
  }
}

export default IngredientsHandler
