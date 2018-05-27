import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import RecipesFinder from './RecipesFinder.js'

class App extends React.Component {
  render(){
  return (
    <div>
    <div className="alert alert-primary" role="alert">
      This is a primary alert—check it out!
    </div>
    <div class="container">
      <RecipesFinder></RecipesFinder>
    </div>

    </div>
  )
  }
}


// ========================================

ReactDOM.render(
  <App/>,
  document.getElementById('root')
);
