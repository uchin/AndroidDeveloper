package com.muklasin.androiddeveloper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Mukhlasin on 9/26/2015.
 */
public class FontView extends TextView {
    private static final String TAG = FontView.class.getSimpleName();
    //Cache the font load status to improve performance
    private static Typeface font;

    public FontView(Context context) {
        super(context);
        setFont(context);
    }

    public FontView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public FontView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {
        // prevent exception in Android Studio / ADT interface builder
        if (this.isInEditMode()) {
            return;
        }

        //Check for font is already loaded
        if (font == null) {
            try {
                font = Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf");
                Log.d(TAG, "Font awesome loaded");
            } catch (RuntimeException e) {
                Log.e(TAG, "Font awesome not loaded");
            }
        }

        //Finally set the font
        setTypeface(font);
    }
}
