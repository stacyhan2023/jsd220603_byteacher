package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.User;
import cn.tedu.boot04.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper mapper;

    @RequestMapping("/reg")
    public String reg(User user){
        System.out.println("user = " + user);
        //通过用户输入的用户名 查询出数据库中的用户信息
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return "用户名已存在!";
        }
        //用户名不存 则开始注册
        mapper.insert(user);
        return "注册成功!";
    }


    @RequestMapping("/login")
    public String login(User user){
        System.out.println("user = " + user);
        //通过用户输入的用户名查询数据库中的密码
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            //判断用户输入的密码和查询到的密码是否一致
            if (user.getPassword().equals(u.getPassword())){
                return "登录成功!";
            }
            return "密码错误!";
        }
        return "用户名不存在!";
    }

}
