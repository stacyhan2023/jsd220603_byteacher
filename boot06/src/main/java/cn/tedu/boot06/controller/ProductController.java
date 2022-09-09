package cn.tedu.boot06.controller;

import cn.tedu.boot06.entity.Product;
import cn.tedu.boot06.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

