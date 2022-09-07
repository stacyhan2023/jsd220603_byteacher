package cn.tedu.boot03.controller;

import cn.tedu.boot03.entity.Product;
import cn.tedu.boot03.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    //自动装配注解, 此注解是Spring框架中提供的注解,添加此注解后Spring框架和MyBatis框架
    //会创建一个实现类(实现了ProductMapper接口),并且实例化了此实现类把实例化后的对象赋值给了
    //mapper变量
    @Autowired(required = false)     //如果AutoWired注解报错 则添加(required = false) 解决误提示
    ProductMapper mapper;

    @RequestMapping("/insert")
    public String insert(Product product){
        System.out.println("product = " + product);
        mapper.insert(product);
        return "添加完成!<a href='/'>返回首页</a>";
    }
}
