package com.newproject.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class CallPhoneUtil {
    /**
     * 拨打电话（跳转到拨号界面，用户手动点击拨打）
     *
     * @param phoneNum 电话号码
     */
    public static void diallPhone(String phoneNum, Context context) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        context.startActivity(intent);
    }

}
