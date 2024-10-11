package c.anurag.database.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import c.anurag.database.application.BaseApplication;
import c.anurag.database.navigation.IntentHelperAbstract;

/**
 * Created by anuragpurwar
 */

public abstract class BaseActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void finish()
    {
        super.finish();
    }

    public IntentHelperAbstract getIntentHelper()
    {
        return ((BaseApplication) getApplication()).getIntentHelper();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onPreSetContentView();
        if (getActivityLayout() > 0) {
            setContentView(getActivityLayout());
        }
        initViews();
        onActivityReady(savedInstanceState);
    }

    protected void onPreSetContentView() {
        //To minimize the overdraw of the screen
        getWindow().setBackgroundDrawable(null);
    }

    protected void initViews() {
        // do nothing
    }

    protected void onActivityReady(
            @Nullable
                    Bundle savedInstanceState)
    {
        // do nothing
    }

    protected abstract int getActivityLayout();
}
