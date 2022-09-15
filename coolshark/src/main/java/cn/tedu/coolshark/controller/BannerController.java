package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.Banner;
import cn.tedu.coolshark.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BannerController {
    @Autowired
    BannerMapper mapper;

    @RequestMapping("/banner/select")
    public List<Banner> select(){
        return mapper.select();
    }
    @RequestMapping("/banner/delete")
    public void delete(int id){
        mapper.deleteById(id);
    }
    @RequestMapping("/banner/insert")
    public void insert(String url){
        mapper.insert(url);

    }
}
