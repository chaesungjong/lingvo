package com.castlebell.lingvo.mmb.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public interface MemberService {

    HashMap<String, Object> loginProcess(String userId, String pwd, String ip, String clientype, HttpSession session);

}
