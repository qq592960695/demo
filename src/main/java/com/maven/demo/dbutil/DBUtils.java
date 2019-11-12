package com.maven.demo.dbutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static MyDataSource dataSource = new MyDataSource();
    public static ResultSet getList(String sql) throws SQLException {  //获取数据返回的信息列表
        Connection connection =(Connection)dataSource.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement=null;
        try {
           preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (Exception e) {
           e.getMessage();
        } finally {
//            resultSet.close();
//           preparedStatement.close();
           dataSource.releaseConnection(connection);

        }
        return null;
    }

    public static int update(String sql) throws SQLException {  //增,删,改数据的方法
        Connection connection =(Connection)dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int num = preparedStatement.executeUpdate();
            return num;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }finally {
            dataSource.releaseConnection(connection);
        }
        return 0;
    }

    public static long save_returnId(String sql, Connection connection) {   //新增数据并返回新增数据的id

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int num = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys != null) {
                long id = 0;
                while (generatedKeys.next()) {
                    id = generatedKeys.getLong(1);
                }
                return id;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;
    }
}