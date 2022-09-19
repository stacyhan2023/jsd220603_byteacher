package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.User;
import cn.tedu.coolshark.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;
    @RequestMapping("/login")
    public int login(@RequestBody User user, HttpSession session, HttpServletResponse response){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                if (user.getRem()){
                    Cookie c1 = new Cookie("username",user.getUsername());
                    Cookie c2 = new Cookie("password",user.getPassword());
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                //把登录成功的用户对象保存到会话里面
                session.setAttribute("user",u);
                return 1;
            }
            return 3;
        }
        return 2;
    }
    @RequestMapping("/currentUser")
    public User currentUser(HttpSession session){
        //把登录成功时的用户对象从会话对象中取出响应给客户端
        return (User) session.getAttribute("user");
    }

}
