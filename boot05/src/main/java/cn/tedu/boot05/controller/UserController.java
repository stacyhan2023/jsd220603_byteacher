package cn.tedu.boot05.controller;

import cn.tedu.boot05.entity.User;
import cn.tedu.boot05.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/check")
    public int check(String username){

        User u = mapper.selectByUsername(username);
        if (u!=null){
            return 2;
        }
        return 1;
    }

    @RequestMapping("/reg")
    public int reg(@RequestBody User user){
        System.out.println("user = " + user);
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return 2;//代表用户名已存在
        }
        mapper.insert(user);

        return 1;
    }
}
