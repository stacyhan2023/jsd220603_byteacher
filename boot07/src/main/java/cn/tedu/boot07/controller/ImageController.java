package cn.tedu.boot07.controller;

import cn.tedu.boot07.entity.Image;
import cn.tedu.boot07.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
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
    @RequestMapping("/delete")
    public void delete(int id){
        //删除文件夹中的图片
        String urls = mapper.selectUrlsById(id);
        //遍历每一个图片路径
        for (String url: urls.split(",")) {
            //删除文件
            new File("e:/files"+url).delete();
        }
        //删除数据库中的数据
        mapper.deleteById(id);
    }
}
