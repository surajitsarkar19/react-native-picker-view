
# react-native-picker-view

## Getting started

`$ npm install react-native-picker-view --save`

### Mostly automatic installation

`$ react-native link react-native-picker-view`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-picker-view` and add `SRSPickerView.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libSRSPickerView.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.surajit.rnpv.SRSPickerViewPackage;` to the imports at the top of the file
  - Add `new SRSPickerViewPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-picker-view'
  	project(':react-native-picker-view').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-picker-view/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-picker-view')
  	```


## Usage
```javascript
import Picker from 'react-native-picker-view';

// TODO: What to do with the module?
<Picker
      values={["Kolkata","Delhi","Hydrabad","Banglore","Pune"]}
      selected={this.state.index}
      style={{width:100,height:200}}
      enableInput={false}
      onSelect={(value,index) => {
          console.log('onSelect', value, index);
          this.setState({index})
      }}
  />
```

## Sample Output

| Android | IOS |
|:---:|:---:|
| <img src="https://raw.githubusercontent.com/surajitsarkar19/react-native-picker-view/master/images/android.gif" width="100%"></img> | <img src="https://raw.githubusercontent.com/surajitsarkar19/react-native-picker-view/master/images/ios.gif" width="80%"></img> |


## props

#### values
Array of values. Array item must be of type string.

#### selected
It is the index of the item that needs to be selected in Picker view. It is a 0 based index. Index less than zero is not supported.

#### enableInput (Android Only)
It is a boolean flag that is determined whether to activate keyboard input in Picker view. This flag is used only for android. 

#### onSelect
It is a callback function, which is called from the library when a selection is changed.
Its signature is :--
```javascript
(selectedValue, selectedIndex) => {
   //selectedValue is the value of the selected item.
   //selectedIndex is the index of the item. 
}
```

  
