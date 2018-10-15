package com.newproject.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.DisplayMetrics;
import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.newproject.utils.MyHttpLoggingInterceptor;
import com.newproject.utils.UmengUtils;
import com.umeng.commonsdk.UMConfigure;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

import okhttp3.OkHttpClient;


public class BaseApplication extends MultiDexApplication {


    protected static BaseApplication mInstance;
    private ExecutorService executorService;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public BaseApplication() {
        mInstance = this;
    }

    public static BaseApplication getApp() {
        if (mInstance != null) {
            return mInstance;
        } else {
            mInstance = new BaseApplication();
            mInstance.onCreate();
            return mInstance;
        }
    }

    public static int screenWidth;
    public static int screenHeight;

    @Override
    public void onCreate() {
        DisplayMetrics mDisplayMetrics = getApplicationContext().getResources()
                .getDisplayMetrics();
        screenWidth = mDisplayMetrics.widthPixels;
        screenHeight = mDisplayMetrics.heightPixels;

        //注册微信
        registToWX();

        // 创建线程池
        executorService = Executors.newCachedThreadPool();
        HttpHeaders headers = new HttpHeaders();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        MyHttpLoggingInterceptor loggingInterceptor = new MyHttpLoggingInterceptor("OkGo");
        loggingInterceptor.setColorLevel(Level.INFO);                               //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);                                 //添加OkGo默认debug日志

        OkGo.getInstance().init(this)
                //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置会使用默认的
                .setRetryCount(3)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(headers);                     //全局公共头
        super.onCreate();
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "1fe6a20054bcef865eeb0991ee84525b");

        UMConfigure.setLogEnabled(true);


        UmengUtils.initUmeng();
    }


    private void registToWX() {
//        mWxApi = WXAPIFactory.createWXAPI(this, UrlConst.weixin_APP_ID, false);
//        mWxApi.registerApp(UrlConst.weixin_APP_ID);
    }


    public ExecutorService getExecutorService() {
        return executorService;
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


}
