package com.icarus.customviews;

import android.content.Context;
import androidx.databinding.BindingAdapter;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class ExpandableNestedListView extends ExpandableListView {

    public ExpandableNestedListView(Context context) {
        super(context);
    }

    public ExpandableNestedListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandableNestedListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom);
        ViewGroup.LayoutParams params = getLayoutParams();
        params.height = getMeasuredHeight();
    }

    @BindingAdapter("setExpandableAdapter")
    public static void bindRecyclerViewAdapter(ExpandableNestedListView expandableNestedListView, ExpandableListAdapter adapter) {
        expandableNestedListView.setAdapter(adapter);

        for (int i = 0; i < adapter.getGroupCount(); i++)
            expandableNestedListView.expandGroup(i);

        expandableNestedListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return true; // This way the expander cannot be collapsed
            }
        });
    }
}