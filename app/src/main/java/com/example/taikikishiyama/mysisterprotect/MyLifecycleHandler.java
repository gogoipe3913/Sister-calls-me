package com.example.taikikishiyama.mysisterprotect;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Taiki.Kishiyama on 2017/09/26.
 */

//今このclass使ってないっす。

// 実際にActivityのLifecycleが変わった時に呼ばれるinterfaceです。
public class MyLifecycleHandler implements Application.ActivityLifecycleCallbacks {
    // どんな方法でもいいですが、例としてintでcountしています。
    private int resumed;
    private int paused;
    private int started;
    private int stopped;

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
        ++resumed;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        ++paused;
        Log.w("test", "application is in foreground: ");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        ++started;
    }

    @Override
    public void onActivityStopped(Activity activity) {
        ++stopped;
        Log.w("test", "application is visible: " );
    }

    // もし必要ならstaticにして参照できるようにすれば、Serviceなどから状態の確認ができます。
    /*
    private static int resumed;
    private static int paused;
    private static int started;
    private static int stopped;

    public static boolean isApplicationVisible() {
        return started > stopped;
    }

    public static boolean isApplicationInForeground() {
        return resumed > paused;
    }
    */
}