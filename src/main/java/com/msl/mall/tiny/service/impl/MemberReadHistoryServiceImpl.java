package com.msl.mall.tiny.service.impl;

import com.msl.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.msl.mall.tiny.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.msl.mall.tiny.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    MemberReadHistoryRepository readHistoryRepository;
    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setMemberId(null);
        memberReadHistory.setCreateTime(new Date());
        MemberReadHistory save = readHistoryRepository.save(memberReadHistory);
        if(save!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for(String id:ids){
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteList.add(memberReadHistory);
        }
        readHistoryRepository.deleteAll(deleteList);
        return ids.size();

    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        List<MemberReadHistory> byMemberIdOrderByCreateTime = readHistoryRepository.findByMemberIdOrderByCreateTime(memberId);
        return byMemberIdOrderByCreateTime;
    }
}
