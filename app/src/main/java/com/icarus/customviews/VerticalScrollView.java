package com.icarus.customviews;

import android.content.Context;

import androidx.core.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class VerticalScrollView extends NestedScrollView {

    public VerticalScrollView(Context p_context, AttributeSet p_attrs) {
        super(p_context, p_attrs);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (no_scrolling) {
            requestDisallowInterceptTouchEvent(true);
            return false;
        }
        requestDisallowInterceptTouchEvent(false);
        //  Standard behavior
        ///
        return super.onTouchEvent(ev);
    }

    boolean no_scrolling = false;
    float old_x, old_y;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();

        if (action == MotionEvent.ACTION_DOWN) {
            old_x = ev.getX();
            old_y = ev.getY();
            no_scrolling = false;

        } else if (action == MotionEvent.ACTION_MOVE) {
            float dx = ev.getX() - old_x;
            float dy = ev.getY() - old_y;

            if (Math.abs(dx) > Math.abs(dy) && dx != 0) {
                View hsvChild = getChildAt(0);
                int childW = hsvChild.getWidth();
                int W = getWidth();

                if (childW > W) {
                    int scrollx = getScrollX();
                    if ((dx < 0 && scrollx + W >= childW) || (dx > 0 && scrollx <= 0)) {
                        no_scrolling = true;
                        return false;
                    } else {
                        no_scrolling = false;
                    }
                } else {
                    no_scrolling = true;
                }
            }
        }

        //  Standard behavior
        //
        return super.onInterceptTouchEvent(ev);
    }

}
