package com.icarus.widget;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.WidgetGalleryBinding;
import com.icarus.widget.viewmodel.GalleryViewModel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Anurag Purwar on 7/2/19.
 */
public class GalleryImageWidget extends BaseWidget<GalleryViewModel> {
    private WidgetGalleryBinding binding;

    public GalleryImageWidget(Context context) {
        super(context);
    }

    public GalleryImageWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getLayoutId() {
        return R.layout.widget_gallery;
    }

    @Override
    protected void initViews(View v) {
        ViewGroup g = (ViewGroup) v;
        LayoutInflater inflater = LayoutInflater.from(v.getContext());
        binding = WidgetGalleryBinding.inflate(inflater, g, true);
    }

    @Override
    protected void invalidateUi(GalleryViewModel viewModel) {
        binding.setVariable(BR.viewModel, viewModel);
        final View valueView = binding.getRoot();
        ((LinearLayout) view).removeAllViews();
        ((LinearLayout) view).addView(valueView);
    }
}
