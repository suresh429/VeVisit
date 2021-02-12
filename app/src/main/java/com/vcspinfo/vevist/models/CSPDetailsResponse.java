package com.vcspinfo.vevist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CSPDetailsResponse {


    @SerializedName("csp_details")
    private List<CspDetailsBean> cspDetails;

    public List<CspDetailsBean> getCspDetails() {
        return cspDetails;
    }

    public void setCspDetails(List<CspDetailsBean> cspDetails) {
        this.cspDetails = cspDetails;
    }

    public static class CspDetailsBean {
        @SerializedName("id")
        private int id;
        @SerializedName("csp_code")
        private String cspCode;
        @SerializedName("email")
        private String email;
        @SerializedName("name")
        private String name;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("alter_mobile")
        private String alterMobile;
        @SerializedName("dob")
        private String dob;
        @SerializedName("pan")
        private String pan;
        @SerializedName("aadhaar")
        private Object aadhaar;
        @SerializedName("gender")
        private String gender;
        @SerializedName("qualification")
        private Object qualification;
        @SerializedName("village")
        private String village;
        @SerializedName("post")
        private Object post;
        @SerializedName("tehsil")
        private Object tehsil;
        @SerializedName("pin")
        private String pin;
        @SerializedName("csp_location")
        private String cspLocation;
        @SerializedName("ssa")
        private String ssa;
        @SerializedName("longitude")
        private String longitude;
        @SerializedName("latitude")
        private String latitude;
        @SerializedName("branch")
        private String branch;
        @SerializedName("branch_code")
        private String branchCode;
        @SerializedName("transfer_account")
        private Object transferAccount;
        @SerializedName("commission_account")
        private Object commissionAccount;
        @SerializedName("status")
        private int status;
        @SerializedName("district_id")
        private int districtId;
        @SerializedName("state_id")
        private int stateId;
        @SerializedName("district")
        private String district;
        @SerializedName("state")
        private String state;
        @SerializedName("created_by")
        private Object createdBy;
        @SerializedName("updated_by")
        private Object updatedBy;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCspCode() {
            return cspCode;
        }

        public void setCspCode(String cspCode) {
            this.cspCode = cspCode;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getAlterMobile() {
            return alterMobile;
        }

        public void setAlterMobile(String alterMobile) {
            this.alterMobile = alterMobile;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getPan() {
            return pan;
        }

        public void setPan(String pan) {
            this.pan = pan;
        }

        public Object getAadhaar() {
            return aadhaar;
        }

        public void setAadhaar(Object aadhaar) {
            this.aadhaar = aadhaar;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Object getQualification() {
            return qualification;
        }

        public void setQualification(Object qualification) {
            this.qualification = qualification;
        }

        public String getVillage() {
            return village;
        }

        public void setVillage(String village) {
            this.village = village;
        }

        public Object getPost() {
            return post;
        }

        public void setPost(Object post) {
            this.post = post;
        }

        public Object getTehsil() {
            return tehsil;
        }

        public void setTehsil(Object tehsil) {
            this.tehsil = tehsil;
        }

        public String getPin() {
            return pin;
        }

        public void setPin(String pin) {
            this.pin = pin;
        }

        public String getCspLocation() {
            return cspLocation;
        }

        public void setCspLocation(String cspLocation) {
            this.cspLocation = cspLocation;
        }

        public String getSsa() {
            return ssa;
        }

        public void setSsa(String ssa) {
            this.ssa = ssa;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getBranchCode() {
            return branchCode;
        }

        public void setBranchCode(String branchCode) {
            this.branchCode = branchCode;
        }

        public Object getTransferAccount() {
            return transferAccount;
        }

        public void setTransferAccount(Object transferAccount) {
            this.transferAccount = transferAccount;
        }

        public Object getCommissionAccount() {
            return commissionAccount;
        }

        public void setCommissionAccount(Object commissionAccount) {
            this.commissionAccount = commissionAccount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getDistrictId() {
            return districtId;
        }

        public void setDistrictId(int districtId) {
            this.districtId = districtId;
        }

        public int getStateId() {
            return stateId;
        }

        public void setStateId(int stateId) {
            this.stateId = stateId;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Object getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Object createdBy) {
            this.createdBy = createdBy;
        }

        public Object getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(Object updatedBy) {
            this.updatedBy = updatedBy;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
