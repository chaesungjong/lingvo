package com.castlebell.lingvo.domain;

import java.io.Serializable;

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;
    private String userKey;
    private String pwd;
    private String name;
    private String hpno;
    private String emergencyHpno;
    private String bloodType;
    private String addr;
    private String foreignYn;
    private String idImgUrl;
    private String state;
    private String grade;
    private String requestTime;
    private String approvalTime;
    private String approvaladminId;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getuserKey() {
        return userKey;
    }

    public void setuserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHpno() {
        return hpno;
    }

    public void setHpno(String hpno) {
        this.hpno = hpno;
    }

    public String getEmergencyHpno() {
        return emergencyHpno;
    }

    public void setEmergencyHpno(String emergencyHpno) {
        this.emergencyHpno = emergencyHpno;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getForeignYn() {
        return foreignYn;
    }

    public void setForeignYn(String foreignYn) {
        this.foreignYn = foreignYn;
    }

    public String getIdImgUrl() {
        return idImgUrl;
    }

    public void setIdImgUrl(String idImgUrl) {
        this.idImgUrl = idImgUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getApprovaladminId() {
        return approvaladminId;
    }

    public void setApprovaladminId(String approvaladminId) {
        this.approvaladminId = approvaladminId;
    }
}