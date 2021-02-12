package com.vcspinfo.vevist.models;

import com.google.gson.annotations.SerializedName;

public class CreateVisitResponse {

    @SerializedName("success")
    private String success;
    @SerializedName("status")
    private int status;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
