package com.castlebell.lingvo.mmb.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public interface MemberService {

    /**
     * 로그인 처리
     * @param userId
     * @param pwd
     * @param ip
     * @param clientype
     * @param session
     * @return
     */
    HashMap<String, Object> loginProcess(String userId, String pwd, String ip, String clientype, HttpSession session);

}
