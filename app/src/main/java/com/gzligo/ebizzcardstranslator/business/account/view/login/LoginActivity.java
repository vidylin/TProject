package com.gzligo.ebizzcardstranslator.business.account.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gzligo.ebizzcardstranslator.R;
import com.gzligo.ebizzcardstranslator.base.BaseActivity;
import com.gzligo.ebizzcardstranslator.base.mvp.IPresenter;
import com.gzligo.ebizzcardstranslator.base.mvp.IView;
import com.gzligo.ebizzcardstranslator.common.ToolActionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZuoJian on 2017/5/24.
 */

public class LoginActivity extends BaseActivity implements IView{

    @BindView(R.id.login_actionbar) ToolActionBar mActionBar;
    @BindView(R.id.txt_register) TextView registerTxt;
    @BindView(R.id.txt_forget) TextView forgetTxt;
    @BindView(R.id.btn_login) Button mLoginBtn;
    @BindView(R.id.tv_phone_num) EditText mPhoneTxt;
    @BindView(R.id.tv_pwd) EditText mPwdTxt;
    @BindView(R.id.pwd_eye_iv) ImageView mEye;

    private boolean isEyeOpen = false;

    @Override
    public IPresenter createPresenter() {
        return new LoginPresenter(new LoginRepository());
    }

    @Override
    public int onLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews() {
        mActionBar.setActionbarCenterTitleMaxEms(12);
        mLoginBtn.setClickable(false);
        mPwdTxt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvents() {
        mPwdTxt.addTextChangedListener(watcher);
        mPhoneTxt.addTextChangedListener(watcher);
        mPhoneTxt.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    }

    @OnClick({R.id.ll_selector_country,R.id.btn_login,R.id.txt_register,R.id.txt_forget,R.id.pwd_eye_iv})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_selector_country:
                break;
            case R.id.btn_login:
                handleLogin();
                break;
            case R.id.txt_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.txt_forget:
                break;
            case R.id.pwd_eye_iv:
                handleEyeShow();
                break;
        }
    }

    private void handleLogin() {

    }

    private void handleEyeShow() {
        isEyeOpen = !isEyeOpen;
        if (isEyeOpen){
            mEye.setBackgroundResource(R.mipmap.login_eye_yes);
            mPwdTxt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }else {
            mEye.setBackgroundResource(R.mipmap.login_eye_no);
            mPwdTxt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
        String text = mPwdTxt.getText().toString();
        mPwdTxt.setSelection(text.length());
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!TextUtils.isEmpty(s)) {
                if (!TextUtils.isEmpty(mPhoneTxt.getText().toString().trim())&&
                        !TextUtils.isEmpty(mPwdTxt.getText().toString().trim())) {
                    mLoginBtn.setBackgroundResource(R.drawable.onclick_green_btn_selector);
                    mLoginBtn.setClickable(true);
                }else {
                    mLoginBtn.setBackgroundResource(R.mipmap.green_btn_normal);
                }
            }else {
                mLoginBtn.setBackgroundResource(R.mipmap.green_btn_normal);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
