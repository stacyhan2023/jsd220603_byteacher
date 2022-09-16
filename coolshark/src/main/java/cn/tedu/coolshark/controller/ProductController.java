package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.Product;
import cn.tedu.coolshark.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
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
    @RequestMapping("/product/delete")
    public void delete(int id){
        //通过id查询到文件路径 然后删除文件
        String url = mapper.selectUrlById(id);
        new File("e:/files"+url).delete();
        //删除数据库中的商品数据
        mapper.deleteById(id);

    }
    @RequestMapping("/product/selectTop")
    public List<Product> selectTop(){
        return mapper.selectTop();
    }

}
