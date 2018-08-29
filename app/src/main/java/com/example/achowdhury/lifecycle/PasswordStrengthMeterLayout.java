package com.example.achowdhury.lifecycle;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.MEDIUM;
import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.STRONG;
import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.WEAK;

public class PasswordStrengthMeterLayout extends LinearLayout implements TextWatcher, PasswordStrengthMVP.View {
    private StengthMeterEditText strengthMeterEditText;
    private PasswordStrengthPresenter presenter;
    private View rootView;

    public PasswordStrengthMeterLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        presenter = new PasswordStrengthPresenter(this);
        LayoutInflater inflater = LayoutInflater.from(context);
        rootView = inflater.inflate(R.layout.layout_password_strength, this);
        strengthMeterEditText = rootView.findViewById(R.id.strength_edit_text);
        strengthMeterEditText.addTextChangedListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        presenter.onTextChanged(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void displayWeak() {
        strengthMeterEditText.updateStrength(WEAK);
        strengthMeterEditText.invalidate();
    }

    @Override
    public void displayMedium() {
        strengthMeterEditText.updateStrength(MEDIUM);
        strengthMeterEditText.invalidate();
    }

    @Override
    public void displayStrong() {
        strengthMeterEditText.updateStrength(STRONG);
        strengthMeterEditText.invalidate();
    }

    @Override
    public void showCriteriaState(CRITERIA criteria, boolean accept) {
        switch(criteria) {
            case CHARACTERS:
                if(accept) {

                }
                else {

                }

            case LETTER:

        }
    }

    enum StrengthLevel {
        NONE,
        WEAK,
        MEDIUM,
        STRONG,
    }

    enum CRITERIA {
        CHARACTERS,
        LETTER,
        NUMBER,
        REPETITION,
        SPECIALCHARS
    }
}
