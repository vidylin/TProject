package com.gzligo.ebizzcardstranslator.business.message;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gzligo.ebizzcardstranslator.R;
import com.gzligo.ebizzcardstranslator.base.BaseFragment;
import com.gzligo.ebizzcardstranslator.base.mvp.IPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * Created by Lwd on 2017/5/24.
 */

public class RecentContactsFragment extends BaseFragment {
    private Unbinder unbinder;
    @BindView(R.id.recent_contacts_srl)
    SwipeRefreshLayout recentContactsSrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recent_contacts, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
