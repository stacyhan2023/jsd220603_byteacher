package cn.tedu.weibo.controller;

import cn.tedu.weibo.entity.Comment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @RequestMapping("/comment/insert")
    public int insert(@RequestBody Comment comment){
        System.out.println("comment = " + comment);

        return 1;
    }
}
