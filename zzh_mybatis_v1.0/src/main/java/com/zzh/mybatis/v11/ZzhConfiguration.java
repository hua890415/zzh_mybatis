package com.zzh.mybatis.v11;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @Description 配置类
 * @Author huafeng.zzh
 * @Date 2021/5/15 14:45
 * @Version 1.0
 */
public class ZzhConfiguration {
    // 存储属性文件的信息
    public static final ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("v11sql");
    }
    /**
     * 获取mapper
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz,ZzhSqlSession zzhSqlSession){
        //三个参数分别为：类加载器、被代理类的实现接口、触发管理器
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[] {clazz},
                new ZzhMapperProxy(zzhSqlSession));
    }
}
