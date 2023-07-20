package com.castlebell.lingvo.work.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.castlebell.lingvo.domain.dao.work.WorkSafetyCheck;

public interface WorkService {

    /**
     * QRCode 인식 하여 현장 정보 가져오기
     * @param qrCode
     * @param session
     * @param request
     * @return
     */
    WorkSafetyCheck getSiteInfo(HttpSession session, HttpServletRequest request);
    
}
