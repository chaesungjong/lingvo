package com.castlebell.lingvo.work.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.castlebell.lingvo.domain.dao.work.WorkSafetyCheck;
import com.castlebell.lingvo.work.dao.domain.request.WorkClassMsgListRequest;
import com.castlebell.lingvo.work.dao.domain.response.WorkClassMsgListResponse;

public interface WorkService {

    /**
     * QRCode 인식 하여 현장 정보 가져오기
     * @param qrCode
     * @param session
     * @param request
     * @return
     */
    WorkSafetyCheck getSiteInfo(HttpSession session, HttpServletRequest request);

    /**
     * 안전예방활동체크 질문 리스트
     * @param qrCode
     * @param session
     * @param request
     * @return
     */
    List<WorkClassMsgListResponse> getWorkClassMsgList(WorkClassMsgListRequest workClassMsgListRequest);

    /**
     * 예방활동체크 
     * @param session
     * @param request
     * @return
     */
    WorkSafetyCheck checkSurvey(HttpSession session, HttpServletRequest request,String gubun,String WorkGubu);
    

}
