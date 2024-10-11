package com.icarus.customviews;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.icarus.R;

/**
 * Created by Monika Rana on 1/24/2019.
 */

public class SlideButton extends RelativeLayout implements View.OnTouchListener {

    private static final int ANIMATION_DURATION = 300;
    private static final int DEFAULT_SIZE = 48;
    private static final float ALPHA_MODIFIER = 0.02f;

    private TextView stuTxtLabel;
    private ImageView stuImgThumb;
    private ImageView stuBackground;

    private OnCompleteListener listener;

    private int thumbWidth = 0;
    private boolean sliding = false;
    private int sliderPosition = 0;
    private int initialSliderPosition = 0;
    private float initialSlidingX = 0;

    public SlideButton(Context context) {
        this(context, null);
    }

    public SlideButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StuButton,
                0, 0);

        init(context);
      /*  setLabel(typedArray.getString(R.styleable.StuButton_stu_label));
        setStuBackground(typedArray.getResourceId(R.styleable.StuButton_stu_background, R.drawable.seekbar_bg));
        setThumb(typedArray.getResourceId(R.styleable.StuButton_stu_thumbDrawable, R.mipmap.left_arrow_buttoon));
        setLabelColor(typedArray.getResourceId(R.styleable.StuButton_stu_label_color, R.color.black));*/
        typedArray.recycle();
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.slide_button, this, true);

        stuTxtLabel = (TextView) findViewById(R.id.stu_text_label);
        stuImgThumb = (ImageView) findViewById(R.id.stu_img_thumb);
        stuBackground = (ImageView) findViewById(R.id.stu_background);

        thumbWidth = dpToPx(DEFAULT_SIZE);

        stuImgThumb.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                if (stuImgThumb != null) {
                    stuImgThumb.getViewTreeObserver().removeOnPreDrawListener(this);
                    thumbWidth = stuImgThumb.getWidth();
                }
                return false;
            }
        });

        setOnTouchListener(this);
    }

    public void setOnCompleteListener(OnCompleteListener listener) {
        this.listener = listener;
    }

    public void reset() {
        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) stuImgThumb.getLayoutParams();
        ValueAnimator animator = ValueAnimator.ofInt(params.leftMargin, 0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (stuImgThumb != null) {
                    params.leftMargin = (Integer) valueAnimator.getAnimatedValue();
                    stuImgThumb.requestLayout();
                }
            }
        });
        stuTxtLabel.setAlpha(1f);
        stuTxtLabel.setText(R.string.slide_to_complete);
        animator.setDuration(ANIMATION_DURATION);
        animator.start();
    }

    public void refresh() {
        sliding = false;
        sliderPosition = 0;
        reset();
        setFocusable(true);
        setEnabled(true);
        setOnTouchListener(this);
        stuTxtLabel.setText(R.string.slide_to_complete);
        stuBackground.setBackgroundResource(R.drawable.seekbar_bg);
        stuTxtLabel.setAlpha(1f);
        stuImgThumb.setVisibility(View.VISIBLE);
    }

/*
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);


    }*/

    private void setMarginLeft(int margin) {
        if (stuImgThumb == null) return;

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) stuImgThumb.getLayoutParams();
        params.setMargins(margin, params.topMargin, params.rightMargin, params.bottomMargin);
        stuImgThumb.setLayoutParams(params);
    }

    @Override
    protected void onDetachedFromWindow() {
        cleanUp();
        super.onDetachedFromWindow();
    }

    private void cleanUp() {
        stuTxtLabel = null;
        stuImgThumb = null;
        stuBackground = null;
    }

    /* --------------------------------------------------- */
    /* > Public Methods */
    /* --------------------------------------------------- */

    public void setLabel(@StringRes int label) {
        setLabel(getContext().getString(label));
    }

    public void setLabel(String label) {
        if (stuTxtLabel != null) {
            stuTxtLabel.setText(label);
        }
    }

    public void setLabelColor(int colorId) {
        if (stuTxtLabel != null) {
            stuTxtLabel.setTextColor(colorId);
        }
    }

    public void setStuBackground(@DrawableRes int resId) {
        if (stuBackground != null) {
            stuBackground.setImageResource(resId);
        }
    }

    public void setThumb(@DrawableRes int resId) {
        if (stuImgThumb != null) {
            stuImgThumb.setImageResource(resId);
        }
    }

    /* --------------------------------------------------- */
    /* > Helper */
    /* --------------------------------------------------- */

    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        view.getParent().requestDisallowInterceptTouchEvent(true);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (event.getX() > sliderPosition && event.getX() < (sliderPosition + thumbWidth)) {
                sliding = true;
                initialSlidingX = event.getX();
                initialSliderPosition = sliderPosition;
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
            if (sliderPosition >= (getMeasuredWidth() - thumbWidth)) {
                if (listener != null) {
                    stuTxtLabel.setText(R.string.completed);
                    stuTxtLabel.setAlpha(1f);
                    stuImgThumb.setVisibility(View.INVISIBLE);
                    setOnTouchListener(null);
                    setDisabled(getContext().getString(R.string.completed));
                    listener.onComplete();

                }
            } else {
                sliding = false;
                sliderPosition = 0;
                reset();
            }
        } else if (event.getAction() == MotionEvent.ACTION_MOVE && sliding) {
            sliderPosition = (int) (initialSliderPosition + (event.getX() - initialSlidingX));

            if (sliderPosition <= 0) {
                sliderPosition = 0;
            }
            if (sliderPosition >= (getMeasuredWidth() - thumbWidth)) {
                sliderPosition = getMeasuredWidth() - thumbWidth;
            } else {
                int max = getMeasuredWidth() - thumbWidth;
                int progress = (int) (sliderPosition * 100 / (max * 1.0f));
                if (progress < 50) {
                    stuTxtLabel.setAlpha(1f - progress * ALPHA_MODIFIER);
                    stuTxtLabel.setText(R.string.slide_to_complete);
                } else {
                    stuTxtLabel.setAlpha(Math.abs(1f - progress * ALPHA_MODIFIER));
                    stuTxtLabel.setText(R.string.completed);
                }
                stuImgThumb.setAlpha(100 - progress);
            }
            setMarginLeft(sliderPosition);
        }

        return true;
    }

    /* --------------------------------------------------- */
    /* > Interfaces */
    /* --------------------------------------------------- */

    public interface OnCompleteListener {
        void onComplete();
    }

    public void isEnabled(boolean isEnabled, String text) {
        if (!isEnabled) {
            setDisabled(text);
        }
    }

    private void setDisabled(String buttonTxt) {
        stuImgThumb.setVisibility(INVISIBLE);
        stuTxtLabel.setText(buttonTxt);
        stuBackground.setBackgroundResource(R.drawable.button_bg_disabled);
        stuTxtLabel.setAllCaps(true);
        setFocusable(false);
        setOnTouchListener(null);
    }
}
