import React from 'react';
import Ingredient from './Ingredient.js'
import 'bootstrap/dist/css/bootstrap.min.css';


class IngredientList extends React.Component {
  constructor(props){
    super(props);
  }

  render() {
    let ingredients = this.props.ingredients.map((ingredient, index) =>
        <li key={index} className={"list-group-item " + (index%2==0 ? 'bg-info' : 'bg-light')}>
          <Ingredient
            name={ingredient}
            onRemove={this.props.onIngredientRemove}
            >
            </Ingredient>
        </li>
      )

    return (
      <ul class="ingredients list-group">
        {ingredients}
      </ul>
    )
  }
}

export default IngredientList
