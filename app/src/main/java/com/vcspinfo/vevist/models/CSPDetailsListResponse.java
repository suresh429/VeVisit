package com.vcspinfo.vevist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CSPDetailsListResponse {


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
        @SerializedName("partners")
        private List<PartnersBean> partners;

        public List<PartnersBean> getPartners() {
            return partners;
        }

        public void setPartners(List<PartnersBean> partners) {
            this.partners = partners;
        }

        public static class PartnersBean {
            @SerializedName("csp_code")
            private String cspCode;
            @SerializedName("name")
            private String name;

            public String getCspCode() {
                return cspCode;
            }

            public void setCspCode(String cspCode) {
                this.cspCode = cspCode;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
