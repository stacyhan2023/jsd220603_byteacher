package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.Category;
import cn.tedu.coolshark.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryMapper mapper;

    @RequestMapping("/category/select")
    public List<Category> select(){
        return mapper.select();
    }
}
