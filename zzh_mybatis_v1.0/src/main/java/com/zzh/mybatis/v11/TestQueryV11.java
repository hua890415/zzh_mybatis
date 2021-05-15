package com.zzh.mybatis.v11;

import com.zzh.mybatis.domain.TTest;
import com.zzh.mybatis.mapper.TTestMapper;
import lombok.val;
import org.junit.Test;

/**
 * @Description
 * @Author huafeng.zzh
 * @Date 2021/5/15 15:41
 * @Version 1.0
 */
public class TestQueryV11 {
    @Test
    public void testQuery(){
        ZzhSqlSession sqlSession = new ZzhSqlSession();
        TTestMapper testMapper = sqlSession.getMapper(TTestMapper.class);
        TTest tTest = testMapper.selectById(2L);
        System.out.println("test===="+tTest);
    }
}
