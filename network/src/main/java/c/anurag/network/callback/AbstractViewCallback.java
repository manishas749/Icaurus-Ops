package c.anurag.network.callback;

import android.app.Activity;
import android.content.Context;

import c.anurag.database.activity.BaseActivity;

public abstract class AbstractViewCallback<T> extends IViewCallback<T> {
    private final Context context;

    public AbstractViewCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onFailure(Throwable e) {
        e.printStackTrace();
    }
}
