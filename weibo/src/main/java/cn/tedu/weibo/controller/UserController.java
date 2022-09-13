package cn.tedu.weibo.controller;

import cn.tedu.weibo.entity.User;
import cn.tedu.weibo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
