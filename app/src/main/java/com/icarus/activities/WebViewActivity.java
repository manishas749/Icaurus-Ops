package com.icarus.activities;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.icarus.R;
import com.icarus.databinding.ActivityWebviewBinding;

/**
 * Created by Monika Rana on 2/11/2019.
 */

public class WebViewActivity extends AppCompatActivity {
    private ActivityWebviewBinding mBinding;
    private static String LINK = "link";

    public static Intent getIntent(Context context, String link) {
        return new Intent(context, WebViewActivity.class)
                .putExtra(LINK, link);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_webview);
        //Setting toolbar
        setSupportActionBar(mBinding.toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mBinding.webView.loadUrl(getIntent() != null ? getIntent().getStringExtra(LINK) : "");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return false;
    }

}
