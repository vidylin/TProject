package com.gzligo.ebizzcardstranslator.base;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gzligo.ebizzcardstranslator.base.delegate.IActivity;
import com.gzligo.ebizzcardstranslator.base.delegate.IActivityDelegate;
import com.gzligo.ebizzcardstranslator.base.mvp.IPresenter;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * Created by xfast on 2017/5/22.
 */

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IActivity<P> {

    private IActivityDelegate mDelegate;
    private P mPresenter;

    // adapter for AutolayoutActivity
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        if (FrameLayout.class.getSimpleName().equals(name)) {
            return new AutoFrameLayout(context, attrs);
        } else if (LinearLayout.class.getSimpleName().equals(name)) {
            return new AutoLinearLayout(context, attrs);
        } else if (RelativeLayout.class.getSimpleName().equals(name)) {
            return new AutoRelativeLayout(context, attrs);
        }
        return super.onCreateView(name, context, attrs);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }

    @Override
    public IActivityDelegate getIDelegate() {
        return mDelegate;
    }

    @Override
    public void setIDelegate(IActivityDelegate delegate) {
        mDelegate = delegate;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (getCurrentFocus()!=null){
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }
}
