package cn.tedu.weibo.controller;

import cn.tedu.weibo.entity.User;
import cn.tedu.weibo.entity.Weibo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class WeiboController {
    @RequestMapping("/weibo/insert")
    public int insert(@RequestBody Weibo weibo, HttpSession session){
        System.out.println("weibo = " + weibo);
        //设置微博的发布时间为当前系统时间  new Date()创建的就是当前系统时间
        weibo.setCreated(new Date());
        //设置作者的信息
        //得到当前登录的用户信息  异常是类型强转
        User user = (User) session.getAttribute("user");
        if (user==null){//如果获取不到user,代表用户未登录,不允许发微博
            return 2;//代表未登录
        }
        return 1;
    }
}
