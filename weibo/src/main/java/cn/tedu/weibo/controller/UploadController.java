package cn.tedu.weibo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile pic) throws IOException {
        //得到唯一文件名
        String fileName = pic.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID()+suffix;
        //创建文件夹
        String dirPath = "e:/files";
        File dirFile = new File(dirPath);
        if (!dirFile.exists()){
           dirFile.mkdirs();
        }
        //得到文件的完整路径
        String filePath = dirPath+"/"+fileName;
        //把文件保存到指定的路径  异常抛出
        pic.transferTo(new File(filePath));
        //把文件路径返回给客户端
        return "/"+fileName;
    }
}
