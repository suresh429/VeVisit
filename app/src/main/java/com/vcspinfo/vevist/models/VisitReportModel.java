package com.vcspinfo.vevist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VisitReportModel {


    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataBean data;

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

    public static class DataBean {
        @SerializedName("visit_reports")
        private List<VisitReportsBean> visitReports;

        public List<VisitReportsBean> getVisitReports() {
            return visitReports;
        }

        public void setVisitReports(List<VisitReportsBean> visitReports) {
            this.visitReports = visitReports;
        }

        public static class VisitReportsBean {
            @SerializedName("date_of_visit")
            private String dateOfVisit;
            @SerializedName("csp_code")
            private String cspCode;
            @SerializedName("status")
            private boolean status;

            public String getDateOfVisit() {
                return dateOfVisit;
            }

            public void setDateOfVisit(String dateOfVisit) {
                this.dateOfVisit = dateOfVisit;
            }

            public String getCspCode() {
                return cspCode;
            }

            public void setCspCode(String cspCode) {
                this.cspCode = cspCode;
            }

            public boolean isStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }
        }
    }
}
