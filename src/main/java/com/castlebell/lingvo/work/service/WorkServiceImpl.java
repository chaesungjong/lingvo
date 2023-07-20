package com.castlebell.lingvo.work.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castlebell.lingvo.domain.dao.mmb.Member;
import com.castlebell.lingvo.domain.dao.work.WorkSafetyCheck;
import com.castlebell.lingvo.repository.WorkMapper;

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
    
}
