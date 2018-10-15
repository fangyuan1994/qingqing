package com.newproject.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.gyf.barlibrary.ImmersionBar;
import com.maning.mndialoglibrary.MProgressDialog;
import com.newproject.R;
import com.newproject.constant.Action;
import com.newproject.entity.RefreshToken;
import com.newproject.dialog.OtherLoginDialog;
import com.newproject.utils.AppManager;
import com.newproject.utils.UmengUtils;
import com.yinglan.keyboard.HideUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2016/6/2.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public ImmersionBar mImmersionBar;
    private InputMethodManager imm;


    protected MProgressDialog mMProgressDialog;
    private OtherLoginDialog otherLoginDialog;

    public void configDialogDefault() {
        //新建一个Dialog
        mMProgressDialog = new MProgressDialog.Builder(this)
                .isCanceledOnTouchOutside(true)
                .setBackgroundViewColor(getResources().getColor(R.color.colorDialogProgressRimColor))
                .setCornerRadius(20)
                .setStrokeColor(getResources().getColor(R.color.colorDialogProgressRimColor))
                .setStrokeWidth(0)
                .setProgressColor(Color.BLACK)
                .setProgressWidth(3)
                .setProgressRimColor(Color.WHITE)
                .setProgressRimWidth(4)
                .setTextColor(getResources().getColor(R.color.black))
                .build();
    }


    public void createOtherLoginDialog() {
        otherLoginDialog = new OtherLoginDialog(this);
        otherLoginDialog.setCanceledOnTouchOutside(true);
        otherLoginDialog.show();
        otherLoginDialog.setCancelable(false);
        WindowManager.LayoutParams lp = otherLoginDialog.getWindow().getAttributes();
        lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        otherLoginDialog.getWindow().setAttributes(lp);
        otherLoginDialog.setMsg(getString(R.string.other_login));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
       //初始化沉浸式
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }
        AppManager.getAppManager().addActivity(this);
        //友盟错误统计
        initView();
        mPageName = getPackageName();
        initData();
        HideUtil.init(this);
    }


    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }


    public abstract int getLayout();

    public abstract void initView();

    public abstract void initData();

    public abstract void refresh(RefreshToken event);

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }


    IntentFilter intentFilter;

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }


    }

    private String mPageName;

    @Override
    protected void onResume() {
        super.onResume();
        UmengUtils.onResumeToActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        UmengUtils.onPauseToActivity(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private boolean isShow = false;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleSomethingElse(RefreshToken event) {
        int code = event.getCode();
        if (code == 200) {
            refresh(event);
        } else if (code == 100) {
            if (!isShow) {
                isShow = true;
                createOtherLoginDialog();
            }
        }
    }


    @Override
    protected void onDestroy() {

        AppManager.getAppManager().finishActivity(this);
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        this.imm = null;
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
        super.onDestroy();
    }


    public void hideSoftKeyBoard() {
        View localView = getCurrentFocus();
        if (this.imm == null) {
            this.imm = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        }
        if ((localView != null) && (this.imm != null)) {
            this.imm.hideSoftInputFromWindow(localView.getWindowToken(), 2);
        }
    }


    @Override
    public void finish() {
        super.finish();
        hideSoftKeyBoard();
    }


}
