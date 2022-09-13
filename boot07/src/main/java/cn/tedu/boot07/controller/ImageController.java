package cn.tedu.boot07.controller;

import cn.tedu.boot07.entity.Image;
import cn.tedu.boot07.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ImageController {
    @Autowired
    ImageMapper mapper;

    @RequestMapping("/insert")
    public void insert(@RequestBody Image image){
        System.out.println("image = " + image);
        mapper.insert(image);
    }

    @RequestMapping("/select")
    public List<Image> select(){


        return mapper.select();
    }
}
