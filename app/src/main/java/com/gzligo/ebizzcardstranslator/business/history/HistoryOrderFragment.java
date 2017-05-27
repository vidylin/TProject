package com.gzligo.ebizzcardstranslator.business.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gzligo.ebizzcardstranslator.R;
import com.gzligo.ebizzcardstranslator.base.BaseFragment;
import com.gzligo.ebizzcardstranslator.base.mvp.IPresenter;

/**
 * Created by Lwd on 2017/5/24.
 */

public class HistoryOrderFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history_order, container, false);
    }

    @Override
    public IPresenter createPresenter() {
        return null;
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
}
