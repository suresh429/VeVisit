package com.vcspinfo.vevist.models;

public class DashBoardModel {
    private String dashBoardTitle;
    private String count;
    private int icon;
    private int color;

    public DashBoardModel(String dashBoardTitle, String count, int icon, int color) {
        this.dashBoardTitle = dashBoardTitle;
        this.count = count;
        this.icon = icon;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDashBoardTitle() {
        return dashBoardTitle;
    }

    public void setDashBoardTitle(String dashBoardTitle) {
        this.dashBoardTitle = dashBoardTitle;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
