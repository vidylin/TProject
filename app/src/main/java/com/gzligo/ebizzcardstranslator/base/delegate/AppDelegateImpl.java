package com.gzligo.ebizzcardstranslator.base.delegate;

import android.app.Application;

import com.gzligo.ebizzcardstranslator.base.AppManager;
import com.gzligo.ebizzcardstranslator.base.lifecycle.ActivityLifecycleCallbacksImpl;
import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by xfast on 2017/5/25.
 */

public class AppDelegateImpl implements IAppDelegate {

    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

    public AppDelegateImpl(IApp app) {
        AppManager.get().init(app);
        mActivityLifecycleCallbacks = new ActivityLifecycleCallbacksImpl();
    }

    @Override
    public void onCreate() {
        AppManager.get().getApplication().registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks);

        {
            AutoLayoutConifg.getInstance().useDeviceSize();

        }
    }

    @Override
    public void onTerminate() {
        if (mActivityLifecycleCallbacks != null) {
            AppManager.get().getApplication().unregisterActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
        }
    }
}
