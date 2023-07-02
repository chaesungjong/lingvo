package com.castlebell.lingvo.mmb;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  MemberMapper {
    

    // TODO [SEARCH FAST] : [테스트 DB 호출]
    String loginProcess();
}
