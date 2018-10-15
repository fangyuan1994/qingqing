package com.newproject.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.newproject.constant.Action;
import com.newproject.constant.UrlConst;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "WXPayEntryActivity";

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.pay_result);

        api = WXAPIFactory.createWXAPI(this, UrlConst.weixin_APP_ID, false);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }


    @Override
    public void onResp(BaseResp baseResp) {
        String s = String.valueOf(baseResp.errCode);
//        Log.e(TAG, "onPayFinish, errCode = " + s);
        Log.e(TAG, "onResp: " + s);
        switch (baseResp.errCode) {
            case 0:
                Intent intent = new Intent(Action.WxPay);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                finish();

                break;
            case -1:
                //签名正确、APPID正确的时候 就是缓存问题换个手机就行。
                finish();
                break;
            case -2:
                finish();
                break;
        }

    }


    @Override
    public void onReq(BaseReq baseReq) {
//
    }


}