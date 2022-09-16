package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.Product;
import cn.tedu.coolshark.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;
    @RequestMapping("/product/insert")
    public void insert(@RequestBody Product product){
        product.setCreated(new Date());
        System.out.println("product = " + product);
        mapper.insert(product);
    }

    @RequestMapping("/product/select")
    public List<Product> select(){
        return mapper.select();
    }

}
