package com.vcspinfo.vevist.models;

import com.google.gson.annotations.SerializedName;

public class DashboardResponse {


    @SerializedName("dashboard")
    private DashboardBean dashboard;
    @SerializedName("status")
    private int status;

    public DashboardBean getDashboard() {
        return dashboard;
    }

    public void setDashboard(DashboardBean dashboard) {
        this.dashboard = dashboard;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DashboardBean {
        @SerializedName("username")
        private String username;
        @SerializedName("today")
        private int today;
        @SerializedName("month")
        private int month;
        @SerializedName("total")
        private int total;
        @SerializedName("csp_1a")
        private int csp1a;
        @SerializedName("csp_3a")
        private int csp3a;
        @SerializedName("csp_1998")
        private int csp1998;
        @SerializedName("csp_pgb")
        private int cspPgb;
        @SerializedName("completed_visits")
        private int completedVisits;
        @SerializedName("pending_visits")
        private int pendingVisits;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getToday() {
            return today;
        }

        public void setToday(int today) {
            this.today = today;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCsp1a() {
            return csp1a;
        }

        public void setCsp1a(int csp1a) {
            this.csp1a = csp1a;
        }

        public int getCsp3a() {
            return csp3a;
        }

        public void setCsp3a(int csp3a) {
            this.csp3a = csp3a;
        }

        public int getCsp1998() {
            return csp1998;
        }

        public void setCsp1998(int csp1998) {
            this.csp1998 = csp1998;
        }

        public int getCspPgb() {
            return cspPgb;
        }

        public void setCspPgb(int cspPgb) {
            this.cspPgb = cspPgb;
        }

        public int getCompletedVisits() {
            return completedVisits;
        }

        public void setCompletedVisits(int completedVisits) {
            this.completedVisits = completedVisits;
        }

        public int getPendingVisits() {
            return pendingVisits;
        }

        public void setPendingVisits(int pendingVisits) {
            this.pendingVisits = pendingVisits;
        }
    }
}
