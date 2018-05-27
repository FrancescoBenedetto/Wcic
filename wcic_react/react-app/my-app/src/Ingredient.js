import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';


class Ingredient extends React.Component {

  constructor(props){
    super(props);
    this.remove = this.remove.bind(this);
  }

  remove(){
    this.props.onRemove(this.props.name);
  }

  render(){
    const name = this.props.name;
    return (
      <div>
      <span style={{wordWrap:'break-word'}}>{name}</span>
      <span class="close" onClick={this.remove}>x</span>
      </div>
    )
  }
}

export default Ingredient
