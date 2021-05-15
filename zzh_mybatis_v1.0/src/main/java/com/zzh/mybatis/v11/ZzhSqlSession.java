package com.zzh.mybatis.v11;

/**
 * @Description 通过SqlSession来处理不同的用户请求
 * @Author huafeng.zzh
 * @Date 2021/5/15 14:44
 * @Version 1.0
 */
public class ZzhSqlSession {
    private ZzhConfiguration configuration;
    private ZzhExecutor executor;

    public ZzhSqlSession() {
        if(null == configuration){
            configuration = new ZzhConfiguration();
        }
        if(null == executor){
            executor = new ZzhExecutor();
        }
    }

    /**
     * 查询操作
     * @param statementId
     * @param parameter
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId, Object parameter) {
        String sql = ZzhConfiguration.sqlMappings.getString(statementId);
        return executor.query(sql,parameter);
    }

    /**
     * 获取mapper
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz){
        return (T)configuration.getMapper(clazz,this);
    }
}
