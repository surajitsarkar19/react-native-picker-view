import React, {Component} from 'react';
import {requireNativeComponent, View} from 'react-native';
import PropTypes from 'prop-types';

export default class AndroidNumberPicker extends Component {

    static defaultProps = {
        selectedIndex: 0,
        height: 200,
        enableInput: true
    };

    static propTypes = {
        ...View.propTypes,
        height: PropTypes.number,
        selectedIndex: PropTypes.number,
        values: PropTypes.arrayOf(PropTypes.string).isRequired,
        onSelect: PropTypes.func,
        enableInput: PropTypes.bool
    };

    constructor(props) {
        super(props);
        this.state = this._stateFromProps(props);
        this._onChange = this._onChange.bind(this);
        this.picker = null;
    }

    componentWillReceiveProps(props) {
        //this.props = props;
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

        if (this.picker && this.state.selectedIndex !== event.nativeEvent.value)
            this.picker.setNativeProps({selected: this.state.selectedIndex});

    }

    render() {
        let {style, ...otherProps} = this.props;

        return (
            <NativeNumberPicker
                ref={(ref)=>{this.picker = ref}}
                selected={this.state.selectedIndex}
                values={this.state.values}
                onChange={this._onChange}
                style={[{height: this.props.height}, style && style]}
                {...otherProps}
            />
        );
    }

}

let NativeNumberPicker = requireNativeComponent('SRSPickerView', AndroidNumberPicker, {
    nativeOnly: {
        onChange: true,
        selected: true,
    }
});
