package com.icarus.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.icarus.models.FragmentsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monika Rana on 1/16/2019.
 */

public class ChecklistDetailPagerAdapter extends FragmentStatePagerAdapter {

    private List<FragmentsModel> fragmentsModels = new ArrayList<>();

    public ChecklistDetailPagerAdapter(FragmentManager fragmentManager, List<FragmentsModel> fragmentsModels) {
        super(fragmentManager);
        this.fragmentsModels = fragmentsModels;
    }

    @Override
    public int getCount() {
        return fragmentsModels.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsModels.get(position).getFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsModels.get(position).getTitle();
    }
}

