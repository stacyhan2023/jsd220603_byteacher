package cn.tedu.boot02.controller;

import cn.tedu.boot02.entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @RequestMapping("/insert")
    public String insert(Product product){
        System.out.println("product = " + product);

        return "添加完成!";
    }
}
