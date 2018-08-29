package com.example.achowdhury.lifecycle;

import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.MEDIUM;
import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.NONE;
import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.STRONG;
import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.WEAK;

public class PasswordStrengthCalculator {
    private PasswordStrengthMVP.Presenter presenter;

    public PasswordStrengthCalculator(PasswordStrengthMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    public PasswordStrengthMeterLayout.StrengthLevel determineStrength(String s) {
        if(s.length() <= 4) {
            return WEAK;
        }
        else if(s.length() > 4 && s.length() <= 7) {
            return MEDIUM;
        }
        else if(s.length() > 7) {
            return STRONG;
        }
        return NONE;
    }

    public void determineCriteriaFollowed(String s) {
        determineCharacterCriteria(s);
        determineRepetitionCriteria(s);
        determineLetterCriteria(s);
        determineNumberCriteria(s);
        determineSpecialCharacterCriteria(s);
    }

    private void determineCharacterCriteria(String s) {

    }

    private void determineRepetitionCriteria(String s) {
    }

    private void determineLetterCriteria(String s) {
    }

    private void determineNumberCriteria(String s) {
    }

    private void determineSpecialCharacterCriteria(String s) {
    }
}

