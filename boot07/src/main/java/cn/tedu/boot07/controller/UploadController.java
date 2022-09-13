package cn.tedu.boot07.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public void upload(MultipartFile pic){
        System.out.println("pic = " + pic);

    }
}
