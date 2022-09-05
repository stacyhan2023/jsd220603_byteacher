package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        //1. 获取数据库连接  异常抛出
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root","root");
        System.out.println("连接对象:"+conn);
        //2. 创建执行SQL语句的对象
        //3. 执行SQL语句
        //4. 关闭资源
    }
}
