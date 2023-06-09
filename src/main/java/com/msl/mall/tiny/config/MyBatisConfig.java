package com.msl.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"com.msl.mall.tiny.mbg.mapper", "com.msl.mall.tiny.dao"})
public class MyBatisConfig {
}
