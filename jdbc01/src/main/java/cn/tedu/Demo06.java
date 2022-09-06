package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        System.out.println("请输入昵称");
        String nick = sc.nextLine();
/*
use empdb;
create table user(id int primary key auto_increment,username varchar(50),
                password varchar(50),
                nick varchar(50));
*
* */
        //得到数据库连接
        try (Connection conn = DBUtils.getConn()){
            //创建执行SQL语句的对象
            Statement s = conn.createStatement();
            //查询user表中是否已经存在了username
            ResultSet rs = s.executeQuery(
                    "select id from user where username='"+username+"'");
            //判断是否查询到了数据
            if (rs.next()){
                System.out.println("用户名已存在");
                return;
            }

            String sql = "insert into user values(null,'"
                    +username+"','"+password+"','"+nick+"')";
            s.executeUpdate(sql);
            System.out.println("注册成功!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
