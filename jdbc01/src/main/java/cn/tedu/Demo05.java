package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo05 {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池
        DruidDataSource dds = new DruidDataSource();
        //设置连接数据库的信息
        dds.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false");
        dds.setUsername("root");
        dds.setPassword("root");
        //设置初始连接数量
        dds.setInitialSize(3);
        //设置最大连接数量
        dds.setMaxActive(5);
        //获取连接对象  异常抛出
        Connection conn = dds.getConnection();
        System.out.println("连接:"+conn);

    }
}
