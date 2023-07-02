package com.castlebell.lingvo.mmb;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;


    @Override
    public String login(Map<String, Object> requestData) {
        return memberMapper.loginProcess();
    }

}
