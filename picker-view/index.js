
import React, { Component } from 'react';
import { requireNativeComponent, View, Picker, Platform} from 'react-native';
import PropTypes from 'prop-types';

import AndroidNumberPicker from "./AndroidNumberPicker"


export default class NumberPicker extends Component {

    static defaultProps = {
        selected: 0,
        enableInput: true
    };

    static propTypes = {
        ...View.propTypes,
        selected: PropTypes.number,
        values: PropTypes.arrayOf(PropTypes.string).isRequired,
        onSelect: PropTypes.func,
        enableInput: PropTypes.bool
    };

    constructor(props) {
        super(props);
    }

    render() {
        return Platform.select({
            ios: this.renderIOS(),
            android: this.renderAndroid()
        });
    }

    renderAndroid(){
        let { values, style, selected, onSelect, enableInput } = this.props
        let height = this.getHeightFromStyle(style);
        return (
            <AndroidNumberPicker
                values={values}
                style={[style]}
                selectedIndex={selected}
                height={height}
                enableInput={enableInput}
                onSelect={(index)=>{
                    onSelect(values[index],index);
                }}
            />
        );
    }

    getHeightFromStyle(style){
        let height = 200;
        if(!style)
            return height;
        if(Array.isArray(style)){
            style.some((item)=>{
                if(item.hasOwnProperty("height")){
                    height = item.height;
                    return true;
                }
            });
        } else{
            if(style.hasOwnProperty("height")){
                height = style.height;
            }
        }
        return height;
    }

    renderIOS(){
        let { values, style, selected, onSelect } = this.props;
        let items = [];
        values.forEach((value,index)=>{
           items.push(
               <Picker.Item label={value} value={value} key={index} />
           )
        });
        return (
            <Picker
                selectedValue={values[selected]}
                style={[style]}
                onValueChange={onSelect}>
                {items}
            </Picker>
        );
    }
}
