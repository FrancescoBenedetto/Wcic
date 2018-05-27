import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import 'font-awesome/css/font-awesome.min.css';


class Recipe extends React.Component {
  render(){
    return (
      <div>
        <table>
          <tbody>
            <tr>
          <td>

            <h5 class="recipe-name text-primary">
              <a href="#">{this.props.name}</a>
            </h5>
            <table>
              <tbody>
                <tr>
              <td>
                <div class="detail">
                <i class="fa fa-line-chart detail" aria-hidden="true">
                  <span class="detail-description">&nbsp;difficoltà:</span>
                {this.props.difficulty}&nbsp;</i>
                </div>
              </td>
              <td>
                <div class="detail">

                <i class="fa fa-clock-o detail" aria-hidden="true">
                  <span class="detail-description">&nbsp;tempo:</span>
                  {this.props.time}&nbsp;</i>
              </div>
              </td>
              <td>
                <div class="detail">
                <i class="fa fa-eur detail" aria-hidden="true">
                  <span class="detail-description">&nbsp;costo:</span>
                  {this.props.cost}&nbsp;
                </i>
              </div>
              </td>
              </tr>
              </tbody>
            </table>
          </td>
        </tr>
          </tbody>
        </table>
      </div>
    )
  }
}

export default Recipe
