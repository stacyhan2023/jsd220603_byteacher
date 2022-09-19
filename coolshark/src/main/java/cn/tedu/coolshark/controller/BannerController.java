package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.Banner;
import cn.tedu.coolshark.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class BannerController {
    @Autowired
    BannerMapper mapper;
    //把配置文件中的值读取出
    @Value("${dirPath}")
    private String dirPath;

    @RequestMapping("/banner/select")
    public List<Banner> select(){
        return mapper.select();
    }
    @RequestMapping("/banner/delete")
    public void delete(int id){
        String url = mapper.selectUrlById(id);
        new File(dirPath+url).delete();

        mapper.deleteById(id);
    }
    @RequestMapping("/banner/insert")
    public void insert(String url){
        mapper.insert(url);

    }
}
