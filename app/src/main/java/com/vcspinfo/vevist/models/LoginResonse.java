package com.vcspinfo.vevist.models;

import com.google.gson.annotations.SerializedName;

public class LoginResonse {

    @SerializedName("success")
    private String success;
    @SerializedName("data")
    private DataBean data;
    @SerializedName("status")
    private int status;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        @SerializedName("user")
        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            @SerializedName("username")
            private String username;
            @SerializedName("name")
            private String name;
            @SerializedName("mobile")
            private String mobile;
            @SerializedName("state")
            private String state;
            @SerializedName("role")
            private String role;
            @SerializedName("authentication_token")
            private String authenticationToken;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getAuthenticationToken() {
                return authenticationToken;
            }

            public void setAuthenticationToken(String authenticationToken) {
                this.authenticationToken = authenticationToken;
            }
        }
    }
}
