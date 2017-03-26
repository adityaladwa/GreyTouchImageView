package com.ladwa.aditya.greytouchimageview;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * A Custom {@link android.widget.ImageView} that add GreyScale Effect on Touch
 * Created by Aditya on 26-Mar-17.
 */

public class GreyTouchImageView extends AppCompatImageView {

    private final String TAG = GreyTouchImageView.class.getSimpleName();


    public GreyTouchImageView(Context context) {
        super(context);
    }

    public GreyTouchImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GreyTouchImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                ColorMatrix matrix = new ColorMatrix();
                matrix.setSaturation(0);
                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
                if (getDrawable() != null) {
                    getDrawable().setColorFilter(filter);
                } else {
                    Log.e(TAG, "No image View Set");
                }
                return true;
            case MotionEvent.ACTION_UP:
                ColorMatrix colorMatrix = new ColorMatrix();
                ColorMatrixColorFilter colorfilter = new ColorMatrixColorFilter(colorMatrix);
                if (getDrawable() != null) {
                    getDrawable().setColorFilter(colorfilter);
                } else {
                    Log.e(TAG, "No image View Set");
                }
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }
}
