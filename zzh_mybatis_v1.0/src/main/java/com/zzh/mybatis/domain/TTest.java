package com.zzh.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Description
 * @Author huafeng.zzh
 * @Date 2021/4/26 9:19
 * @Version 1.0
 */
public class TTest {
    private Long id;
    private String studentName;
    private String className;
    private List<String> course;
}
