package cn.tedu.boot02.controller;

import cn.tedu.boot02.entity.User;
import cn.tedu.boot02.utils.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class UserController {

    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user){
        System.out.println("user = " + user);
        //获取连接
        try (Connection conn = DBUtils.getConn()){
            //准备查询数据的SQL
            String sql = "select id from user where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return "用户名已存在!";
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "注册成功!";
    }
}
