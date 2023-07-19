package com.castlebell.lingvo.mmb.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castlebell.lingvo.domain.dao.mmb.LoginResult;
import com.castlebell.lingvo.domain.dao.mmb.Member;
import com.castlebell.lingvo.repository.MemberMapper;
import com.castlebell.lingvo.util.StringUtil;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper MemberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.MemberMapper = memberMapper;
    }

    /**
     * 로그인 처리
     */
    @Override
    public HashMap<String, Object> loginProcess(String userid, String userpw, String ip, String clienttype, HttpSession session) {
        
        HashMap<String, Object> result = new HashMap<String, Object>();
        String retVal = "";        
        String errMsg = "";

        result.put("userid",userid);
        result.put("userpw",userpw);
        result.put("ip",ip);
        result.put("clienttype",clienttype);

        LoginResult loginResult = new LoginResult();
        loginResult.setUserid(userid);
        loginResult.setUserpw(userpw);
        loginResult.setIp(ip);
        loginResult.setClienttype(clienttype);

        try{
            //로그인 처리
            MemberMapper.memLogin(loginResult);

            retVal = StringUtil.objectToString(loginResult.getRetVal());
            errMsg = StringUtil.objectToString(loginResult.getErrMsg());
            result.put("retVal", retVal);
            result.put("errMsg", errMsg);

            //로그인 실패
            if(!"0".equals(retVal)) {
                return result;
            }

            //로그인 정보 가져오기
            Map<String, Object> params = new HashMap<>();
            params.put("gubun", "MEM_USERINFO");
            params.put("userid", userid);
            params.put("ip", ip);
            params.put("userkey", ""); 
            params.put("etcParam1", "");
            params.put("etcParam2", "");
            //로그인 처리
            Member member = MemberMapper.memUserInfo(params);

            if(member == null) {
                result.put("retVal", "-1");
                result.put("errMsg", "로그인 정보가 없습니다.");
                return result;
            }

            //로그인 성공
            session.setAttribute("member", member);

        }catch(Exception e){
            e.printStackTrace();
            result.put("retVal", "-1");
            result.put("errMsg", "로그인 처리중 오류가 발생하였습니다.");
        }

        return result;
    }
}
