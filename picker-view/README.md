
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
import SRSPickerView from 'react-native-picker-view';

// TODO: What to do with the module?
SRSPickerView;
```
  