package cn.tedu.boot05.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/check")
    public String check(String username){

        if (username.equals("tom")){
            return "用户名已存在!";
        }
        return "用户名可用";
    }
}
