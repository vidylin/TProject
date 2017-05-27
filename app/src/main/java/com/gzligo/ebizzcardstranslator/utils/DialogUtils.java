package com.gzligo.ebizzcardstranslator.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.gzligo.ebizzcardstranslator.R;

import butterknife.BindView;

/**
 * Created by ZuoJian on 2017/5/26.
 */

public class DialogUtils {

    private static Dialog createDialog(Context context, int layoutId) {
        return createDialog(context, layoutId, true);
    }

    private static Dialog createDialog(Context context, int layoutId, boolean reSetWidth) {
        Dialog dialog = new Dialog(context, R.style.dialog);
        View view = LayoutInflater.from(context).inflate(layoutId, null);
        dialog.setContentView(view);
        if (reSetWidth) {
            try {
                Window dialogWindow = dialog.getWindow();
                WindowManager m = ((Activity) context).getWindowManager();
                Display d = m.getDefaultDisplay();
                WindowManager.LayoutParams p = dialogWindow.getAttributes();
                p.width = (int) (d.getWidth() * 0.75);
                p.alpha = 0.95f;
                p.dimAmount = 0.5f;
                dialogWindow.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialogWindow.setAttributes(p);
            }catch (Exception e) {
                Log.w("lw", "createDialog set width failed." + e.toString());
            }
        }
        try {
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dialog;
    }

    public static Dialog showTitleContentDialog(Context context, String title, String content, String cancel, String confirm, final TranslatorCallBack.OnDialogClickListener listener) {
        final Dialog dialog = createDialog(context, R.layout.dialog_send_message);
        TextView tvTile = (TextView) dialog.findViewById(R.id.tv_title);
        TextView tvContent = (TextView) dialog.findViewById(R.id.tv_content);
        tvTile.setText(title);
        tvContent.setText(content);

        TextView tvCancel = (TextView) dialog.findViewById(R.id.tv_cancel);
        tvCancel.setText(cancel);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        TextView tvConfirm = (TextView) dialog.findViewById(R.id.tv_confirm);
        tvConfirm.setText(confirm);
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                if (listener != null) {
                    listener.onConfirm();
                }
            }
        });
        return dialog;
    }
}