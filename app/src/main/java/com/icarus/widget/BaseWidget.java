package com.icarus.widget;

import com.icarus.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Anurag Purwar on 7/2/19.
 */

public abstract class BaseWidget<T> extends LinearLayout {
    protected TypedArray attributes = null;
    protected View view;
    private T viewModel;

    public BaseWidget(Context context) {
        super(context);
        int layoutId = getLayoutId();
        if (layoutId != 0) {
            view = inflate(context, layoutId, this);
        }
        initViews(view);
    }

    public BaseWidget(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        int layoutId = getLayoutId();
        if(layoutId != 0)
        {
            view = inflate(context, layoutId, this);
        }
        attributes = getContext().obtainStyledAttributes(attrs, getStyleableResource());
        initViews(view);
    }

    protected int[] getStyleableResource()
    {
        return R.styleable.widgets;
    }


    /*
     * Used to set the layout for inflator
     * @
     */
    public abstract int getLayoutId();

    /*
     * initialization of views and binding
     * @
     */
    protected abstract void initViews(View v);

    /*
     * get data from widget
     * @
     */
    protected T getItem() {
        return viewModel;
    }

    /*
     * set data in widget
     * @
     */
    public void setItem(T viewModel) {
        this.viewModel = viewModel;
        invalidateUi(viewModel);
    }

    public void reset() {
        invalidateUi(viewModel);
    }

    /*
     * update UI after setItem(T viewModel) called
     * @
     */
    protected abstract void invalidateUi(T viewModel);

    /*
     * return view of widget
     * @
     */
    public View getView() {
        return view;
    }
}
