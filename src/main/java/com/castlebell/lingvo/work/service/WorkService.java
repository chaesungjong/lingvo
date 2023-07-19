package com.castlebell.lingvo.work.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface WorkService {

    /**
     * QRCode 인식 하여 현장 정보 가져오기
     * @param qrCode
     * @param session
     * @param request
     * @return
     */
    HashMap<String, Object> getSiteInfo(HttpSession session, HttpServletRequest request);
    
}
