package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.Product;
import cn.tedu.coolshark.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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

    @RequestMapping("/product/selectIndex")
    public List<Product> selectIndex(){
        return mapper.selectIndex();
    }

    @RequestMapping("/product/selectByCid")
    public List<Product> selectByCid(int id){

        return mapper.selectByCid(id);
    }

    @RequestMapping("/product/selectByWd")
    public List<Product> selectByWd(String wd){
        System.out.println("wd = " + wd);

        return mapper.selectByWd(wd);
    }

    //  id=5
    @RequestMapping("/product/selectById")
    public Product selectById(int id, HttpSession session){
        //从会话对象中取出当前商品id相关的信息
        String info = (String) session.getAttribute("view"+id);
        //如果没有取到 代表没有浏览过
        if (info==null){
            //让浏览量+1
            mapper.updateViewCountById(id);
            //把当前商品的id保存到会话对象里面
            session.setAttribute("view"+id,"isVisible");
        }

        System.out.println("id = " + id);
        return mapper.selectById(id);
    }

}
