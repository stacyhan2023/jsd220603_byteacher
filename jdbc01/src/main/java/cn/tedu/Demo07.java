package cn.tedu;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        try (Connection conn = DBUtils.getConn()){
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(
                    "select count(*) from user where username='"
                            +username+"' and password='"+password+"'");
            //让游标往下移动 指向返回的数据
            rs.next();
            //取出查询到的数量  1代表查询到的数据位置
            int count = rs.getInt(1);
            if (count>0){
                System.out.println("登录成功!");
            }else{
                System.out.println("用户名或密码错误!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
