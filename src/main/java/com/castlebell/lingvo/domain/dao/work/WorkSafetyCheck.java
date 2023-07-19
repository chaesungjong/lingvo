package com.castlebell.lingvo.domain.dao.work;

import java.io.Serializable;

public class WorkSafetyCheck implements Serializable {

    
    private static final long serialVersionUID = 1L;

    private String errCode;                                                             // 결과 값
    private String siteCode;                                                            // 현장 코드
    private String siteName;                                                            // 현장 명
    private String siteAddress;                                                         // 현장 주소
    private String constName;                                                           // 공사 명
    private String companyName;                                                         // 현장 소속 회사 명
    private String workType;                                                            // 작업 유형
    private int workSeq;                                                                // 작업 순번


    public String getErrCode() {
        return errCode;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public String getConstName() {
        return constName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getWorkType() {
        return workType;
    }

    public int getWorkSeq() {
        return workSeq;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        return "WorkSafetyCheck [companyName=" + companyName + ", constName=" + constName + ", errCode=" + errCode
                + ", siteAddress=" + siteAddress + ", siteCode=" + siteCode + ", siteName=" + siteName + ", workSeq="
                + workSeq + ", workType=" + workType + "]";
    }
}