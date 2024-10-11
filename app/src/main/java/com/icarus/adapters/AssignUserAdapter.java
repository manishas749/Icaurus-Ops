package com.icarus.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.databinding.ItemAssignChecklistBinding;
import com.icarus.models.UserItems;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.databinding.DataBindingUtil;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

public class AssignUserAdapter extends RecyclerView.Adapter<AssignUserAdapter.GenericViewHolder> {

    private List<UserItems> userItemsList;
    private Integer loggedInUserId;
    private Context context;

    public AssignUserAdapter(Context context, List<UserItems> userItemsList) {
        this.userItemsList = userItemsList;
        loggedInUserId = BaseApplication.getPreferenceManager().getUserId();
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return userItemsList == null ? 0 : userItemsList.size();
    }

    @NonNull
    public AssignUserAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemAssignChecklistBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_assign_checklist, parent, false);
        return new AssignUserAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignUserAdapter.GenericViewHolder holder, int position) {
        holder.bind(userItemsList.get(position), position);
    }


    /**
     * Returns selected index when filter is applied
     */
    public List<UserItems> getUserItemsSelectedList() {
        return userItemsList;
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ItemAssignChecklistBinding binding;

        GenericViewHolder(ItemAssignChecklistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(UserItems items, final Integer position) {
            binding.setVariable(BR.userItem, items);
            binding.setVariable(BR.isEnabled, !loggedInUserId.equals(items.getId()));
            binding.setVariable(BR.position, position);


            if (loggedInUserId.equals(items.getId()))
                setCheckboxDisabledColor(binding.checkBoxSelect);
            else
                setCheckboxColor(binding.checkBoxSelect);

            binding.checkBoxSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    userItemsList.get(position).setSelected(isChecked);
                }
            });

            binding.executePendingBindings();
        }

        private void setCheckboxDisabledColor(CheckBox button) {
            if (Build.VERSION.SDK_INT < 21) {
                CompoundButtonCompat.setButtonTintList(button, ColorStateList.valueOf(context.getResources().getColor(R.color.gray)));
            } else {
                button.setButtonTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.gray)));
            }
        }

        private void setCheckboxColor(CheckBox button) {
            if (Build.VERSION.SDK_INT < 21) {
                CompoundButtonCompat.setButtonTintList(button, ColorStateList.valueOf(context.getResources().getColor(R.color.colorPrimary)));
            } else {
                button.setButtonTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.colorPrimary)));
            }
        }

    }
}

