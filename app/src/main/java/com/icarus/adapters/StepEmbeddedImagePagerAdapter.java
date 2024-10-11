package com.icarus.adapters;

import android.content.Context;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icarus.R;
import com.icarus.databinding.ItemPagerImageAdapterBinding;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

import java.util.List;

/**
 * Created by Monika Rana on 27/01/2020
 */
public class StepEmbeddedImagePagerAdapter extends PagerAdapter {

    private Context context;
    private List<ChecklistDetailItems> embeddedImages;
    private ChecklistExecutionViewModel viewModel;

    public StepEmbeddedImagePagerAdapter(Context context, List<ChecklistDetailItems> embeddedImages, ChecklistExecutionViewModel viewModel) {
        this.context = context;
        this.embeddedImages = embeddedImages;
        this.viewModel = viewModel;
    }

    @Override
    public int getCount() {
        return embeddedImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ItemPagerImageAdapterBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_pager_image_adapter, container, false);
        binding.setItem(embeddedImages.get(position));
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
        View view = binding.getRoot();
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }
}