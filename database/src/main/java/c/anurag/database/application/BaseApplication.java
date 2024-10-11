package c.anurag.database.application;

import android.content.Context;

import c.anurag.common.application.AbstractApplication;
import c.anurag.common.preference.PreferenceManager;
import c.anurag.database.navigation.IntentHelperAbstract;
import c.anurag.database.util.CommonFunctions;

/**
 * <h1>Base Application Class</h1>
 * <p>
 * 1. Override the getCrashHandler method to set the default uncaught exception handler. This handler is invoked in
 * case any Thread dies due to an unhandled exception.
 * <p>
 * <h1>How to use</h1>
 * <h2>Setting the handler class</h2>
 * <p>
 * {@code
 *
 * @author Anurag Purwar
 * @version 1.0
 * @{@link Override}
 * public AbstractExceptionHandler getCrashHandler}() {
 * return new MyCrashHandler();
 * }
 */
public abstract class BaseApplication extends AbstractApplication {
    private static PreferenceManager preferenceManager;
    private static Context context;
    private static CommonFunctions commonFunctions;

    public static PreferenceManager getPreferenceManager() {
        return preferenceManager;
    }

    public static Context getContext() {
        return context;
    }

    public static CommonFunctions getCommonFunctions() {
        return commonFunctions;
    }

    @Override
    public void init() {
        super.init();
        context = this;
        preferenceManager = new PreferenceManager(this);
        commonFunctions = new CommonFunctions(this);
    }

    @Override
    protected void onPostCreate() {
        super.onPostCreate();
    }

    @Override
    protected void onPreCreate() {
        super.onPreCreate();
    }

    public abstract IntentHelperAbstract getIntentHelper();
}
