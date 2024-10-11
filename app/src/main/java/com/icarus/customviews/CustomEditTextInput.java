package com.icarus.customviews;

import android.content.Context;
import com.google.android.material.textfield.TextInputEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

/**
 * Created by Monika Rana on 13/05/2020
 */
public class CustomEditTextInput extends TextInputEditText implements TextWatcher {
    public CustomEditTextInput(Context context) {
        super(context);
    }

    public CustomEditTextInput(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomEditTextInput(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() > 0) {
            setError("");
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
