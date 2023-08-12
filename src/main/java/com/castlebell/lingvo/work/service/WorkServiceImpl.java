package com.castlebell.lingvo.work.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.cmm.session.WorkSafetyCheck;
import com.castlebell.lingvo.work.dao.WorkMapper;
import com.castlebell.lingvo.work.dao.domain.request.WorkClassMsgListRequest;
import com.castlebell.lingvo.work.dao.domain.response.WorkClassMsgListResponse;
import com.castlebell.lingvo.work.dao.domain.response.workIssueMsgListResponse;

@Service
public class WorkServiceImpl implements WorkService{


    private final WorkMapper workMapper;

    @Autowired
    public WorkServiceImpl(WorkMapper workMapper) {
        this.workMapper = workMapper;
    }


    @Override
    public WorkSafetyCheck getSiteInfo(HttpSession session, HttpServletRequest request) {

        Member member = (Member) session.getAttribute("member");

        String qrCode = request.getParameter("qrCode");
        String userid = member.getUserid();
        String ip = request.getRemoteAddr();

        WorkSafetyCheck workSafetyCheck = new WorkSafetyCheck();
        workSafetyCheck.setGubun("QR_CHECKIN");
        workSafetyCheck.setUserid(userid);
        workSafetyCheck.setQrCode(qrCode);
        workSafetyCheck.setWorkGubun("");
        workSafetyCheck.setWorkClass("");
        workSafetyCheck.setState("");
        workSafetyCheck.setIp(ip);
        workSafetyCheck.setWorkSeq("0");
        workSafetyCheck.setEtcParam1("");
        workSafetyCheck =  workMapper.workSafetyCheck(workSafetyCheck);

        return workSafetyCheck;
    }


    @Override
    public List<WorkClassMsgListResponse> getWorkClassMsgList(WorkClassMsgListRequest workClassMsgListRequest) {
        return workMapper.getWorkClassMsgList(workClassMsgListRequest);
    }


    @Override
    public WorkSafetyCheck checkSurvey(HttpSession session, HttpServletRequest request,String gubun,String WorkGubun) {

        Member member = (Member) session.getAttribute("member");
        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");

        String ip = request.getRemoteAddr();                    // 접속자 IP
        String userid = member.getUserid();                     // 접속자 ID

        workSafetyCheck.setGubun(gubun);                        // QR_CHECKIN
        workSafetyCheck.setWorkGubun(WorkGubun);
        workSafetyCheck.setWorkClass("");
        workSafetyCheck.setIp(ip);
        workSafetyCheck.setUserid(userid);
        workSafetyCheck = workMapper.workSafetyCheck(workSafetyCheck);
        
        return workSafetyCheck;
    }


    @Override
    public List<workIssueMsgListResponse> workIssueMsgList(HashMap<String, String> map) {
        return workMapper.getWorkIssueMsgList(map);
    }
    
}
