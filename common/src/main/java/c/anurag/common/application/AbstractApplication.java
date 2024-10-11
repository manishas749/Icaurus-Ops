package c.anurag.common.application;

import androidx.multidex.MultiDexApplication;
import androidx.appcompat.app.AppCompatDelegate;

/**
 * Created by anuragpurwar
 */
public abstract class AbstractApplication extends MultiDexApplication {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onCreate() {
        onPreCreate();
        super.onCreate();
        init();
        onPostCreate();
    }

    protected void init() {
    }

    protected void onPostCreate() {
        //do nothing
    }

    protected void onPreCreate() {
        //do nothing
    }
}
