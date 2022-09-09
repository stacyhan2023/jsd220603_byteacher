package cn.tedu.boot06.controller;

import cn.tedu.boot06.entity.Product;
import cn.tedu.boot06.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;

    @RequestMapping("/insert")
    public void insert(@RequestBody Product product){
        System.out.println("product = " + product);
        //创建mapper 调用mapper的insert方法
        mapper.insert(product);
    }

    @RequestMapping("/select")
    public List<Product> select(){

        //调用mapper中的查询方法 把查询到的list集合直接响应给客户端
        return mapper.select();
    }
}

