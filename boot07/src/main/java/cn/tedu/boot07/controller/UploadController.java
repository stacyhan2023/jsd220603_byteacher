package cn.tedu.boot07.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public void upload(MultipartFile pic){
        System.out.println("pic = " + pic);
        //得到文件的原始文件名        a.jpg
        String fileName = pic.getOriginalFilename();
        System.out.println(fileName);
        //得到后缀   .jpg
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
        //得到唯一文件名 UUID.randomUUID() 获取由16进制字符串组成的一个唯一标识符
        fileName = UUID.randomUUID()+suffix;
        System.out.println(fileName);


    }
}
