package com.msl.mall.tiny.nosql.mongodb.repository;

import com.msl.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
   List<MemberReadHistory> findByMemberIdOrderByCreateTime(Long memberId);
}
