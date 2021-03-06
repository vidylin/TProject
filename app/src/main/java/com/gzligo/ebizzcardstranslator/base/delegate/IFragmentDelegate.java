package com.gzligo.ebizzcardstranslator.base.delegate;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Created by xfast on 2017/5/26.
 */

public interface IFragmentDelegate {

    void onAttach(Context context);

    void onCreate(Bundle savedInstanceState);

    void onCreateView(View view, Bundle savedInstanceState);

    void onActivityCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onSaveInstanceState(Bundle outState);

    void onDestroyView();

    void onDestroy();

    void onDetach();

    boolean isAdded();
}
