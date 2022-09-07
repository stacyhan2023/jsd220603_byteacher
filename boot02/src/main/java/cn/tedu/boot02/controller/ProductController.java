package cn.tedu.boot02.controller;

import cn.tedu.boot02.entity.Product;
import cn.tedu.boot02.utils.DBUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class ProductController {
    @RequestMapping("/insert")
    public String insert(Product product){
        System.out.println("product = " + product);
        try (Connection conn = DBUtils.getConn()){
            String sql = "insert into product values(null,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,product.getTitle());
            ps.setDouble(2,product.getPrice());
            ps.setInt(3,product.getNum());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "添加完成!<a href='/'>返回首页</a>";
    }

    @RequestMapping("/select")
    public String select(){
        //创建集合用来装查询到的数据
        ArrayList<Product> list = new ArrayList<>();
        try (Connection conn = DBUtils.getConn()){
            String sql = "select * from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String title = rs.getString(2);
                double price = rs.getDouble(3);
                int num = rs.getInt(4);
                //把查询到的商品信息封装到商品对象中,并把对象装进list集合
                list.add(new Product(id,title,price,num));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<table border='1'>";
        html+="<caption>商品列表</caption>";
        html+="<tr><th>id</th><th>商品标题</th><th>价格</th><th>库存</th><th>操作</th></tr>";
        for (Product p:list) {
            html+="<tr>";
            html+="<td>"+p.getId()+"</td>";
            html+="<td>"+p.getTitle()+"</td>";
            html+="<td>"+p.getPrice()+"</td>";
            html+="<td>"+p.getNum()+"</td>";
            html+="<td><a href='/delete?id="+p.getId()+"'>删除</a></td>";
            html+="</tr>";
        }
        html+="</table>";
        return html;
    }
    @RequestMapping("/delete")
    public String delete(int id){
        System.out.println("id = " + id);
        try (Connection conn = DBUtils.getConn()){
            String sql = "delete from product where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "删除完成!<a href='/select'>返回列表页面</a>";
    }
}
