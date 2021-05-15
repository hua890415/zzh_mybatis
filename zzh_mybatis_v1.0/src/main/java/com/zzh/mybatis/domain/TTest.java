package com.zzh.mybatis.domain;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author huafeng.zzh
 * @Date 2021/4/26 9:19
 * @Version 1.0
 */
@Data
public class TTest {
    private Long id;
    private String studentName;
    private String className;
    private List<String> course;
    private String courseStr;
}
