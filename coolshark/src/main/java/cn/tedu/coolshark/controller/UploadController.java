package cn.tedu.coolshark.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    //把配置文件中的值读取出
    @Value("${dirPath}")
    private String dirPath;

    @RequestMapping("/upload")
    public String upload(MultipartFile pic) throws IOException {
        //得到唯一文件名
        String fileName = pic.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID()+suffix;
        //准备文件夹
        File dirFile = new File(dirPath);
        if (!dirFile.exists()){
            dirFile.mkdirs();
        }
        //准备文件的完整路径
        String filePath = dirPath+"/"+fileName;
        pic.transferTo(new File(filePath));
        return "/"+fileName;
    }

    @RequestMapping("/remove")
    public void remove(String url){
        //删除文件
        new File(dirPath+url).delete();
    }

}
