package cn.tedu.boot07.controller;

import cn.tedu.boot07.entity.Image;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
    @RequestMapping("/insert")
    public void insert(@RequestBody Image image){
        System.out.println("image = " + image);
    }
}
