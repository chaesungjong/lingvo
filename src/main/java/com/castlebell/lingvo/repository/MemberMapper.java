package com.castlebell.lingvo.repository;


import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.castlebell.lingvo.domain.dao.mmb.LoginResult;
import com.castlebell.lingvo.domain.dao.mmb.Member;

/**
 * 회원 정보 관련 매퍼
 */
@Mapper
public interface MemberMapper {

    /**
     * 로그인 처리
     * @return
     */
    void memLogin(LoginResult param);

    /**
     * 로그인 정보 가져온다.
     * @return
     */
    Member memUserInfo(Map<String, Object> params);

}
