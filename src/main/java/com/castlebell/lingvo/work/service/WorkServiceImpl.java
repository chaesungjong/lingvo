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
    public HashMap<String, Object> getSiteInfo(HttpSession session, HttpServletRequest request) {

        HashMap<String, Object> requestHashMap = new HashMap<String, Object>();
        Member member = (Member) session.getAttribute("member");

        String qrCode = request.getParameter("qrCode");
        String userid = member.getUserid();
        String ip = request.getRemoteAddr();
        String workSql = request.getParameter("workSql");

        requestHashMap.put("gubun", "QR_CHECKIN");
        requestHashMap.put("userid", userid);
        requestHashMap.put("qrCode", qrCode);
        requestHashMap.put("workGubun", "");
        requestHashMap.put("workClass", "");
        requestHashMap.put("state", "");
        requestHashMap.put("ip", ip);
        requestHashMap.put("workSql", "0");
        requestHashMap.put("etcParam1", "");


        WorkSafetyCheck workSafetyCheck =  workMapper.workSafetyCheck(requestHashMap);


        HashMap<String, Object> result = new HashMap<String, Object>();
        if("0".equals(workSafetyCheck.getErrCode())){
            result.put("errCode", "0");
            result.put("errMsg", "정상처리되었습니다.");
            result.put("WorkSafetyCheck", workSafetyCheck);
        }else{
            result.put("errCode", workSafetyCheck.getErrCode());
            result.put("errMsg",  "잘못 된 공사 현장 입니다. 다시 확인 부탁드립니다.");
        }
        return result;
    }
    
}
