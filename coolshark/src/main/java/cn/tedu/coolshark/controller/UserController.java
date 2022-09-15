package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.User;
import cn.tedu.coolshark.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;
    @RequestMapping("/login")
    public int login(@RequestBody User user){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                return 1;
            }
            return 3;
        }
        return 2;
    }
}
