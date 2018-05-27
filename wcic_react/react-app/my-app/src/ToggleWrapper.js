import React from 'react'
import Toggle from 'react-bootstrap-toggle';
import 'bootstrap-toggle/css/bootstrap-toggle.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';



class ToggleWrapper extends React.Component {
  constructor(props) {
    super(props);
    this.state = { toggleActive: props.value, toggleColor: "primary" };
    this.onToggle = this.onToggle.bind(this);
  }

  onToggle() {
    //let color = !this.state.toggleActive ? "primary" : "default";
    this.setState({ toggleActive: !this.state.toggleActive});
    this.props.onToggle({name:this.props.name, value: !this.state.toggleActive})
  }

  render() {
    return (
        <Toggle
          onClick={this.onToggle}
          on={"si"}
          off={"no"}
          size="sm"
          onstyle="info"
          handlestyle="primary"
          active={this.state.toggleActive}
        ></Toggle>
    )
  }
}

export default ToggleWrapper
