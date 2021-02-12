package com.vcspinfo.vevist.models;

import com.google.gson.annotations.SerializedName;

public class CSPDetailsListResponse {

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
