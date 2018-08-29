package com.example.achowdhury.lifecycle;

public class PasswordStrengthPresenter implements PasswordStrengthMVP.Presenter {
    private PasswordStrengthMVP.View view;
    private PasswordStrengthCalculator calcService;

    public PasswordStrengthPresenter(PasswordStrengthMVP.View view) {
        this.view = view;

        calcService = new PasswordStrengthCalculator(this);
    }

    @Override
    public void onCriteriaChecked(PasswordStrengthMeterLayout.CRITERIA criteria, boolean accept) {
        view.showCriteriaState(criteria, accept);
    }

    @Override
    public void onTextChanged(String text) {
        calcService.determineStrength(text);
        calcService.determineCriteriaFollowed(text);
    }
}
