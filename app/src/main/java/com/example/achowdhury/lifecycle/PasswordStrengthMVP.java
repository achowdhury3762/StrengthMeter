package com.example.achowdhury.lifecycle;

public interface PasswordStrengthMVP {
    interface View {
        void displayWeak();

        void displayMedium();

        void displayStrong();

        void showCriteriaState(PasswordStrengthMeterLayout.CRITERIA criteria, boolean accept);
    }

    interface Presenter {
        void onCriteriaChecked(PasswordStrengthMeterLayout.CRITERIA criteria, boolean accept);

        void onTextChanged(String text);
    }
}
