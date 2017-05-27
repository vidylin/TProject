package com.gzligo.ebizzcardstranslator.business.account.view.login;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gzligo.ebizzcardstranslator.R;
import com.gzligo.ebizzcardstranslator.base.BaseActivity;
import com.gzligo.ebizzcardstranslator.base.mvp.IPresenter;
import com.gzligo.ebizzcardstranslator.base.mvp.IView;
import com.gzligo.ebizzcardstranslator.common.ToolActionBar;
import com.gzligo.ebizzcardstranslator.utils.DialogUtils;
import com.gzligo.ebizzcardstranslator.utils.TranslatorCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZuoJian on 2017/5/26.
 */

public class RegisterActivity extends BaseActivity implements IView{

    @BindView(R.id.register_actionbar)
    ToolActionBar mActionBar;
    @BindView(R.id.register_nickname_txt)
    EditText mNickname;
    @BindView(R.id.register_tv_district_num)
    TextView mDistrictNum;
    @BindView(R.id.register_tv_phone_num)
    EditText mPhoneTxt;
    @BindView(R.id.register_tv_pwd)
    EditText mPwdTxt;
    @BindView(R.id.register_avatar_iv)
    ImageView mAvatarIv;
    @BindView(R.id.register_btn)
    Button registerBtn;
    @BindView(R.id.pwd_eye_iv)
    ImageView mEye;

    private boolean isEyeOpen = false;
    private Dialog mDialog;

    @Override
    public IPresenter createPresenter() {
        return null;
    }

    @Override
    public int onLayoutResId() {
        return R.layout.activity_register;
    }

    @Override
    public void initViews() {
        mActionBar.setActionbarCenterTitleMaxEms(12);
        registerBtn.setClickable(false);
        mPwdTxt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    @Override
    public void initData() {

    }
    @Override
    public void initEvents() {
        mPwdTxt.addTextChangedListener(watcher);
        mPhoneTxt.addTextChangedListener(watcher);
        mNickname.addTextChangedListener(watcher);
    }

    @OnClick({R.id.tv_close,R.id.register_avatar_iv,R.id.ll_selector_country,R.id.register_btn,R.id.register_protocol_txt
                ,R.id.pwd_eye_iv})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_close:
                finish();
                break;
            case R.id.register_avatar_iv:
                break;
            case R.id.ll_selector_country:
                break;
            case R.id.register_btn:
                handleRegister();
                break;
            case R.id.pwd_eye_iv:
                handleEyeShow();
                break;
            case R.id.register_protocol_txt:
                break;
        }
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

    private void handleRegister() {
        mDialog = DialogUtils.showTitleContentDialog(this, getResources().getString(R.string.register_confirm_phone),
                getResources().getString(R.string.register_sms_code_send_to) +"\n" + mDistrictNum.getText().toString().trim()+
                mPhoneTxt.getText().toString().trim(),getResources().getString(R.string.cancel), getResources().getString(R.string.confirm),
                new TranslatorCallBack.OnDialogClickListener() {
                    @Override
                    public void onConfirm() {
                        register();
                    }
                });
    }

    private void register(){
        Intent intent = new Intent(this,RegisterPhoneVerActivity.class);
        intent.putExtra(TranslatorConstants.Login.PHONE_NUMBER,mPhoneTxt.getText().toString().trim());
        startActivity(intent);
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!TextUtils.isEmpty(s)) {
                if (!TextUtils.isEmpty(mPhoneTxt.getText().toString().trim())&&
                        !TextUtils.isEmpty(mPwdTxt.getText().toString().trim())&&
                        !TextUtils.isEmpty(mNickname.getText().toString().trim())) {
                    registerBtn.setBackgroundResource(R.drawable.onclick_green_btn_selector);
                    registerBtn.setClickable(true);
                }else {
                    registerBtn.setBackgroundResource(R.mipmap.green_btn_normal);
                }
            }else {
                registerBtn.setBackgroundResource(R.mipmap.green_btn_normal);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
