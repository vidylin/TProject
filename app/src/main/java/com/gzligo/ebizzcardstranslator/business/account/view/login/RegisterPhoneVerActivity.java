package com.gzligo.ebizzcardstranslator.business.account.view.login;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gzligo.ebizzcardstranslator.R;
import com.gzligo.ebizzcardstranslator.base.BaseActivity;
import com.gzligo.ebizzcardstranslator.base.mvp.IPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ZuoJian on 2017/5/26.
 */

public class RegisterPhoneVerActivity extends BaseActivity {

    @BindView(R.id.ver_phone_tv)
    TextView mPhoneTxt;
    @BindView(R.id.ver_code_edt)
    EditText mCode;
    @BindView(R.id.ver_resend_tv)
    TextView mResend;
    @BindView(R.id.ver_next)
    Button nextBtn;

    @Override
    public IPresenter createPresenter() {
        return null;
    }

    @Override
    public int onLayoutResId() {
        return R.layout.activity_phone_ver;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        String phone = getIntent().getStringExtra(TranslatorConstants.Login.PHONE_NUMBER);
        if(!TextUtils.isEmpty(phone) && phone.length() > 6 ){
            StringBuilder sb  =new StringBuilder();
            for (int i = 0; i < phone.length(); i++) {
                char c = phone.charAt(i);
                if (i >= 3 && i <= 6) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }

            mPhoneTxt.setText(sb.toString());
        }
    }

    @Override
    public void initEvents() {
        mCode.addTextChangedListener(watcher);
        nextBtn.setClickable(false);
    }

    @OnClick({R.id.tv_close,R.id.ver_resend_tv,R.id.ver_next})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_close:
                finish();
                break;
            case R.id.ver_resend_tv:
                break;
            case R.id.ver_next:
                break;
        }
    }


    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!TextUtils.isEmpty(s)) {
                if (!TextUtils.isEmpty(mCode.getText().toString().trim())){
                    nextBtn.setBackgroundResource(R.drawable.onclick_green_btn_selector);
                    nextBtn.setClickable(true);
                }else {
                    nextBtn.setBackgroundResource(R.mipmap.green_btn_normal);
                }
            }else {
                nextBtn.setBackgroundResource(R.mipmap.green_btn_normal);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
