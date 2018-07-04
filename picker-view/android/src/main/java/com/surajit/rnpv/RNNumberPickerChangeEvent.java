package com.surajit.rnpv;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class RNNumberPickerChangeEvent extends Event<RNNumberPickerChangeEvent> {
    public static final String EVENT_NAME = "topChange";

    private final int mValue;

    public RNNumberPickerChangeEvent(int id, long uptimeMillis, int value) {
        super(id);
        mValue = value;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap eventData = Arguments.createMap();
        eventData.putInt("value", mValue);
        return eventData;
    }
}