package cn.tedu.weibo.controller;

import cn.tedu.weibo.entity.User;
import cn.tedu.weibo.entity.Weibo;
import cn.tedu.weibo.mapper.WeiboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class WeiboController {
    @Autowired
    WeiboMapper mapper;

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
        //把当前登录的用户信息赋值给weibo对象
        weibo.setUserId(user.getId());
        weibo.setNick(user.getNick());
        System.out.println("weibo = " + weibo );
        //把weibo对象中的数据保存到weibo表
        mapper.insert(weibo);
        return 1;
    }

    @RequestMapping("/weibo/select")
    public List<Weibo> select(){
        return mapper.select();
    }
    @RequestMapping("/weibo/selectById")
    public Weibo selectById(int id){
        System.out.println("id = " + id);
        return mapper.selectById(id);
    }
}
