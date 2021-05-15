package com.zzh.mybatis.mapper;

import com.zzh.mybatis.domain.TTest;

import java.util.List;

/**
 * @Description
 * @Author huafeng.zzh
 * @Date 2021/5/15 15:16
 * @Version 1.0
 */
public interface TTestMapper {
    TTest selectById(Long id);
}
