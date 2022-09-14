package cn.tedu.weibo.controller;

import cn.tedu.weibo.entity.User;
import cn.tedu.weibo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/reg")
    public int reg(@RequestBody User user){
        System.out.println("user = " + user);
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return 2; //用户名已存在
        }
         mapper.insert(user);
        return 1;//注册成功!
    }

    @RequestMapping("/login")
    public int login(@RequestBody User user, HttpSession session){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (user.getPassword().equals(u.getPassword())){
                //把当前客户端登录成功的用户对象保存到对应的会话对象中
                session.setAttribute("user",u);
                return 1;//登录成功
            }
            return 3;//密码错误
        }
        return 2;//用户名不存在
    }
    @RequestMapping("/currentUser")
    public User currentUser(HttpSession session){
        //从当前客户端对应的会话对象中取出登录成功时保存的用户对象
        //如果没有登录得到的是null
        return (User) session.getAttribute("user");
    }

}
