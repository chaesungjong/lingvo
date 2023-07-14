package com.castlebell.lingvo.repository;


import java.util.HashMap;
import org.apache.ibatis.annotations.Mapper;

/**
 * 회원 정보 관련 매퍼
 */
@Mapper
public interface MemberMapper {

    /**
     * 로그인 처리
     * @return
     */
    HashMap<String, Object> memLogin(String userid, String userpw, String ip, String clienttype);

}
