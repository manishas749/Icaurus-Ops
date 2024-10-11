package com.icarus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.icarus.R;
import com.icarus.models.ChecklistItemPlaceHolders;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ItemPlaceholderAdapter extends BaseExpandableListAdapter {
    private List<String> headers = new ArrayList<>();
    private Context mContext;
    private LinkedHashMap<String, List<ChecklistItemPlaceHolders>> placeholderList;

    public ItemPlaceholderAdapter(Context context, ExpandableListView listView,
                                  LinkedHashMap<String, List<ChecklistItemPlaceHolders>> groupsList) {
        this.placeholderList = groupsList;
        mContext = context;
        for (Map.Entry<String, List<ChecklistItemPlaceHolders>> mapEntry : groupsList.entrySet()) {
            headers.add(mapEntry.getKey());
        }
    }

    @Override
    public int getGroupCount() {
        return this.headers.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.placeholderList.get(headers.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.headers.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return placeholderList.get(this.headers.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerName = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_placeholder_sequence_number, null);
        }
        TextView txtSequenceNumber = (TextView) convertView.findViewById(R.id.txtName);
        txtSequenceNumber.setText(headerName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ChecklistItemPlaceHolders itemPlaceHolders = (ChecklistItemPlaceHolders) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_placeholder_values, null);
        }
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtValue = (TextView) convertView.findViewById(R.id.txtValue);
        txtName.setText(itemPlaceHolders.getName());
        txtValue.setText(itemPlaceHolders.getValue());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
