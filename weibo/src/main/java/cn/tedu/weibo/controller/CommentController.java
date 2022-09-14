package cn.tedu.weibo.controller;

import cn.tedu.weibo.entity.Comment;
import cn.tedu.weibo.entity.User;
import cn.tedu.weibo.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class CommentController {
    @Autowired
    CommentMapper mapper;
    @RequestMapping("/comment/insert")
    public int insert(@RequestBody Comment comment, HttpSession session){
        System.out.println("comment = " + comment);
        User user = (User) session.getAttribute("user");
        if (user==null){
            return 2;//代表没有登录
        }
        //把当前登录的用户名赋值给评论对象
        comment.setNick(user.getNick());
        //把comment的数据保存到 comment表中
        mapper.insert(comment);
        return 1;
    }
}
