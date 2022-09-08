package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/reg")
    public String reg(User user){
        System.out.println("user = " + user);

        return "注册成功!";
    }
}
