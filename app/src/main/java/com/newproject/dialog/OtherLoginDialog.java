package com.newproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


import com.newproject.R;
import com.newproject.utils.AppManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/9/13.
 */
public class OtherLoginDialog extends Dialog {


    private String msg;
    private TextView tvTip;


    private Context mContext;

    public OtherLoginDialog(Context context) {
        super(context, R.style.Translucent_NoTitle);
        this.mContext = context.getApplicationContext();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        init();
    }

    private void init() {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.othe_user_login_layout, null);
        tvTip = (TextView) layout.findViewById(R.id.tv_tip);
        ButterKnife.bind(this, layout);
        tvTip.setText(msg);
        setContentView(layout);
    }

    @OnClick(R.id.tv_determine)
    public void onClick() {
        AppManager.getAppManager().finishAllActivity();
//        mContext.startActivity(new Intent(mContext, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        dismiss();
    }

    public void setMsg(String msg) {
        this.msg = msg;
        tvTip.setText(msg);
    }
}
