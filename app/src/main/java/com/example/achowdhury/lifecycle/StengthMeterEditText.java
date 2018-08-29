package com.example.achowdhury.lifecycle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.design.widget.TextInputEditText;
import android.util.AttributeSet;

import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.MEDIUM;
import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.NONE;
import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.STRONG;
import static com.example.achowdhury.lifecycle.PasswordStrengthMeterLayout.StrengthLevel.WEAK;

public class StengthMeterEditText extends TextInputEditText {
    private PasswordStrengthMeterLayout.StrengthLevel strength = NONE;
    private Paint paint;
    private int totalHeight;
    private int totalWidth;
    private int barWidth;

    public StengthMeterEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(Color.parseColor("#D3D3D3"));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        totalHeight = getMeasuredHeight();
        totalWidth = getMeasuredWidth();
        barWidth = totalWidth/3;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int yAxis = totalHeight - 16;

        if(strength == NONE) {
            paint.setColor(Color.parseColor("#D3D3D3"));
            canvas.drawLine(0, yAxis, totalWidth - 5, yAxis, paint);
        }
        else if(strength == WEAK) {
            paint.setColor(Color.parseColor("#D3D3D3"));
            canvas.drawLine(0, yAxis, totalWidth - 5, yAxis, paint);

            paint.setColor(Color.RED);
            canvas.drawLine(0, yAxis, barWidth, yAxis, paint);
        }
        else if(strength == MEDIUM) {
            paint.setColor(Color.parseColor("#D3D3D3"));
            canvas.drawLine(0, yAxis, totalWidth - 5, yAxis, paint);

            paint.setColor(Color.YELLOW);
            canvas.drawLine(0, yAxis, barWidth + barWidth, yAxis, paint);
        }
        else if(strength == STRONG) {
            paint.setColor(Color.parseColor("#D3D3D3"));
            canvas.drawLine(0, yAxis, totalWidth - 5, yAxis, paint);

            paint.setColor(Color.GREEN);
            canvas.drawLine(0, yAxis, totalWidth - 5, yAxis, paint);
        }

        super.onDraw(canvas);
    }

    public void updateStrength(PasswordStrengthMeterLayout.StrengthLevel strength) {
        this.strength = strength;
    }
}
