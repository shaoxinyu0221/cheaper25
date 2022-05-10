package com.shaoxinyu.jdbc.myjdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc02 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();
        //2.提供连接信息
        String url = "jdbc:mysql://localhost:3306/day022_jdbc";
        Properties properties = new Properties();
        properties.getProperty("user","root");
        properties.getProperty("password","shaoxinyu123");

        Connection connect = driver.connect(url,properties);

        //3.写sql语句
        String sql = "insert into userinfo(username,password) values('admin','1234')";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows);


        //4.关闭连接
        statement.close();
        connect.close();

    }
}
