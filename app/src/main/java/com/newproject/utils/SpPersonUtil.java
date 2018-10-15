package com.newproject.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.newproject.constant.PreConst;
import com.newproject.entity.LoginBean;

public class SpPersonUtil {


    SharedPreferences sp;


    //sp 文件名
    public static LoginBean getPersonMessage(Context context) {
        String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
        LoginBean loginBean = new Gson().fromJson(content, LoginBean.class);
        return loginBean;
    }

    public static void setPersonMessage(Context context, String msg) {
        PreferenceUtil.setPrefString(context, PreConst.PERSON, msg);
    }

    public static boolean isLogin(Context context) {
        String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
        if (TextUtils.isEmpty(content)) {
            return false;
        } else {
            return true;
        }
    }

    //获取用户token
    public static String getToken(Context context) {
        boolean login = isLogin(context);
        if (login) {
            String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
            LoginBean loginBean = toClass(content);
            return loginBean.getData().getToken();
        } else {
            return "";
        }
    }

    public static LoginBean toClass(String content) {
        return new Gson().fromJson(content, LoginBean.class);
    }

    //获取用户id
    public static String getUserId(Context context) {
        boolean login = isLogin(context);
        if (login) {
            String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
            LoginBean loginBean = toClass(content);
            return loginBean.getData().getId();
        } else {
            return "";
        }
    }


    //获取用户头像
    public static String getAvatar(Context context) {
        boolean login = isLogin(context);
        if (login) {
            String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
            LoginBean loginBean = toClass(content);
            return loginBean.getData().getAvatar();
        } else {
            return "";
        }
    }


    //获取用户昵称
    public static String getNickName(Context context) {
        boolean login = isLogin(context);
        if (login) {
            String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
            LoginBean loginBean = toClass(content);
            return loginBean.getData().getUsername();
        } else {
            return "";
        }
    }

    //获取用户昵称
    public static String getPhone(Context context) {
        boolean login = isLogin(context);
        if (login) {
            String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
            LoginBean loginBean = toClass(content);
            return loginBean.getData().getMobile();
        } else {
            return "";
        }
    }


    //获取地址
    public static String getAddress(Context context) {
        boolean login = isLogin(context);
        if (login) {
            String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
            LoginBean loginBean = toClass(content);

            return loginBean.getData().getAddress();
        } else {
            return "";
        }
    }

    public static void upName(Context context, String name) {
        String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
        LoginBean loginBean = toClass(content);
        loginBean.getData().setUsername(name);
        String s = new Gson().toJson(loginBean);
        PreferenceUtil.setPrefString(context, PreConst.PERSON, s);
    }


    public static void upToken(Context context, String token) {
        String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
        LoginBean loginBean = toClass(content);
        if(loginBean.getData() != null){
            loginBean.getData().setToken(token);
            String s = new Gson().toJson(loginBean);
            PreferenceUtil.setPrefString(context, PreConst.PERSON, s);
        }
    }


    public static void upPhone(Context context, String mobile) {
        String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
        LoginBean loginBean = toClass(content);
        loginBean.getData().setMobile(mobile);
        String s = new Gson().toJson(loginBean);
        PreferenceUtil.setPrefString(context, PreConst.PERSON, s);
    }


    public static void upAddress(Context context, String addresss) {
        String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
        LoginBean loginBean = toClass(content);
        loginBean.getData().setAddress(addresss);
        String s = new Gson().toJson(loginBean);
        PreferenceUtil.setPrefString(context, PreConst.PERSON, s);
    }


    public static void upAvatar(Context context, String avatar) {
        String content = PreferenceUtil.getPrefString(context, PreConst.PERSON, "");
        LoginBean loginBean = toClass(content);
        loginBean.getData().setAvatar(avatar);
        String s = new Gson().toJson(loginBean);
        PreferenceUtil.setPrefString(context, PreConst.PERSON, s);
    }


    public static void setPerson(Context context, String person) {
        SharedPreferences sp = context.getSharedPreferences("person", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
    }


    //这 一部分 是用于记住密码用的 不会在退出时清除缓存
    public static void setRememberEnable(Context context, boolean isEnable) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.REMEMBER, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(PreConst.REMEMBER, isEnable);
        edit.commit();
    }

    public static void setMobile(Context context, String mobile) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.MOBILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(PreConst.MOBILE, mobile);
        edit.commit();
    }

    public static void setUpApk(Context context, boolean isUpdate) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.MOBILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(PreConst.UPAPK, isUpdate);
        edit.commit();
    }

    public static void setApkFile(Context context, String path) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.MOBILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(PreConst.APKPATH, path);
        edit.commit();
    }

    public static void setDown(Context context, boolean path) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.MOBILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(PreConst.IS_DOWN, path);
        edit.commit();
    }


    public static void setPassword(Context context, String password) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.PASSWORD, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(PreConst.PASSWORD, password);
        edit.commit();
    }


    public static boolean getUpApk(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.MOBILE, Context.MODE_PRIVATE);
        return sp.getBoolean(PreConst.UPAPK, false);
    }

    public static boolean getDown(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.MOBILE, Context.MODE_PRIVATE);
        return sp.getBoolean(PreConst.IS_DOWN, false);
    }

    public static boolean getRemeberEnable(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.REMEMBER, Context.MODE_PRIVATE);
        return sp.getBoolean(PreConst.REMEMBER, false);
    }

    public static String getApkPath(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.MOBILE, Context.MODE_PRIVATE);
        return sp.getString(PreConst.APKPATH, "");
    }

    public static String getMobile(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.MOBILE, Context.MODE_PRIVATE);
        return sp.getString(PreConst.MOBILE, "0");
    }

    public static String getPassword(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PreConst.PASSWORD, Context.MODE_PRIVATE);
        return sp.getString(PreConst.PASSWORD, "0");
    }
    //这 一部分 是用于记住密码用的 不会在退出时清除缓存


    public void getLoginBean() {
        return;
    }


    public void putData(boolean yesOrNo) {
        SharedPreferences.Editor edit = sp.edit();
    }

    public boolean getData() {
        return false;
    }


}
