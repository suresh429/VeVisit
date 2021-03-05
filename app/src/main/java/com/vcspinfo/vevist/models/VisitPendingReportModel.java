package com.vcspinfo.vevist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VisitPendingReportModel {

    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataBean data;
    @SerializedName("status")
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        @SerializedName("pendings")
        private List<String> pendings;

        public List<String> getPendings() {
            return pendings;
        }

        public void setPendings(List<String> pendings) {
            this.pendings = pendings;
        }
    }
}
