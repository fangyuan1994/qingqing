package com.newproject.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/5/23.
 */

public class RefreshEntity {

    /**
     * code : 200
     * msg : 成功
     * extras :
     * data : 6jfu4sab9vggogs0gg0cwg00c
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("extras")
    private String extras;
    @SerializedName("data")
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
