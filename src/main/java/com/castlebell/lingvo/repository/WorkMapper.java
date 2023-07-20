package com.castlebell.lingvo.repository;

import org.apache.ibatis.annotations.Mapper;
import com.castlebell.lingvo.domain.dao.work.WorkSafetyCheck;

/**
 * 작업 관련 프로시저 매퍼
 */
@Mapper
public interface WorkMapper {
    

    /**
     * 금일 작업시작하기
     * @return
     */
    WorkSafetyCheck workSafetyCheck(WorkSafetyCheck workSafetyCheck);
}
