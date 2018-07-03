
import React, { Component, PropTypes } from 'react';
import { requireNativeComponent, View} from 'react-native';

var REF_PICKER = 'numberpicker';

class NumberPicker extends Component {

    constructor(props) {
        super(props);
        this.state = this._stateFromProps(props);
        this._onChange = this._onChange.bind(this);
    }

    componentWillReceiveProps(props) {
        this.props = props;
        this.setState(this._stateFromProps(props))
    }

    _stateFromProps(props) {
        return {
            selectedIndex: props.selectedIndex,
            values: props.values
        };
    }

    _onChange(event) {

        if (this.props.onSelect)
            this.props.onSelect(event.nativeEvent.value);

        if (this.refs[REF_PICKER] && this.state.selectedIndex !== event.nativeEvent.value)
            this.refs[REF_PICKER].setNativeProps({selected: this.state.selectedIndex});

    }

    render() {
        var { values, style, ...otherProps } = this.props;

        return (
            <NativeNumberPicker
        ref={REF_PICKER}
        selected={this.state.selectedIndex}
        values={this.state.values}
        onChange={this._onChange}
        style={[{height:this.props.height}, style && style]}
        {...otherProps}
        />
    );
    }
}

NumberPicker.defaultProps  = {
    selectedIndex: 0,
    height: 100,
};

NumberPicker.propTypes = {
    ...View.propTypes,
    height: PropTypes.number,
    selectedIndex: PropTypes.number,
    values: PropTypes.arrayOf(PropTypes.string).isRequired,
    onSelect: PropTypes.func,
};

var NativeNumberPicker = requireNativeComponent('SRSPickerView', NumberPicker, {
    nativeOnly: {
        onChange: true,
        selected: true,
    }
});

module.exports = NumberPicker;
