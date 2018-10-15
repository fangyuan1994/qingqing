package com.newproject.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/5/21.
 */

public class LoginBean {


    /**
     * code : 200
     * msg : success
     * data : {"id":"4","username":"18797816527","mobile":"18797816527","avatar":"","token":"655964caabf35a187a32b79cbe5dd119","type":"1","address":""}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4
         * username : 18797816527
         * mobile : 18797816527
         * avatar :
         * token : 655964caabf35a187a32b79cbe5dd119
         * type : 1
         * address :
         */

        @SerializedName("id")
        private String id;
        @SerializedName("username")
        private String username;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("token")
        private String token;
        @SerializedName("type")
        private String type;
        @SerializedName("address")
        private String address;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
