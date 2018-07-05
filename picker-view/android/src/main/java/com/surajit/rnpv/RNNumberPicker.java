package com.surajit.rnpv;

import javax.annotation.Nullable;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

public class RNNumberPicker extends NumberPicker {

    private @Nullable OnChangeListener mOnChangeListener;
    private boolean mSuppressNextEvent;
    private @Nullable Integer mStagedSelection;
    private @Nullable Integer mTextSize;
    private @Nullable Integer mTextColor;

    /**
     * Listener interface for events.
     */
    public interface OnChangeListener {
        void onValueChange(int value);
    }

    public RNNumberPicker(Context context) {
        super(context);
        initView();
    }

    public RNNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public RNNumberPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView(){
        //disable the typing
        //enableNumberPickerManualEditing(this,false);
    }

    public void enableNumberPickerManualEditing(NumberPicker numPicker, boolean enable) {
        int childCount = numPicker.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View childView = numPicker.getChildAt(i);
            if (childView instanceof EditText) {
                EditText et = (EditText) childView;
                et.setFocusable(enable);
                return;
            }
        }
    }

    public void setOnChangeListener(@Nullable OnChangeListener onValueChangeListener) {
        setOnValueChangedListener(
            new OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    if (!mSuppressNextEvent && mOnChangeListener != null) {
                        mOnChangeListener.onValueChange(newVal);
                    }
                    mSuppressNextEvent = false;
                }
            }
        );
        mOnChangeListener = onValueChangeListener;
    }

    @Nullable public OnChangeListener getOnChangeListener() {
        return mOnChangeListener;
    }

    /**
     * Will cache "selection" value locally and set it only once {@link #updateStagedSelection} is
     * called
     */
    public void setStagedSelection(int selection) {
        mStagedSelection = selection;
    }

    public void updateStagedSelection() {
        if (mStagedSelection != null) {
            setValueWithSuppressEvent(mStagedSelection);
            mStagedSelection = null;
        }
    }

    /**
     * Set the selection while suppressing the follow-up event.
     * This is used so we don't get an event when changing the selection ourselves.
     *
     * @param value
     */
    private void setValueWithSuppressEvent(int value) {
        if (value != getValue()) {
            mSuppressNextEvent = true;
            setValue(value);
        }
    }

}
