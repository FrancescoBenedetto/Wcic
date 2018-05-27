import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-toggle/css/bootstrap-toggle.min.css';
import ToggleWrapper from './ToggleWrapper.js'
import _ from 'lodash'




class DishTypeSelector extends React.Component {
  constructor(props){
      super(props);
      this.updateOptions = this.updateOptions.bind(this);
  }

  updateOptions(option){
    var temp = this.props.options.slice();
    var index = _.findIndex(temp, {name: option.name});
    // Replace item at index using native splice
    temp.splice(index, 1, {name: option.name, value: option.value});
    this.props.onValueChange(temp);
  }

  setListItems() {
    return this.props.options.map( (option, index) =>
      <li key={index} class="list-group-item">
    <div>
      <label>
        <ToggleWrapper
          value={option.value}
          name={option.name}
          onToggle={this.updateOptions}
          >
        </ToggleWrapper>
      &nbsp;{option.name}
    </label>
    </div>
    </li>
    )
  }

  render() {
    let listOptions = this.setListItems();
    return (
      <div class="input-group">
        <h6>{this.props.header}</h6>
        <ul class="list-group">
          {listOptions}
        </ul>
      </div>
    )
  }
}

export default DishTypeSelector
