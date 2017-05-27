package com.gzligo.ebizzcardstranslator.business.chat;

import android.os.Bundle;

import com.gzligo.ebizzcardstranslator.R;
import com.gzligo.ebizzcardstranslator.base.BaseActivity;
import com.gzligo.ebizzcardstranslator.base.mvp.IPresenter;

import butterknife.ButterKnife;

public class ChatActivity extends BaseActivity {

    @Override
    public IPresenter createPresenter() {
        return null;
    }

    @Override
    public int onLayoutResId() {
        return R.layout.activity_chat;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
    }

    @Override
    public void initEvents() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
