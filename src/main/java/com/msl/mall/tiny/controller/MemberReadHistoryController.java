package com.msl.mall.tiny.controller;

import com.msl.mall.tiny.common.api.CommonResult;
import com.msl.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.msl.mall.tiny.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.msl.mall.tiny.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "MemberReadHistoryController",description = "会员商品浏览记录管理")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {
    @Autowired
    private MemberReadHistoryService readHistoryService;
    @PostMapping("/create")
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory){
        int count=readHistoryService.create(memberReadHistory);
        if(count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();

    }
    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam("ids")List<String>ids){
       int count= readHistoryService.delete(ids);
       return CommonResult.success(count);
    }
    @GetMapping("/list")
    public CommonResult<List<MemberReadHistory>> list(Long memberId){
       List<MemberReadHistory> memberReadHistories = readHistoryService.list(memberId);
       return CommonResult.success(memberReadHistories);

    }
}
