package com.chnt.gr.preOrder.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.chnt.gr.preOrder.R;

/**
 * Created by Christina Chaniotaki (christinachaniotaki96@gmail.com) on 08,April,2019
 */
public class InputLayoutWithEditTextView extends FrameLayout {

    private TextInputLayout inputLayout;
    private TextInputEditText inputEditText;

    public InputLayoutWithEditTextView(Context context) {
        super(context);
    }

    public InputLayoutWithEditTextView(Context context, AttributeSet attrs)  {
        super(context, attrs);
        setup(context, attrs);
    }

    private void setup(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_input_layout_edit_text, this);

        inputLayout = findViewById(R.id.inputLayout);
        inputEditText = findViewById(R.id.inputEditText);

        TypedArray attributeArray = context.obtainStyledAttributes(attrs, R.styleable.InputLayoutWithEditTextView);
        setLayoutError(attributeArray.getString(R.styleable.InputLayoutWithEditTextView_itemInputLayout));
        setEditTextValue(attributeArray.getString(R.styleable.InputLayoutWithEditTextView_itemEditTextValue));
        setEditTextHint(attributeArray.getString(R.styleable.InputLayoutWithEditTextView_itemEditTextHint));
        setEditTestInputType(attributeArray.getInt(R.styleable.InputLayoutWithEditTextView_android_inputType, InputType.TYPE_CLASS_TEXT));
        attributeArray.recycle();
        initListeners();
    }


    public void  setLayoutError(String errorText) { inputLayout.setError(errorText);}

    public void  setEditTextValue(String value) { inputEditText.setText(value); }

    public String getEditTextValue() { return inputEditText.getText().toString().trim(); }

    public void  setEditTextHint(String hint) { inputLayout.setHint(hint); }

    public void  setEditTestInputType(Integer type) { inputEditText.setInputType(type); }

    private void  initListeners() {
        inputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                inputLayout.setError(null);
            }
        });
    }
}
