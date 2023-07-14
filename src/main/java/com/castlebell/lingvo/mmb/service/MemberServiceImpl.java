package com.castlebell.lingvo.mmb.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castlebell.lingvo.domain.Member;
import com.castlebell.lingvo.repository.MemberMapper;
import com.castlebell.lingvo.util.StringUtil;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper MemberMapper;

   @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.MemberMapper = memberMapper;
    }

    @Override
    public HashMap<String, Object> loginProcess(String userid, String userpw, String ip, String clienttype, HttpSession session) {
        
        HashMap<String, Object> result = new HashMap<String, Object>();
        String retVal = "";

        //로그인 처리
        // result = MemberMapper.memLogin(userid, userpw, ip, clienttype);

        // retVal = StringUtil.objectToString(result.get("retVal"));


        // //로그인 실패
        // if(!"0".equals(retVal)) {
        //     return result;
        // }

        Member member = new Member();

        // member.setUserid(StringUtil.objectToString(result.get("userid")));
        // member.setName(StringUtil.objectToString(result.get("name")));
        // member.setHpno(StringUtil.objectToString(result.get("hpno")));
        // member.setEmergencyHpno(StringUtil.objectToString(result.get("emergencyHpno")));
        // member.setBloodType(StringUtil.objectToString(result.get("bloodType")));
        // member.setAddr(StringUtil.objectToString(result.get("addr")));
        // member.setForeignYn(StringUtil.objectToString(result.get("foreignYn")));
        // member.setIdImgUrl(StringUtil.objectToString(result.get("idImgUrl")));
        // member.setState(StringUtil.objectToString(result.get("state")));
        // member.setGrade(StringUtil.objectToString(result.get("grade")));
        // member.setRequestTime(StringUtil.objectToString(result.get("requestTime")));
        // member.setApprovalTime(StringUtil.objectToString(result.get("approvalTime")));
        // member.setApprovaladminId(StringUtil.objectToString(result.get("approvaladminId")));


        if("test".equals(userid)){
            member.setUserid("test");
            member.setuserKey("10000003");
            member.setName("홍길동");
            member.setHpno("01011112222");
            member.setEmergencyHpno("01033334444");
            member.setBloodType("O");
            member.setAddr("서울시 강남구 서초동 123번지");
            member.setForeignYn("N");
            member.setIdImgUrl("https://m.naver.com");
            member.setState("Y");
            member.setGrade("U1");
        }

        session.setAttribute("member", member);


        //로그인 성공
        //회원정보를 가져와야 함.

        return result;
    }
}
