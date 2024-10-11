package com.icarus.workorder.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.databinding.ActivityWorkOrderDetailBinding;
import com.icarus.workorder.fragments.WorkorderDetailFragment;
import com.icarus.workorder.viewmodels.WorkOrderDetailViewModel;

public class WorkOrderDetailActivity extends BaseActivity<ActivityWorkOrderDetailBinding, WorkOrderDetailViewModel> {

    private static final String WORK_ORDER_ID = "WORK_ORDER_ID";
    private static final String WORK_ORDER_UUID = "WORK_ORDER_UUID";
    private WorkOrderDetailViewModel mWorkOrderDetailModel;
    private ActivityWorkOrderDetailBinding mBinding;

    public static Intent getInstance(Context context, int workOrderId, String workOrderUuid) {
        return new Intent(context, WorkOrderDetailActivity.class)
                .putExtra(WORK_ORDER_ID, workOrderId)
                .putExtra(WORK_ORDER_UUID, workOrderUuid);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_work_order_detail;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public WorkOrderDetailViewModel getViewModel() {
        return mWorkOrderDetailModel = new ViewModelProvider(this).get(WorkOrderDetailViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        setSupportActionBar(mBinding.toolbar);
        int workOrderId = getIntent().getIntExtra(WORK_ORDER_ID, 0);
        String workOrderUuid = getIntent().getStringExtra(WORK_ORDER_UUID);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(String.format(getString(R.string.workorder_id_x), ((workOrderId <= 0) ? getString(R.string.not_synchronized) : String.valueOf(workOrderId))));
        }
        Fragment fragment = WorkorderDetailFragment.getInstance(workOrderId, workOrderUuid);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
