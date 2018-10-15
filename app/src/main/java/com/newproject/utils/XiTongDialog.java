package com.newproject.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

public class XiTongDialog {

    public static void showDialog(Context context, String title, String message, String positive) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // 设置参数
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positive, new DialogInterface.OnClickListener() {// 积极

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {

                    }
                });
        builder.create().show();
    }


    public interface CallBack<T> {

        void onFailure(@Nullable String msg);

        void onSuccess(@Nullable String msg);

    }

    public static void showXinDialog(Context context, String title, String positive, String negative
            , final XiTongDialog.CallBack<String> callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // 设置参数
        builder.setTitle(title)
                .setPositiveButton(positive, new DialogInterface.OnClickListener() {// 积极

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        callback.onSuccess("");
                    }
                })
                .setNegativeButton(negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        builder.create().show();
    }
}
