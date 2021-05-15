package com.zzh.mybatis.v11;

import com.zzh.mybatis.domain.TTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * @Description
 * @Author huafeng.zzh
 * @Date 2021/5/15 14:46
 * @Version 1.0
 */
public class ZzhExecutor {
    public <T> T query(String sql, Object parameter) {
        Connection connection = null;
        Statement statement = null;
        TTest tTest = new TTest();

        ResourceBundle bundle = ResourceBundle.getBundle("sql");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format(sql,parameter));
            while (rs.next()) {
                Long id = rs.getLong("id");
                String studentName = rs.getString("student_name");
                String className = rs.getString("class_name");
                String course = rs.getString("course");
                tTest.setId(id);
                tTest.setStudentName(studentName);
                tTest.setClassName(className);
                tTest.setCourseStr(course);

                System.out.println("结果：====="+tTest);
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return (T)tTest;
    }
}
