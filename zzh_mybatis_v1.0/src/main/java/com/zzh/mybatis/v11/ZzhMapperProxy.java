package com.zzh.mybatis.v11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description mapper代理对象
 * @Author huafeng.zzh
 * @Date 2021/5/15 14:59
 * @Version 1.0
 */
public class ZzhMapperProxy implements InvocationHandler {
    private ZzhSqlSession sqlSession;

    public ZzhMapperProxy(ZzhSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface+"."+methodName;
        return sqlSession.selectOne(statementId,args[0]);
    }
}
