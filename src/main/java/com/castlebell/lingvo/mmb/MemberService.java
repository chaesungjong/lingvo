package com.castlebell.lingvo.mmb;

import java.util.Map;



public interface MemberService {

    /**
     * 로그인 처리
     * @param requestData
     * @return
     */
    public String login(Map<String, Object> requestData);

}
