package com.shaoxinyu.jdbc.myjdbc;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Jdbc01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.提供数据库信息
        String url = "jdbc:mysql://localhost:3306/day022_jdbc";
        String user = "root";
        String password = "shaoxinyu123";
        //驱动地址
        String driverClass = "com.mysql.cj.jdbc.Driver";

        //2.注册驱动
        Class.forName(driverClass);

        //3.连接数据库
        Connection connect = DriverManager.getConnection(url,user,password);

        //4.写sql语法
        String sql = "insert into userinfo(username,password) values('admin','1234')";

        //5.sql语法预编译
        PreparedStatement pst = connect.prepareStatement(sql);

        //6.执行sql语句
        int result = pst.executeUpdate();
        System.out.println("受影响的行数为" + result);

        //7.关闭连接
        pst.close();
        connect.close();
    }
}

