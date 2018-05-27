import Slider from 'rc-slider'
import Tooltip from 'rc-tooltip';
import React, { Component } from 'react'
import 'rc-tooltip/assets/bootstrap.css';
import 'rc-slider/assets/index.css';

const wrapperStyle = { width: 170 };

class SliderWrapper extends Component {

  constructor(props){
    super(props);
  }

  render(){
    const Handle = Slider.Handle;
    const handle = (props) => {
    const { value, dragging, index, ...restProps } = props;
    return (
      <Tooltip
        prefixCls="rc-slider-tooltip"
        overlay={value}
        visible={dragging}
        placement="top"
        key={index}
      >
        <Handle value={value} {...restProps} />
      </Tooltip>
    );
  };


    return (
      <div style={wrapperStyle}>
        <p># minimo di ingredienti:</p>
        <Slider
          min={1}
          max={this.props.ingredientsNumber}
          //dots={true}
          handle={handle}
          >
        </Slider>
      </div>
)
  }
}

export default SliderWrapper
