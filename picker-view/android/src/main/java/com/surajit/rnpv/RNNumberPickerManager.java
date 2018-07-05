package com.surajit.rnpv;

import javax.annotation.Nullable;

import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.common.SystemClock;
import com.facebook.react.bridge.ReadableArray;

import java.lang.Integer;
import java.lang.String;

public class RNNumberPickerManager extends SimpleViewManager<RNNumberPicker> {

    public static final String REACT_CLASS = "SRSPickerView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected RNNumberPicker createViewInstance(ThemedReactContext reactContext) {
        return new RNNumberPicker(reactContext);
    }

    @ReactProp(name = "values")
    public void setValues(RNNumberPicker view, @Nullable  ReadableArray items) {
        String[] displayValues = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            displayValues[i] = (String) items.getString(i);
        }

        view.setMinValue(0);
        view.setMaxValue(displayValues.length - 1);
        view.setDisplayedValues(displayValues);
    }

    @ReactProp(name = "selected")
    public void setValue(RNNumberPicker view, Integer selected) {
        view.setValue(selected);
    }

    @ReactProp(name = "enableInput")
    public void enableInput(RNNumberPicker view, boolean enable){
        view.enableNumberPickerManualEditing(view,enable);
    }

    @Override
    protected void addEventEmitters(final ThemedReactContext reactContext, final RNNumberPicker picker) {
        picker.setOnChangeListener(
                new RNNumberPickerEventEmitter(
                        picker,
                        reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher()
                )
        );
    }

    private static class RNNumberPickerEventEmitter implements RNNumberPicker.OnChangeListener {

        private final RNNumberPicker mRNNumberPicker;
        private final EventDispatcher mEventDispatcher;

        public RNNumberPickerEventEmitter(RNNumberPicker reactNumberPicker, EventDispatcher eventDispatcher) {
            mRNNumberPicker = reactNumberPicker;
            mEventDispatcher = eventDispatcher;
        }

        @Override
        public void onValueChange(int value) {
            mEventDispatcher.dispatchEvent(
                new RNNumberPickerChangeEvent(mRNNumberPicker.getId(), SystemClock.nanoTime(), value)
            );
        }
    }

}
