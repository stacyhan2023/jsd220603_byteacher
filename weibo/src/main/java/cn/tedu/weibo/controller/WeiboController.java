package cn.tedu.weibo.controller;

import cn.tedu.weibo.entity.Weibo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeiboController {
    @RequestMapping("/weibo/insert")
    public int insert(@RequestBody Weibo weibo){
        System.out.println("weibo = " + weibo);
        return 1;
    }
}
