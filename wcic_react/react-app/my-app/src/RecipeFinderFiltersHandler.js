import React from 'react';
import SliderWrapper from './SliderWrapper.js';
import DishTypeSelector from './DishTypeSelector.js';

class RecipeFinderFiltersHandler extends React.Component {
  constructor(props){
    super(props);
  }

  render(){
    return(
      <div>
        <div class="slider-container">
          <SliderWrapper
            ingredientsNumber={this.props.ingredientsNumber}
            onSliderValueChange={this.props.onSliderValueChange}
            >
            </SliderWrapper>
        </div>
        <div class="dish-selector-container">
          <DishTypeSelector
            header={"seleziona il tipo di piatto"}
            options={this.props.dishType}
            onValueChange={this.props.onDishTypeChange}
            >
          </DishTypeSelector>
        </div>
      </div>
    )
  }
}

export default RecipeFinderFiltersHandler;
