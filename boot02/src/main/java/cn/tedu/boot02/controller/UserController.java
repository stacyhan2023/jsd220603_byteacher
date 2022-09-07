package cn.tedu.boot02.controller;

import cn.tedu.boot02.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user){
        System.out.println("user = " + user);


        return "注册成功!";
    }
}
