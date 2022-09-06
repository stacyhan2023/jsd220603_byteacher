package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        System.out.println("请输入昵称");
        String nick = sc.nextLine();
        try (Connection conn = DBUtils.getConn()){
            String sql = "select id from user where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                System.out.println("用户名已存在!");
                return;
            }
            //往数据库中添加数据
           String insert_sql = "insert into user values(null,?,?,?)";
            ps = conn.prepareStatement(insert_sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,nick);
            ps.executeUpdate();
            System.out.println("注册成功!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
