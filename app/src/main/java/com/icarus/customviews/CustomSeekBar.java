package com.icarus.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import com.icarus.R;

/**
 * Created by Monika Rana on 08/11/2019
 */
public class CustomSeekBar extends androidx.appcompat.widget.AppCompatSeekBar {

    private Rect rect;
    private Paint paint ;
    private int seekbar_height;

    public CustomSeekBar(Context context) {
        super(context);
    }

    public CustomSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        rect = new Rect();
        paint = new Paint();
        seekbar_height = 7;
    }

    public CustomSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {

        rect.set(getThumbOffset(),
                (getHeight() / 2) - (seekbar_height/2),
                getWidth()- getThumbOffset(),
                (getHeight() / 2) + (seekbar_height/2));

        paint.setColor(getResources().getColor(R.color.seek_bar_disable_color));
        canvas.drawRect(rect, paint);

        if (this.getProgress() > 50) {
            rect.set(getWidth() / 2,
                    (getHeight() / 2) - (seekbar_height/2),
                    getWidth() / 2 + (getWidth() / 100) * (getProgress() - 50),
                    getHeight() / 2 + (seekbar_height/2));

            paint.setColor(getResources().getColor(R.color.seek_bar_enable_color));
            canvas.drawRect(rect, paint);
        }

        if (this.getProgress() < 50) {
            rect.set(getWidth() / 2 - ((getWidth() / 100) * (50 - getProgress())),
                    (getHeight() / 2) - (seekbar_height/2),
                    getWidth() / 2,
                    getHeight() / 2 + (seekbar_height/2));

            paint.setColor(getResources().getColor(R.color.seek_bar_enable_color));
            canvas.drawRect(rect, paint);
        }

        super.onDraw(canvas);
    }
}